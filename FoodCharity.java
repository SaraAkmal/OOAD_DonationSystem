/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationsystem;

import java.io.Serializable;
import java.util.ArrayList;

class FoodCharity extends charity {
    private static final long serialVersionUID =-40880320912166530L;
     ArrayList<FoodType> Food_Types = new ArrayList<FoodType>();

    public FoodCharity(int charityID,String charityName){
        super(charityID,charityName);

    }

    //method where admins add new food types, implement it in another command pattern other than charityoper
    void Add_Food_To_Charity(String type, int Factor){
        FoodType AddedToCharity = new FoodType(type);
        AddedToCharity.setFactor(Factor); //price of kilo today
        Food_Types.add(AddedToCharity);
    }

    //check choice and return food type like choice from array list
    public FoodType stringTofoodType (String choice) {
        FoodType food = new FoodType(choice);
        for (FoodType element : Food_Types) {
            if (element.type.equalsIgnoreCase(choice)) {
                food = element;
            }
        }
        //didnt handle case if food is not available
        return food;

    }


    public void add_food_donation(int kilos,String type) {
        //food_Type function converts string to type
        stringTofoodType(type).quantity_in_kilo =  kilos;
        int amount = stringTofoodType(type).DonationCalculation();
        this.AddInBankAccount(amount);
    }



}

class FoodType implements DonationCalculationStrategy , Serializable{
    String type;
    int quantity_in_kilo;
    int Factor;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity_in_kilo() {
        return quantity_in_kilo;
    }

    public void setQuantity_in_kilo(int quantity_in_kilo) {
        this.quantity_in_kilo = quantity_in_kilo;
    }

    public int getFactor() {
        return Factor;
    }

    public void setFactor(int factor) {
        Factor = factor;
    }

    FoodType(String type){
        this.type = type;
    }

    //how much does a kilo of type of food amount to today
   public int DonationCalculation(){
        return Factor*quantity_in_kilo;
    }


}




























