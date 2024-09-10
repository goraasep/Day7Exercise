package org.example;

import org.example.Day7Exercise.Exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("======= EXERCISE DAY 7 =======");
        System.out.println("1. Array Average.");
        System.out.println("2. File Reader.");
        Scanner scanIn = new Scanner(System.in);
        Exercise.run(getNumExercise(scanIn));
        scanIn.close();
    }
    static int getNumExercise(Scanner scanner) {
        System.out.print("Choose Exercise: ");
        scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Input is not integer type.");
            return getNumExercise(scanner);
        }
    }
}