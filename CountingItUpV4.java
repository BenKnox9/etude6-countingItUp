import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountingItUpV4 {
    
    private static ArrayList<Long> denomList = new ArrayList<Long>();
    /**
     * link to nuum count thing:
     * https://en.wikipedia.org/wiki/Combination
     **/

    /**
     * Method which iterates through an array of n to n - k, for example; 50, 50 - 1, ... 50 - k. Also iterates 
     * through another array of k to 0. We then find the greatest common denominator of the result and the list of k to 0.
     * After this we divide the result by that gcd and then multiply that result by the next item in the array for n.
     * This process gets repeated until all of the array k have been divided and all of the list k have been multiplied 
     * onto the result.
     *
     * @param n
     * @param k
     * @return the result from the N choose K set
     */
    public static long solve(long[] n, ArrayList<Long> k) {
        long ni, ki;
        long updated = 1;

        n = checkMods(n, k);
        for (int i = 0; i < n.length; i ++) { 
            ni = n[i];
            if (i > 0) {
                updated = ni * updated;
            }
            for (int j = 0; j < k.size(); j++) { 
                ki = k.get(j);
                if(i > 0) {
                    if(updated % ki == 0) {  
                        updated /= ki;
                        k.remove(j);  
                        j = 0;
                        continue;  
                    }
                    else {
                        continue;
                    }
                }
                if (ni % ki == 0) {  
                    updated *= (ni/ki);
                    k.remove(j);
                    j = 0; 
                    break;  
                }
            }
        }

        while(!k.isEmpty()) {
            System.out.println("InN THE WHILE LOOP");
            updated = updated/k.get(0);
            k.remove(0);
        }
        return updated;
    }

    public static long[] checkMods(long[] n, ArrayList<Long> k) {
        int count = 0;
        int nIndex = 0;

        if(k.size() == 1) {
            return n;
        }

        for (int i = 0; i < k.size(); i++) {
            for (int j = 0; j < n.length; j++) {
                long ki = k.get(i);
                if(n[j] % ki == 0) {
                    nIndex = j;
                    count++;
                }
            }
            if(count == 1) {
                n[nIndex] = n[nIndex] / k.get(i); 
                k.remove(i);
            }
        }
        return n;
    }

    /**
     * Creates a numerator which has its values starting from N to N - K
     * @param n 
     * @param k
     * @return a long array with the numerator decresing from N to N - K
     */
    public static long[] getNumerator(long n, long k) {
        long[] x = new long[(int)(k)];
        
        int j = 0;
        for(long i = n; i > n - k; i--) {
            x[j] = i;
            j++;
        }
        return x;
    }

    /**
     * Fills and arraylist of longs which is used for the denominator, ranging from k to 1
     * @param n
     * @param k
     * @return
     */
    public static ArrayList<Long> fillDenomList(long k) {

        ArrayList<Long> denomList = new ArrayList<>();
        for(long i = k; i > 0; i--) {
            denomList.add(i);
        }
        return denomList;
    }


    public static void main(String[] args) throws FileNotFoundException {
        
        // File f = new File("/Users/danielbohinc/Documents/2023/COSC326/etude6-countingitup/exampleIn.txt");
        // Scanner sc = new Scanner(f);
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            // denomList = new ArrayList<Long>();
            String input = sc.nextLine();
            input.strip();
            String[] inputArr = input.split(" ");

            long n = Long.parseLong(inputArr[0]);
            long k = Long.parseLong(inputArr[1]);

            long[] numerator = getNumerator(n, k);
            denomList = fillDenomList(k);
            System.out.println(solve(numerator, denomList));

        }

        sc.close();
    }
}