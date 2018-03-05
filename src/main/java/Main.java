public class Main {

    static Combination combination = new Combination();


    public static void main(String[] args) {
        TestA a = new TestA();
        TestB b = new TestB();
        System.out.println("A class(8) "+a.getA());
        System.out.println("B class(4) "+b.getA());
        /*int[] compCombArray = combination.generateCombination();
        int compComb = combination.convertIntArrayToInt(compCombArray);
        System.out.println(compComb);

        int[] userCombArray = new int[4];

        Scanner reader = new Scanner(System.in);
        int cntIter=0;
        do {
            System.out.println("Enter combination:");
            for (int i = 0; i < 4; i++) {
                userCombArray[i] = reader.nextInt();
            }

            System.out.println(combination.verifyComb(compCombArray, userCombArray));
            cntIter++;
        }
        while (combination.convertIntArrayToInt(userCombArray)!=compComb);
        System.out.println("Count of trues"+cntIter);
        reader.close();*/

    }
}
