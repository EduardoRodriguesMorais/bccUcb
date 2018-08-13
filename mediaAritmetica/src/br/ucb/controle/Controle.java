package br.ucb.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.modelo.bean.Calculo;

/**
 * Servlet implementation class Controle
 */
@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String visao = null;
		String acao = request.getParameter("acao");
		switch(acao) {
			case "mediaAritmetica":
				visao = "resultado.jsp";
				float result = 0;
				Calculo calc = new Calculo();
				result =  calc.mediaAritmetica(Float.parseFloat(request.getParameter("valorA")),Float.parseFloat(request.getParameter("valorB")));
				request.setAttribute("resultado",result);
				break;
		}
		dispatcher = request.getRequestDispatcher(visao);
		dispatcher.forward(request, response);
	}


}
