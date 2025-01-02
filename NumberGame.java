import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int roundsPlayed = 0;
        int totalScore = 0;

        while (true) {
            // Generate a random number
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsRemaining = 10;
            roundsPlayed++;

            System.out.println("\nRound " + roundsPlayed + ": I have chosen a number between 1 and 100. Can you guess what it is?");

            while (attemptsRemaining > 0) {
                System.out.print("Enter your guess: ");
                
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                // Compare the guess with the actual number
                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    totalScore += attemptsRemaining; // Add remaining attempts to score
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsRemaining--;
                System.out.println("Attempts remaining: " + attemptsRemaining);
            }

            if (attemptsRemaining == 0) {
                System.out.println("You've run out of attempts. The number was " + numberToGuess + ".");
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        // Display final score
        System.out.println("\nGame Over! You played " + roundsPlayed + " round(s) with a total score of " + totalScore + ".");
        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}
