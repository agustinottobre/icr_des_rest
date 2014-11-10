package despacho.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import dtos.ODVDTO;
//import stub.Stub;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		http://localhost:8080/despacho/Login?username=test&password=
		System.out.println("### doGet Login");
		String user = request.getParameter("username");
		String pass = request.getParameter("passsword");
		HttpSession session = request.getSession();
		session.setAttribute("error", "");
	    session.setAttribute("confirm", "");
	    
		//para testear nomas
		if (user.equals("test"))
		{			
		    session.setAttribute("estaLogueado", "true");		    
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			return;
		}
				
		session = request.getSession();
		session.setAttribute("error", "Usuario y/o contraseña incorrectos");
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request,response);
		System.out.println("### doPost Login");
		String user = request.getParameter("username");
		String pass = request.getParameter("passsword");
		
	}
}
