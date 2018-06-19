package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Implementation of {@link Combination} interface
 */
public class CombinationImpl implements Combination {
    /**
     * Static field with Length of generated combination
     */
    final private static Integer LENGTH_COMB = 4;

    /**
     *  Generating of combination
     *
     *  Using the array of unique digits.
     *  Via Random method get digits from array to combination array.
     *  After getting the digit, he's removed from digits array
     * @return generated combination from computer
     */
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

    /**
     *
     * @param compComb array of int with combination generated by computer
     * @param userComb array of int with combination entered by user
     * @return String with result of verification like a '%Б%К',
     * where '%' - digits from 0 to 4.
     * For example, '4Б0К' - if compComb==userComb
     */
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