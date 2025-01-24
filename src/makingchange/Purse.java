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
    private final Map<DDenomination, Integer> money = new HashMap<>();

    
    // adds the entered amount to the purse, they type of money and the amount
    public void add(DDenomination type, int num) {
        money.put(type, money.getOrDefault(type, 0) + num);
    }


    // removes the money from the purse, and returns that value OR 0 if not enough
    public double remove(DDenomination type, int num) {
        if (!money.containsKey(type) || money.get(type) < num){
            throw new IllegalArgumentException("Need more " + type.name());
        }
        money.put(type, money.get(type) - num);
        if (money.get(type) == 0) money.remove(type);
        return type.amt() * num;
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
        StringBuilder sb = new StringBuilder("Purse contains:/n");
        money.forEach((denom, count) -> sb.append(count).append(" x ").append(denom).append("\n"));
        return sb.toString();

    }
}