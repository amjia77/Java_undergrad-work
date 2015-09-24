//Lingjia Zhang
//INSY4305-001

public class Customer
{
   private String name;
   private double amountOwed;

   public Customer()
   {
      setName("");
      setAmountOwed(0.0);
   }

   public Customer(String n, double a)
   {
      setName(n);
      setAmountOwed(a);
   }

   public void setName(String n)
   {
      name = n;
   }

   public void setAmountOwed(double a)
   {
      amountOwed = a;
   }

   public String getName()
   {
      return name;
   }

   public double getAmountOwed()
   {
      return amountOwed;
   }

   public String toString()
   {
      return ("Name "+ name + " Amount Owed " + amountOwed + "\n");
   }


}