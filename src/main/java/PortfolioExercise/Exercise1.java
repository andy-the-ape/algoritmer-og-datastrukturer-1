package PortfolioExercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Exercise1 {

    public static void main(String[] args) {
        System.out.println("Sum of odd squares: " + sumOfOddNumberSquares(8));
        System.out.println("Additive: " + additive("82842605"));
        System.out.println("unique numbers test: " + Arrays.toString(findThreeNumbers(
                new int[]{1, 1, 5, 6, 8, 8, 4, 5}
        )));
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

    public static int[] findThreeNumbers(int[] inputArray) {
    /*
    Skriv en algoritme, der har et array af usorterede, entydige naturlige tal som input og find de tre tal i
    arrayet, hvis sum er tættest på en potens af 2. Det samme tal kan må bruges én gang.
    Algoritmens returværdi skal være et heltalsarray, som først indeholder de tre tal og dernæst den tilhørende
    potens af to (fx 512).
    Kaldt med arrayet {23,56,22,11,65,89,3,44,87,910,45,35,98}, returneres de tre tal 89, 3, 35 og potensen af
    2: 128.
     */

        //The same number can only be used once, so we purge all duplicates of the inputArray:
        LinkedHashSet<Integer> uniqueNumbersSet = new LinkedHashSet<>();
        for (int i : inputArray) {
            uniqueNumbersSet.add(i);
        }
        //Convert new Integer Set back to int array:
        int[] uniqueNumbersArray = uniqueNumbersSet.stream().mapToInt(x -> x).toArray();

        

//        for (int i = 0; i < inputArray.length; i++) {
//
//            for (int j = 0;)
//        }

    }

}
