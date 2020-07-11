package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineDeleteController", urlPatterns = "/discipline-delete")
public class DisciplineDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("idsDeleteDisc");
		String[] idsArr = ids.split(",");
		for (String id: idsArr){
			DBManager.deleteDiscipline(id);
		}
		resp.sendRedirect("/disciplines");
	}
}
