package Entities;

/**
 * Combination entity
 */
public class Combination  {

    private int[] combination;

    public Combination() {
    }

    /**
     * For transform String with combination to int[] and write to combination field
     * @param combination string with combination for transformation
     */
    public void setCombination(String combination){
        this.combination = new int[combination.length()];
        for (int i = 0; i < combination.length(); i++) {
            this.combination[i] = Integer.parseInt(String.valueOf(combination.toCharArray()[i]));
        }
    }

    public void setCombination(int[] combination) {
        this.combination = combination;
    }

    public int[] getCombination() {
        return combination;
    }

    /**
     * Get method which return combination int[] as String
     * @return String with combination
     * @see Combination#setCombination(String)
     */
    public String getCombinationString(){
        StringBuilder sb = new StringBuilder();
        for (int i:combination)
            sb.append(i);
        return sb.toString();
    }




}
