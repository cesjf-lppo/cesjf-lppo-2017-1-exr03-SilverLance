package br.cesjf.lppo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adriano
 */
@WebServlet(name = "ListaVisitantesServlet", urlPatterns = {"/lista.html"})
public class ListaVisitantesServlet extends HttpServlet {

   private static SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List <Visitante> visitantes = new ArrayList<>();
        
                try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "usuario");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM visitante");

            while(resultado.next()){
                Visitante visitante = new Visitante();
                visitante.setId(resultado.getLong("Id"));
                visitante.setNome(resultado.getString("nome"));
                visitante.setIdade(resultado.getInt("idade"));
                String d = data.format(resultado.getDate("entrada"));
                visitante.setEntrada(resultado.getTimestamp("entrada"));
                visitante.setSaida(resultado.getTimestamp("saida"));
                visitantes.add(visitante);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaVisitantesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaVisitantesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("visitante", visitantes);
        request.getRequestDispatcher("WEB-INF/listaVisitantes.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}