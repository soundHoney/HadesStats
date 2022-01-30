package sample;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile {
    private static final String COMMA_DELIMITER = ",";

    int counter = 0;

    public String[] readFileToArray(File file, int size) {

        String[] records = new String[size];

        try (
                BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;
            while ((st = br.readLine()) != null) {
                String[] values = st.split(COMMA_DELIMITER);
                records[counter] = (values[1]);
                counter++;
            }

        } catch (Exception e) {
            System.out.println("Invalid file location!");
            System.out.println(file);
        }

        return records;
    }
}
