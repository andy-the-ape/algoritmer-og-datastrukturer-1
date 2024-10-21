package PortfolioExercise;

public class Exercise1 {
    /*
    Skriv en rekursiv algoritme, som har et naturligt tal som parameter og returnerer summen af de ulige tals
    kvadrater fra 1 til N.
    Eksempel: kaldt med parameteren 8 returneres 84 (1^2+3^2+ 5^2+ 7^2).
    Det er vigtigt at optimere algoritmen, så overflødige rekursive kald undgås
    */

    public static void main(String[] args) {
        System.out.println("Sum of odd squares: " + sumOfOddNumberSquares(8));
    }

    public static int sumOfOddNumberSquares(int N) {
        if (N <= 0) return 0;
        if (N % 2 == 0) return sumOfOddNumberSquares(N-1);
        return N * N + sumOfOddNumberSquares(N-2);
    }

}
