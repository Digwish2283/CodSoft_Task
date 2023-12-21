import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame();
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

        } while (playAgain);

        System.out.println("Thank you for playing the Guessing Game!");
        scanner.close();
    }

    private static void playGame() {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int userGuess;
        int attempts = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Try to guess the secret number between 1 and 100.");

        while (attempts < 10) {
            System.out.print("Enter your guess: ");
            userGuess = getValidInput(); 

            attempts++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return; 
            } else if (userGuess < secretNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
    }

    private static int getValidInput() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }
}

