import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class Combination {
    final private Integer lengthCombination = 4;
    public int[] generateCombination(){
        int[] combination = new int[4*lengthCombination];
        Random random = new Random();
        do {
            for(int i=0;i<combination.length;i++)
                combination[i]=random.nextInt(10);
            combination = Arrays.stream(combination).distinct().limit(4).toArray();
        }

        while (combination.length!=lengthCombination);
        return combination;
    }

    public String verifyComb(int[] compComb,int[] userComb ){
        int bulls=0;
        int cows=0;
        for (int i=0;i<lengthCombination;i++) {
            if (userComb[i]==compComb[i])
                bulls++;
            else {
                int finalI = i;
                if (IntStream.of(userComb).anyMatch(x->x==compComb[finalI]))
                    cows++;
            }
        }
        return bulls+"Б"+cows+"K";

    }
    public int convertIntArrayToInt(int[] array){
        StringBuilder sb = new StringBuilder();
        for (int i:array)
            sb.append(i);
        return Integer.valueOf(sb.toString());
    }


}
