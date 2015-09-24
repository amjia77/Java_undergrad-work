// Lingjia Zhang
// INSY3300-001

import java.util.Scanner;

public class Restaurant
{
   public static void main(String args[])
   {
      Scanner input = new Scanner (System.in);
      
      double meal;
      double tax;
      double tip;
      double total;

      System.out.print("Enter the charge for the meal:");
      meal = input.nextDouble();

      tax = .0675 * meal;
      tip = .15 * (meal + tax);
      total = meal + tax + tip;

      System.out.printf("\n%s     %s     %s     %s\n", "Meal", "Tax", "Tip", "Total");
      System.out.printf("$%.2f   $%.2f   $%.2f   $%.2f\n", meal, tax, tip, total);    
   }
}