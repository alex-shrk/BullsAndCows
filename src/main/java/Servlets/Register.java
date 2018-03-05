package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String login = (String)req.getParameter("userLogin");
        String password = (String)req.getParameter("userPsw");
        String name = (String)req.getParameter("userName");

        DBConnectionHelper.DBConnectionManager db = DBConnectionHelper.getDBConnectionManager();
        try(Connection connection = db.getConnection()) {



            String sqlInsertUser = "INSERT INTO \"User\"(login,psw,name) VALUES(?,?,?)";
            PreparedStatement insertUser = connection.prepareStatement(sqlInsertUser);
            insertUser.setString(1,login);
            insertUser.setString(2,password);
            insertUser.setString(3,name);
            insertUser.execute();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
            rd.forward(req,resp);





        } catch (SQLException e1) {
            e1.printStackTrace();
        }




       /* RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);*/

    }
}
