package me.kylesimmonds.romancalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RomanController {

    @GetMapping("/calculator")
    public String displayCalculator(Model model) {
        model.addAttribute("calculator", new Conversion());
        return "calculator";
    }

    @PostMapping("/calculator")
    public String processLogin(@ModelAttribute Conversion conversion, Model model) {
        String roman = conversion.getRoman();
        int value = conversion.getValue();
        conversion.setRoman(integerToRomanNumeral(value));
        conversion.setValue(romanToInteger(roman));
        model.addAttribute("calculator", conversion);
        return "result";
    }

    private int romanToInteger(String s) {
        int result = 0;
        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String test = s;

        for (int i = 0; i < decimal.length; i++) {
            while (test.indexOf(roman[i]) == 0) {
                result += decimal[i];
                test = test.substring(roman[i].length());
            }
        }
        return result;
    }

    private String integerToRomanNumeral(int input) {
        if (input < 1 || input > 3999) return "N/A";

        String s = "";

        while (input >= 1000) {
            s += "M";
            input -= 1000;
        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }

        return s;
    }
}
