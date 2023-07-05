package numberguessinggame;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int min = 1; 
        int max = 100; 

        Random random = new Random();
        int targetNumber = random.nextInt(max - min + 1) + min;

        Scanner scanner = new Scanner(System.in);
        int guess;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Hello!!!Welcome to  Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + min + " and " + max + ".");
        System.out.println("Can you guess it?");

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                guessedCorrectly = true;
            } else if (guess < targetNumber) {
                System.out.println(" Your guessed number is too low! Try again.");
            } else {
                System.out.println(" Your guessed number is too high! Try again.");
            }
        }

        System.out.println("Congratulations! You  have guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
    }
}