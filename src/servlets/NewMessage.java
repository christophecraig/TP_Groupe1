package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Dal;

public class NewMessage extends HttpServlet {
	public static final String ATT_BEAN = "messages";
	public static final String VUE = "/WEB-INF/messageList.jsp";
	public static final String ATT_PARAM_DISCUSSION = "idDiscussion";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dal.addMessage(request.getParameter("login"), request.getParameter("message"));

		request.setAttribute(ATT_BEAN, Dal.getMessage(Integer.parseInt(request.getParameter(ATT_PARAM_DISCUSSION))));
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
