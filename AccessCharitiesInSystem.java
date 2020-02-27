
package donationsystem;



import java.io.Serializable;
import java.util.ArrayList;
//facade to data

interface AccessCharitiesInSystem  {

    static charitiesInSystem callCharityInSystem (){

        return charitiesInSystem.getInstance();
    }
}





//singleton database for charities in system
class  charitiesInSystem implements Serializable {

    MoneycharitiesInSystem money = new MoneycharitiesInSystem();
    foodCharitiesInSystem food = new foodCharitiesInSystem();

    private static charitiesInSystem uniqueInstance = null;
    private charitiesInSystem( ) {} // private constructor

    public static charitiesInSystem getInstance( ) {
        if (uniqueInstance == null)
            uniqueInstance = new charitiesInSystem();
        return uniqueInstance;
    }



}



class MoneycharitiesInSystem implements Serializable {
     ArrayList<MoneyCharity> MoneyCharitiesArray = new ArrayList<MoneyCharity>();

    moneyCharityFactory newMoneycharity = new moneyCharityFactory();


    void add_new_MoneyCharity(int charityID,String CharityName){
        MoneyCharitiesArray.add(newMoneycharity.createMoneyCharity(charityID,CharityName));
    }

    public void printCharities () {

        for (charity element : MoneyCharitiesArray) {

            System.out.println(element.charityAcc.getCash_inflow());
        }
    }

    public ArrayList<MoneyCharity> getCharities () {

        return MoneyCharitiesArray;
    }

    public void  add_in_specific_charity (int Amount, String Choice) {
        for (charity element : MoneyCharitiesArray) {
            if (element.CharityName.equalsIgnoreCase(Choice)){
                element.AddInBankAccount(Amount);
            }
        }
      }

    }





class foodCharitiesInSystem implements Serializable {
     ArrayList<FoodCharity> FoodCharitiesArray = new ArrayList<FoodCharity>();
    foodCharityFactory newFoodcharity = new foodCharityFactory();



    void add_new_FoodCharity(int charityID,String CharityName){
        FoodCharitiesArray.add(newFoodcharity.createFoodCharity(charityID,CharityName));
        //printCharities();
    }

    public void printCharities () {

        for (charity element : FoodCharitiesArray) {

            System.out.println(element.CharityName);
        }
    }

    public ArrayList<FoodCharity> getCharities () {

        return FoodCharitiesArray;
    }

    public ArrayList<FoodType> get_Types_in_specific_charity (String CharityName) {
        for (FoodCharity element : FoodCharitiesArray) {
            if(element.CharityName.equals(CharityName)){
               

                return element.Food_Types;
            }
        }
        return null;
    }

//admin uses this method to add food type in food charity

    public void  add_type_in_specific_charity (String Choice, String type, int Factor) {
        for (FoodCharity element : FoodCharitiesArray) {
            if(element.CharityName.equals(Choice)){
                element.Add_Food_To_Charity(type,Factor);
            }
        }

    }

//customer uses this method in donate in specific charity
    public void  add_in_specific_charity (int Kilos, String type, String Choice) {
        for (FoodCharity element : FoodCharitiesArray) {
            if (element.CharityName.equalsIgnoreCase(Choice)){
                element.add_food_donation(Kilos,type);
            }
        }
    }

}



class foodCharityFactory
{
    public static FoodCharity createFoodCharity(int charityID,String CharityName)
    {
        return new FoodCharity(charityID,CharityName);
    }
}

class moneyCharityFactory
{
    public static MoneyCharity createMoneyCharity(int charityID,String CharityName)
    {
        return new MoneyCharity(charityID,CharityName);
    }
}
