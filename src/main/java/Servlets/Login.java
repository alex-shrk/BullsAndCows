package Servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String login = req.getParameter("userLogin");
        String password = req.getParameter("userPsw");


        DBConnectionHelper.DBConnectionManager db = DBConnectionHelper.getDBConnectionManager();
        try( Connection connection = db.getConnection()) {



            String sqlGetUserId = "SELECT id FROM \"User\" WHERE login=? AND psw=?";
            PreparedStatement getUserId = connection.prepareStatement(sqlGetUserId);
            getUserId.setString(1,login);
            getUserId.setString(2,password);
            ResultSet resultSet = getUserId.executeQuery();
            if (resultSet.next()){
                Long id = resultSet.getLong("id");
                session.setAttribute("userId",id);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }




        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/startGame");
        dispatcher.forward(req,resp);

    }
}
