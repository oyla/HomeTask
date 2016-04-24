/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Oyla
 */
class Phone {

    private String number;

    Phone() {
        this("");
    }

    Phone(String number) {
        Pattern p = Pattern.compile("^[0-9]{7,15}$");
        Matcher m = p.matcher(number);
        if (m.find()) {
            setNumber(number);
        } else {
            setNumber("");
        }

    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public String showPhone() {
        String s = "";
        if (getNumber().isEmpty()) {
            s = "Unknown phone";
        } else {
            s = getNumber();
            int count = s.length();
            int num = 3;
            int last = count % num;
            String symbol = "-";
            if (last == 1 || last == 0) {
                last += 3;
            }
            int parts = (count - last) / num;
            while (parts > 0) {
                s = s.replaceFirst(s.substring(0, parts * num), s.substring(0, parts * num) + symbol);
                parts--;
            }
        }
        return s;
    }
}
