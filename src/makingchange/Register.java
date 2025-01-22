// Kendra Fitzgerald
// Register.java

package makingchange;

import java.util.ArrayList;
import java.util.List;


// cash register that is going to calcuate change for the entered amount

public class Register {
    // creates a list (register) of all the denominations
    private final List<DDenomination> denominations;

    public Register() {
        denominations = new ArrayList<>();

        denominations.add(new DDenomination("Penny", 0.01, "coin", "penny.png"));
        denominations.add(new DDenomination("Nickel", 0.05, "coin", "nickel.png"));
        denominations.add(new DDenomination("Dime", 0.10, "coin", "dime.png"));
        denominations.add(new DDenomination("Quarter", 0.25, "coin", "quarter.png"));
        denominations.add(new DDenomination("One-Dollar", 1.0, "bill", "one.png"));
        denominations.add(new DDenomination("Five-Dollar", 5.0, "bill", "five.png"));
        denominations.add(new DDenomination("Ten-Dollar", 10.0, "bill", "ten.png"));
        denominations.add(new DDenomination("Fifty-Dollar", 50.0, "bill", "fifty.png"));
    }


    // takes in the amount to make change for and
    // calculates the number of bills, using the least amount and returns a purse containing that amount
    public Purse makeChange(double amt) {
        // Handle invalid amounts
        if (amt <= 0 || amt < 0.01) {
            return new Purse();
        }

        // trying to avoid floating-point problems
        amt = Math.round(amt * 100.0) / 100.0;

        Purse purse = new Purse();
        for (DDenomination den : denominations) {
            int count = (int) (amt / den.amt());
            if (count > 0) {
                purse.add(den, count);
                amt -= count * den.amt();
                // avoiding here again
                amt = Math.round(amt * 100.0) / 100.0;
            }
        }
        return purse;
    }


    public static void main(String[] args) {
        Register register = new Register();
        // Test cases from assignment
        double[] testAmounts = {0, 1.25, 0.00001, 0.005, -5.45, 69.89};

        for (double amount : testAmounts) {
            Purse change = register.makeChange(amount);
            System.out.printf("Amount: $%.5f\n", amount);
            System.out.println("Change: " + change);
            System.out.println();
        }
    }
}