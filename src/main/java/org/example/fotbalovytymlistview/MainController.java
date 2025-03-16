package org.example.fotbalovytymlistview;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Label label;

    @FXML
    private ListView<Player> list = new ListView<>();


    public void initialize() {
        Player player1 = new Player("Lionel Messi", "Útočník", 93);
        Player player2 = new Player("Kevin De Bruyne", "Záložník", 91);
        Player player3 = new Player("Thibaut Courtois", "Brankář", 89);
        list.getItems().add(player1);
        list.getItems().add(player2);
        list.getItems().add(player3);
    }

    @FXML
    protected void onDeleteClick() {
        list.getItems().remove(list.getSelectionModel().getSelectedItem());
    }

    @FXML
    protected void displayPlayerDetails() {
        Player player = list.getSelectionModel().getSelectedItem();
        if (player != null) {
            String text = " Vybraný hráč:\n" +  " Jméno hráče: " + player .getName() + "\n Pozice hráče: " + player.getPosition() + "\n Hodnocení hráče: " + player.getRating();
            label.setText(text);
        }
    }


    @FXML
    protected void onAddPlayerClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-player.fxml"));
        GridPane gridPane = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add User");
        stage.setScene(new Scene(gridPane));
        stage.showAndWait();
        AddPlayerController controller = fxmlLoader.getController();
        Player newPlayer = controller.getPlayer();
        if (newPlayer != null) {
            list.getItems().add(newPlayer);
        }
    }

    @FXML
    protected void onEditPlayerClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("add-player.fxml"));
        GridPane gridPane = fxmlLoader.load();

        AddPlayerController controller = fxmlLoader.getController();
        Player editedPlayer = list.getSelectionModel().getSelectedItem();
        controller.setPlayer(editedPlayer);

        Stage stage = new Stage();
        stage.setTitle("Edit Player");
        stage.setScene(new Scene(gridPane));
        stage.showAndWait();
        editedPlayer = controller.getPlayer();
        list.getItems().set(list.getSelectionModel().getSelectedIndex(), editedPlayer);
    }
}