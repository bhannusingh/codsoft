import java.util.Random;
import java.util.Scanner;

public class hello{

    public static void 
    in(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number Game!");

        while (true) {
            // Step 1: Generate a random number within the specified range
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;

            // Step 5: Limit the number of attempts
            int maxAttempts = 10;

            while (attempts < maxAttempts) {
                // Step 2: Prompt the user to enter their guess
                System.out.print("Guess the number (between 1 and 100): ");

                // Validate user input
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();  // Consume the invalid input
                }

                int userGuess = scanner.nextInt();

                // Step 3: Compare the user's guess and provide feedback
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber +
                            " in " + (attempts + 1) + " attempts.");
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }

                attempts++;
            }

            // Step 7: Display the user's score
            System.out.println("Round Over. Your score: " + (maxAttempts - attempts) + " points.");

            // Step 6: Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}
