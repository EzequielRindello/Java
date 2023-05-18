import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTestScores {

	public static void main(String[] args) {

		System.out.print("\033[H\033[2J");
		System.out.flush();
		ArrayList<String[]> classRoster = loadData("StudentTestGrades.csv");
		text(classRoster);
	}

	public static ArrayList<String[]> loadData(String name) {

		Scanner in = null;
		ArrayList<String[]> classRoster = new ArrayList<String[]>();

		try {
			in = new Scanner(new File("StudentTestGrades.csv"));
			in.nextLine();

			while (in.hasNextLine()) {
				String[] line = in.nextLine().split(",");
				classRoster.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return classRoster;
	}

	public static void text(ArrayList<String[]> classRoster) {

		System.out.println("-----------------------------------------------------");
		System.out.printf("%-30s%7s%7s%7s%n", "Student", "Test 1", "Test 2", "Test 3");
		System.out.println("-----------------------------------------------------");

		for (String[] grade : classRoster) {

			for (int i = 1; i < 4; i++) {
				
				int dit = Integer.parseInt(grade[i]);
				if (dit >= 94) {
					grade[i] = "A";
				} else if (dit > 90) {
					grade[i] = "A-";
				} else if (dit > 87) {
					grade[i] = "B+";
				} else if (dit > 84) {
					grade[i] = "B";
				} else if (dit > 80) {
					grade[i] = "B-";
				} else if (dit > 77) {
					grade[i] = "C+";
				} else if (dit > 74) {
					grade[i] = "C";
				} else if (dit > 70) {
					grade[i] = "C-";
				} else if (dit > 67) {
					grade[i] = "D+";
				} else if (dit > 64) {
					grade[i] = "D";
				} else if (dit > 60) {
					grade[i] = "D-";
				} else {
					grade[i] = "E";
				}
			}
			System.out.printf("%-30s%7s%7s%7s%n", grade[0], grade[1], grade[2], grade[3]);
		}
	}
}
