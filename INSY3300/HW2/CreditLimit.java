// Lingjia Zhang
// INSY3300-001


import java.util.Scanner;

public class CreditLimit
{
   public static void main(String args[])
   {
      Scanner input = new Scanner(System.in);

      int accountNumber;
      int beginBal;
      int charges;
      int credits;
      int creditLim;
      int newBal;
      
      System.out.println("Enter account number or -1 to quit");
      accountNumber = input.nextInt();

      while(accountNumber != -1)
      {
         System.out.println("Enter balance at the beginning of the month:");
         beginBal = input.nextInt();

         System.out.println("Enter total of all items charged by the customer this month:");
         charges = input.nextInt();

         System.out.println("Enter total of all credits applied to the customer's account this month:");
         credits = input.nextInt();

         System.out.println("Enter allowed credit limit:");
         creditLim = input.nextInt();

         newBal = beginBal + charges - credits;
         System.out.printf("The new balance is $%d", newBal);

         if(newBal > creditLim)
            System.out.println("Credit limit exceeded");

         System.out.println("");

         System.out.println("Enter account number or -1 to quit");
         accountNumber = input.nextInt();
      }
   }
}