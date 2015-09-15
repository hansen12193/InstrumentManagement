public class Inst {

   private String serialNumber;
   private double price;
   InstSpec spec;
   
   public Inst(String serialNumber, double price, InstSpec spec) {
      this.serialNumber = serialNumber;
      this.price = price;
      this.spec = spec;
   }

   public String getSerial() {
      return serialNumber;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double newPrice) {
      this.price = newPrice;
   }

   public InstSpec getSpec() {
      return spec;
   }
   
   public void printSpec() {
      spec.printSpec();
   }
}