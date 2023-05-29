import java.util.Scanner;

public class CountingItUpV5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String input = sc.nextLine();
            input.strip();
            String[] inputArr = input.split(" ");

            long n = Long.parseLong(inputArr[0]);
            long k = Long.parseLong(inputArr[1]);

            System.out.println(binomial(n, k));
        }
        sc.close();
    }

    public static long binomial(long n, long k) {
        long result = 1;

        long divResult;
        long divRemainder;
        long multiply1;
        long multiply2;

        k = Math.min(k, n - k);

        for (long i = 1; i <= k; i++) {

            divResult = result / i;
            divRemainder = result % i;

            multiply1 = divResult * n;
            multiply2 = divRemainder * n;

            result = multiply1 + (multiply2 / i);

            n--;
        }
        return result;
    }
}
