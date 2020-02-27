/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationsystem;

import java.io.Serializable;

interface DonationCalculationStrategy{
    int DonationCalculation();
}


 abstract class charity  implements Serializable {
     int charityID;
     String CharityName;
     BankAccount charityAcc;
     BankFactory bankFactory = new BankFactory();

     public charity(int charityID, String charityName) {
         this.charityID = charityID;
         this.CharityName = charityName;
         this.charityAcc =  bankFactory.createBankAccount(CharityName);
     }



     public String getName (){
         return this.CharityName;
     }
     public int getcharityID (){

         return this.charityID;
     }
     public void setcharityID(int charityID)
     {
         this.charityID = charityID;
     }

     protected void AddInBankAccount(int amount){
         charityAcc.add_in_bank(amount);
     }
}




