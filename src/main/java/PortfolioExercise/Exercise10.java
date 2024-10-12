package PortfolioExercise;

public class Exercise10 {
    /*
    Skriv en rekursiv metode med følgende signatur:
    int logTo(int N)
    Algoritmen returner totals-logaritmen af N, og det er en forudsætning, at N er et naturligt tal og en potens
    af 2.
    Kaldt med N = 32 returneres 5, og med N = 4096 returneres 12.
     */

    public static void main(String[] args) {
        System.out.println("The logarithm of "+ 4096 + " is = " + logTo(4096));
    }

    public static int logTo(int N) {
        int log = 0;
        if (N >= 2) {
            log++;
            log += logTo(N / 2);
        }
        return log;
    }
}
