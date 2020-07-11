package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Semestr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermsController", urlPatterns = "/terms")
public class TermsController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectedTermId = req.getParameter("selectedTermId");

		List<Semestr> semestrs = DBManager.getAllActiveSemestrs();
		req.setAttribute("semestrs", semestrs);
		if (selectedTermId == null){
			req.setAttribute("selectedTerm", semestrs.get(0));
			List<Discipline> disciplinesBySelectedTerm = DBManager.getDisciplinesInSemestr(semestrs.get(0).getId()+"");
			req.setAttribute("disciplinesByTerm", disciplinesBySelectedTerm);
		}else{
			for (Semestr s: semestrs){
				String semestrId = s.getId() + "";
				if (semestrId.equals(selectedTermId) ){
					req.setAttribute("selectedTerm", s);
					List<Discipline> disciplinesBySelectedTerm = DBManager.getDisciplinesInSemestr(s.getId()+"");
					req.setAttribute("disciplinesByTerm", disciplinesBySelectedTerm);
				}
			}
		}

		req.getRequestDispatcher("/WEB-INF/jsp/terms.jsp").forward(req, resp);
	}
}
