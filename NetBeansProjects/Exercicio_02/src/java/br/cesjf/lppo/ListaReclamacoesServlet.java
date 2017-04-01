package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "ListaReclamacoesServlet", urlPatterns = {"/lista.html"})
public class ListaReclamacoesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Reclamacao> reclamacao = new ArrayList<>();

        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "usuario");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM reclamacao");
            while(resultado.next()){
                Reclamacao ReclamacaoAtual = new Reclamacao();
                ReclamacaoAtual.setId(resultado.getLong("id"));
                ReclamacaoAtual.setNome(resultado.getString("nome"));
                ReclamacaoAtual.setEmail(resultado.getString("email"));
                ReclamacaoAtual.setDescricao(resultado.getString("descricao"));
                ReclamacaoAtual.setStatus(resultado.getInt("status"));
                reclamacao.add(ReclamacaoAtual);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaReclamacoesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaReclamacoesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("reclamacao", reclamacao);
        request.getRequestDispatcher("WEB-INF/listaReclamacoes.jsp").forward(request, response);
    }

}
