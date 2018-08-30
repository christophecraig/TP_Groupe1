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
import beans.Sujet;
import connection.Dal;

public class Discussion extends HttpServlet {
    public static final String ATT_BEAN = "discussions";
    public static final String VUE = "/WEB-INF/discussionList.jsp";
    public static final String ATT_PARAM_SUJET = "idSujet";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(ATT_BEAN, Dal.getDiscussions(Integer.parseInt(request.getParameter(ATT_PARAM_SUJET))));
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
