package com.pluralsight;

import com.pluralsight.dealership.AdminUserInterface;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    final static Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {

        AdminUserInterface ui = new AdminUserInterface();
        ui.displayMenu();

        }
    }