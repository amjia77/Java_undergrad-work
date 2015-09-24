//Lingjia Zhang
//INSY4305-001

import java.util.ArrayList;
import java.io.*;

public abstract class Network implements Commercial, Serializable
{
   private String name;
   private String president;
   private Address headquarters;
   private ArrayList<Show> schedule = new ArrayList<Show>(); 
   private ArrayList<Customer> customerList = new ArrayList<Customer>();

   public Network()
   {
      setName("");
      setPresident("");
      setHeadquarters(new Address());
   }

   public Network(String n, String p, Address h)
   {
      setName(n);
      setPresident(p);
      setHeadquarters(h);
   }

   public void setName(String n)
   {
      name = n;
   }

   public void setPresident(String p)
   {
      president = p;
   }

   public void setHeadquarters(Address h)
   {
      headquarters = h;
   }

   public String getName()
   {
      return name;
   }

   public String getPresident()
   {
      return president;
   }

   public Address getHeadquarters()
   {
      return headquarters;
   }

   public ArrayList<Show> getSchedule()
   {
      return schedule;
   }

   public void addShow(Show s)
   {
      schedule.add(s);
   }

   public ArrayList<Customer> getCustomerList()
   {
      return customerList;
   }

   public void addCustomer(Customer c)
   {
      if(!customerList.contains(c))
      {
         customerList.add(c);
      } 
   }

   public String toString()
   {
      return(" Name " + name + " President " + president + " Headquarters " + headquarters.toString() + "\n" + " Shows " + "\n" + makeSchedule() + " Customers " + "\n" + makeCustomerList());
   }

   public String makeSchedule()
   {
      String msg="";
      for (Show s: schedule)
         msg += s.toString() + "\n";
      return msg;
   }

   public String makeCustomerList()
   {
      String msg="";
      for(Customer c: customerList)
         msg += c.toString() + "\n";
      return msg;
   }

   public void buyCommercial(int sec, String t, Customer c) throws ShowNotFoundException, NoAvailableCommercialTimeException   
   {
      for (Show s: schedule)
      {
         if(t.equals(s.getTitle()))
         {
            if(s.getAvailableCommercialTime()-sec >= 0)
            {
	       s.setAvailableCommercialTime(s.getAvailableCommercialTime()-sec);
               addCustomer(c);  
               c.setAmountOwed(c.getAmountOwed() + calculateCommercialCost(sec));
            }
            else //****************Exception for NoAvailableCommercialTime and you cannot sell a commercial**********
               throw new NoAvailableCommercialTimeException();

            return;
         }
      }

      throw new ShowNotFoundException("Show does not exist" + "\n" + "Dateline");
   }

   public abstract double calculateCommercialCost(int sec);
   
}