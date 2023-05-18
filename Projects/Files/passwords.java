import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class passwords {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("------------------------------------");
        System.out.println("Beginning password analysis...");
        System.out.println("Opening file 'Pwd.txt'");
        ArrayList<String> loadData = FtoS("pwd.txt");

        ArrayList<String> valid = new ArrayList<String>();
        ArrayList<String> invalid = new ArrayList<String>();
        for (int i = 0; i < loadData.size(); i++) {
            int count = 0;
            String check = loadData.get(i);

            if (check.length() >= 8) {
                count++;
                if (Upper(loadData.get(i))) {
                    count++;
                    if (Lower(loadData.get(i))) {
                        count++;
                        if (Number(loadData.get(i)))
                            ;
                        count++;
                        if (Contain(loadData.get(i))) {
                            count++;
                        }
                    }
                }
            }
            if (count == 5) {
                valid.add(loadData.get(i));
            } else {
                invalid.add(loadData.get(i));
            }
            SaveValid(valid);
            SaveInvalid(invalid);
        }

        System.out.println("Analysis complete.\nClosing files.");
        System.out.println("Results can be found in files:\n-'invalidpwd.txt'\n-'validpwd.txt'");
        System.out.println("------------------------------------");
    }

    public static ArrayList<String> FtoS(String file) {
        Scanner in = null;
        ArrayList<String> data = new ArrayList<String>();
        try {
            in = new Scanner(new File(file));

            while (in.hasNextLine()) {
                String passwords = in.nextLine();
                data.add(passwords);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return data;
    }

    public static boolean Upper(String data) {
        boolean valid = false;
        for (int i = 0; i <= data.length() - 1; i++) {
            char ch = data.charAt(i);
            if (Character.isUpperCase(ch)) {
                valid = true;
            }
        }
        return valid;
    }

    public static boolean Lower(String data) {
        boolean valid = false;
        for (int i = 0; i <= data.length() - 1; i++) {
            char ch = data.charAt(i);
            if (Character.isLowerCase(ch)) {
                valid = true;
            }
        }
        return valid;
    }

    public static boolean Number(String data) {
        boolean valid = false;
        for (int i = 0; i <= data.length() - 1; i++) {
            char ch = data.charAt(i);
            if (Character.isDigit(ch)) {
                valid = true;
            }
        }
        return valid;
    }

    public static boolean Contain(String data) {
        boolean valid = false;
        String special = "@,#,%,-,&,*";
        String[] specials = special.split(",");
        for (String check : specials) {
            if (data.contains(check)) {
                valid = true;
            }
        }
        return valid;
    }

    public static void SaveValid(ArrayList<String> passwords) {
        String filename = "validpwd.txt";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String go : passwords)
            writer.println(go);
        writer.close();
    }

    public static void SaveInvalid(ArrayList<String> passwords) {
        String filename = "invalidpwd.txt";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String go : passwords)
            writer.println(go);
        writer.close();
    }
}
