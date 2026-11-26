package org.example.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.DataBase;

public class MainController {
    @FXML
    private TextField emaillog;
    @FXML
    private TextField emailreg;
    @FXML
    private PasswordField passwordreg;
    @FXML
    private PasswordField passwordlog;
    @FXML
    private Label statusLabel;
    @FXML
    private RadioButton newitem;
    @FXML
    private RadioButton additem;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField costTextField;
    @FXML
    private Label costLabel;
    @FXML
    private ChoiceBox nameChoiceBox;



    @FXML
    private void Register() {
        String email = emailreg.getText().trim();
        String password = passwordreg.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            statusLabel.setStyle("-fx-background-color: #ffebee; -fx-text-fill: #c62828; -fx-background-radius: 8px; -fx-padding: 10px 15px; -fx-font-size: 20px; -fx-font-weight: bold;");
            statusLabel.setText("Fill all fields!");
            return;
        }

        boolean isRegistered = DataBase.Registration(email, password);
        if (isRegistered) {
            statusLabel.setStyle("-fx-background-color: #e8f5e9; -fx-text-fill: #2e7d32; -fx-background-radius: 8px; -fx-padding: 10px 15px; -fx-font-size: 20px; -fx-font-weight: bold;");
            statusLabel.setText("Success");
        } else {
            statusLabel.setStyle("-fx-background-color: #ffebee; -fx-text-fill: #c62828; -fx-background-radius: 8px; -fx-padding: 10px 15px; -fx-font-size: 20px; -fx-font-weight: bold;");
            statusLabel.setText("Email is taken.");
        }
    }

    @FXML
    private void Login(ActionEvent event) {
        String email = emaillog.getText().trim();
        String password = passwordlog.getText().trim();
        boolean isValidUser = DataBase.checkUser(email, password);

        if (isValidUser) {
            System.out.println("Login successful!");
            SwitchSceneController.switchScene(event, "/mainmenu.fxml", "Main Menu");
        } else {
            System.out.println("Incorrect email or password");
        }
    }

    @FXML
    private void switchToRegister(MouseEvent event) {
        SwitchSceneController.switchScene(event, "/registrationpage.fxml", "Registration");
    }

    @FXML
    private void switchToLogin(MouseEvent event) {
        SwitchSceneController.switchScene(event, "/loginpage.fxml", "Login");
    }

    @FXML
    private void OpenRepairs(ActionEvent event) {
        SwitchSceneController.switchScene(event, "/repairsmanagement.fxml", "Repairs Management");
    }
    @FXML
    private void OpenInventory(ActionEvent event) {
        SwitchSceneController.switchScene(event, "/inventorymanagement.fxml", "Inventory Management");
    }
    @FXML
    private void OpenClients(ActionEvent event) {
        SwitchSceneController.switchScene(event, "/clientsmanagement.fxml", "Clients Management");
    }
    @FXML
    private void OpenLogin(ActionEvent event) {
        SwitchSceneController.switchScene(event, "/loginpage.fxml", "Login Page");
    }
    @FXML
    private void BackMenu(ActionEvent event) {
        SwitchSceneController.switchScene(event, "/mainmenu.fxml", "Main Menu");
    }
    @FXML
    private void AddClients(ActionEvent event) {
        SwitchSceneController.switchScene(event, "/newclient.fxml", "New Client");
    }
    @FXML
    private void AddRepairs(ActionEvent event) {
        SwitchSceneController.switchScene(event, "/neworder.fxml", "New Order");
    }
    @FXML
    private void AddInventory(ActionEvent event) {
        SwitchSceneController.switchScene(event, "/addinventory.fxml", "Add Inventory");
    }
    @FXML
    private void ChangeItem(ActionEvent event) {
        if (newitem.isSelected()) {
            nameTextField.setOpacity(1.0);
            nameTextField.setDisable(false);
            nameTextField.setMouseTransparent(false);
            nameChoiceBox.setOpacity(0.0);
            nameChoiceBox.setDisable(true);
            nameChoiceBox.setMouseTransparent(true);
            costTextField.setOpacity(1.0);
            costTextField.setDisable(false);
            costTextField.setMouseTransparent(false);
            costLabel.setOpacity(1.0);
        }else{
            nameTextField.setOpacity(0.0);
            nameTextField.setDisable(true);
            nameTextField.setMouseTransparent(true);
            nameChoiceBox.setOpacity(1.0);
            nameChoiceBox.setDisable(false);
            nameChoiceBox.setMouseTransparent(false);
            costTextField.setOpacity(0.0);
            costTextField.setDisable(true);
            costTextField.setMouseTransparent(true);
            costLabel.setOpacity(0.0);
        }
    }
}