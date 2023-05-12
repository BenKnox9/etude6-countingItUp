def main():


    def solve(x, y):
        ans = 1
        for i in range(1, y + 1):
            ans = ans * (x / i)
            x-=1
        return ans

    # public static long solve(long x, long y) {
    print(solve(100, 10))
    #     double ans = 1;
    #     for (int i = 1; i < y + 1; i++) {
    #         ans = ans * ((double) x-- / i);
    #     }
    #     return (long) ans;
    # }

main()