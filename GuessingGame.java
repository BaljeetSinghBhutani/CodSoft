package Internship;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 10;
        boolean playAgain = true;
        int rounds = 0;
        int totalAttempts = 0;

        while (playAgain) {
            rounds++;
            int targetNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;

            System.out.println("Round " + rounds + " - Guess the number between " + lowerRange + " and " + upperRange + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + targetNumber + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        double averageAttempts = (double) totalAttempts / rounds;
        System.out.println("Thanks for playing! Your average attempts per round: " + String.format("%.2f", averageAttempts));

        scanner.close();
    }
}