/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click n
bfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Convert;
import view.Menu;

/**
 *
 * @author Nguyen Quang Hau
 */
public class ChangingBaseProgramming extends Menu<String> {

    private static String title = "CHANGE BASE";
    private static String options[] = {"From 2", "From 10", "From 16", "Exit"};
    private Convert c;

    public ChangingBaseProgramming() {
        super(title, options);
        c = new Convert();
    }

    @Override
    public void excute(int n) {
        int to = -1;

        switch (n) {

            // convert from base 2
            case 1:
                do {
                    to = menu2(n);

                    if (to != 3) {

                        String s = val.getString("Enter a binary number: ", "[01]{1,}");
                        int value = -1;
                        String result = "";

                        try {
                            value = Integer.parseInt(s);
                            if (to == 1) {
                                result = c.convertingFrom16To10(c.convertingFrom2To16(value));
                            } else {
                                result = c.convertingFrom2To16(value);
                            }

                            System.out.println("Result: " + result);
                        } catch (Exception e) {
                            System.out.println("The input is invalid");
                        }

                    }
                } while (to != 3);
                break;

            // convert from base 10
            case 2:
                do {
                    to = menu2(n);

                    if (to != 3) {

                        String s = val.getString("Enter a decimal number: ", "\\d{1,}");
                        int value = -1;
                        String result = "";

                        try {
                            value = Integer.parseInt(s);

                            if (to == 1) {
                                result = c.convertingFrom10To2(value);
                            } else {
                                value = Integer.parseInt(c.convertingFrom10To2(value));
                                result = c.convertingFrom2To16(value);
                            }

                            System.out.println("Result: " + result);
                        } catch (Exception e) {
                            System.out.println("The input is invalid");
                        }

                    }
                } while (to != 3);
                break;

            // convert from base 16
            case 3:
                do {
                    to = menu2(n);

                    if (to != 3) {

                        String s = val.getString("Enter a hexadecimal number: ", "[\\d|A-F]{1,}");
                        String result = "";
                        int value = 0;
                        try {

                            if (to == 1) {
                                value = Integer.parseInt(c.convertingFrom16To10(s));
                                result = c.convertingFrom10To2(value);
                            } else {
                                result = c.convertingFrom16To10(s);
                            }

                            System.out.println("Result: " + result);
                        } catch (Exception e) {
                            System.out.println("The input is invalid");
                        }

                    }
                } while (to != 3);
                break;

        }

    }

    private int menu2(int n) {
        String ops[] = new String[3];
        int choice = -1;

        if (n == 1) {
            n = 2;
            ops[0] = "To 10 ";
            ops[1] = "To 16 ";
        } else if (n == 2) {
            n = 10;
            ops[0] = "To 2 ";
            ops[1] = "To 16 ";
        } else {
            n = 16;
            ops[0] = "To 2 ";
            ops[1] = "To 10 ";
        }

        ops[2] = "Exit";

        System.out.println("----------------------");
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i + 1) + ". " + ops[i]);
        }
        return val.getIntData("Enter your selection: ", 1, 3);
    }

}
