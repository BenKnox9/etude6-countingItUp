public class countingItUpV2 {

    public static void main(String[] args) {
        System.out.println(solve(100, 15));
    }

    /**
     * link to nuum count thing:
     * https://en.wikipedia.org/wiki/Combination
     **/
    public static long solve(long x, long y) {
        double ans = 1;
        for (int i = 1; i < y + 1; i++) {
            ans = ans * ((double) x-- / i);
        }
        return (long) ans;
    }
}
