package donationsystem;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

class FoodInputsGUI {

    Label insertKilo;
    Label DonateFood;
    Label foodTypeLabel;
    ComboBox FoodTypes;
    TextField KiloTextField;
    ComboBox<String> FoodCharityNames;
    VBox vboxFood;
    Button foodDonatebtn;
    Pane Root;

    public FoodInputsGUI() {
        Root = new Pane();
        foodTypeLabel = new Label("Choose Food Type");
        FoodTypes = new ComboBox();
        FoodCharityNames = new ComboBox();
        vboxFood = new VBox(30);
        DonateFood = new Label("Choose Charity");
        FoodCharityNames = new ComboBox<>();
        insertKilo = new Label("Kilos to Donate:");
        KiloTextField = new TextField();
        foodDonatebtn = new Button("Donate");
        vboxFood.getChildren().addAll(DonateFood, FoodCharityNames, foodTypeLabel, FoodTypes, insertKilo, KiloTextField, foodDonatebtn);
        vboxFood.setLayoutX(150);
        vboxFood.setLayoutY(100);
        Root.setPrefSize(500, 500);
        Root.getChildren().add(vboxFood);

        foodDonatebtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                inputFormGUI InputForm = new inputFormGUI();
                InputForm.InputWindow.show();
                InputForm.ProcceedBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        //client calling invoker
                        acceptFoodDonation();

                        SaveData saveFoodCharities = new SaveData( AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray, "FoodCharities.ser");
                        saveFoodCharities.SerializeData(AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray);


                        InputForm.InputWindow.close();
                    }
                });

                InputForm.DonatedBefore.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if(InputForm.DonatedBefore()){
                            //client calling invoker
                            acceptFoodDonation();

                            SaveData saveFoodCharities = new SaveData( AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray, "FoodCharities.ser");
                            saveFoodCharities.SerializeData(AccessCharitiesInSystem.callCharityInSystem().food.FoodCharitiesArray);

                            InputForm.InputWindow.close();
                        }
                        else{
                            InputForm.userEmail.setText("Not Found");
                            InputForm.userEmail.setTextFill(Color.RED);
                        }

                    }
                });


            }
        });

        FoodCharityNames.setOnAction(e -> {
            AccessCharitiesInSystem.callCharityInSystem().food.printCharities();
            FilltypeComboBox();


        });
    }


    void acceptFoodDonation(){
        if(!KiloTextField.getText().trim().isEmpty()){

            Donation newFoodDonation = new Donation();
            AddMoneyInFoodBank_Operation FoodOperation = new AddMoneyInFoodBank_Operation( Integer.parseInt(KiloTextField.getText()),FoodTypes.getValue().toString(),FoodCharityNames.getValue());
            newFoodDonation.addDonationtoSystem(FoodOperation);
            FoodOperation.execute();

        }
    }

    void FillcharityComboBox() {
        ArrayList<FoodCharity> charity_name = AccessCharitiesInSystem.callCharityInSystem().food.getCharities();
        for (charity element : charity_name) {
            FoodCharityNames.getItems().add(element.CharityName);
        }
    }

    void FilltypeComboBox() {
        ArrayList<FoodType> charity_name = AccessCharitiesInSystem.callCharityInSystem().food.get_Types_in_specific_charity(FoodCharityNames.getValue());
        for (FoodType element : charity_name) {
            FoodTypes.getItems().add(element.type);
        }

    }

}