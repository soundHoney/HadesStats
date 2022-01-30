package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.ArrayCounter;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCounterTest {

    @Test
    void getArrayCount() {
        ArrayCounter arrayCounter = new ArrayCounter();
        ArrayCounter arrayCounter4 = new ArrayCounter();

        File file = new File("X:\\CODiNG\\Learn\\JAVA\\HadesStats\\src\\text files\\hhh.txt");
        File file4 = new File("X:\\CODiNG\\Learn\\JAVA\\HadesStats\\src\\text files\\4 entries.txt");
        int count = arrayCounter.getArrayCount(file);
        int count4 = arrayCounter4.getArrayCount(file4);
        assertEquals(2, count);
        assertEquals(4, count4);

    }

    @Test
    @DisplayName("Test arrayCounter throws exception")
    void testArraycounterThrowsException(){
        ArrayCounter arrayCounter = new ArrayCounter();
        File file = new File("X:\\CODiNG\\Learn\\JAVA\\HadesStats\\src\\text files\\hhhh.txt");
        assertThrows(Exception.class, () -> arrayCounter.getArrayCount(file));


    }

}