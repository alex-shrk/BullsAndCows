package Servlets;

import Helpers.Vars;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FinishGame extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute("counterTryes",null);
        session.setAttribute("compCombination",null);
        session.setAttribute(Vars.RATING_LIST,null);
        session.setAttribute("userComboHistory",null);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/startGame");
        dispatcher.forward(req, resp);

    }
}

