package Helpers;

import DAO.Combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CombinationImpl implements Combination {
    final private static Integer LENGTH_COMB = 4;

    public int[] generate() {
        int[] combination = new int[LENGTH_COMB];
        List<Integer> digits = new ArrayList<>(10);
        for (int i = 0; i <= 9; i++) {
            digits.add(i);
        }
        Random random = new Random();
        int randomDigit;
        for (int i = 0; i < LENGTH_COMB; i++) {
            randomDigit = random.nextInt(digits.size());
            combination[i] = digits.get(randomDigit);
            digits.remove(randomDigit);
        }
        return combination;

    }

    public String verify(int[] compComb, int[] userComb) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < LENGTH_COMB; i++) {
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
}
