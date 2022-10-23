package BarPlot;

import java.util.Scanner;

public class Barplot {
    /**
     * Repeat a character n times.
     *
     * @param c The character to repeat
     * @param n the number of times to repeat the character c
     * @return A string of the character c repeated n times.
     */
    public static String repeat(char c, int n) {
        return String.valueOf(c).repeat(n);
    }

    /**
     * If the label is shorter than the length, pad it with spaces. If the label is longer than the length, truncate it. If
     * the label is the same length as the length, return the label
     *
     * @param label The label to draw
     * @param length The length of the label.
     * @return A string of the label with the correct length.
     */
    public static String drawLabel(String label, int length) {
        if(label.length() < length) {
            return label + repeat(' ', (length - label.length()));
        } else if(label.length() > length) {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < length; i++) {
                value.append(label.charAt(i));
            }
            return value.toString();
        } else {
            return label;
        }
    }

    /**
     * It takes a label and a value, and returns a string that represents a bar chart
     *
     * @param label The label for the bar.
     * @param value The value of the bar. Must be between 0 and 30 (inclusive).
     * @return A string that is a bar graph.
     */
    public static String drawBar(String label, int value) {
        if(value < 0 || value > 30) {
            return null;
        }
        return label + "|" + repeat('#', value) + repeat(' ', 30-value) + "|";
    }

    /**
     * It takes a label and a value between 0 and 1, and returns a string that represents a bar chart of the value
     *
     * @param label The label of the bar.
     * @param value a double between 0 and 1
     * @return A string that is a bar graph of the value.
     */
    public static String drawBar(String label, double value) {
        if(value < 0 || value > 1) {
            return null;
        }
        value *= 30;
        int valueNew = (int) value;
        return label + "|" + repeat('#', valueNew) + repeat(' ', 30-valueNew) + "|";
    }

    /**
     * The main method takes in a string and an integer as input, and prints out a barplot of the string with the length of the
     * barplot being the integer
     */
    public static void main(String[] args) {
        String label = "";
        int len = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        if (sc.hasNext()) {
            label = sc.next();
        }
        else{
            System.out.println("Incorrect Input");
            return;
        }
        if (sc.hasNextInt()) {
            len = sc.nextInt();
        }
        else{
            System.out.println("Incorrect Input");
            return;
        }
        String dLabel = drawLabel(label, len);
        System.out.println(drawBar(dLabel, len));
    }
}
