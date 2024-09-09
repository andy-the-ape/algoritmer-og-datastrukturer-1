package LectionOne;

public class LectionOne {
    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(evenSquares(6));
        System.out.println(fib(4));
        System.out.println(linear("hellomygoodfriend", 'd', 17));
        int[] array = {1, 2, 3, 7, 8, 10, 15, 31, 43, 78, 99, 102, 131, 203, 401, 505, 1002, 1102, 1104, 1234, 1450};
        System.out.println(binarySearch(array, 505));
    }

    public static int sum(int n) {
        //returns the sum of the first n natural numbers
        if (n < 1) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static int evenSquares(int n) {
    //returns the sum of the first n even numbers’ squares
        if (n < 1) {
            return 0;
        }
        int nthEvenNumber = 2 * n;
        return nthEvenNumber * nthEvenNumber + evenSquares(n - 1);
    }

    public static int fib(int n) {
    //returns the nth Fibonacci number
        if (n < 1) {
            return 0;
        }
        else if (n == 1 )
            return 1;
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static boolean linear(String s, char c, int l) {
    //returns true if string s with the length l contains
    //char c, otherwise false.
        if (l < 1) {
            return false;
        }
        if (s.charAt(0) == c) {
            return true;
        }
        else {
            return linear(s.substring(1,l), c, l-1);
        }
    }

    public static boolean binarySearch(int[] arr, int value) {
    //returns true if value is in arr, otherwise false
    //the elements in arr are sorted
        return binarySearch(arr, value, 0, arr.length-1);
    }
    public static boolean binarySearch(int[] arr, int value, int left, int right) {
    //overloading method to be able to call it recursively.
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;

        if (arr[mid] == value) {
            return true;
        }
        else if (value < arr[mid]) {
            return binarySearch(arr, value, left, mid - 1);
        }
        else {
            return binarySearch(arr, value, mid + 1, right);
        }
    }
}
