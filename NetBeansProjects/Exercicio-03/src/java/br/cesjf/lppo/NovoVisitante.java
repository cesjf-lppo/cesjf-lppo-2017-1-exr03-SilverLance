package br.cesjf.lppo;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "NovoVisitanteServlet", urlPatterns = {"/novo.html"})
public class NovoVisitante extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/novoVisitante.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        long entrada = Date.parse(request.getParameter("entrada"));
        long saida = Date.parse(request.getParameter("saida"));

        Logger.getLogger(NovoVisitante.class.getName()).log(Level.INFO, "POST: " + nome + "" + idade + "" + entrada +"" + saida);

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/lppo-2017-1";
            Connection conexao = DriverManager.getConnection(url, "usuario", "usuario");
            System.out.println("Conexao aberta com sucesso!");

            String sql = "INSERT INTO visitante(nome, idade, entrada, saida) VALUES('"
                    + nome + "', '"
                    + idade + "', '"
                    + entrada + "', '"
                    + saida + "')";

            Statement operacao = conexao.createStatement();
            operacao.executeUpdate(sql);
            System.out.println("Registro inserido!");

        } catch (ClassNotFoundException ex) {
            System.err.println("Driver indisponivel!");
            Logger.getLogger(NovoVisitante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.err.println("Problema ao acessar o banco!");
            Logger.getLogger(NovoVisitante.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("lista.html");
    }

}
