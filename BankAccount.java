
package donationsystem;
import java.io.Serializable;
import java.util.Scanner;

class BankAccount implements Serializable {

    private String nameOfBank;



    private int cash_inflow;

    public void add_in_bank(int amount) {
        cash_inflow += amount;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }
    public void setNameOfBank(String nameOfBank) {

        this.nameOfBank = nameOfBank;
    }
    public int getCash_inflow() {
        return cash_inflow;
    }
}


class BankFactory implements Serializable
{
    public static BankAccount createBankAccount(String nameOfBank)
    {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setNameOfBank(nameOfBank);
        return bankAccount;

    }
}


