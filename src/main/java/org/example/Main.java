package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static boolean isRunning = true;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (isRunning) {
            displayAuthMenu();
        }

        scanner.close();
        System.out.println("Programme terminé.");
    }

    private static void displayAuthMenu() {
        System.out.println("\n=== ConsoleBank ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.print("Choix : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> System.out.println("Fonction d'inscription...");
            case 2 -> {
                System.out.println("Fonction de connexion...");
            }
            case 0 -> {
                System.out.println("Exit");
                isRunning = false;
            }
            default -> System.out.println("Choix invalide !");
        }
    }
}