package controllers;

import database.DBManager;
import entity.Mark;
import entity.Semestr;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStud = req.getParameter("idStudentProgress");
		Student student = null;
		try {
			student = DBManager.getStudentById(idStud);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		List<Semestr> semestrs= DBManager.getAllActiveSemestrs();
		Semestr selectedSemestr = semestrs.get(0);

		List<Mark> marks = DBManager.getMarkByStudentSemestr(idStud, selectedSemestr.getId() );

		req.setAttribute("marks", marks);
		req.setAttribute("selectedSemestr", selectedSemestr);
		req.setAttribute("student", student);
		req.setAttribute("semestrs", semestrs);
		req.getRequestDispatcher("/WEB-INF/jsp/student-progress.jsp").forward(req, resp);

	}
}
