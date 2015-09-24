// Lingjia Zhang
// INSY3300-001


import javax.swing.JOptionPane;

public class RetailItemTest
{
   public static void main(String args[])
   {
      String message = " ";      

      RetailItem rt1 = new RetailItem("Jacket", 12, 59.95);
      RetailItem rt2 = new RetailItem("DesignerJeans", 40, 34.95);
      RetailItem rt3 = new RetailItem("Shirt", 20, 24.95);

      double jacketTotal;
      double jeansTotal;
      double shirtTotal;
      double grandTotal;

      jacketTotal = rt1.getPrice() * rt1.getUnitsOnHand();
      jeansTotal = rt2.getPrice() * rt2.getUnitsOnHand();
      shirtTotal = rt3.getPrice() * rt3.getUnitsOnHand();
      grandTotal = jacketTotal + jeansTotal + shirtTotal;

      message = String.format("%s  $%,.2f\n", "Jacket", jacketTotal);
      message = message + String.format("%s  $%,.2f\n", "Designer Jeans", jeansTotal);
      message = message + String.format("%s  $%,.2f\n", "Shirt", shirtTotal);
      message = message + String.format("%s  $%,.2f\n", "Total", grandTotal);

      JOptionPane.showMessageDialog(null, message);

   }
}