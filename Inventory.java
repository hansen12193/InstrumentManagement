import java.util.*;

public class Inventory {
   // create the inventory list of instruments
   private List<Inst> instruments;

   // initialize the instruments list as empty
   public Inventory() {
      instruments = new LinkedList<Inst>();
   }

   // add an instrument by creating a new item in the instrument list, called from the tester class
   public void addInstrument(String serialNumber, double price, InstSpec spec) {
      Inst instrument = new Inst(serialNumber, price, spec);
      instruments.add(instrument);
   }

   // return the instrument whos serial number matches the searched serial
   public Inst getInstrument(String serialNumber) {
      for (Iterator i = instruments.iterator(); i.hasNext(); ) {
         Inst instrument = (Inst)i.next();
         if (instrument.getSerial().equals(serialNumber)) {
            return instrument;
         }
      }
      return null;
   }

   // find all matches in the inventory that have key value pairs as being searched for: search("builder", "gibson", "type", "electric");
   public List<Inst> search(String[] args) {
      List<Inst> matchingInstruments = new LinkedList<Inst>();
      for (Iterator i = instruments.iterator(); i.hasNext(); ) {
         Inst instrument = (Inst)i.next();
         if (instrument.getSpec().matches(args)) {
            matchingInstruments.add(instrument);
         }
      }
      return matchingInstruments;
   }
}