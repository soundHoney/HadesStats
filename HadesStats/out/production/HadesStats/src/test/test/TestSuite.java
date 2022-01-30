package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.DisplayAndCalculate;
import sample.Main;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;

public class TestSuite {
    private final Main checkFile = new Main();
    private final DisplayAndCalculate dac = new DisplayAndCalculate();
    final int[] answer = {7, 4, 6, 1, 9};

    @Test
    @DisplayName("Inside testCheckFileExists")
    public void testCheckFileExists() {


        String fullFileName = "X:\\CODiNG\\Learn\\JAVA\\HadesStats\\src\\sample\\Resources\\Escape.mp3";
        Assertions.assertTrue(checkFile.checkFileExists(fullFileName));
        Assertions.assertFalse(checkFile.checkFileExists("x:\\CODiNG\\eat.txt"));
    }


    @Test
    @DisplayName("Inside testBestWorstAvg")
    public void testBestWorstAvg() {
        dac.bestWorstAvg(answer, 5);
        System.out.println(dac.getAverage() / 5);

        assertAll("test Best Worst Avg",
                () -> {
                    Assertions.assertEquals(dac.getMin(), 1);
                    Assertions.assertEquals(dac.getMax(), 9);
                    Assertions.assertEquals((dac.getAverage() / 5), 5, 0.5);
                    Assertions.assertEquals(dac.getCurrent(), 46);
                    Assertions.assertEquals(dac.getMinCurrent(), 45);

                }
        );
    }

    @Test
    @DisplayName("Inside testMusic")
    void testMusic() {
    }

    @Test
    @DisplayName("Inside processCSV")
    void testProcessCSV() {
        File file = new File("X:\\CODiNG\\Learn\\JAVA\\HadesStats\\src\\text files\\4 entries.txt");
        File badFile = new File("X:\\CODiNG\\Learn\\matt.txt");
        Main process = new Main();
        String[] result;
        result = process.processCSV(file);
        String[] badResult = process.processCSV(badFile);
        String[] badExpectedResult = {null, null, null};

        assertAll("Testing process CSV results",
                () -> {
                    Assertions.assertEquals(result[0], "Your best run was #" + 43 + " with " + 320 + " kills");
                    Assertions.assertEquals(result[1], "Your worst run was #" + 44 + " with " + 283 + " kills");
                    Assertions.assertEquals(result[2], "Average kills per run = " + 304);
                    Assertions.assertEquals(Arrays.toString(badResult), Arrays.toString(badExpectedResult));

                });
    }

    @Test
    @DisplayName("Test Display and Calculate")
    void testDisplayAndCalculate() {
        DisplayAndCalculate dac = new DisplayAndCalculate();
        final int[] answer = {311, 320, 283};
        final int length = 3;
        dac.displayKills(answer, length);
        dac.bestWorstAvg(answer, length);
        int average = dac.getAverage() / length;
        assertAll("Testing Display and calculate",
                () -> {
                    Assertions.assertEquals(dac.getCurrent(), 43);
                    Assertions.assertEquals(dac.getMax(), 320);
                    Assertions.assertEquals(dac.getMinCurrent(), 44);
                    Assertions.assertEquals(dac.getMin(), 283);
                    Assertions.assertEquals(average, 304);
                }
        );
    }
}
