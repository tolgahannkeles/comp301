package homework1;

public class Question1 {

    public static void main(String[] args) {
        System.out.println("The smallest value of n is: " + findSmallestN());
    }

    static int findSmallestN() {
        //Time complexity of the function is O(n) because the while loop runs n times.
        int n = 1;
        while (100 * n * n > Math.pow(2, n)) {
            //The condition is equivalent to 100n^2 > 2^n
            n++;
        }
        return n;
    }
}