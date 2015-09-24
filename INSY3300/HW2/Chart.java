// Lingjia Zhang
// INSY3300-001


import java.util.Scanner;

public class Chart
{
   public static void main(String args[])
   {
      Scanner input = new Scanner(System.in);

      int counter1 = 1;
      int counter2 = 1;
      int counter3 = 1;
      int sales1;
      int sales2;
      int sales3;

      System.out.printf("Enter today's sales for store 1: ");     //在此不用\n因为Enter is hitted when input
      sales1 = input.nextInt();
      int star1 = sales1/100;

      System.out.printf("Enter today's sales for store 2: ");
      sales2 = input.nextInt();
      int star2 = sales2/100;

      System.out.printf("Enter today's sales for store 3: ");
      sales3 = input.nextInt();
      int star3 = sales3/100;

      System.out.println("\nSALES BAR CHART");
      
      System.out.printf("Store 1: ");
      while(counter1 <= star1)
      {
          System.out.printf("*");  
          counter1 ++;
      }

      System.out.printf("\nStore 2: ");
      while(counter2 <= star2)
      {
          System.out.printf("*");  
          counter2 ++;
      }

      System.out.printf("\nStore 3: ");
      while(counter3 <= star3)
      {
          System.out.printf("*");  
          counter3 ++;
      }
   }
}