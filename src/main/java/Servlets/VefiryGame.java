package Servlets;

import Helpers.DBConnectionHelper.DBConnectionManager;

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
import java.util.List;
import java.util.stream.IntStream;

import static Helpers.DBConnectionHelper.getDBConnectionManager;


public class VefiryGame extends HttpServlet {
    final private Integer lengthCombination = 4;

    private List<String[]> userComboHistory;
    private int counterTryes = 0;



    private String convertIntArrayToInt(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array)
            sb.append(i);
        return sb.toString();
    }

    private String verifyComb(int[] compComb, int[] userComb) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < lengthCombination; i++) {
            if (userComb[i] == compComb[i])
                bulls++;
            else {
                int finalI = i;
                if (IntStream.of(userComb).anyMatch(x -> x == compComb[finalI]))
                    cows++;
            }
        }
        return bulls + "Б" + cows + "К";

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        counterTryes = (int) session.getAttribute("counterTryes");
        userComboHistory = (List<String[]>) session.getAttribute("userComboHistory");
        int[] userComboChars = new int[4];
        char[] userCombo = req.getParameter("userCombo").toCharArray();

        for (int i = 0; i < 4; i++) {
            userComboChars[i] = Integer.parseInt(String.valueOf(userCombo[i]));

        }
        int[] compComb = (int[]) session.getAttribute("compCombination");
        String answer = verifyComb(compComb, userComboChars);

        counterTryes++;
        userComboHistory.add(new String[]{convertIntArrayToInt(userComboChars), answer});

        RequestDispatcher dispatcher;

        if (answer.equals("4Б0К")) {

            DBConnectionManager db = getDBConnectionManager();
            try(Connection connection = db.getConnection()) {
                Long idUser = (Long) session.getAttribute("userId");


                String sqlInsertUser = "INSERT INTO \"History\"(id_user,result) VALUES(?,?)";
                PreparedStatement insertUser = connection.prepareStatement(sqlInsertUser);
                insertUser.setLong(1,idUser);
                insertUser.setLong(2,counterTryes);
                insertUser.execute();

                String sqlGetRatingView = "SELECT * FROM \"RatingView\"";
                PreparedStatement getRatingView = connection.prepareStatement(sqlGetRatingView);
                ResultSet ratingSet = getRatingView.executeQuery();
                session.setAttribute("ratingSet", ratingSet);

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            dispatcher = getServletContext().getRequestDispatcher("/result.jsp");
        }
        else
            dispatcher = getServletContext().getRequestDispatcher("/game.jsp");



        session.setAttribute("counterTryes", counterTryes);
        session.setAttribute("userComboHistory", userComboHistory);
        dispatcher.forward(req, resp);

    }
}
