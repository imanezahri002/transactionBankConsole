package org.example;

import org.example.models.Account;
import org.example.models.User;
import org.example.repositories.implementation.InMemoryAccountRepository;
import org.example.services.AccountService;
import org.example.services.AuthService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import org.example.repositories.implementation.InMemoryUserRepository;
import org.example.services.AuthService;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static boolean isRunning = true;

    private static InMemoryUserRepository userRepo = new InMemoryUserRepository(); // le "carnet"
    private static AuthService authService = new AuthService(userRepo);

    private static InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();
    private static AccountService accountService = new AccountService(accountRepository);

    private static User currentUser = null;


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

        User user = authService.login(email, password);


        if (user != null) {
            System.out.println("Connexion réussie ! Bienvenue 🎉");
            currentUser = user;
            showUserMenu();

        } else {
            System.out.println("Email ou mot de passe incorrect ❌");
        }
    }
    private static void showUserMenu(){
        while (currentUser != null && isRunning) {

        System.out.println("\n=== Connecté (Logged in as " + currentUser.getFullname() + ") ===");
        System.out.println("1. Create account");
        System.out.println("2. List my accounts");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer");
        System.out.println("6. Transaction history");
        System.out.println("7. Update profile");
        System.out.println("8. Change password");
        System.out.println("9. Close account");
        System.out.println("10. Logout");
        System.out.println("11. Exit");
        System.out.print("Choix: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.print("1. create account : \n");
                createAccount();
            }
            case 2 -> {
                System.out.print("2. list my accounts : \n");
                displayAccountsByUser(currentUser);
            }
            case 3 -> {
                System.out.print("3. deposit : ");
            }
            case 4 -> {
                System.out.print("4. withdraw : ");
            }
            case 5 -> {
                System.out.print("5. transfer : ");
            }
            case 6 -> {
                System.out.print("6. Transaction history : ");
            }
            case 7 -> {
                System.out.print("7. Update profile: ");
                updateUser();

            }
            case 8 -> {
                System.out.print("8. Change password : ");

            }
            case 9 -> {
                System.out.print("9. Close account : ");
                clotureAccount();

            }
            case 10 -> {
                System.out.print("10. Logout avec succes ");
                currentUser = null;
            }
            case 11 -> {
                System.out.print("11. Exit : ");
                isRunning = false;
            }
            default -> System.out.println("Choix invalide !");
        }
        }
    }
    private static void updateUser(){
        System.out.print("Update profile : ");
        System.out.print("fullname : ");
        String name = scanner.nextLine();
        System.out.print("email : ");
        String email = scanner.nextLine();
        System.out.print("adresse : ");
        String adresse = scanner.nextLine();
        System.out.print("mot de passe : ");
        String password = scanner.nextLine();

        currentUser.setFullname(name);
        currentUser.setEmail(email);
        currentUser.setAdresse(adresse);
        currentUser.setPassword(password);
        authService.editUser(currentUser);

    }

    private static void createAccount() {
        System.out.print("Create account : ");
        System.out.print(" Solde initial : ");
        BigDecimal balance = scanner.nextBigDecimal();
        scanner.nextLine();

        Account account = accountService.addAccount(currentUser, balance);
        System.out.println("Compte créé avec ID : " + account.getAccountId());
    }
    public static void displayAccountsByUser(User user) {
        System.out.print("My Accounts : ");
        List<Account> accounts = accountRepository.findAccountsByOwner(currentUser);

        if(accounts.isEmpty()){
            System.out.println("No accounts found");

        }
        else{
            for(Account account : accounts){
                System.out.println("IdAccount : " + account.getAccountId()
                                    +"\nbalance:" + account.getBalance()
                                    +"\nis active:"+ account.isActive()
                                    +"\ncreated At"+ account.getCreatedAt());
            }
        }
    }

    public static void clotureAccount() {
        System.out.println("\n=== Clôturer un compte ===");
        System.out.println("Voici vos comptes :\n");
        displayAccountsByUser(currentUser);
        System.out.print("Entrez l'ID du compte à clôturer : ");
        String accountId = scanner.nextLine();
        accountService.desactivateAccount(accountId, currentUser);
    }

}