package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="DisciplinesController", urlPatterns="/disciplines")
public class DisciplinesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //test adding incremental cookies
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            int countNot = 0;
            for (Cookie current : cookies) {
                if (current.getName().equals("count")) {
                    int value = Integer.parseInt(current.getValue());
                    value++;
                    current.setValue(value + "");
                    resp.addCookie(current);
                } else
                    countNot++;
            }
            if (countNot == cookies.length) {
                Cookie cookie = new Cookie("count", "1");
                resp.addCookie(cookie);
            }
        } else {
            Cookie cookie = new Cookie("count", "1");
            resp.addCookie(cookie);
        }
        try {
            List<Discipline> disciplines = null;
            disciplines = DBManager.getAllActiveDisciplines();
            req.setAttribute("disciplines", disciplines);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/jsp/disciplines.jsp").forward(req, resp);
    }
}
