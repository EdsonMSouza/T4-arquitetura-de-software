package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" 
    // desc="HttpServlet methods. 
    // Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // configuração para manter a acentuação e 
        // caracteres especiais
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // conexão com a camada do Model (Banco de Dados)
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // essas linhas configuram o código de página 
        // ou seja, acentos e caracteres especiais
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Opçãpo que vem do formulário
        // <input type="hidden" 
        //        name="operacao" value="tipo_da_operacao" />
        String operacao = request.getParameter("operacao");

        // seleciona a opção armazena em "operacao"
        switch (operacao) {
            case "Inserir":
                String ra = request.getParameter("ra");
                String nome = request.getParameter("nome");
                String curso = request.getParameter("curso");

                request.setAttribute("mensagem",
                        "Você clicou em Inserir");

                request.setAttribute("ra", ra);
                request.setAttribute("nome", nome);
                request.setAttribute("curso", curso);

                break;

            case "Pesquisar":
                request.setAttribute("mensagem",
                        "Você clicou em Pesquisar");
                break;

            case "Editar":
                request.setAttribute("mensagem",
                        "Você clicou em Editar");
                break;

            case "Atualizar":
                request.setAttribute("mensagem",
                        "Você clicou em Atualizar");
                break;

            case "Excluir":
                request.setAttribute("mensagem",
                        "Você clicou em Excluir");
                break;

            case "Confirmar Exclusao":
                request.setAttribute("mensagem",
                        "Você clicou em Confirmar Exclusão");
                break;
        }
        // redireciona para a view_mensagem
        request.getRequestDispatcher("view_mensagem.jsp").
                forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
