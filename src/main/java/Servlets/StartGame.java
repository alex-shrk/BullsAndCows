package Servlets;

import Entities.Combination;
import Entities.History;
import Helpers.CombinationImpl;
import Helpers.Vars;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class StartGame extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();

        Combination compComb = new Combination();
        compComb.setCombination(new CombinationImpl().generate());

        session.setAttribute(Vars.COMP_COMBO, compComb);

        History history = new History();
        session.setAttribute(Vars.HISTORY, history);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/game.jsp");
        dispatcher.forward(req, resp);


    }
}
