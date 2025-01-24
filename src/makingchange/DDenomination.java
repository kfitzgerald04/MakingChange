// Kendra Fitzgerald
// Denomination.java

package makingchange;

/**
 * A record holding different types of currency denominations.
 * includes: name, amount, from(bill or coin), and the image for each
 */
public record DDenomination(String name, double amt, String form, String img) {
    public String toString(){
        return name + " (" + form + ") -$" + amt;
    }

}