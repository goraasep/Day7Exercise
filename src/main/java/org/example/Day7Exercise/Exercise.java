package org.example.Day7Exercise;

public class Exercise {
    public static void run(int number) {
        switch (number) {
            case 1:
                Problem1 problem1 = new Problem1();
                problem1.run();
                break;
            case 2:
                Problem2 problem2=new Problem2();
                problem2.run();
                break;
            default:
                System.out.println("Not available");
        }
    }
}
