package utils;

public class VariableUtils {
    public static boolean isNumber(String s){
        boolean r = false;
        try {
            Double.parseDouble(s);
            r = true;
        } catch (Exception e) {
            r = false;
        }
        return r;
    }
}