package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Calcs Fibonacci sequence.
 *
 * @author Mr. Riscalas
 * @version 1.0
 * @since 2023-04-19
 */
public final class Fibonacci {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the Fibonacci method.
    *
    * @param num //num
    * @return num
    */
    public static int fibonacci(final int num) {
        // Checks if num is less than 1 if so it returns the value
        if (num <= 1) {
            return num;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    /**
    * This is the main method.
    *
    * @param args //unused
    */
    public static void main(final String[] args) {
        // Set the input and output file paths
        final String inputFilePath = "input.txt";
        final String outputFilePath = "output.txt";

        // Read input from file using Scanner
        try (Scanner scanner = new Scanner(new File(inputFilePath));
            FileWriter writer = new FileWriter(outputFilePath)) {
            /* Read each line from the input file and calc the
            * fibonacci using recursions
            */
            while (scanner.hasNextLine()) {
                final int line = scanner.nextInt();
                final int fibNum = fibonacci(line);

                // Write the answer to the output file
                writer.write(line + " digit in the Fibonacci sequence is "
                        + fibNum + "\n");
            }
        } catch (FileNotFoundException error) {
            System.err.println("File not found: " + error.getMessage());
        } catch (IOException error) {
            System.err.println("Error writing to file: " + error.getMessage());
        }
    }
}
