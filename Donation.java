/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationsystem;

//invoker of charity operations

import java.util.ArrayList;

class Donation {
     ArrayList<CharityOperation> charityOperations = new ArrayList<CharityOperation>();

     public void addDonationtoSystem(CharityOperation charityOperation){
         charityOperations.add(charityOperation);

     }

     //executing operations in loop
    public void accept_donations(){

        for (CharityOperation operation : charityOperations) {
            operation.execute();
        }
    }

    //executing one operation
    public void accept_a_donation(CharityOperation operation){
            operation.execute();

    }

}