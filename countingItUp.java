
class countingItUp {

    static long nuumCount = 0;

    public static void main(String[] args) {
        System.out.print(solve(3, 2));
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
        return factorialNumerator(x, y) / factorialDenom(y);
    }
}