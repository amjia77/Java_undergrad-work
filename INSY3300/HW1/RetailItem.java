// Lingjia Zhang
// INSY3300-001

public class RetailItem
{
   private String description;
   private int unitsOnHand;
   private double price;

   public RetailItem()
   {
      setDescription("");
      setUnitsOnHand(0);
      setPrice(0.0);
   }   

   public RetailItem(String name, int units, double p)
   {
      setDescription(name);
      setUnitsOnHand(units);
      setPrice(p);
   }

   public void setDescription(String name)
   {
      description = name;
   }

   public void setUnitsOnHand(int units)
   {
      unitsOnHand = units;
   }

   public void setPrice(double p)
   {
      price = p;
   }

   public String getDescription()
   {
      return description;
   }

   public int getUnitsOnHand()
   {
      return unitsOnHand;
   }

   public double getPrice()
   {
      return price;
   }

   public String toString()
   {
       return ("The item is " + description + "\nThe units on hand is " + unitsOnHand + "\nThe price is " + price);
   }
}