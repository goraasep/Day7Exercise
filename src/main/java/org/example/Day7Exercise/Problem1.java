package org.example.Day7Exercise;

import org.example.Day7Exercise.exceptions.LastElementException;
import org.example.Day7Exercise.exceptions.NoElementException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Problem1 {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("1. Array Average.");
        int[] inArray = getArray(scanner);
        average(inArray);
        this.scanner.close();
    }

    public static int[] getArray(Scanner scanner) {
        try {
            System.out.print("Input Array: ");
            String inArrNumber = scanner.nextLine();
            String[] arrString = inArrNumber.split(",");
            if (!Objects.equals(arrString[arrString.length - 1], "q")) {
                throw new LastElementException();
            }
            if (arrString.length == 1) {
                throw new NoElementException();
            }
            int[] numbers = new int[arrString.length - 1];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(arrString[i]);
            }
            return numbers;
        } catch (LastElementException | NoElementException e) {
            System.out.println(e.getMessage());
            return getArray(scanner);
        } catch (NumberFormatException e) {
            System.out.println("Input is not integer.");
            return getArray(scanner);
        }
    }

    public static void average(int[] arrNumbers) {
        try {
            double sum = 0, avg = 0;
            for (int number : arrNumbers) {
                sum += number;
            }
            System.out.println("Arr : " + Arrays.toString(arrNumbers));
            System.out.println("Sum : " + sum);
            System.out.println("Length : " + arrNumbers.length);
            avg = sum / arrNumbers.length;
            System.out.println("Output : " + avg);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
