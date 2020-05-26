package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/controller.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
    }
    protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	try {
    		request.setCharacterEncoding("UTF-8");
    		Command comando = (Command) Class.forName("command." + request.getParameter("command")).newInstance();
			comando.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}

}
