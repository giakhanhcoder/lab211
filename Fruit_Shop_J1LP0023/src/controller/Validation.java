/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author GIA KHANH
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public String getString(String msg, String valid) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (s.matches(valid)) {
                return s;
            }
            System.err.println("INVALID STRING! PLEASE INPUT AGAIN!");
        }
    }

    public int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.err.println("Please enter an integer in range " + min + " ==> " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer in range " + min + " ==> " + max);
            }
        }

    }

    public double getDouble(String msg, double min, double max) {
        while (true) {
            try {
                System.out.print(msg);
                double n = Double.parseDouble(sc.nextLine());
                if (n < min || n > max) {
                    System.err.println("Please enter an real number in range " + min + " ==> " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Please enter an real number in range " + min + " ==> " + max);
            }
        }

    }

    public boolean getYN(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("y")) {
                return true;
            } else if (s.equalsIgnoreCase("n")) {
                return false;
            }
            System.err.println("Please input only Y/N");
        }
    }

}
