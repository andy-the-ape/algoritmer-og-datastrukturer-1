package PortfolioExercise;

public class Exercise7 {
    /*
    6561 er et eksempel på et naturligt tal, som kan skrives som X^Y hvor X og Y er heltal, dvs. 9^4. Et andet
    eksempel er 3125 (5^5).
    Skriv en algoritme, som kan afgøre om et givent naturligt tal Z < 100,000 (algoritmens parameter) kan
    skrives som Z=X^Y hvor X og Y er heltal, hvorom det gælder, at X > 2 og Y > 2.
    Algoritmens returværdi skal designes således, at følgende information kan udledes fra den:
    • Værdien af X (i tilfældet 6561 er X=9).
    • Værdien af Y (i tilfældet 6561 er Y=4).
    • For det givne Z kan der være flere løsningspar (X,Y). For 3125 er der kun et
    løsningspar; men for 6561 er X=3 og Y=8 også en mulighed. Hvis der er mere end én
    løsning, skal den med den største X-værdi returneres.
    • Hvis det givne Z ikke har noget løsningspar (X,Y) eller Z indeholder en ulovlig værdi,
    returneres en dummy eller default værdi.
    Algoritmen skal optimeres under antagelsen af, at maksimumværdien for Z og minimumsværdierne for X og
    Y aldrig ændrer sig.
     */
    public static void main(String[] args) {
        System.out.println(naturalNumbersComposition(6561));
    }

    public static String naturalNumbersComposition(int Z) {
        //Based on the condition that X and Y must both be > 2 and a natural number, we know that Z must at least be
        //3^3 = 27.
        if (Z >= 100000 || Z <= 27 ) {
            return "Error: The input value must be a natural number between 27 and 100000!";
        }
        int[] solutionPair = new int[2];

        outerLoop:
        for (int X = 3; X <= Z; X++) {
            for (int Y = 3; Y <= Z; Y++) {
                if (Math.pow(X, Y) > Z) {
                    break;
                } else if (Math.pow(X, Y) == Z) {
                    if (X > solutionPair[0]) {
                        solutionPair[0] = X;
                        solutionPair[1] = Y;
                    }
                }
            }
        }

        if (solutionPair[0] == 0) {
            return "There are no possible solutions for that input value.";
        }
        else {
            return Z + " can be composed by " + solutionPair[0] + " to the power of " + solutionPair[1];
        }
    }
}
