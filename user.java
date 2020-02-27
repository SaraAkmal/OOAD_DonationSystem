/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

interface AccessUsersDataManagement {

    static usersDataManagement callUsersDataManagement (){

        return usersDataManagement.getInstance();
    }
}


class usersDataManagement implements Serializable{
    UserFactory userFactory;
     ArrayList<user> Users_in_System = new ArrayList<user>();

    private usersDataManagement(){
        userFactory = new UserFactory();
    }

    private static usersDataManagement uniqueInstance = null;


    public static usersDataManagement getInstance( ) {
        if (uniqueInstance == null)
            uniqueInstance = new usersDataManagement();
        return uniqueInstance;
    }

    void addUser(String name,String mail,String location ,String Bankaccount, int Iban){
       user new_User = userFactory.createUser();
        new_User.setName(name);
        new_User.setmail(mail);
        new_User.setLocation(location);
        new_User.setBankaccount(Bankaccount);
        new_User.setIban(Iban);
        Users_in_System.add(new_User);
    }

    Boolean searchForExistingUser(String Email){
        Boolean state = false;
        for (user element : Users_in_System) {
            if(element.getmail().equals(Email) ){
                state = true;
                return state;
            }

        }
        return state;
    }

}

class user implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Name ;
    private String mail ;
    private String Location ;
    private String Bankaccount;
    private int Iban;



    public user (){

    }
    public void setBankaccount(String bankaccount) {
        Bankaccount = bankaccount;
    }
    public String getBankaccount() {
        return Bankaccount;
    }



    public int getIban() {
        return Iban;
    }

    public void setIban(int iban) {
        Iban = iban;
    }



    public String getName (){
        return this.Name;
    }
    public void setName (String Name ){

        this.Name = Name;
    }
    public String getmail (){
        return this.mail;
    }
    public void setmail (String mail ){

        this.mail = mail;
    }
    public String getLocation (){
        return this.Name;
    }
    public void setLocation(String location ){

        this.Location = Location;
    }




}


 class UserFactory
{
    public static user createUser()
    {
        return new user();
    }
}


