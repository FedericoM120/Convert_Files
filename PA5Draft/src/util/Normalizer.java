package util;
import java.math.BigDecimal;
import java.util.*;
public class Normalizer {
    private static String normalize(String cell){
        if(cell.isEmpty())
            return "N/A";
        try{
            int ival = Integer.parseInt(cell);
            String rv = "" + Math.abs(ival);
            for(int i = 0; i < 9 - ("" + Math.abs(ival)).length();i++)
                rv = "0" + rv;
            rv = (ival >= 0?"+": "-") + rv;
            return rv;
        }catch(InputMismatchException exp){
            try{
                //non-integer
                double dval = Double.parseDouble(cell);
                if (dval > 100 || dval < .01) {
                    System.out.printf("%.2e", dval);
                }
                if (BigDecimal.valueOf(dval).scale() > 2) {
                    System.out.printf("%.2f", dval);
                }
            }catch(InputMismatchException exp2){
                //non-numerical
                String sval = cell;
                if (sval.length() < 14) {
                    System.out.println(sval);
                } else {
                    System.out.println(sval.substring(0, 10) + "...");
                }
            }
        }
    }
    public static ArrayList<String>normalizeTable(ArrayList<String> rows, String fileFormat){
        //Your code here:
        //Step 1: Break down every row into cells
        //Step 2: call normalize to normalize each cell
        //Step 3: merge normalized cells with the same separator that you used to break them down.
    }
}
