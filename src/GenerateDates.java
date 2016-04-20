//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
//
///**
// * Created by Konrad on 05.04.2016.
// */
//public class GenerateDates {
//
//    public static void main(String[] args) {
//
//        GenerateDates g = new GenerateDates();
//
//        g.generateDates("insertion_dates.txt","dates",2004,0,1,2004,11,31);
//
//    }
//
//    public void generateDates(String outputFileName, String table, int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
//        StringBuilder sb = new StringBuilder();
//        GregorianCalendar startD = new GregorianCalendar(startYear, startMonth, startDay);
//        GregorianCalendar endD = new GregorianCalendar(endYear, endMonth, endDay);
//
//        try {
//            Writer writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream(outputFileName), "utf-8"));
//
//            String insert = "INSERT INTO " + table + " VALUES(";
//            int i = 0;
//            while (!startD.after(endD)) {
//
//                sb = new StringBuilder();
//
//                sb.append(insert);
//
//                sb.append("'");
//                sb.append(++i);
//                sb.append("'");
//                sb.append(",");
//                sb.append("'");
//                sb.append(startD.get(Calendar.DAY_OF_MONTH));
//                sb.append("'");
//                sb.append(",");
//                sb.append("'");
//                sb.append(startD.get((Calendar.MONTH))+1);
//                sb.append("'");
//                sb.append(",");
//                sb.append("'");
//                sb.append(startD.get(Calendar.YEAR));
//                sb.append("'");
//                sb.append(")");
//                sb.append(System.lineSeparator());
//                startD.add(Calendar.DAY_OF_MONTH,1);
//                writer.write(sb.toString());
//            }
//
//
//
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
