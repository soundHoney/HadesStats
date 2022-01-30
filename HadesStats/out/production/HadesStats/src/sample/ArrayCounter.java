package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ArrayCounter {

    int arrayCount = 0;

    public int getArrayCount(File file) {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while (br.readLine() != null) {
                arrayCount++;
            }
        } catch (Exception e) {
            System.out.println("Array Count failed!");
        }
        return arrayCount;
    }
}
