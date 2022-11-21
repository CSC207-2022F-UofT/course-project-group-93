package user_interface.login_leaderboard;

import use_cases.login_leaderboard.IFileInput;

import java.io.*;
import java.util.ArrayList;

/**
 * FileReader transforms the data in the CSV file into a readable format for the use cases.
 */
public class FileReader implements IFileInput {

    /**
     * Create a nested array list of the data stored in the CSV file. Each row/user is saved
     * in an array.
     * @return : A Nested Array List
     */
    @Override
    public ArrayList<ArrayList<String>> readFile(){
        String filePath = "C:\\Users\\arifa\\IdeaProjects\\course-project-group-93\\" +
                "src\\main\\java\\user_interface\\login_leaderboard\\data.csv";
        String line = "";

        ArrayList<ArrayList<String>> arr = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(filePath));
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                ArrayList<String> row = new ArrayList<>();

                row.add(values[0]);
                row.add(values[1]);
                row.add(values[2]);
                row.add(values[3]);
                row.add(values[4]);
                row.add(values[5]);

                arr.add(row);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arr;
    }
}