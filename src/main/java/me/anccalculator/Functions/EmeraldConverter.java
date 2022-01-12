package me.anccalculator.Functions;

public class EmeraldConverter {

    public static String calculate(Double emeralds, boolean calcFees) {
        String fees = "";

        if (calcFees) {
            if (emeralds > 512 && emeralds < 16385) {
                emeralds = Math.floor(emeralds - (emeralds * 0.1));
                fees = "10%";
            } else if (emeralds > 16385 && emeralds < 65837) {
                emeralds = Math.floor(emeralds - (emeralds * 0.075));
                fees = "7.5%";
            } else if (emeralds > 65537 && emeralds < 262145) {
                emeralds = Math.floor(emeralds - (emeralds * 0.05));
                fees = "5%";
            } else if (emeralds > 262145) {
                emeralds = Math.floor(emeralds - (emeralds * 0.025));
                fees = "2.5%";
            }
        } else {
            fees = "0%";
        }

        double le = 0;
        double eb = 0;
        double e = 0;

        le = Math.floor((emeralds / 64) / 64);
        double leCalc = Math.floor((emeralds / 64) / 64);
        if (leCalc >= 1) {
            double afterLE = (leCalc * 64);
            eb = Math.floor((emeralds / 64) - afterLE);
        } else {
            eb = Math.floor(emeralds / 64);
        }
        double ebCalc = Math.floor(emeralds / 64);
        if (ebCalc >= 1) {
            double afterEB = (ebCalc * 64);
            e = Math.floor(emeralds - afterEB);
        } else {
            e = Math.floor(emeralds);
        }

        return String.format("%s LE\n%s EB\n%s E\n%s Fee", le, eb, e, fees);
    }
}
