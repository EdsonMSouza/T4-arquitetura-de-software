package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // criação de um atributo que será utilizado entre as páginas JSP
        request.setAttribute("mensagem", "Você clicou em Listar");

        // aqui vamos redirecionar para a view correta (cliente)
        // Dispatcher = despachar ou enviar
        request.getRequestDispatcher("view_mensagem.jsp").
                forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // essas linhas configuram o código de página 
        // ou seja, acentos e caracteres especiais
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // vamos criar o controle para administrar o que está acontecendo
        // vamos criar uma variável para recuperar qual "opção" o usuário escolheu
        // esta opção virá dos formulários, conforme a linha abaixo:
        // <input type="hidden" name="operacao" value="tipo_da_operacao" />
        String operacao = request.getParameter("operacao");

        // criaremos as opções de operações que vamos usar nesta aplicação
        // Inserir, Pesquisar, Editar, Atualizar, Excluir e Confirmar Exclusão
        // vamos usar o switch para selecionar a opção desejada
        // todas as operações abaixo são referentes a banco de dados
        switch (operacao) {
            case "Inserir":
                System.out.println("Foi clicado em Inserir no formulário");
                String ra = request.getParameter("ra");
                String nome = request.getParameter("nome");
                String curso = request.getParameter("curso");
                
                request.setAttribute("mensagem", "Você clicou em Inserir");
                request.setAttribute("ra", ra);
                request.setAttribute("nome", nome);
                request.setAttribute("curso", curso);
                
                break;
            case "Pesquisar":
                System.out.println("Foi clicado em Pesquisar no formulário");
                request.setAttribute("mensagem", "Você clicou em Pesquisar");
                break;
            case "Editar":
                System.out.println("Foi clicado em Editar no formulário");
                request.setAttribute("mensagem", "Você clicou em Editar");
                break;
            case "Atualizar":
                System.out.println("Foi clicado em Atualizar no formulário");
                request.setAttribute("mensagem", "Você clicou em Atualizar");
                break;
            case "Excluir":
                System.out.println("Foi clicado em Excluir no formulário");
                request.setAttribute("mensagem", "Você clicou em Excluir");
                break;
            case "Confirmar Exclusao":
                System.out.println("Foi clicado em Confirmar Exclusão no formulário");
                request.setAttribute("mensagem", "Você clicou em Confirmar Exclusão");
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
