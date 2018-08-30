package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import connection.Dal;

public class NewMessage extends HttpServlet {
	public static final String ATT_BEAN = "messages";
	public static final String ATT_STATUT = "statut";
	public static final String VUE = "/WEB-INF/messageList.jsp";
	public static final String ATT_PARAM_DISCUSSION = "idDiscussion";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dal.addMessage(Dal.addUtilisateur(request.getParameter("login"), request.getParameter("mail")), 
				Integer.parseInt(request.getParameter(ATT_PARAM_DISCUSSION)), request.getParameter("message"), DateTime.now());
		request.setAttribute(ATT_BEAN, Dal.getMessage(Integer.parseInt(request.getParameter(ATT_PARAM_DISCUSSION))));
		request.setAttribute(ATT_STATUT, Dal.getDiscussion(Integer.parseInt(request.getParameter(ATT_PARAM_DISCUSSION))).isStatut());
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
