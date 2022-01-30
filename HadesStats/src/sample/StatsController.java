package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StatsController {

    @FXML
    Label bestLabel;
    @FXML
    Label worstLabel;
    @FXML
    Label averageKills;


    public void setLabels(String best, String worst, String averageText){

        bestLabel.setText(best);
        worstLabel.setText(worst);
        averageKills.setText(averageText);

    }

}
