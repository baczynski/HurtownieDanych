import java.io.*;

/**
 * Created by PC on 2016-03-10.
 */
public class GenerateIntegers {

    public static void main(String [] args){

        try (BufferedReader br = new BufferedReader(new FileReader("insertion_customer.txt"))) {
          String line = br.readLine();
            int oldValue=0;
            boolean found = false;
            while (line != null && !found) {

                String[] values = line.split("[']");
                int presetValue = Integer.parseInt(values[1]);
                if (oldValue != presetValue-1) {
                    found = true;
                }
                oldValue=presetValue;


                line = br.readLine();
            }
            br.close();
            System.out.println(oldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
