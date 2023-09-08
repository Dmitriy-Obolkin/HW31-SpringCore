package ua.ithillel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.model.MyCart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("ua.ithillel");

        MyCart cart = applicationContext.getBean(MyCart.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action: add, remove, print, quit");
            String action = scanner.nextLine().trim().toLowerCase();

            switch (action) {
                case "add" -> {
                    System.out.println("Enter product ID:");
                    try {
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        cart.addProduct(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a valid number.");
                    }
                }
                case "remove" -> {
                    System.out.println("Enter product ID:");
                    try {
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        cart.removeProduct(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a valid number.");
                    }
                }
                case "print" -> System.out.println(cart);
                case "quit" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Unknown action. Please choose add, remove, print or quit.");
            }

        }
    }
}