// Lingjia Zhang
// INSY3300-001


public class Employee

{
   private String firstName;
   private String lastName;
   private double hours;
   private double rate;

   public Employee()
   {
      setFirstName("");
      setLastName("");
      setHours(0.0);
      setRate(0.0);
   }

   public Employee(String first, String last, double h, double r)
   {
      setFirstName(first);
      setLastName(last);
      setHours(h);
      setRate(r);
   } 

   public void setFirstName(String f)
   {
      firstName = f;
   }

   public void setLastName(String l)
   {
      lastName = l;
   }

   public void setHours(double h)
   {
      hours = h;
   }

   public void setRate(double r)
   {
      rate = r;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public double getHours()
   {
      return hours;
   }

   public double getRate()
   {
      return rate;
   }

   public String toString()
   {
      return ("First name: " + firstName + " Last name: " + lastName + " Hours " + hours + " Rate " + rate);
   }
}