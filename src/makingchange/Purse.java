// Kendra Fitzgerald
// Purse.java

package makingchange;

import java.util.HashMap;
import java.util.Map;

/**
 purse that holds various denominations of money.
 the methods add, remove, and calculate the total value
 */

public class Purse {
    // stores the denominations and their values 
    private final Map<DDenomination, Integer> money;

    // empty purse
    public Purse() {
        this.money = new HashMap<>();
    }

    
    // adds the entered amount to the purse, they type of money and the amount
    public void add(DDenomination type, int num) {
        money.put(type, money.getOrDefault(type, 0) + num);
    }


    // removes the money from the purse, and returns that value OR 0 if not enough
    public double remove(DDenomination type, int num) {
        int currentCount = money.getOrDefault(type, 0);
        if (currentCount >= num) {
            money.put(type, currentCount - num);
            return num * type.amt();
        }
        return 0.0;
    }

   // calculates and returns the total amount of money in the purse
    public double getTotal() {
        return money.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }


    // returns the money to be displayed
    public Map<DDenomination, Integer> getmoney() {
        return new HashMap<>(money);
    }


    // returns string representation of the money in the purse
    public String toString() {
        if (money.isEmpty()) {
            return "Empty Purse";
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<DDenomination, Integer> entry : money.entrySet()) {
            if (entry.getValue() > 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(entry.getValue())
                        .append(" ")
                        .append(entry.getKey().name());
            }
        }
        return sb.toString();
    }
}