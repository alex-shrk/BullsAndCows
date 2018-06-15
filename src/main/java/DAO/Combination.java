package DAO;

public interface Combination {
    int[] generate();
    String verify(int[] compComb,int[] userComb);
}
