package ru.kalispeller.HackedClient.module;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GlobFunc {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double getFrac(double val) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(val));
        int intVal = bigDecimal.intValue();
        double FracVal = bigDecimal.subtract(new BigDecimal(intVal)).doubleValue();
        return FracVal;
    }

    public static int getInt (double val) {
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(val));
        int intVal = bigDecimal.intValue();
        return intVal;
    }
}
