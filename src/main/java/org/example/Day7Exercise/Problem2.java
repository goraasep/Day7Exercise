package org.example.Day7Exercise;

import org.example.Day7Exercise.exceptions.LastElementException;
import org.example.Day7Exercise.exceptions.NoElementException;
import org.example.Day7Exercise.exceptions.NotIntegerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Problem2 {
    private Scanner scanner;
    private double totalSales = 0;
    private double productSold = 0;
    private String mostBoughtItem = "";
    private String leastBoughtItem = "";
    private double mostProductSold = 0;
    private double leastProductSold = 0;

    public void run() {
        System.out.println("2. File Reader.");
        try {
            this.scanner = readFile("src/main/resources/product_sales_data.csv");
            readData();
            getResult();
            this.scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Ensure file is in the correct path");
        } catch (NumberFormatException e) {
            System.out.println("Line format is wrong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Scanner readFile(String path) throws FileNotFoundException {
        File myFile = new File(path);
        return new Scanner(myFile);
    }

    public void getResult(){
        String formattedDouble = String.format("%.2f", this.totalSales);
        System.out.println("Total Sales : " + formattedDouble);
        System.out.println("Total Product Sold : " + this.productSold);
        System.out.println("Most Bought Product : " + this.mostBoughtItem + " (" + this.mostProductSold + " pcs)");
        System.out.println("Least Bought Product : " + this.leastBoughtItem + " (" + this.leastProductSold + " pcs)");
    }

    public void readData() throws NumberFormatException{
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        while (scanner.hasNextLine()) {
            String newLine = scanner.nextLine();
            String[] arrString = newLine.split(",");
            int sold = Integer.parseInt(arrString[1]);
            double price = Double.parseDouble(arrString[2]);
            double sales = sold * price;
            this.totalSales += sales;
            this.productSold += sold;
            if (this.mostProductSold < sold) {
                this.mostProductSold = sold;
                this.mostBoughtItem = arrString[0];
            } else if (this.leastProductSold > sold || Objects.equals(this.leastBoughtItem, "")) {
                this.leastProductSold = sold;
                this.leastBoughtItem = arrString[0];
            }
        }
    }

}
