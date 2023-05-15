import java.io.FileWriter;
import java.math.BigInteger;

public class BigIntOutPut {
    
    public static void main(String[] args) {
        
        runTests();
    }
    
    static BigInteger binom(int N, int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                     .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

    private static void runTests() {

        long answer = 0, bigIntvalue;
        int wrongAnwers = 0;

        for(int i = 1; i < 101; i++) {
            for (int denom = 1; denom < 16; denom++) {
                answer = CoutingItUpTesting.connectMethods((long)i, (long)denom);
                bigIntvalue = binom(i, denom).longValue();
                if(bigIntvalue != answer) {
                    System.out.println("i:  " + i + ",  DENOM:  " + denom);
                    System.out.println("Big int value:  " + bigIntvalue + ", Solve value: " + answer + "\n");
                    wrongAnwers++;
                }
            }
        }
        System.out.println("Number of wrong answers: " + wrongAnwers);
    }
}
