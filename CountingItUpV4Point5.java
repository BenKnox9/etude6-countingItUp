import java.util.Scanner;

public class CountingItUpV4Point5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            // denomList = new ArrayList<Long>();
            String input = sc.nextLine();
            input.strip();
            String[] inputArr = input.split(" ");

            long n = Long.parseLong(inputArr[0]);
            long k = Long.parseLong(inputArr[1]);

            System.out.println(binomialCoefficient(n, k));
        }
    }

    /**
     * Using Euclids algorithm for GDC
     * Used from https://www.w3resource.com/java-exercises/basic/java-basic-exercise-157.php 
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long binomialCoefficient(long n, long k) {
        // symmetry of Pascal's Triangle
        if (k > n - k) {
            k = n - k; 
        }

        //k = 1 return n
        //n = k return 1

        long result = 1;

        for (long i = 1, m = n; i <= k; i++, m--) {
            //get gcd for next number in denom
            long d = gcd(result, i + 1);
            
            //divide result by gdc
            result = result / d;

            long nextTerm = m;

            //get gcd for next value in numerator --> same as above just with numerator
            d = gcd(nextTerm, i + 1);

            // //divide next numerator by gcd
            nextTerm = nextTerm / d;
            
            //multiply result by next term
            result = result * nextTerm; 
        }
        return result;
    }

}
