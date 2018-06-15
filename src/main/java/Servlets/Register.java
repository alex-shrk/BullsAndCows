package Servlets;

import DAO.DAOFactory;
import Helpers.Vars;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String login = req.getParameter(Vars.USER_LOGIN);
        String password = req.getParameter(Vars.USER_PASSWORD);
        String name = req.getParameter(Vars.USER_NAME);

        DAOFactory.getInstance().getUserDAO().create(login,password,name);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
        rd.forward(req,resp);




    }
}
