//Lingjia Zhang
//INSY4305-001

import java.io.*;

public class PublicNetwork extends Network implements Serializable
{
   private String sponsor;

   public PublicNetwork()
   {
      super();
      setSponsor("");
   }

   public PublicNetwork(String n, String p, Address h, String s)   
   {
      super(n, p, h);
      setSponsor(s);
   }

   public void setSponsor(String s)
   {
      sponsor = s;
   }

   public String getSponsor()
   {
      return sponsor;
   }

   public String toString()
   {
      return(" Sponsor " + sponsor + "\n" + super.toString());
   }

   public double calculateCommercialCost(int sec)
   {
      int cost;
      if(sec <= 15)
         cost=5000;
      else
         cost=5000*(sec/15);       
      return cost;        
   }
}