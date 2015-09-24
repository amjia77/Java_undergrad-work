// Lingjia Zhang
// INSY3300-001

public class Graduate extends Student
{
   private double costPerHour = 295.0;
   private String program;

   public Graduate()
   {
      super();
      setCostPerHour(0.0);   
      setProgram("");
   }

   public Graduate(String fn, String ln, int id, Address address, double tuition, double cost, String p)
   {
      super(fn, ln, id, address, tuition);
      setCostPerHour(cost);
      setProgram(p);
   }

   public void setCostPerHour(double cost)
   {
      costPerHour = cost;
   }

   public void setProgram(String p)
   {
      program = p;
   }

   public double getCostPerHour()
   {
      return costPerHour;
   }

   public String getProgram()
   {
      return program;
   }

   @Override
   public String toString()
   {
      return(super.toString() + " Cost Per Hour " + costPerHour + " Program " + program);
   }

   @Override
   public void calculateTuition(int hours)
   {
      setTuition(hours * 50 + hours * costPerHour);   
      setTuition(getTuition()*1.1);
      calculateFees(getTuition());           
   }

}