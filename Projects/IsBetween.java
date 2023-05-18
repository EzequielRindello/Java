import java.util.Scanner;

public class IsBetween {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean playing = false;
		boolean test = false;
		int first, second, third = 0;

		do {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("This program will ask for three numbers.");
			System.out.println("Then determine if the second number lies between the first and the third.");

			while (true) {
				System.out.println("Please enter the first number: ");
				try {
					first = Integer.parseInt(in.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Error.Please enter a whole number.");
				}
			}

			while (true) {
				System.out.println("Please enter the third number: ");
				try {
					third = Integer.parseInt(in.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Error.Please enter a whole number.");
				}
			}

			while (true) {
				System.out.println("Please enter the second number to be tested (the between number): ");
				try {
					second = Integer.parseInt(in.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Error.Please enter a whole number.");
				}
			}

			test = isBetween(first, second, third);

			if (test == false) {
				System.out.println(second + " does not lie between the numbers " + first + " and " + third);
			} else if (test == true) {
				System.out.println(second + " lies between the numbers " + first + " and " + third);
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

	public static boolean isBetween(int first, int second, int third) {
		if (second > first && second < third) {
			return true;
		} else {
			return false;
		}
	}
}
