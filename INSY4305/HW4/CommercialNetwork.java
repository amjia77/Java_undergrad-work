//Lingjia Zhang
//INSY4305-001

import java.io.*;

public class CommercialNetwork extends Network implements Serializable
{
   private String owner;
   private String parentCompany;

   public CommercialNetwork()
   {
      super();
      setOwner("");
      setParentCompany("");
   }
 
   public CommercialNetwork(String n, String p, Address h, String o, String pc)
   {
      super(n, p, h);
      setOwner(o);
      setParentCompany(pc);
   }

   public void setOwner(String o)
   {
      owner = o;
   }

   public void setParentCompany(String pc)
   {
      parentCompany = pc;
   }

   public String getOwner()
   {
      return owner;
   }

   public String getParentCompany()
   {
      return parentCompany;
   }

   public String toString()
   {
      return (" Owner " + owner + " Parent Company " + parentCompany + "\n" + super.toString());
   }
   
   public double calculateCommercialCost(int sec)
   {
      int cost;
      if(sec <= 15)
         cost=5000;
      else
         cost=5000* (sec/15);  
      return cost+10000;
   }
}