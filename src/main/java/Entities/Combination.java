package Entities;

public class Combination  {

    private int[] combination;

    public Combination() {
    }

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

    public String getCombinationString(){
        StringBuilder sb = new StringBuilder();
        for (int i:combination)
            sb.append(i);
        return sb.toString();
    }




}
