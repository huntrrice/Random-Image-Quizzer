import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    /**
     * returns value from csv based on col and row
     * 
     * @param col
     * @param row
     * @return
     */
    public static String getValue(int col, int row) {
        // followed this video: https://www.youtube.com/watch?v=-Aud0cDh-J8
        // turned into method and made it so it only printed the requested row using if
        // statement and counter
        String csvFile = SetData.getCsv();
        String line = "";
        int ii = 0;
        String returnThis = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile)); // links csv file to the Reader
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // checks each position and only returns one with inputted
                                                   // coordinates
                ii++;
                if (ii == row) {
                    returnThis = values[col];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnThis;
    }

    /**
     * returns total amount of rows in csv file
     */
    public static int getRows() {
        String csvFile = SetData.getCsv();
        String line = "";
        int ii = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile)); // links csv file to the Reader
            while ((line = br.readLine()) != null) {
                ii++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ii;
    }

    /**
     * returns position of string in csv
     */
    public static List<Integer> getPosition(String searchWord) {
        List<Integer> returnValue = new ArrayList<>(Arrays.asList());
        for (int col = 0; col < 2; col++) { // checks each position for string and returns coordinates when it is found
            for (int row = 1; row <= getRows(); row++) {
                String value = getValue(col, row);
                if (value.equals(searchWord)) {
                    returnValue.add(col);
                    returnValue.add(row);
                }
            }
        }
        return returnValue;
    }

    /**
     * randomly chooses options from the first row of csv, the same value can not
     * occur twice
     * 
     * @return
     */
    public static ArrayList<String> getOptions() {
        ArrayList<String> options = new ArrayList<>(Arrays.asList()); // randomly generates positions in csv and adds
                                                                      // them to list of options if value is not already
                                                                      // in list
        for (int ii = 1; ii <= 4; ii++) {
            Random random = new Random();
            int row = random.nextInt(1, getRows() + 1);
            Boolean keepgoing = true;
            while (keepgoing) {
                String addThis = getValue(0, row);
                if (options.contains(addThis)) {
                    row = random.nextInt(1, getRows() + 1);// found how to do this here
                                                           // https://stackoverflow.com/questions/4404084/check-if-a-value-exists-in-arraylist
                    keepgoing = true;
                } else {
                    options.add(addThis);
                    keepgoing = false;
                }
            }
        }
        return options;
    }

    /**
     * randomly chooses correct answer from options list
     * 
     * @param options
     * @return
     */
    public static String getCorrect(ArrayList<String> options) {
        Random random = new Random();
        int index = random.nextInt(0, 3);
        String correct = options.get(index);
        return correct;
    }

    /**
     * returns the image when given answer name
     */
    public static String getImage(String answer) { // takes col 0 name in and returns col 1
        List<Integer> position = getPosition(answer);
        String returnValue = getValue(1, position.get(1));
        return returnValue;
    }
}
