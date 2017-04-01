package br.cesjf.lppo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Visitante> visitante = new ArrayList<>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "usuario");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM visitante");
            while(resultado.next()){
                Visitante VisitanteAtual = new Visitante();
                VisitanteAtual.setId(resultado.getLong("id"));
                VisitanteAtual.setNome(resultado.getString("nome"));
                VisitanteAtual.setIdade(resultado.getInt("idade"));
                VisitanteAtual.setEntrada(resultado.getTimestamp("entrada"));
                VisitanteAtual.setSaida(resultado.getTimestamp("saida"));
                visitante.add(VisitanteAtual);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaVisitantesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaVisitantesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("visitante", visitante);
        request.getRequestDispatcher("WEB-INF/listaVisitantes.jsp").forward(request, response);
    }

}
