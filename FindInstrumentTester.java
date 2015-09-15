import java.lang.*;
import java.util.*;

public class FindInstrumentTester {

   public static void main(String[] args) {
      // set up the inventory
      Inventory inventory = new Inventory();
      initializeInventory(inventory);
      
      // define the search phrase to find in the inventory in logical pairs: {"builder", "gibson", "type", "electric", ...} and the search serial
      String[] searchPhrase = new String[] {"Builder", "Gibson"};
      String searchSerial = "123456";


      // perform and display the results of searching the inventory for the search phrase
      System.out.println("Performing a search based on the search phrase: " + Arrays.toString(searchPhrase));
      System.out.print("---------- \n");
      List<Inst> matchingInstruments = inventory.search(searchPhrase);
      if (!matchingInstruments.isEmpty()) {
         for (int count = (matchingInstruments.size() - 1); count >= 0; count--) {
            System.out.print("Serial number " + (matchingInstruments.get(count)).getSerial());
            System.out.print(" priced at $" + (matchingInstruments.get(count)).getPrice());
            System.out.print(" with the following properties: \n");
            (matchingInstruments.get(count)).printSpec();
            System.out.print("---------- \n");
         }
      } 
      else {
         System.out.println("Sorry, no matching items in the inventory.");
      }
      System.out.print(" \n");
      
      
      // perform and display the results of searching the inventory for the search serial
      System.out.println("Performing a search based on the serial number: " + searchSerial);
      System.out.print("---------- \n");
      Inst match;
      if ((match = inventory.getInstrument(searchSerial)) != null) {
         System.out.print("Serial number " + match.getSerial());
         System.out.print(" priced at $" + match.getPrice());
         System.out.print(" with the following properties: \n");
         match.printSpec();
         System.out.print("---------- \n");
      } 
      else {
         System.out.println("Sorry, no matching items in the inventory.");
      }
      System.out.print(" \n");
   }

   private static void initializeInventory(Inventory inventory) {
      // make some placeholder instruments to be added into the inventory
      inventory.addInstrument("123456",  2549.99, new InstSpec(new String[] {"Instrument", "Trombone", 
         "Type", "Wind", "Builder", "Joe Dixon", "Name", "El Trombono"} ));
      inventory.addInstrument("346125",   749.99, new InstSpec(new String[] {"Instrument", "Tuba", 
         "Octave", "Super low", "Type", "Wind", "Size", "So large"} ));
      inventory.addInstrument("321654",  3499.95, new InstSpec(new String[] {"Instrument", "Guitar", 
         "Builder", "Collings", "Model", "CJ", "Type", "Acoustic", "Topwood", "Sitka", "Strings", "6"} ));
      inventory.addInstrument("526341",  9449.95, new InstSpec(new String[] {"Instrument", "Guitar", 
         "Builder", "Gibson", "Model", "Stratocaster", "Type", "Electric", "Topwood", "Alder", "Strings", "24"} ));
      inventory.addInstrument("431652",  1499.99, new InstSpec(new String[] {"Instrument", "Mandolin", 
         "Builder", "Olson", "Type", "Acoustic", "Model", "PWNR9001", "Style", "A"} ));
      inventory.addInstrument("8900231", 2945.95, new InstSpec(new String[] {"Instrument", "Banjo", 
         "Builder", "Gibson", "Model", "RB-3 Wreath", "Type", "Acoustic", "Strings", "5", "Backwood", "Maple"} ));
      inventory.addInstrument("5194575", 1249.95, new InstSpec(new String[] {} ));
   }
}