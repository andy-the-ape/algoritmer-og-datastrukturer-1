package PortfolioExercise;

public class Exercise1and2 {

    public static void main(String[] args) {
        System.out.println("Sum of odd squares: " + sumOfOddNumberSquares(8));
        System.out.println("Additive: " + additive("82842605"));

    }

    public static int sumOfOddNumberSquares(int N) {
     /*
    Skriv en rekursiv algoritme, som har et naturligt tal som parameter og returnerer summen af de ulige tals
    kvadrater fra 1 til N.
    Eksempel: kaldt med parameteren 8 returneres 84 (1^2+3^2+ 5^2+ 7^2).
    Det er vigtigt at optimere algoritmen, så overflødige rekursive kald undgås
     */
        if (N <= 0) return 0;
        if (N % 2 == 0) return sumOfOddNumberSquares(N-1);
        return N * N + sumOfOddNumberSquares(N-2);
    }

    public static boolean additive(String s) {
    /*
    Skriv en rekursiv algoritme med følgende signatur:
    bool additive(String s)
    Parameteren indeholder en streng bestående af cifre, fx. “82842605”.
    Algoritmen returnerer true, hvis parameteren indeholder en substring af tre på hinanden efterfølgende tal,
    hvor det tredje ciffer er lig med summen af de to forrige.
    I ovenstående eksempel returneres true, fordi indeks 5 (6) er summen af indeks 3 og 4 (4 plus 2).
    Tip: ASCII-værdien af karakteren ‘7’ er 55.
     */
        if (s.length() < 3) return false;
        int firstDigit = s.charAt(0) - '0';
        int secondDigit = (int)s.charAt(1)  - '0';
        int thirdDigit = (int)s.charAt(2)  - '0';
        if (firstDigit + secondDigit == thirdDigit) return true;
        return additive(s.substring(1));
    }


}
