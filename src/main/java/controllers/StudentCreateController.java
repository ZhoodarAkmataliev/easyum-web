package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="StudentCreateController", urlPatterns = "/create-students")
public class StudentCreateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/create-students.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newSurname = req.getParameter("surename");
		String newName = req.getParameter("name");
		String newGroup = req.getParameter("group");
		String newDate = req.getParameter("date");
		DBManager.createStudents(newSurname, newName, newGroup, newDate);
		resp.sendRedirect("/students");
	}
}
