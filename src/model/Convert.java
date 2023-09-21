/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author Nguyen Quang Hau
 */
public class Convert {

    public String convertingFrom10To2(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            result.append(n % 2);
            n /= 2;
        }

        return result.reverse().toString();
    }

    public String convertingFrom2To16(int n) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        int k = 0;

        while (n > 0) {
            k += (n % 10) * (int) Math.pow(2, count);
            count++;

            if (count == 4 || n / 10 == 0) {
                if (k > 9) {
                    result.append((char) (k + 55));
                } else {
                    result.append(k);
                }
                count = 0;
                k = 0;
            }
            n /= 10;
        }

        return result.reverse().toString();
    }

    public String convertingFrom16To10(String s) {
      
        int sum = 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isAlphabetic(c)) {
                sum += (c - 55) * (int) Math.pow(16, count);
            } else {
                sum += (c - '0') * (int) Math.pow(16, count);
            }
            count++;
        }

        return sum+"";
    }

}
