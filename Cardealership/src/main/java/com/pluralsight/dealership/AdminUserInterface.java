package com.pluralsight.dealership;

import java.util.Scanner;

public class AdminUserInterface {
    private Scanner scanner;

    // Constructor to initialize the scanner
    public AdminUserInterface() {
        scanner = new Scanner(System.in);
    }

    // Method to display the menu and handle user input
    public void displayMenu() {
        while (true) {
            System.out.println("\nAdmin User Interface");
            System.out.println("1. Manage Users");
            System.out.println("2. View Reports");
            System.out.println("3. Configure Settings");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    manageUsers();
                    break;
                case 2:
                    viewReports();
                    break;
                case 3:
                    configureSettings();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to manage users
    private void manageUsers() {
        System.out.println("Manage Users selected.");
        // Implement user management logic here
    }

    // Method to view reports
    private void viewReports() {
        System.out.println("View Reports selected.");
        // Implement report viewing logic here
    }

    // Method to configure settings
    private void configureSettings() {
        System.out.println("Configure Settings selected.");
        // Implement settings configuration logic here
    }
}
