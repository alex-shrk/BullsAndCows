package Servlets;

import Connection.DBConnectionHelper.DBConnectionManager;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static Connection.DBConnectionHelper.getDBConnectionManager;


public class StartGame extends HttpServlet {
    final private Integer lengthCombination = 4;
    private int[] generateCombination(){
        int[] combination = new int [lengthCombination];
        List<Integer> digits = new ArrayList<>(10);
        for (int i=0;i<=9;i++){
            digits.add(i);
        }
        Random random = new Random();
        int randomDigit;
        for (int i=0;i<lengthCombination;i++) {
            randomDigit = random.nextInt(digits.size());
            combination[i] = digits.get(randomDigit);
            digits.remove(randomDigit);
        }
        return combination;
    }
    public String convertIntArrayToInt(int[] array){
        StringBuilder sb = new StringBuilder();
        for (int i:array)
            sb.append(i);
        return sb.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        DBConnectionManager db = getDBConnectionManager();
        try(Connection connection = db.getConnection()) {
            HttpSession session = req.getSession();

            Long idUser = (Long) session.getAttribute("userId");


            String sqlGetUserName = "SELECT name FROM \"User\" WHERE id=?";
            PreparedStatement getUserName = connection.prepareStatement(sqlGetUserName);
            getUserName.setLong(1, idUser);
            ResultSet resultSet = getUserName.executeQuery();
            if (resultSet.next())//move pointer to result and verify, that exist
                session.setAttribute("userName", resultSet.getString("name"));

            int[] combination = generateCombination();
            session.setAttribute("compCombination", combination);
            String combString = convertIntArrayToInt(combination);
            session.setAttribute("compCombString", combString);

            session.setAttribute("counterTryes", 0);
            session.setAttribute("userComboHistory",new ArrayList<String[]>());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/game.jsp");
            dispatcher.forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
