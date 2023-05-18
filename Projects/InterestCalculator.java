import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean playing = false;
		double amountEachMonth, annualInterest = 0;
		int monthsToSave = 0;

		do {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("This proram will then show the monthly balance over the period of planned savings.");

			while (true) {
				System.out.println("Please enter the amount to be deposited each month:");
				try {
					amountEachMonth = Double.parseDouble(in.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Invalid response! Please enter a number.");
				}
			}

			while (true) {
				System.out.println("Please enter the annual interest rate");
				try {
					annualInterest = Double.parseDouble(in.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Invalid response! Please enter a number.");
				}
			}

			while (true) {
				System.out.println("Please enter the number of months you plan to save:");
				try {
					monthsToSave = Integer.parseInt(in.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Invalid response! Please enter a number.");
				}
			}

			double rateToUse = annualInterest / 100 / 12;
			for (int i = 1; i <= monthsToSave; i++) {
				double sum1 = amountEachMonth * (Math.pow(1 + rateToUse, i) - 1) / rateToUse;
				System.out.printf("Month %d: $%,.2f\n", i, sum1);
			}

			while (true) {
				System.out.println("Would you like to make another calculation? (Y/N):");
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
