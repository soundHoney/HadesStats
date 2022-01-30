package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    final int HEIGHT = 725;
    final int WIDTH = 1290;

    @Override
    public void start(Stage stage) {
        music();

        try {


            Parent parentRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
            Scene scene = new Scene(parentRoot, WIDTH, HEIGHT);


            Image icon = new Image("HadesIcon.jpg");
            stage.getIcons().add(icon);
            stage.setTitle("Hades stat calculator");
            stage.sizeToScene();
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void music() {
        String fullFileName = "X:\\CODiNG\\Learn\\JAVA\\HadesStats\\src\\sample\\Resources\\Escape.mp3";

        if (checkFileExists(fullFileName)) {
            File f = new File(fullFileName);
            System.out.println("File URI : " + f.toURI());
            Media media = new Media(f.toURI().toString());
            MediaPlayer mplayer = new MediaPlayer(media);
            mplayer.setAutoPlay(true);
        } else {
            System.out.printf("File %s not found%n", fullFileName);
        }
    }


    public String[] processCSV(File file) {
        DisplayAndCalculate dac = new DisplayAndCalculate();
        int totalArray;
        String best;
        String worst;
        String averageText;

        ReadFile rf = new ReadFile();
        String[] result;
        String[] textArray = new String[3];

        // count lines in CSV file for array size
        ArrayCounter arrayCounter = new ArrayCounter();

        boolean fileExists = checkFileExists(file.toString());

        if (!fileExists) {
            System.out.printf("File %s not found%n", file);

        } else {
            totalArray = arrayCounter.getArrayCount(file);
            result = rf.readFileToArray(file, totalArray);


            final int[] answer = new int[totalArray - 1];
            final int[] totalKilled = new int[totalArray - 1];

            for (int i = 0; i < result.length - 1; i++) {
                if (result[i + 1] == null) break;
                int int1 = Integer.parseInt(result[i].trim());
                int int2 = Integer.parseInt(result[i + 1].trim());
                totalKilled[i] = int1;
                answer[i] = int2 - int1;
            }

            System.out.println("answer length = " + answer.length);
            System.out.println("result length = " + result.length);
            System.out.println("Total array = " + totalArray);

            dac.displayKills(answer, answer.length);

            dac.bestWorstAvg(answer, answer.length);

            int runNumber, maxKills, worstRunNum, minKills, average;

            runNumber = dac.getCurrent();
            maxKills = dac.getMax();
            worstRunNum = dac.getMinCurrent();
            minKills = dac.getMin();
            average = dac.getAverage() / (totalArray - 1);

            best = "Your best run was #" + runNumber + " with " + maxKills + " kills";
            worst = "Your worst run was #" + worstRunNum + " with " + minKills + " kills";
            averageText = "Average kills per run = " + average;

            textArray[0] = best;
            textArray[1] = worst;
            textArray[2] = averageText;

            return textArray;
        }

        System.out.println("Text array: " + Arrays.toString(textArray));
        return textArray;
    }

    public boolean checkFileExists(String filename) {
        File f = new File(filename);
        return f.exists();
    }

}
