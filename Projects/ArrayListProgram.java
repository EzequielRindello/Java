import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListProgram {

	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");
        	System.out.flush();
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> points = new ArrayList<Integer>();

		while (true) {
			System.out.println("Add numbers.Pres enter to stop.");
			String answer = in.nextLine();

			try {
				int add = Integer.parseInt(answer);
				points.add(add);
			} catch (Exception e) {
				if (answer == "") {
					Report(points);
					Average(points);
					Max(points);
					Min(points);
					break;
				}
				System.out.println("Error.Please enter a whole number.");
			}
		}

		in.close();
	}

	public static void Report(ArrayList<Integer> points) {
		System.out.println("The ArrayList contains:");
		System.out.println("------------------------");
		
		for (Integer s : points) {
			System.out.println(s);
		}
	}

	public static void Average(ArrayList<Integer> points) {
		float sum = 0;

		for (int num : points) {
			sum += num;
		}

		float average = (sum / points.size());
		System.out.println("The average points are;");
		System.out.println(average);
	}

	public static void Max(ArrayList<Integer> points) {
		int max = points.get(0);

		for (int i = 0; i < points.size(); i++) {
			if (points.get(i) > max) {
				max = points.get(i);
			}
		}

		System.out.println("The max points are: ");
		System.out.println(max);
	}

	public static void Min(ArrayList<Integer> points) {
		int minimum = points.get(0);

		for (int i = 1; i < points.size(); i++) {
			if (minimum > points.get(i))
				minimum = points.get(i);
		}

		System.out.println("The minumun points are: ");
		System.out.println(minimum);
	}
}
