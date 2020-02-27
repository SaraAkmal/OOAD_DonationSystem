/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationsystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {

    startMenu Menu;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Menu = new startMenu();
        admin admin1 = new admin("1");
//        admin1.admins_addMoneyCharity(3,"5757");
//        admin1.admins_addFoodCharity(2,"resala");
//        admin1.admins_add_FoodType_in_Charity("resala","rice",3);


        primaryStage.setTitle("Donation System");
        primaryStage.setScene(new Scene(Menu.Root));
        primaryStage.show();


        Menu.MoneyButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                primaryStage.setScene(new Scene(Menu.moneyGui.Root));
                Menu.moneyGui.FillcharityComboBox();

            }
        });

        Menu.FoodButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                primaryStage.setScene(new Scene(Menu.foodGui.Root));
                Menu.foodGui.FillcharityComboBox();


            }
        });

        Menu.AdminBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                primaryStage.setScene(Menu.adminGui.AdminScene);


            }
        });

    }


    public static void main(String[] args) throws FileNotFoundException {


        SaveData saveUsers = new SaveData(AccessUsersDataManagement.callUsersDataManagement().Users_in_System, "UsersFile.ser");
        SaveData saveMoneyCharities = new SaveData(AccessCharitiesInSystem.callCharityInSystem().money.MoneyCharitiesArray, "MoneyCharities.ser");
        SaveData saveFoodCharities = new SaveData( AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray, "FoodCharities.ser");


        if(saveFoodCharities.getisEmpty() != -1){

            AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray = saveFoodCharities.DeserializeData();
        }
        if(saveMoneyCharities.getisEmpty() != -1){

            AccessCharitiesInSystem.callCharityInSystem().money.MoneyCharitiesArray = saveMoneyCharities.DeserializeData();
        }  if( saveUsers.getisEmpty() != -1){
            AccessUsersDataManagement.callUsersDataManagement().Users_in_System = saveUsers.DeserializeData();

        }


            launch(args);


    }
    }





class startMenu{

    Pane Root;
    Button MoneyButton;
    Button FoodButton;
    Button AdminBtn;
    MoneyInputsGUI moneyGui;
    FoodInputsGUI  foodGui;
    AdminsGUI adminGui;

    public startMenu(){
        moneyGui = new MoneyInputsGUI();
        foodGui = new FoodInputsGUI();
        adminGui = new AdminsGUI();
        Root = new Pane();
        MoneyButton = new Button("Money Charity");
        MoneyButton.setLayoutX(150);
        MoneyButton.setLayoutY(150);
        FoodButton = new Button("Food Charity");
        FoodButton.setLayoutX(300);
        FoodButton.setLayoutY(150);
        AdminBtn = new Button("Admin login");
        AdminBtn.setLayoutX(400);
        AdminBtn.setLayoutY(10);
        Root.setPrefSize(500, 500);
        Root.getChildren().addAll(MoneyButton,FoodButton,AdminBtn);
    }
}







