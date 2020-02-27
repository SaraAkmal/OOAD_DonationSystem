/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

class MoneyInputsGUI{
    Pane Root;
    Label insertMoney;
    Label DonateMoney;
    TextField moneyinputTextField;
    ComboBox MoneyCharityNames;
    VBox vboxMoney;
    Button moneyDonatebtn;



    public MoneyInputsGUI(){


        vboxMoney = new VBox(30);
        Root = new Pane();
        MoneyCharityNames = new ComboBox();
        DonateMoney = new Label("Choose Charity");
        insertMoney = new Label("Amount of Money:");
        moneyinputTextField = new TextField();
        moneyDonatebtn = new Button("Donate");
        vboxMoney.getChildren().addAll(DonateMoney,MoneyCharityNames,insertMoney,moneyinputTextField,moneyDonatebtn);
        vboxMoney.setLayoutX(150);
        vboxMoney.setLayoutY(100);
        Root.setPrefSize(500, 500);
        Root.getChildren().add(vboxMoney);
        moneyDonatebtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                inputFormGUI InputForm = new inputFormGUI();
                InputForm.InputWindow.show();
                
                
                InputForm.ProcceedBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {

                        //client calling invoker
                        acceptMoneyDonation();
                        SaveData saveMoneyCharities = new SaveData(AccessCharitiesInSystem.callCharityInSystem().money.MoneyCharitiesArray, "MoneyCharities.ser");
                        saveMoneyCharities.SerializeData(AccessCharitiesInSystem.callCharityInSystem().money.MoneyCharitiesArray);
                        AccessCharitiesInSystem.callCharityInSystem().money.printCharities();
                        InputForm.InputWindow.close();
                    }
                });

                InputForm.DonatedBefore.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if(InputForm.DonatedBefore()){
                            //client calling invoker
                            acceptMoneyDonation();

                            SaveData saveMoneyCharities = new SaveData(AccessCharitiesInSystem.callCharityInSystem().money.MoneyCharitiesArray, "MoneyCharities.ser");
                            saveMoneyCharities.SerializeData(AccessCharitiesInSystem.callCharityInSystem().money.MoneyCharitiesArray);

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

    }

    void FillcharityComboBox(){
        ArrayList<MoneyCharity> charity_name = AccessCharitiesInSystem.callCharityInSystem().money.getCharities();
        for (charity element : charity_name) {
            MoneyCharityNames.getItems().add(element.CharityName);
        }
    }

    void acceptMoneyDonation(){
        if(!moneyinputTextField.getText().trim().isEmpty()){

            Donation newMoneyDonation = new Donation();
            addMoneyInMoneyBankAccount_Operation MoneyOperation = new addMoneyInMoneyBankAccount_Operation( Integer.parseInt(moneyinputTextField.getText()),MoneyCharityNames.getValue().toString());
            newMoneyDonation.addDonationtoSystem(MoneyOperation);
            MoneyOperation.execute();

        }
    }


}