import java.util.Scanner;

public class Calculations {

	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");
        	System.out.flush();
		Scanner in = new Scanner(System.in);
		String answer = "";

		System.out.println("Welcome to the calculator.\nPlease enter an operation:");
		while (true) {
			System.out.println("1.Calculate area.\n2.Calculate BMI.\n3.Calculate shirt size ");
			answer = in.nextLine();
			switch (answer) {
			case "1":
				Area(in);
				break;
			case "2":
				Bmi(in);
				break;
			case "3":
				ShirtSize(in);
				break;
			default:
				System.out.println("Error. Enter a valid choice.");
			}
		}
	}

	public static void Area(Scanner x) {
		System.out.println(
				"Please enter 1 if you want to calculate the area of a square or 2 for the area of a rectangle:");

		while (true) {
			String answer = x.nextLine();
			if (answer.contains("1")) {
				System.out.println("Please enter the width of the square");
				while (true) {
					String valid = x.nextLine();
					
					try {
						int width = Integer.parseInt(valid);
						int squareArea = width * width;
						System.out.println("The area of a square with a width of " + width + " is " + squareArea);
						break;
					} catch (Exception e) {
						System.out.println("Error. Please enter a whole number.");
					}
				}
				return;
			} else if (answer.contains("2")) {
				System.out.println("Please enter the width of the rectangle");
				System.out.println("Please enter height of the rectangle");

				while (true) {
					String width = x.nextLine();
					String height = x.nextLine();
					
					try {
						int num1 = Integer.parseInt(width);
						int num2 = Integer.parseInt(height);
						int rectangleArea = num1 * num2;
						System.out.println("The area of a square with a width of " + num1 + " and a height of " + num2
								+ " is " + rectangleArea);
						break;
					} catch (Exception e) {

						System.out.println(
								"Error. Please enter a whole number, remember fist the width and then the height of the rectangle.");
					}
				}
				return;
			} else {
				System.out.println("Error.Please enter 1 or 2.");
			}
		}
	}

	public static void Bmi(Scanner j) {
		float imput1 = 0;
		float imput2 = 0;

		System.out.println("In this program we will calculate a person's BMI.");
		while (true) {

			while (true) {
				System.out.println("Please enter a person's height in inches:");

				try {
					j.nextFloat();
					break;
				} catch (Exception e) {
					System.out.println("Error. Please enter a valid number");
				}
			}

			while (true) {
				System.out.println("Please enter a person's weight in pounds:");

				try {
					imput2 = j.nextFloat();
					break;
				} catch (Exception e) {
					System.out.println("Error. Please enter a valid number");
				}
			}

			float kg = (float) (0.45359237 * imput2);
			float m = (float) (0.0254 * imput1);
			float bmi = kg / (m * m);

			if (bmi < 18.5) {
				System.out.println(
						"The person's BMI is: " + bmi + ". The person has a BMI classification of: Underweight");
			} else if (bmi >= 18.5 && bmi < 24.9) {
				System.out.println("The person's BMI is: " + bmi + ". The person has a BMI classification of: Normal");
			} else if (bmi >= 25 && bmi < 29.9) {
				System.out.println(
						"The person's BMI is: " + bmi + ". The person has a BMI classification of: Overweight");
			} else {
				System.out.println("The person's BMI is: " + bmi + ". The person has a BMI classification of: Obese");
			}
			return;
		}
	}

	public static void ShirtSize(Scanner in) {
		System.out.println(
				"In this program, we will determine a man's shirt size based on the measurement in inches of the customer's chest.");
		System.out.println("Please enter the customer's chest measurement in inches:");

		String valid = in.nextLine();
		int chestSize = Integer.parseInt(valid);

		if (chestSize >= 0 && chestSize <= 37) {
			System.out.println("Your size is S");
		} else if (chestSize >= 38 && chestSize < 40) {
			System.out.println("Your size to order is M");
		} else if (chestSize >= 40 && chestSize < 43) {
			System.out.println("Your size to order is L");
		} else if (chestSize >= 43 && chestSize < 46) {
			System.out.println("Your size to order is XL");
		} else {
			System.out.println("Your size to order is XXL");
		}
	}
}
