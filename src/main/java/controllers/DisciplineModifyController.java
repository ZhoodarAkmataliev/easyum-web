package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DisciplineModifyController", urlPatterns = "/modify-discipline")

public class DisciplineModifyController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idDics = req.getParameter("idModifyDisc");
		try {
			Discipline discipline = DBManager.getDisciplineById(idDics);
			req.setAttribute("discipline", discipline);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/jsp/discipline-modify.jsp").forward(req,resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idDisc = req.getParameter("discID");
		String newName = req.getParameter("secondName");
		DBManager.modifyDiscipline(idDisc, newName);
		resp.sendRedirect("/disciplines");
	}
}
