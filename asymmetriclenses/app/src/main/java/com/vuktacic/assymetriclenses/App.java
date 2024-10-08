// https://github.com/Zylve/apcsa/tree/main/asymmetriclenses

package com.vuktacic.assymetriclenses;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static double bigRadius;
    private static double smallRadius;
    private static double offset;
    private static double area;

    public static void main(String[] args) {

        System.out.print("Input radius 1: ");
        try {
            bigRadius = scanner.nextDouble();
        } catch(Exception e) {
            System.out.println("Invalid input");
            return;
        }

        System.out.print("Input radius 2: ");
        try {
            smallRadius = scanner.nextDouble();
        } catch(Exception e) {
            System.out.println("Invalid input");
            return;
        }

        if(smallRadius > bigRadius) {
            System.out.println("Invalid input: radius 2 is greater than radius 1");
            return;
        }

        System.out.print("Input offset d: ");
        try {
            offset = scanner.nextDouble();
        } catch(Exception e) {
            System.out.println("Invalid input");
            return;
        }

        // If the sum or difference of the radii is equal to the offset, the lens contacts at a single point and has zero area.
        if((bigRadius + smallRadius == offset) || (bigRadius - smallRadius == offset)) {
            System.out.println("Lens with zero area");
            return;
        }

        // If the sum or difference of the radii is less than the offset, the circles do not contact each other and no lens exists.
        if((bigRadius + smallRadius < offset) || (bigRadius - smallRadius > offset)) {
            System.out.println("No lens exists");
            return;
        }

        // First Expression of the mathematical equation
        double firstExp = Math.pow(smallRadius, 2) * Math.acos(
            (Math.pow(offset, 2) + Math.pow(smallRadius, 2) - Math.pow(bigRadius, 2)) // Numerator of arccos
                / (2 * offset * smallRadius) // Denominator of arccos
        );

        // Second Expression, radii variables are swapped here.
        double secondExp = Math.pow(bigRadius, 2) * Math.acos(
            (Math.pow(offset, 2) + Math.pow(bigRadius, 2) - Math.pow(smallRadius, 2))
                / (2 * offset * bigRadius)
        );

        // Third Expression
        double thirdExp = 0.5 * Math.sqrt(
            (-offset + smallRadius + bigRadius) // Terms under square root are multiplied together.
                * (offset + smallRadius - bigRadius)
                * (offset - smallRadius + bigRadius)
                * (offset + smallRadius + bigRadius)
        );

        area = firstExp + secondExp - thirdExp;

        /*
         * Use Math.pow(a, b), where b is the number of decimal places to round to.
         * Multiply by 10^4 so the first four decimal points are to the left of the decimal point.
         * Use Math.round() to round up/down based on the first decimal place and get a whole number.
         * Divide by 10^4 to return the last four digits of the whole number to the decimal places and get a double.
         */
        area = Math.round(area * Math.pow(10, 4)) / Math.pow(10, 4);

        System.out.println(area);
    }
}
