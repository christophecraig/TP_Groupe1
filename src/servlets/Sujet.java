package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import connection.Dal;

public class Sujet extends HttpServlet {
	public static final String ATT_BEAN = "sujets";
	public static final String VUE = "/WEB-INF/subjectList.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(ATT_BEAN, Dal.getSujet());
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
