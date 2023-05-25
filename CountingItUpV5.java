import java.util.Scanner;

public class CountingItUpV5 {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            // denomList = new ArrayList<Long>();
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
        long result = 1, i;
      
        if (k > n-k) // take advantage of symmetry
            k = n-k;
      
        for (i = 1; i <= k; i++, n--) {
            if (result/i > Long.MAX_VALUE/n) // return 0 on potential overflow
                return 0;

            result = result / i * n + result % i * n / i; // split result * n / i into (result / i * i + c % i) * n / i
        }
        return result;
      }
}
