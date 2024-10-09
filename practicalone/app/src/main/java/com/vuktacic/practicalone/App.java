package com.vuktacic.practicalone;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    private static String[] lines = new String[0];
    private static int itemCount = 0;
    private static double subTotal = 0;
    private static double taxTotal = 0;
    private static double total = 0;

    public static void main(String[] args) {
        try {
            // Place groceries.txt in the same folder as the JAR. That is what this very long piece of code does.
            // Creates a file object of the location of the JAR, then gets the path of the folder.
            // For some reason Java does not have a nicer way of doing this.
            String javaFileFolderPath = (new File(App.class.getProtectionDomain().getCodeSource().getLocation().toURI())).getParentFile().getAbsolutePath();

            // Reads the entire file and loads the lines into an array of strings.
            lines = Files.readAllLines(Path.of(javaFileFolderPath, "groceries.txt")).toArray(new String[0]);

        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("\tSTOP 'N' Shop");
        System.out.println("\t1212 Pinewood Plaza");
        System.out.println("\tSpringfield, BC");
        System.out.println();
        System.out.println();

        // Repeats the \u2550 character x times in a row.
        System.out.println("\u2550".repeat(33));
        System.out.printf("  %-12s   %2s  %s    %s\n", "Item", "Q", "Unit", "");
        System.out.printf("  %-12s   %2s  %s    %s\n", "", "", "Cost", "");
        System.out.println();

        // Iterate through every line in the file.
        for(int i = 0; i < lines.length; i++) {
            String line = lines[i];

            // Each sections is separated by a space. This does not conflict with the item names as they use dashes instead.
            String[] parts = line.split(" ");

            String name = parts[0];
            int count = Integer.parseInt(parts[1]);
            double price = Double.parseDouble(parts[2]);
            String tax = parts[3];

            // If the name is longer than 12 characters truncate it.
            name = name.length() > 12 ? name.substring(0, 12) : name;

            itemCount += count;

            double cost = count * price;
            subTotal += cost;
            taxTotal += tax.equals("T") ? cost : 0; // If taxable, add it to the tax total.

            System.out.printf("  %-12s   %2d  $%.2f    %s\n", name, count, price, tax);
        }

        System.out.println("\u2550".repeat(33));

        // Calculate the 12% tax based off of the taxable total.
        taxTotal *= 0.12;
        total = subTotal + taxTotal;

        System.out.println();
        System.out.printf("  %-12s   $%6.2f\n", "SUBTOTAL", subTotal);
        System.out.printf("  %-12s   $%6.2f\n", "TAXES", taxTotal);
        System.out.printf("  %-12s   $%6.2f\n", "TOTAL", total);
        System.out.printf("  %-12s   %d\n", "Items Sold", itemCount);
        System.out.println();
        System.out.println("\tThank you.");
        System.out.println("\tPlease come again.");
    }
}
