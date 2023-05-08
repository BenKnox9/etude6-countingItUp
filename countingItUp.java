import java.io.FileWriter;

class countingItUp {

    static long nuumCount = 0;

    public static void main(String[] args) throws Exception {
        
        FileWriter f = new FileWriter("/Users/danielbohinc/Documents/2023/COSC326/etude6-countingitup/testOutput.csv");

        f.write("Numerator, Denominator, Average Time, Output\n");
        runTests(f);

    }

    private static void runTests(FileWriter f) throws Exception {

        long endTime = 0;
        long answer = 0;
        long startTime = 0;
        long average = 0;

        for(int i = 1; i < 53; i++) {
            for (int denom = 1; denom < 11; denom++) {
                for (int j = 0; j < 10; j++) {
                    startTime = System.nanoTime();
                    answer = solve(i, denom);
                    endTime = System.nanoTime();
                    average += endTime - startTime;
                }
                average = average / 10;
                try {
                    f.write(i + ", " + denom + ", " + Long.toString(average) + ", " + Long.toString(answer) + "\n");
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println(e.getMessage());
                }
            }
        }
        f.close();
    }

    /**
     * link to nuum count thing:
     * https://en.wikipedia.org/wiki/Combination
     **/
    public static long factorialNumerator(long x, long y) {
        if (x < 0)
            throw new IllegalArgumentException("x must be >= 0");
        if (x <= 1)
            return 1; // Stop recursing here
        else if (nuumCount < y - 1) {
            nuumCount++;
            return x * factorialNumerator(x - 1, y); // Recurse by calling ourselves
        } else {
            return x;
        }
    }

    public static long factorialDenom(long y) {
        if (y < 0)
            throw new IllegalArgumentException("x must be >= 0");
        if (y <= 1)
            return 1; // Stop recursing here
        else {
            return y * factorialDenom(y - 1); // Recurse by calling ourselves
        }
    }

    public static long solve(long x, long y) {
        long value = factorialNumerator(x, y) / factorialDenom(y);
        nuumCount = 0;
        return value;
    }
}