package PortfolioExercise;

import java.util.HashMap;
import java.util.HashSet;

public class Exercise11 {
    /*
    Tabellen nedenfor repræsenterer de afgivne stemmer ved et valg.
    {7,4,3,5,3,1,6,4,5,1,7,5}
    I dette eksempel er der 7 kandidater (1-7), og der er afgivet 12 stemmer. Kandidat 6 fik 1 stemme,
    kandidaterne 1, 3, 4 og 7 fik hver 2 stemmer, kandidat 5 fik 3 stemmer, and kandidat 2 fik 0 stemmer.
    Opgaven går ud på at skrive en algoritme, som kaldt med tabellen og eventuelt tabellens længde, kan
    afgøre om en kandidat fik mere end 50 % af stemmerne. I så fald returneres kandidatens nummer. Hvis
    ingen kandidat fik over 50 % af stemmerne, returneres -1.
    I eksemplet opnåede ingen af kandidaterne flertal, og der returneres -1.
     */
    public static void main(String[] args) {
        System.out.println(findMajorityVote(new int[]{7,4,3,5,3,1,6,4,5,1,7,5,5,5,5,5,5,5,5,5}));
    }

    public static int findMajorityVote(int[] table) {
        //We will use a HashMap to gather all the votes uniquely
        //with the vote as the key and the number of votes as the value
        //and keep track of the highest count of votes
        HashMap<Integer, Integer> voteMap = new HashMap<>();
        int voteWithHighestCount = 0;
        for (Integer vote : table) {
            if (!voteMap.containsKey(vote)) {
                voteMap.put(vote, 1);
                voteWithHighestCount = vote;
            } else {
                voteMap.put(vote, voteMap.get(vote)+1);

                if (voteWithHighestCount != vote) {
                    if (voteMap.get(voteWithHighestCount) < voteMap.get(vote)) {
                        voteWithHighestCount = vote;
                    }
                }
            }
        }
        //Determine if vote with the highest count has exceeded 50% of the amount of possible votes
        if (voteMap.get(voteWithHighestCount) > table.length/2) {
            return voteWithHighestCount;
        } else {
            return -1;
        }
    }
}
