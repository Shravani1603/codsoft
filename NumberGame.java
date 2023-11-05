import java.util.Random;
import java.util.Scanner;

 public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (" + (attempts + 1) + "/" + maxAttempts + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Your guess is out of the valid range.");
                } else if (userGuess < targetNumber) {
                    System.out.println("The number is higher. Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("The number is lower. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    score += (maxAttempts - attempts); // Increase score based on remaining attempts
                    break;
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("You've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }

            rounds++;
        }

        System.out.println("Game over! You played " + rounds + " round(s) and your final score is: " + score);

        scanner.close();
    }
}