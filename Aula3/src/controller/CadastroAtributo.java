package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastroAtributo
 */
@WebServlet("/CadastroAtributos.do")
public class CadastroAtributo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pReq = request.getParameter("req");
		String pSes = request.getParameter("ses");
		String pApp = request.getParameter("app");
		
		request.setAttribute("sReq", pReq); // Setando no escopo de requisição
		request.getSession().setAttribute("sSes", pSes); // Setando no escopo de sessão.
		getServletContext().setAttribute("sApp", pApp); // Setando no escopo de aplicação.

		RequestDispatcher view =
				request.getRequestDispatcher("listaAtributos.jsp");
				view.forward(request, response);
	}

}
