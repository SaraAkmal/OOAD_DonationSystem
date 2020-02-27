/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationsystem;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class inputFormGUI {
    Label userName;
    Label DonatedBeforeLabel;
    TextField nameTextField;
    Label userEmail;
    TextField emailTextField;
    Label userLocation;
    TextField locationTextField;
    Label userBankAccount;
    TextField bankTextField;
    Label userIban;
    TextField ibanTextField;
    Button ProcceedBtn;
    Stage InputWindow;
    Boolean ExistingUser;
    Button DonatedBefore;
    public inputFormGUI(){


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene InputScene = new Scene(grid, 500, 500);

        DonatedBeforeLabel = new Label("Enter Email only if you donated before");
        grid.add(DonatedBeforeLabel, 0, 0);

        userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        userEmail = new Label("User Email:");
        grid.add(userEmail, 0, 2);

        emailTextField = new TextField();
        grid.add(emailTextField, 1, 2);

        userLocation = new Label("Location:");
        grid.add(userLocation, 0, 3);

        locationTextField = new TextField();
        grid.add(locationTextField, 1, 3);


        userBankAccount = new Label("Bank Account:");
        grid.add(userBankAccount, 0, 4);

        bankTextField = new TextField();
        grid.add(bankTextField, 1, 4);


        userIban = new Label("Iban:");
        grid.add(userIban, 0, 5);

        ibanTextField = new TextField();
        grid.add(ibanTextField, 1, 5);

        ProcceedBtn = new Button("Proceed");
        grid.add(ProcceedBtn, 1, 6);



        DonatedBefore = new Button("Donated Before!");
        grid.add(DonatedBefore, 0, 10);



        // New window (Stage)
        InputWindow = new Stage();
        InputWindow.setTitle("InputForm");
        InputWindow.setScene(InputScene);

        ExistingUser = false;





        ProcceedBtn.setOnAction(e -> {

            AccessUsersDataManagement.callUsersDataManagement().addUser(nameTextField.getText(),emailTextField.getText(),locationTextField.getText(),bankTextField.getText(),Integer.parseInt(ibanTextField.getText()));
            System.out.println("sizee ");
            SaveData saveUsers = new SaveData(AccessUsersDataManagement.callUsersDataManagement().Users_in_System, "UsersFile.ser");

            saveUsers.SerializeData(AccessUsersDataManagement.callUsersDataManagement().Users_in_System);

            System.out.println(AccessUsersDataManagement.callUsersDataManagement().Users_in_System.size());
            

        });

    }

    Boolean DonatedBefore(){

        return AccessUsersDataManagement.callUsersDataManagement().searchForExistingUser(emailTextField.getText());

    }

}