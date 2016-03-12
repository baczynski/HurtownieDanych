import java.io.*;

/**
 * Created by PC on 2016-03-09.
 */
public class ReadWrite {

//    public static void main(String[] args) {
////        reWrite("inventory.txt", "INVENTORY");
// //      reWrite("customer.txt", "CUSTOMER");
////        reWrite("customer_hist.txt", "CUSTOMER_HIST");
////        reWrite("orderlines.txt", "ORDERLINES");
////        reWrite("orders.txt", "ORDERS");
//       reWrite("products.txt", "PRODUCTS");
//
//    }

    static void reWrite(String fileName, String table) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("insertion_" + fileName), "utf-8"));


            String insert = "INSERT INTO " + table + " VALUES(";
            while (line != null) {

                String[] values = line.split("[\t]");
                sb = new StringBuilder();

                sb.append(insert);

                for (int i = 0; i < values.length; i++) {
                        sb.append("'");
                        sb.append(values[i]);
                        sb.append("'");

                    if (i < values.length - 1) {
                        sb.append(",");
                    } else
                        sb.append(")");
                }
                sb.append(System.lineSeparator());
                writer.write(sb.toString());
                line = br.readLine();
            }
            String everything = sb.toString();

            writer.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
