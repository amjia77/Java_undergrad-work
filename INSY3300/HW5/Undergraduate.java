// Lingjia Zhang
// INSY3300-001

public class Undergraduate extends Student
{
   private double costPerHour = 125.0;

   public Undergraduate()
   {
      super();
      setCostPerHour(0.0);   
   }

   public Undergraduate(String fn, String ln, int id, Address address, double tuition, double cost)
   {
      super(fn, ln, id, address, tuition);
      setCostPerHour(cost);
   }

   public void setCostPerHour(double cost)
   {
      costPerHour = cost;
   }

   public double getCostPerHour()
   {
      return costPerHour;
   }

   @Override
   public String toString()
   {
      return(super.toString() + " Cost Per Hour " + costPerHour);
   }

   @Override
   public void calculateTuition(int hours)
   {
      setTuition(hours * 50 + hours * costPerHour); 
      calculateFees(getTuition());                
   }

}