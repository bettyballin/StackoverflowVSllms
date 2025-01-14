// Example of setting up a simple text-based interface using Java's Console class (for old hardware).
import java.io.Console;

public class Terminal {
  public void displayMenu() {
    Console console = System.console();
    if (console != null) {
      String menuOption = console.readLine("Select an option:\n1. Add Item\n2. List Items\nEnter choice: ");
      switch (menuOption) {
        case "1":
          // Logic to add item
          break;
        case "2":
          // Logic to list items
          break;
        default:
          console.printf("Invalid choice.\n");
      }
    } else {
      System.err.println("No Console found");
    }
  }

  public static void main(String[] args) {
    new Terminal().displayMenu();
  }
}