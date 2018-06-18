package Servlets;

import Helpers.Vars;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute(Vars.USER,null);
        session.setAttribute(Vars.HISTORY,null);
        session.setAttribute(Vars.COMP_COMBO,null);
        session.setAttribute(Vars.RATING_LIST,null);//fixme
        session.setAttribute(Vars.USER_COMBO,null);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }
}

