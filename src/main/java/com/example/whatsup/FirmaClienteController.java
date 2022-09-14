package com.example.whatsup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FirmaClienteController {

    @FXML
    private Button miguel;

    @FXML
    private Button pilar;

    @FXML
    private Button santiago;

    @FXML
    void ckMiguel(ActionEvent event) {

    }

    @FXML
    void ckPilar(ActionEvent event) throws IOException {
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("firmaCliente.fxml"));
        root=fxmlLoader.load();
        ContactosController contactosController=fxmlLoader.getController();
        //contactosController.userChat("Pilar");
    }

    @FXML
    void ckSantiago(ActionEvent event) {

    }
    private Stage stage;
    private Scene scene;
    private Parent root;

}
