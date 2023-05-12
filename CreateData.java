import java.io.FileWriter;
import java.math.BigInteger;
import java.util.Random;

public class CreateData {
    
    public static void main(String[] args) {
        
        // FileWriter fw = new FileWriter("/Users/danielbohinc/Documents/2023/COSC326/etude6-countingitup/dataOutput.txt");
        
        Random r = new Random();

        BigInteger output = new BigInteger(128, r);

        System.out.println(output);
    }
}
