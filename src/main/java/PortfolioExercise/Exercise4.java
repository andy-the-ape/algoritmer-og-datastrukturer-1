package PortfolioExercise;

import java.util.*;

public class Exercise4 {
    /*
    Skriv en algoritme, der har et array af usorterede, entydige naturlige tal som input og find de tre tal i
    arrayet, hvis sum er tættest på en potens af 2. Det samme tal kan må bruges én gang.
    Algoritmens returværdi skal være et heltalsarray, som først indeholder de tre tal og dernæst den tilhørende
    potens af to (fx 512).
    Kaldt med arrayet {23,56,22,11,65,89,3,44,87,910,45,35,98}, returneres de tre tal 89, 3, 35 og potensen af
    2: 128.
    */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThreeNumbers(
                new int[]{23,56,22,11,65,89,3,44,87,910,45,35,98}
        )));
    }

    public static int[] findThreeNumbers(int[] inputArray) {
        //The same number can only be used once, so we purge all duplicates of the inputArray:
        LinkedHashSet<Integer> uniqueNumbersSet = new LinkedHashSet<>();
        for (int i : inputArray) {
            uniqueNumbersSet.add(i);
        }
        //Convert new Integer Set back to int array:
        int[] uniqueNumbersArray = uniqueNumbersSet.stream().mapToInt(x -> x).toArray();

        HashMap<int[], Integer> sumOfThreeNumbers = new HashMap<>();

        for (int i = 0; i < uniqueNumbersArray.length - 2; i++) {

            for (int j = i + 1; j < uniqueNumbersArray.length - 1; j++) {

                for (int k = j + 1; k < uniqueNumbersArray.length; k++) {
                    sumOfThreeNumbers.put(new int[]{
                            uniqueNumbersArray[i],
                            uniqueNumbersArray[j],
                            uniqueNumbersArray[k]
                    }, uniqueNumbersArray[i]+uniqueNumbersArray[j]+uniqueNumbersArray[k]);
                }
            }
        }

        //Find power of 2 values up to 100 and save them in a LinkedList:
        LinkedList<Integer> powerOfTwosList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            powerOfTwosList.add(i, (int) Math.pow(2, i+1));
        }

        //Check our sums against the power of 2 and save their proximity as a value in a new HashMap:
        HashMap<int[], int[]> proximityMap = new HashMap<>();
        for (Map.Entry<int[], Integer> entry : sumOfThreeNumbers.entrySet()) {
            for (Integer powerOfTwo : powerOfTwosList) {
                int absoluteDifference;
                if (entry.getValue() > powerOfTwo) {
                    absoluteDifference = entry.getValue() - powerOfTwo;
                }
                else if (entry.getValue() < powerOfTwo) {
                    absoluteDifference = powerOfTwo - entry.getValue();
                }
                else {
                    absoluteDifference = 0;
                }
                if (proximityMap.containsKey(entry.getKey())) {
                    if (proximityMap.get(entry.getKey())[0] > absoluteDifference) {
                        proximityMap.replace(entry.getKey(), new int[]{absoluteDifference, powerOfTwo});
                    }
                } else {
                    proximityMap.put(entry.getKey(), new int[]{absoluteDifference, powerOfTwo});
                }
            }
        }

        //Now run through all proximity values to determine the three numbers that have a sum closest to a power of 2:
        int[] closestResult = new int[4];
        int smallestProximityValue = -1;
        for (Map.Entry<int[], int[]> entry : proximityMap.entrySet()) {
            if (closestResult[3] == 0) {
                smallestProximityValue = entry.getValue()[0];
                closestResult = new int[]{
                        entry.getKey()[0], entry.getKey()[1], entry.getKey()[2], entry.getValue()[1]
                };
            }
            if (entry.getValue()[0] < smallestProximityValue) {
                smallestProximityValue = entry.getValue()[0];
                closestResult = new int[]{
                        entry.getKey()[0], entry.getKey()[1], entry.getKey()[2], entry.getValue()[1]
                };
            }
        }
        return closestResult;
    }
}
