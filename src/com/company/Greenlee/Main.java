package com.company.Greenlee;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    // Trenton Greenlee.
    // 2/4/2020.
    // Exercise 4.
    public static void main(String[] args) {
        // Calling the city() and output() methods.
        city();
        output();
    }

    // Global Scanner (Within the program).
    private static Scanner input = new Scanner(System.in);

    // Global HashMap and ArrayLists (Within the program).
    private static Map<String, Double> cityAvgTemp = new HashMap<>();
    private static List<String> city = new ArrayList<>();
    private static List<Double> avg = new ArrayList<>();

    // Methods.
    // city() - User inputs the name of a city and the 5 day temperatures.
    public static void city() {
        // Two separate Scanners for each input variable.
        Scanner input = new Scanner(System.in);
        Scanner temper = new Scanner(System.in);
        System.out.println("Please enter a city names (Enter 'END' to stop): ");
        double totalTemp = 0;
        double temp;
        String user = input.nextLine();

        // Using a while loop to have the user continue inputting until they enter 'END' for the user variable.
        while (!(user.equals("END"))) {
            System.out.println("Enter 5-Day Temperature: ");
            for (int i = 0; i < 5; i++) {
                temp = temper.nextDouble();
                totalTemp += temp;
            }
            // Calling averageTemp() method to divide the total by the number of temperatures inputted which is 5.
            averageTemp(totalTemp);
            totalTemp = 0;
            // Adding user variable to the city ArrayList, indicating the average temperature has been calculated.
            city.add(user);
            // Asking user for city again since previous city input did not equal 'END'.
            System.out.println("Please enter a city names (Enter 'END' to stop): ");
            user = input.nextLine();
        }
    }

    // averageTemp() - Calculates the average temperature of the 5-Day week and adds the value to the avg ArrayList.
    public static void averageTemp(double total) {
        double average = total / 5.0;
        avg.add(average);
    }

    // output() - Prints out the city's name and average temperature.
    // Not guaranteed to have the same order the user inputted the city name and its average temperature.
    public static void output() {
        // Using a for loop to connect the city and its average temperature by their corresponding indexes.
        for (int i = 0; i < avg.size(); i++) {
            cityAvgTemp.put(city.get(i), avg.get(i));
        }

        // Using the DecimalFormat class to restrict the decimal places to two for the average temperature.
        DecimalFormat celsiusFormat = new DecimalFormat("###.##");

        // Using a for-each loop to separate the key-value pair into an organized output.
        for (Map.Entry<String, Double> entry : cityAvgTemp.entrySet()) {
            System.out.println("City: " + entry.getKey() + ", Average Temperature: " + celsiusFormat.format(entry.getValue()) + "°C");
        }
    }
}
