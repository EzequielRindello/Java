import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
            System.out.flush();
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int answer, guess, numGuesses;

        do {
            answer = random.nextInt(100) + 1;
            numGuesses = 0;
            System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

            do {
                System.out.print("Enter your guess: ");
                guess = in.nextInt();
                numGuesses++;

                if (guess < answer) {
                    System.out.println("Too low! Try again.");
                } else if (guess > answer) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations, you guessed it in " + numGuesses + " guesses!");
                }
            } while (guess != answer);

            System.out.print("If you want to play again enter Y. If not enter any key.");
        } while (in.next().equalsIgnoreCase("y"));

        in.close();
    }
}
