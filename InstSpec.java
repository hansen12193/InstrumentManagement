import java.util.*;

public class InstSpec {
   private Map<String, String> properties = new HashMap<String, String>();
   
   // the constructor takes any number of arguments, which will be keys and pairs in order ("builder", "gibson", "type", "electric", ...) and insert them into a 
   // property hashmap respecting those associations
   public InstSpec(String[] args) {
      if ((args.length % 2) == 1) {
         System.err.println("Invalid number of paramters for an instrument to be instantiated! ");
         System.exit(0);
      }
      else {
         for (int index = (args.length - 1); index >= 1; index -= 2) {
            properties.put(args[index - 1], args[index]);
         }
      }
   }
   
   // matches will look through the property hash to check if the arguments ("builder", "gibson", "type", "electric", ...) have associated entries in the property hashmap
   // if all of the argument keys exist and have matching argument values in the hashmap, the instrument will be returned
   // this also allows for identical keys to mean different things but have logical values associated (type -> wind, or type -> acoustic)
   public boolean matches(String[] args) {
      if ((args.length % 2) == 1) {
         System.err.println("Invalid number of paramters for an instrument search! ");
         System.exit(0);
         // this won't get called because the program will terminate here - simply avoids compiler complaining for now
         return false;
      }
      else {
         for (int index = (args.length - 1); index >= 1; index -= 2) {
            if (!properties.containsKey(args[index - 1]) || (!properties.get(args[index - 1]).equals(args[index]))) {
               return false;
            }
         }
         return true;
      }
   }
   
   public void printSpec() {
      for (String key : properties.keySet()) {
         String value = properties.get(key);
         System.out.println(key + ": " + value);
      }
   }
}