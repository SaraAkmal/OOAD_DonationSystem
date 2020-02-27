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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdminsGUI {
    Label CharityIdLabel;
    Label CharityNameLabel;
    TextField charityIDField;
    TextField charityNameField;
    Label CharityFoodTypeLabel;
    TextField CharityFoodTypeText;
    Label FactorLabel;
    TextField FactorTextField;
    Stage AdminWindow;
    Button AddFoodCharity;
    Button AddMoneyCharity;
    Button EnterPassword;
    TextField PasswordField;
    Scene AdminScene;
    admin admin_1 = new admin("1");
//    SaveData moneyCharities;
//    SaveData saveFoodCharities;


public AdminsGUI(){
//  moneyCharities = new SaveData( AccessCharitiesInSystem.callCharityInSystem().money.MoneyCharitiesArray, "MoneyCharities.ser");
//    saveFoodCharities = new SaveData( AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray, "FoodCharities.ser");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));
    Scene AdminAdd = new Scene(grid, 500, 500);

    Pane adminPass = new Pane();

    EnterPassword = new Button("Enter Password");
    EnterPassword.setLayoutX(200);
    EnterPassword.setLayoutY(200);

    PasswordField = new TextField();
    PasswordField.setLayoutX(180);
    PasswordField.setLayoutY(150);


    adminPass.getChildren().addAll(EnterPassword,PasswordField);
     AdminScene = new Scene(adminPass, 500, 500);

    CharityIdLabel = new Label("Charity Id:");
    grid.add(CharityIdLabel, 0, 0);

    charityIDField = new TextField();
    grid.add(charityIDField, 1, 0);

    CharityNameLabel = new Label("Charity Name:");
    grid.add(CharityNameLabel, 0, 1);

    charityNameField = new TextField();
    grid.add(charityNameField, 1, 1);

    CharityFoodTypeLabel= new Label("Charity FoodType:");
    grid.add(CharityFoodTypeLabel, 0, 2);

    CharityFoodTypeText = new TextField();
    grid.add(CharityFoodTypeText, 1, 2);

    FactorLabel= new Label("Factor:");
    grid.add(FactorLabel, 0, 3);

    FactorTextField = new TextField();
    grid.add(FactorTextField, 1, 3);

    AddFoodCharity = new Button("Add Food Charity");
    grid.add(AddFoodCharity, 0, 4);

    AddMoneyCharity = new Button("Add Money Charity");
    grid.add(AddMoneyCharity, 1, 4);




    EnterPassword.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {


           if(PasswordField.getText().equals(admin_1.getPassword())){
               AdminWindow = new Stage();
               AdminWindow.setTitle("Admin Window");
               AdminWindow.setScene(AdminAdd);
               AdminWindow.show();
           }
           else{
               EnterPassword.setStyle("-fx-border-color: red;");
           }


        }
    });

    AddFoodCharity.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {


            admin_1.admins_addFoodCharity(Integer.parseInt(charityIDField.getText()),charityNameField.getText());
            admin_1.admins_add_FoodType_in_Charity(charityNameField.getText(),CharityFoodTypeText.getText(),Integer.parseInt(FactorTextField.getText()));

            SaveData saveFoodCharities = new SaveData( AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray, "FoodCharities.ser");
            saveFoodCharities.SerializeData(AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray);
             System.out.println(AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray);

        }
    });

    AddMoneyCharity.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {


            admin_1.admins_addMoneyCharity(Integer.parseInt(charityIDField.getText()),charityNameField.getText());


            SaveData saveMoneyCharities = new SaveData(AccessCharitiesInSystem.callCharityInSystem().money.MoneyCharitiesArray, "MoneyCharities.ser");
            saveMoneyCharities.SerializeData(AccessCharitiesInSystem.callCharityInSystem().money.MoneyCharitiesArray);
           
        }
    });



    }




}
