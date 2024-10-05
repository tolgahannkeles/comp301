package homework1;

public class Question2 {
    static long oneMinuteInMicroseconds = 60 * 1000000;
    static long oneHourInMicroseconds = 60 * oneMinuteInMicroseconds;
    static long oneDayInMicroseconds = 24 * oneHourInMicroseconds;
    static long oneMonthInMicroseconds = 30 * oneDayInMicroseconds;

    public static void main(String[] args) {
        System.out.println("For n log n:");
        calculateNLogNRow();
        System.out.println("--------------------");
        System.out.println("For n!:");
        calculateFactorialRow();
    }

    static void calculateNLogNRow() {
        // It calculates the largest problem size solvable in 1 minute, 1 hour, 1 day, and 1 month for n log n.
        System.out.println("Largest problem size solvable in 1 minute for n log n: " + findNLogN(oneMinuteInMicroseconds));
        System.out.println("Largest problem size solvable in 1 hour for n log n: " + findNLogN(oneHourInMicroseconds));
        System.out.println("Largest problem size solvable in 1 day for n log n: " + findNLogN(oneDayInMicroseconds));
        System.out.println("Largest problem size solvable in 1 month for n log n: " + findNLogN(oneMonthInMicroseconds));
    }

    static void calculateFactorialRow() {
        // It calculates the largest problem size solvable in 1 minute, 1 hour, 1 day, and 1 month for n!.
        System.out.println("Largest problem size solvable in 1 minute for n!: " + findFactorial(oneMinuteInMicroseconds));
        System.out.println("Largest problem size solvable in 1 hour for n!: " + findFactorial(oneHourInMicroseconds));
        System.out.println("Largest problem size solvable in 1 day for n!: " + findFactorial(oneDayInMicroseconds));
        System.out.println("Largest problem size solvable in 1 month for n!: " + findFactorial(oneMonthInMicroseconds));
    }

    static long findNLogN(long time) {
        // It finds the largest n such that n log n <= time.
        // The function uses binary search to find n.
        long low = 1;
        long high = time;
        long mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            double result = mid * Math.log(mid) / Math.log(2);

            if (result == time) {
                return mid;
            } else if (result < time) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    static long findFactorial(long time) {
        // It finds the largest n such that n! <= time.
        long n = 1;

        while (factorial(n) <= time) {
            n *= 2;
        }
        while (factorial(n) >= time) {
            n--;
        }
        return n;
    }

    private static long factorial(long n) {
        // It calculates the factorial of n.
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}