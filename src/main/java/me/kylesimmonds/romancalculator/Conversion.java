package me.kylesimmonds.romancalculator;

public class Conversion {
    private String roman;
    private int value;

    public String getRoman() {
        return roman;
    }
    public void setRoman(String roman) {
        this.roman = roman.toUpperCase();
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
