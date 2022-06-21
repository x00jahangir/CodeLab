import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

    public static String getLineFromFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.STUDENTS_FILE_NAME)));
        return bufferedReader.readLine();
    }

    public static BufferedWriter getFileBufferedWriter() throws Exception {
        return new BufferedWriter(new FileWriter(Constants.STUDENTS_FILE_NAME, true));
    }

    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println(Constants.MSG_INVALID_NUMBER_OF_ARGUMENTS);
            System.err.println(Constants.MSG_EXITING_PROGRAM);
            System.exit(Constants.INVALID_NUMBER_OF_ARGUMENTS_EXIT_STATUS);
        }
        if (args[0].equals(Constants.ARG_LIST_DATA)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                String line = getLineFromFile();
                String students[] = line.split(Constants.WORDS_SPLIT_REGEX);
                for (String student : students) {
                    System.out.println(student);
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.MSG_LOADED_DATA);
        } else if (args[0].equals(Constants.ARG_SHOW_RANDOM_DATA)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                String line = getLineFromFile();
                String students[] = line.split(Constants.WORDS_SPLIT_REGEX);
                Random random = new Random();
                int index = random.nextInt(students.length);
                System.out.println(students[index]);
            } catch (Exception e) {
            }
            System.out.println(Constants.MSG_LOADED_DATA);
        } else if (args[0].contains(Constants.ARG_ADD_DATA)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                BufferedWriter bufferedWriter = getFileBufferedWriter();
                String newData = args[0].substring(1);
                Date date = new Date();
                String dateFormatPattern = Constants.DATE_FORMAT_PATTERN;
                DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
                String formattedDate = dateFormat.format(date);
                bufferedWriter.write(Constants.WORDS_SPLIT_REGEX + newData + Constants.MSG_DATA_UPDATED + formattedDate);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println(Constants.MSG_LOADED_DATA);
        } else if (args[0].contains(Constants.ARG_FIND_DATA)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                String line = getLineFromFile();
                String students[] = line.split(Constants.WORDS_SPLIT_REGEX);
                boolean found = false;
                String t = args[0].substring(1);
                for (int idx = 0; idx < students.length && !found; idx++) {
                    if (students[idx].equals(t)) {
                        System.out.println(Constants.MSG_DATA_FOUND);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println(Constants.MSG_DATA_NOT_FOUND);
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.MSG_LOADED_DATA);
        } else if (args[0].contains(Constants.ARG_COUNT_WORDS)) {
            System.out.println(Constants.MSG_LOADING_DATA);
            try {
                String line = getLineFromFile();
                int wordCount = line.split(Constants.WORDS_SPLIT_REGEX).length;
                System.out.println(wordCount + Constants.MSG_WORDS_FOUND);
            } catch (Exception e) {
            }
            System.out.println(Constants.MSG_LOADED_DATA);
        }
        else{
            System.err.println(Constants.MSG_INVALID_ARGUMENTS);
            System.err.println(Constants.MSG_EXITING_PROGRAM);
            System.exit(Constants.INVALID_ARGUMENT_EXIT_STATUS);
        }
    }

}