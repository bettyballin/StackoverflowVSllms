import java.lang.String;
public class UserAccount {
    // Short name: bal; Long description: accountBalance
    private double bal;

    public void deposit(double amount) {
        bal += amount;
    }

    public double getBal() { // Short name: getBal; Long description: getAccountBalance
        return bal;
    }

    // Metadata file or embedded annotations
    /*
    <variable>
      <shortName>bal</shortName>
      <longName>accountBalance</longName>
      <description>The current balance of the user's account.</description>
    </variable>

    <method>
      <shortName>getBal</shortName>
      <longName>getAccountBalance</longName>
      <description>Returns the current balance of the user's account.</description>
    </method>
    */

    public static void main(String[] args) {
    }
}