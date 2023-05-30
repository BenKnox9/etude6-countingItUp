import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Class used to run testing on our CountingItUp program. Spits out the
 * corresponding times and values into our csv file
 */
public class CoutingItUpTesting {

    private static ArrayList<Long> denomList = new ArrayList<Long>();

    public static void main(String[] args) throws Exception {

        FileWriter fileOutput = new FileWriter("testOutput.csv");

        fileOutput.write("Numerator, Denominator, Average Time, Output\n");

        long startTime = 0, endTime = 0;
        long total = 0;
        for (int i = 0; i <= 9; i++) {
            startTime = System.nanoTime();
            runTests(fileOutput);
            endTime = System.nanoTime();
            total += (endTime - startTime);
            fileOutput = new FileWriter("testOutput.csv");
        }

        System.out.println("Total time: " + ((total) / 1_000_000) / 10 + "ms");
        fileOutput.close();
    }

    /**
     * used for testing, initialises the long array and denom list which is then
     * used to calculate
     * 
     * @param n
     * @param k
     * @return final result of N chose K
     */
    public static long connectMethods(long n, long k) {
        denomList = new ArrayList<Long>();
        long[] numerator = CountingItUpV4.getNumerator(n, k);
        ArrayList<Long> denomList = CountingItUpV4.fillDenomList(k);

        return CountingItUpV4.solve(numerator, denomList);
    }

    /**
     * Method used to output data to a file, which averages the time in nano seconds
     * from 10 runs of N chose K.
     * 
     * @param f
     * @throws Exception
     */
    private static void runTests(FileWriter f) throws Exception {

        long endTime = 0;
        long answer = 0;
        long startTime = 0;
        long average = 0;

        for (int i = 1; i < 101; i++) {
            for (int denom = 1; denom < 16; denom++) {
                average = 0;
                for (int j = 0; j < 10; j++) {

                    startTime = System.nanoTime();
                    answer = connectMethods((long) i, (long) denom);
                    endTime = System.nanoTime();
                    average += endTime - startTime;
                }
                average = (average / 10);
                try {
                    f.write(i + ", " + denom + ", " + Long.toString(average) + ", " + Long.toString(answer) + "\n");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        f.close();
    }
}
