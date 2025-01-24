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
        denominations.add(new DDenomination("Fifty-Dollar", 50.0, "bill", "fifty.jpg"));
        denominations.add(new DDenomination("Ten-Dollar", 10.0, "bill", "ten.jpg"));
        denominations.add(new DDenomination("Five-Dollar", 5.0, "bill", "five.jpg"));
        denominations.add(new DDenomination("One-Dollar", 1.0, "bill", "one.jpg"));
        denominations.add(new DDenomination("Quarter", 0.25, "coin", "quarter.jpg"));
        denominations.add(new DDenomination("Dime", 0.10, "coin", "dime.jpg"));
        denominations.add(new DDenomination("Nickel", 0.05, "coin", "nickel.jpg"));
        denominations.add(new DDenomination("Penny", 0.01, "coin", "penny.jpg"));
    }


    // takes in the amount to make change for and
    // calculates the number of bills, using the least amount and returns a purse containing that amount
    public Purse makeChange(double amt) {
        Purse purse = new Purse();
        for (DDenomination den : denominations) {
            int count = (int) (amt / den.amt());
            if (count > 0) {
                purse.add(den, count);
                amt -= count * den.amt();
                // avoid floating point arithmetic
                amt = Math.round(amt * 100.0) / 100.0;
            }
        }
        return purse;
    }


}