package org.example.fotbalovytymlistview;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddPlayerController {
    @FXML
    private TextField jmenoTextField;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private ToggleGroup role;

    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
        if (player != null) {
            this.jmenoTextField.setText(player.getName());
            spinner.getValueFactory().setValue(player.getRating());
            RadioButton selectedRole = null;
            for (Toggle toggle : role.getToggles()) {
                if (((RadioButton) toggle).getText().equals(player.getPosition())) {
                    selectedRole = (RadioButton) toggle;
                    break;
                }
            }
            //Radio button odpovidající roli hráče nastavim jako zaškrnutý
            if (selectedRole != null) {
                selectedRole.setSelected(true);
            }
        }

    }

    public void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        spinner.setValueFactory(valueFactory);
    }

    @FXML
    protected void onCancelClick() {
        Stage stage = (Stage) jmenoTextField.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onOKClick() {
        String name = this.jmenoTextField.getText();
        int rating = this.spinner.getValue();
        RadioButton roleB = (RadioButton) this.role.getSelectedToggle();
        this.player = new Player(name, roleB.getText(), rating);
        Stage stage = (Stage) jmenoTextField.getScene().getWindow();
        stage.close();
    }

    public Player getPlayer() {
        return player;
    }

}
