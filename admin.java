
package donationsystem;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.ArrayList;

public class admin implements AccessCharitiesInSystem {

    public static String getPassword() {
        return Password;
    }

    private static String Password ;

    public admin(String Password ) {
        this.Password = Password;
    }

    void admins_addFoodCharity(int charityID, String CharityName){
        AccessCharitiesInSystem.callCharityInSystem().food.add_new_FoodCharity(charityID,CharityName);

    }

    void admins_addMoneyCharity(int charityID, String CharityName){
        AccessCharitiesInSystem.callCharityInSystem().money.add_new_MoneyCharity(charityID,CharityName);
    }

    void admins_add_FoodType_in_Charity(String CharityName, String type, int Factor){
        AccessCharitiesInSystem.callCharityInSystem().food.add_type_in_specific_charity(CharityName,type,Factor);
    }


}
