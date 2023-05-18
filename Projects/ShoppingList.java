import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Ezequiel Rindello
 */

public class ShoppingList {
	/**
	 * main() method displays a menu to the user and asks them to select a command.
	 * The method will continue to display the menu to the user until they wish to
	 * quit by selecting 'Exit' from the menu.
	 * <p>
	 * The method also creates a new, empty shoppingList of type ArrayList<String>
	 * Based on the user input, the appropriate method will be called to perform
	 * actions on the shoppingList.
	 * <p>
	 * Calls: getChoice(), addItems(), deleteItems(), showItems(), sortItems().
	 */
	public static void main(String[] args) {
		// Initialize variables and clear the console
		Scanner in = new Scanner(System.in); // Input Scanner for String
		ArrayList<String> shoppingList = new ArrayList<String>(); // ArrayList for shoppingList
		String choice; // Holds user input of type String
		boolean done = false; // Keeps program running until user wants to quit
		System.out.print("\033[H\033[2J");
		System.out.flush();

		do {
			// Print out the menu to the console
			System.out.println();
			System.out.println("1. Add Items");
			System.out.println("2. Delete Items");
			System.out.println("3. Show Items");
			System.out.println("4. Sort Items");
			System.out.println("5. Save List");
			System.out.println("6. Open List");
			System.out.println("7. Exit");
			System.out.print("Please enter a command: ");
			choice = in.nextLine();

			// Call the appropriate method for the choice selected.
			switch (choice) {
				case "1": // Add items to the Shopping List
					AddItems(in, shoppingList);
					break;
				case "2": // Delete items from the Shopping List
					DeleteItems(in, shoppingList);
					break;
				case "3": // Show the items in the Shopping List
					ShowItems(shoppingList);
					break;
				case "4": // Sort the items in the Shopping List
					SortItems(shoppingList);
					break;
				case "5": // Asks the user if they would like to overwrite the existing saved shopping
							// list
					SaveList(in, shoppingList);
					break;
				case "6": //
					OpenList(in, shoppingList, "shoppingList");
					break;
				case "7": // Exit the program
					System.out.println();
					System.out.println("Goodbye!");
					done = true;
					break;
				default: // Handles all input that is not between 1-5
					System.out.println("Invalid response.  Please enter a choice from the menu (1-7).");
			} // End of switch (choice)
		} while (!done); // Keep running the program until the user quits

		in.close();
	}

	// the course asked me not to use the names of the variables defined in the
	// "main" program
	public static void AddItems(Scanner z, ArrayList<String> x) {

		while (true) {
			System.out.println("Add an <item>:<amount> to the list (or just hit 'ENTER' when done):");
			String item = z.nextLine();

			if (item.contains(":")) {
				x.add(item);
				System.out.println(item + " has been added to the Shopping List.");
			} else if (item.equalsIgnoreCase("")) {
				System.out.println(x.size() + " items have been added to your Shopping List.");
				break;
			} else {
				System.out.println("Invalid Entry. No ':' found. Entry must be in the form '<item>:<amount>'");
			}
		}
	}

	public static void DeleteItems(Scanner a, ArrayList<String> b) {

		while (true) {
			System.out.println("Delete an item from the list (or just hit 'ENTER' when done):");
			String item = a.nextLine();

			if (b.contains(item)) {
				if (item != "")
					System.out.println(item + " has been deleted from the Shopping List.");
				b.remove(new String(item));

			} else if (item.equalsIgnoreCase("")) {
				System.out.println("The items have been deleted from your Shopping List.");
				break;
			} else {
				System.out.println("Invalid Response! " + item + " is NOT an item in the list.");
				ShowItems(b);
			}
		}
	}

	public static void ShowItems(ArrayList<String> jk) {
		System.out.println("The Shopping List contains the following items:");
		System.out.println("------------------------------------------------------------------");
		System.out.println("Shopping List");
		System.out.println("------------------------------------------------------------------");

		for (String item : jk) {
			int commaIndex = item.indexOf(":");
			String firstWord = item.substring(0, commaIndex);
			String secondWord = item.substring(commaIndex + 1);
			System.out.println(firstWord + "   " + secondWord);
		}
		System.out.println("------------------------------------------------------------------");
	}

	public static void SortItems(ArrayList<String> op) {
		Collections.sort(op);
		System.out.println("The Shopping List has been sorted.");
		System.out.println("The Shopping List contains the following items:");

		for (String item : op) {
			System.out.println(item);
		}
	}

	public static void SaveList(Scanner sIn, ArrayList<String> shoppingList) {
		String filename = "ShoppingList.txt";
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(
				"Are you sure you wish to overwrite the 'Shopping List.txt' file with your current list? (Y/N)");
		while (true) {
			String answer = sIn.nextLine();
			if (answer.equalsIgnoreCase("Y")) {
				for (String item : shoppingList) {
					writer.println(item);
				}
				System.out.println("shoppingList saved in: " + filename);
				break;
			} else if (answer.equalsIgnoreCase("N")) {
				System.out.println("Shopping List not saved.");
				break;
			} else {
				System.out.println("Invalid response. Please enter Y/N");
			}
		}
	}

	public static void OpenList(Scanner sIn, ArrayList<String> shoppingList, String filename) {

		if (shoppingList.size() == 0) {
			System.out.println("Shopping List not opened.");
			return;
		}

		boolean overwritre = false;
		File ShoppingList = new File(filename);

		if (ShoppingList.exists()) {

			do {
				System.out.println(
						"Are you sure you wish to overwrite the 'Shopping List.txt' file with your current list? (Y/N)");
				String answer = sIn.nextLine();
				if (answer.equalsIgnoreCase("Y")) {
					overwritre = true;
				} else if (answer.equalsIgnoreCase("N")) {
					System.out.println("Shopping List not saved.");
					overwritre = true;
					return;
				} else {
					System.out.println("Invalid response. Please enter Y/N");
				}
			} while (!overwritre);

			PrintWriter writer = null;

			try {
				writer = new PrintWriter(ShoppingList);
				for (String s : shoppingList) {
					writer.println(s);
				}
				System.out.println("shoppingList saved in: " + filename);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					writer.close();
				}
			}
		}
	}
}