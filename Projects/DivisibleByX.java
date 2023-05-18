import java.util.Scanner;

public class DivisibleByX {

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        	System.out.flush();
        Scanner in = new Scanner(System.in);
        boolean playing = false;
        int startingNumber, endingNumber, testNumber = 0;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("In this program, You will display a series of numbers divisible by an integer.");
            System.out.println("You will enter a starting number, the ending number and the integer to be considered.");

            while (true) {
                System.out.println("Please enter the starting number:");
                try {
                    startingNumber = Integer.parseInt(in.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid response! Please enter a number.");
                }
            }

            while (true) {
                System.out.println("Please enter the ending number:");
                try {
                    endingNumber = Integer.parseInt(in.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid response! Please enter a number.");
                }
            }

            while (true) {
                System.out.println("Please enter the test number:");
                try {
                    testNumber = Integer.parseInt(in.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid response! Please enter a number.");
                }
            }

            System.out.println("The results are:");
            for (int i = startingNumber; i <= endingNumber; i++) {
                if (i % testNumber == 0) {
                    int sum1 = i;
                    System.out.println(sum1);
                }
            }

            while (true) {
                System.out.println("Would you like to play again? (Y/N)");
                String userInput = in.nextLine();
                if (userInput.equalsIgnoreCase("N")) {
                    playing = true;
                    break;
                } else if (userInput.equalsIgnoreCase("Y")) {
                    break;
                } else {
                    System.out.println("Error: Please enter Y or N !");
                }
            }
        } while (!playing);

        in.close();
    }
}
