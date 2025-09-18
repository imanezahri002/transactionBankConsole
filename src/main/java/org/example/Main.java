package org.example;

import org.example.services.AuthService;

import java.util.Scanner;
import org.example.repositories.implementation.InMemoryUserRepository;
import org.example.services.AuthService;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static boolean isRunning = true;

    private static InMemoryUserRepository userRepo = new InMemoryUserRepository(); // le "carnet"
    private static AuthService authService = new AuthService(userRepo);

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
            case 1 -> {
                System.out.println("Fonction d'inscription...\n");
                registerUser();
            }


            case 2 -> {
                System.out.println("Fonction de connexion...\n");
                loginUser();
            }
            case 0 -> {
                System.out.println("Exit");
                isRunning = false;
            }
            default -> System.out.println("Choix invalide !");
        }
    }
    private static void registerUser() {
        System.out.print("Nom complet : ");
        String fullname = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();


        boolean success = authService.register(fullname, email, adresse, password);

        if (success) {
            System.out.println("Utilisateur enregistré avec succès !");
            userRepo.displayUsers();
        } else {
            System.out.println("Cet email est déjà utilisé !");
        }
    }
    private static void loginUser() {
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        boolean success = authService.login(email, password);

        if (success) {
            System.out.println("Connexion réussie ! Bienvenue 🎉");
        } else {
            System.out.println("Email ou mot de passe incorrect ❌");
        }
    }


}