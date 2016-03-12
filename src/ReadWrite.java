import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2016-03-09.
 */
public class ReadWrite {

    public static void main(String[] args) {
        List<Integer> emptyList = new ArrayList<>();

        List<Integer> customerColumnToOmit = new ArrayList<>();
        customerColumnToOmit.add(15);
        customerColumnToOmit.add(16);

        List<Integer> productsColumnsToOmit = new ArrayList<>();
        productsColumnsToOmit.add(6);

        reWrite("DATABASE/products.txt", "DATABASE/INSERTION/insertion_products.txt", "PRODUCTS",productsColumnsToOmit);
        reWrite("DATABASE/inventory.txt", "DATABASE/INSERTION/insertion_inventory.txt", "INVENTORY",emptyList);
        reWrite("DATABASE/customer.txt", "DATABASE/INSERTION/insertion_customer.txt", "CUSTOMER", customerColumnToOmit);
        reWrite("DATABASE/customer_hist.txt", "DATABASE/INSERTION/insertion_customer_hist.txt", "CUSTOMER_HIST",emptyList);
        reWrite("DATABASE/orderlines.txt", "DATABASE/INSERTION/insertion_orderlines.txt", "ORDERLINES",emptyList);
        reWrite("DATABASE/orders.txt", "DATABASE/INSERTION/insertion_orders.txt", "ORDERS",emptyList);


    }

    static void reWrite(String inputFileName, String outputFileName, String table, List<Integer> columnsToOmit) {

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outputFileName), "utf-8"));


            String insert = "INSERT INTO " + table + " VALUES(";
            while (line != null) {

                String[] values = line.split("[\t]");
                sb = new StringBuilder();

                sb.append(insert);

                for (int i = 0; i < values.length; i++) {
                    if(!columnsToOmit.contains(i)) {
                        sb.append("'");
                        sb.append(values[i]);
                        sb.append("'");

                        if (i < values.length - 1) {
                            sb.append(",");
                        }
                    }
                }
                if(sb.charAt(sb.length()-1)==','){
                    sb.replace(sb.length()-1,sb.length(),")");
                }
                else {
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
