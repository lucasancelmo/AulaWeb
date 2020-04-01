package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterpaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
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
	//	int pId = Integer.parseInt(request.getParameter("id"));
		String pNome = request.getParameter("nome");
		double pArea = Double.parseDouble(request.getParameter("area"));
		long pPopulacao = Long.parseLong(request.getParameter("populacao"));
		
		//instanciar o javabean
		Pais pais = new Pais();
	//	pais.setId(pId);
		pais.setNome(pNome);
		pais.setArea(pArea);
		pais.setPopulacao(pPopulacao);
		
		//instanciar o service
		PaisService cs = new PaisService();
		cs.criar(pais);
		pais = cs.carregar(pais.getId());
		PrintWriter out = response.getWriter();
		System.out.println(pais.getId());
		
		out.println("<html><head><title>Pais Cadastrado</title></head><body>");
		out.println(	"Id: "+pais.getId()+"<br>");
		out.println(	"nome do Pais: "+pais.getNome()+"<br>");
		out.println(	"�rea: "+pais.getArea()+"<br>");
		out.println(	"Popula��o: "+pais.getPopulacao()+"<br>");
		out.println("<a href=index.html>Inicio</a>");
	    out.println("</body></html>");
		
	}

}