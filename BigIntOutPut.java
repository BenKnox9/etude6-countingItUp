import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class BigIntOutPut {

    private static ArrayList<Long> denomList = new ArrayList<Long>();

    public static void main(String[] args) throws FileNotFoundException {
        int problems = 0;

        File f = new File("mock.txt");
        Scanner sc = new Scanner(f);
        // Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            denomList = new ArrayList<Long>();
            String input = sc.nextLine();
            input.strip();
            String[] inputArr = input.split(" ");

            long n = Long.parseLong(inputArr[0]);
            long k = Long.parseLong(inputArr[1]);

            long answer = CountingItUpV5.binomial(n, k);

            long bigIntvalue = binom((int) n, (int) k).longValue();

            if (answer != bigIntvalue) {
                System.out.println("n:  " + n + ",  k:  " + k);
                System.out.println("Big int value:  " + bigIntvalue + ", Solve value: " + answer + "\n");
                problems++;
            }

        }
        System.out.println("Number of problems: " + problems);

    }

    private static void compare(long n, long k) {

        long answer = CoutingItUpTesting.connectMethods(n, k);
        long bigIntvalue = binom((int) n, (int) k).longValue();

        System.out.println("COUNTING:   " + answer);
        System.out.println("BIG INT:    " + bigIntvalue);
    }

    static BigInteger binom(int N, int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N - k))
                    .divide(BigInteger.valueOf(k + 1));
        }
        return ret;
    }

    private static void runTests() {

        long answer = 0, bigIntvalue;
        int wrongAnwers = 0;

        for (int i = 1; i < 151; i++) {
            for (int denom = 1; denom < 15; denom++) {
                answer = CoutingItUpTesting.connectMethods((long) i, (long) denom);
                bigIntvalue = binom(i, denom).longValue();
                if (bigIntvalue != answer) {
                    System.out.println("i:  " + i + ",  DENOM:  " + denom);
                    System.out.println("Big int value:  " + bigIntvalue + ", Solve value: " + answer + "\n");
                    wrongAnwers++;
                }
            }
        }
        System.out.println("Number of wrong answers: " + wrongAnwers);
    }
}
