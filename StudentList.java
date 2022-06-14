import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if (args.length > 1 || args.length < 1){
            System.err.println("Invalid number of arguments.");
            System.err.println("Exiting program.");
            System.exit(1);
        }
//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String students[] = line.split(", ");
                for (String student : students) {
                    System.out.println(student);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                        new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String students[] = line.split(", ");
                Random random = new Random();
                int index = random.nextInt(students.length);
                System.out.println(students[index]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String newData = args[0].substring(1);
                Date date = new Date();
                String dateFormatPattern = "dd-mm-yyyy hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
                String formattedDate = dateFormat.format(date);
                bufferedWriter.write(", " + newData + "\nList last updated on " + formattedDate);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String students[] = line.split(",");
                boolean found = false;
                String t = args[0].substring(1);
                for (int idx = 0; idx < students.length && !found; idx++) {
                    if (students[idx].equals(t)) {
                        System.out.println("We found it!");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Could not find " + t);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                int wordCount = line.split(", ").length;
                System.out.println(wordCount + " word(s) found");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
        else{
            System.err.println("Invalid arguments.");
            System.err.println("Exiting program.");
            System.exit(2);
        }
    }

}