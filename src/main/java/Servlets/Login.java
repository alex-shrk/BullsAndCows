package Servlets;


import DAO.DAOFactory;
import Entities.User;
import Helpers.Vars;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();


        HttpSession session = req.getSession();

        String login = req.getParameter(Vars.USER_LOGIN);
        String password = req.getParameter(Vars.USER_PASSWORD);

        User user = DAOFactory.getInstance().getUserDAO().get(login, password);
        if (user.getId()!=null){
            session.setAttribute(Vars.USER, user);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/startGame");
            dispatcher.forward(req, resp);

        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User not found');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }

    }
}
