package Servlets;

import DAO.DAOFactory;
import DAO.HistoryDAO;
import Entities.Combination;
import Entities.History;
import Entities.User;
import Helpers.CombinationImpl;
import Helpers.Vars;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class VefiryGame extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(Vars.USER);
        History history = (History) session.getAttribute(Vars.HISTORY);

        Combination userCombo = new Combination();
        userCombo.setCombination(req.getParameter(Vars.USER_COMBO));
        Combination compCombo = (Combination) session.getAttribute(Vars.COMP_COMBO);
        String answer = new CombinationImpl().verify(compCombo.getCombination(), userCombo.getCombination());

        history.add(userCombo,answer);


        RequestDispatcher dispatcher;

        if (answer.equals(Vars.RIGHT_ANSWER)) {
            HistoryDAO dao = DAOFactory.getInstance().getHistoryDAO();
            dao.add(user,history.getCounter());
            session.setAttribute(Vars.RATING_LIST, dao.getRating());
            dispatcher = getServletContext().getRequestDispatcher("/result.jsp");
        }
        else
            dispatcher = getServletContext().getRequestDispatcher("/game.jsp");

        session.setAttribute(Vars.HISTORY, history);
        dispatcher.forward(req, resp);

    }
}
