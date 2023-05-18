import java.util.Scanner;

public class FoodCalculator {

	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");
        	System.out.flush();
		Scanner in = new Scanner(System.in);
		System.out.println("This program would calculate the food for you.");

		while (true) {
			try {
				System.out.println("Please enter the number of people who would attend.");
				String answer = in.nextLine();
				int total = Integer.parseInt(answer);
				Calculations(total);
				break;
			} catch (Exception e) {
				System.out.println("Error. Please enter a valid number.");
			}
		}
		
		in.close();
	}

	public static void Calculations(int total) {
		double chiken = 0.5;
		int lemonade = 12;
		int iceCream = 6;

		double sum1 = chiken* total;
		int sum2 = lemonade * total;
		int sum3 = iceCream * total;
		System.out.println();
		System.out.println("Beginning calculation analysis....");
		System.out.println("You would need:");
		System.out.println(sum1 + " Lb of chiken.");
		System.out.println(sum2 + " Oz of Lemonade.");
		System.out.println(sum3 + " Oz of Icecream.");
	}
}
