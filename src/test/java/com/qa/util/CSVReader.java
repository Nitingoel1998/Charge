package com.qa.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class CSVReader {
//    public static void main(String[] args) {
//        // Define the file path
//        String filePath = "your_file_path.csv"; // Replace with your actual file path
//        
//        // Initialize a 2D array to store CSV data
//        String[][] data = readCSV(filePath);
//        
//        // Print the 2D array to verify
//        print2DArray(data);
//    }
    
    // Method to read CSV and store data into a 2D array
    public static String[][] readCSV(String filePath) {
        String[][] data = null;
       
        try {
            // Initialize Scanner to read from file
            Scanner sc = new Scanner(new File(filePath));
            sc.useDelimiter(",\"|\\n"); // Use comma or newline as delimiter
            
            // Determine number of rows and columns in CSV
            int rows = 0;
            int cols = 0;
            
            
            // Count rows and columns
            while (sc.hasNextLine()) {
                rows++;
                String[] line = sc.nextLine().split(",\"");
                if (cols == 0) {
                    cols = line.length;
                    System.out.println(cols);
                }
            }
            
            // Reset scanner to read from start
            sc = new Scanner(new File(filePath));
            sc.useDelimiter(",\"|\\n"); // Use comma or newline as delimiter
            
            // Initialize data array with determined rows and columns
            data = new String[rows][cols];
            
            // Read data into 2D array
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (sc.hasNext()) {
                        data[i][j] = sc.next().trim(); // Read and trim whitespace
                    }
                }
            }
            
            // Close the scanner
            sc.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return data;
    }
    
    // Method to print a 2D array (for verification)
    public static void print2DArray(String[][] data) {
        if (data != null) {
            for (String[] row : data) {
                for (String value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }
}
