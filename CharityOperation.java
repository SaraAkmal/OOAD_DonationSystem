/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationsystem;

//command
public interface CharityOperation {
    void execute();
}

class AddMoneyInFoodBank_Operation implements CharityOperation {
    String foodCharity;
    int Kilos;
    String type;


    public AddMoneyInFoodBank_Operation(int Kilos, String type, String foodCharity) {
        this.foodCharity = foodCharity;
        this.Kilos = Kilos;
        this.type = type;
    }

    @Override
    public void execute() {
        AccessCharitiesInSystem.callCharityInSystem().food.add_in_specific_charity(Kilos,type,foodCharity);
    }


}


class addMoneyInMoneyBankAccount_Operation implements CharityOperation {
    String moneyCharity;
   int amount;


    public addMoneyInMoneyBankAccount_Operation(int amount, String moneyCharity) {
        this.moneyCharity = moneyCharity;
        this.amount = amount;
    }



    @Override
    public void execute() {
        AccessCharitiesInSystem.callCharityInSystem().money.add_in_specific_charity(amount,moneyCharity);

    }


}