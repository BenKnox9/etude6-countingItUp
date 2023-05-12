import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CountingItUpV3 {

    private static ArrayList<Long> denomList = new ArrayList<Long>();
        

    public static void main(String[] args) throws Exception {

        File f = new File("/Users/danielbohinc/Documents/2023/COSC326/etude6-countingitup/exampleIn.txt");
        // Scanner sc = new Scanner(f);
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            denomList = new ArrayList<Long>();
            String input = sc.nextLine();
            input.strip();
            String[] inputArr = input.split(" ");

            long n = Long.parseLong(inputArr[0]);
            long k = Long.parseLong(inputArr[1]);

            long[] numerator = getNumerator(n, k);
            denomList = fillDenomList(n, k);

            System.out.println(solve(numerator, denomList));
        }
        
        // FileWriter fileOutput = new FileWriter("/Users/danielbohinc/Documents/2023/COSC326/etude6-countingitup/dataOutput.txt");

        // fileOutput.write("Numerator, Denominator, Average Time, Output\n");
        // runTests(fileOutput);
    } 
    

    /**
     * link to nuum count thing:
     * https://en.wikipedia.org/wiki/Combination
     **/

    /**
     * if we had a input of 50 k, put 50, 50 - 1, ... 50 - k, put those into an array
     *  for each number in the array, we scan through the arraylist and check for largest 
     * of n which returns remainder of zero, if there is no remainder of zero 
     */
    /**
     * Method which iterates through an array of n to n - k, for example; 50, 50 - 1, ... 50 - k,
     * and through k to 0, finding the greatest common denominator of the two and multiplying the result of
     * the n/k to the result. If there is no common denominator then n will just be multiplied by the result.
     * After these loops have finished, the final result will be divided by any remaining demoninator in the
     * list of k to 0.
     * @param n
     * @param k
     * @return the result from the N choose K set
     */
    public static long solve(long[] n, ArrayList<Long> k) {
        long ni, ki;
        long result = 1;
        for (int i = 0; i < n.length; i ++){ 
            ni = n[i];
            for (int j = 0; j < k.size(); j++){ 
                ki = k.get(j);
                if (ni % ki == 0){  
                    result *= (ni/ki); 
                    k.remove(j);  
                    break;  
                }
                else if(j == k.size() - 1) {
                    result *= n[i]; 
                }
            }
        }

        long output = 1;
        long denomFinal = 1;
        for (int i = 0; i < k.size(); i++) {
            denomFinal *= k.get(i);
        }

        output = result/denomFinal;
        return output;
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
    public static ArrayList<Long> fillDenomList(long n, long k) {
        
        int j = 0;
        for(long i = k; i > 0; i--) {
            denomList.add(i);
            j++;
        }
        return denomList;
    }
    
    /**
     * used for testing, initialises the long array and denom list which is then used to calculate
     * @param n
     * @param k
     * @return final result of N chose K
     */
    public static long connectMethods(long n, long k){
        denomList = new ArrayList<Long>();
        long[] numerator = getNumerator(n, k);
        denomList = fillDenomList(n, k);

        return solve(numerator, denomList);
    }


    /**
     * Method used to output data to a file, which averages the time in nano seconds from 10 runs of N chose K.
     * @param f
     * @throws Exception
     */
    private static void runTests(FileWriter f) throws Exception {

        long endTime = 0;
        long answer = 0;
        long startTime = 0;
        long average = 0;

        for(int i = 1; i < 53; i++) {
            for (int denom = 1; denom < 11; denom++) {
                average = 0;
                for (int j = 0; j < 10; j++) {

                    startTime = System.nanoTime();
                    answer = connectMethods((long)i, (long)denom);
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
