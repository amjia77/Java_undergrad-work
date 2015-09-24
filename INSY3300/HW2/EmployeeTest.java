// Lingjia Zhang
// INSY3300-001


import javax.swing.JOptionPane;

public class EmployeeTest
{
   public static void main(String args[])
   {
      String message = " ";

      Employee ep1 = new Employee("Mary", "Jones", 45, 15.00);
      Employee ep2 = new Employee("Steve", "Smith", 30, 7.25);  

      double jonesGrossPay;
      double smithGrossPay;

      if(ep1.getHours() > 40)
         jonesGrossPay = 40 * ep1.getRate() + (ep1.getHours() - 40) * ep1.getRate() * 1.5;
      else
         jonesGrossPay = ep1.getHours() * ep1.getRate();
      
      if(ep2.getHours() > 40)
         smithGrossPay = 40 * ep2.getRate() + (ep2.getHours() - 40) * ep2.getRate() * 1.5;
      else
         smithGrossPay = ep2.getHours() * ep2.getRate();

      message = String.format("%s  $%.2f\n", ep1.getLastName(), jonesGrossPay);
      message = message + String.format("%s  $%.2f\n", ep2.getLastName(), smithGrossPay); 

      JOptionPane.showMessageDialog(null, message);
   }
}