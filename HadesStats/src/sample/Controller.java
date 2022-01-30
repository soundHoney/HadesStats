package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Controller {

    private Stage stage;
    private Scene scene;
    final int HEIGHT = 725;
    final int WIDTH = 1290;


    @FXML
    private Label myLabel;
    @FXML
     Label worstLabel;
    @FXML
     Label bestLabel;
    @FXML
     Label averageLabel;

    @FXML
    public void setLabels() throws InterruptedException {
        Main process = new Main();
        String[] labels;
        File file = new File("c:\\users\\matt potter\\desktop\\HADES.txt");
        labels = process.processCSV(file);
        System.out.println("Here is labels 0 " + labels[0]);
        System.out.println("Here is labels 1 " + labels[1]);
        System.out.println("Here is labels 2 " + labels[2]);

        bestLabel.setText(labels[0]);
        worstLabel.setText(labels[1]);
        averageLabel.setText(labels[2]);

    }

    public void calculate(@NotNull ActionEvent actionEvent) throws IOException, InterruptedException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("StatsPage.fxml"));
        Parent parentRoot = loader.load();
        Controller controller = loader.getController();

        controller.setLabels();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(parentRoot, WIDTH, HEIGHT);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();

        System.out.println("Oh baby!");
    }
}
