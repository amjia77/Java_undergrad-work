//Lingjia Zhang
//INSY4305-001

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NetworkTest
{
   public static void main(String args[])
   {
      PublicNetwork n1 = new PublicNetwork("PBS", "Paula Kerger", new Address("2100 Chrystal Drive", "Arlington", "Virginia", 22202), "Public Radio");
      CommercialNetwork n2 = new CommercialNetwork("CBS", "Leslie Moonves", new Address("51 West 52nd Street", "New York", "New York", 10019), "Philippe Dauman", "Viacom");
      CommercialNetwork n3 = new CommercialNetwork("ABC", "Ben Sherwood", new Address("54 West 67th Street", "New York", "New York", 10017), "Ed Noble", "Disney");
      CommercialNetwork n4 = new CommercialNetwork("NBC", "Jeff Zucker", new Address("30 Rockefeller Center", "New York", "New York", 10112), "Burke Cox", "General Electric");

      Show s1 = new Show("Big Bang Theory", "Lorre", 300);
      Show s2 = new Show("Hawaii Five O", "Kurtzman", 600);
      Show s3 = new Show("ABC World News", "Arlidge", 250);
      Show s4 = new Show("CEO", "Cullum", 150);

      Actor ac1 = new Actor("Johnny Galecki", 28);
      Actor ac2 = new Actor("Jim Parsons", 30);
      Actor ac3 = new Actor("Kaley Cuoco", 26);
      Actor ac4 = new Actor("Alex O'Loughlin", 35);
      Actor ac5 = new Actor("Scott Caan", 33);
      Actor ac6 = new Actor("Daniel Kim", 36);
      Actor ac7 = new Actor("Grace Park", 32);
      Actor ac8 = new Actor("Diane Sawyer", 60);
      Actor ac9 = new Actor("David Muir", 45);
      Actor ac10 = new Actor("Cullum", 58);

      s1.addActor(ac1);
      s1.addActor(ac2);
      s1.addActor(ac3);
      s2.addActor(ac4);
      s2.addActor(ac5);
      s2.addActor(ac6);
      s2.addActor(ac7);
      s3.addActor(ac8);
      s3.addActor(ac9);
      s4.addActor(ac10);
 
      s1.setType(Show.ShowType.COMEDY);
      s2.setType(Show.ShowType.DRAMA);
      s3.setType(Show.ShowType.NEWS);
      s4.setType(Show.ShowType.NEWS);

      n2.addShow(s1);
      n2.addShow(s2);
      n3.addShow(s3);
      n1.addShow(s4);

      Customer c1 = new Customer("Toyota", 0.0);
      Customer c2 = new Customer("General Mills", 0.0);  
      Customer c3 = new Customer("Apple", 0.0);
      Customer c4 = new Customer("Microsoft", 0.0);
      Customer c5 = new Customer("Greenpeace", 0.0);
      Customer c6 = new Customer("Google", 0.0);
  
      try
      {
         n2.buyCommercial(15, "Big Bang Theory", c1);
         n2.buyCommercial(20, "Hawaii Five O", c2);
         n2.buyCommercial(30, "Big Bang Theory", c3);
         n3.buyCommercial(15, "ABC World News", c4);
         n1.buyCommercial(10, "CEO", c5);
         n2.buyCommercial(45, "Hawaii Five O", c2);
         n4.buyCommercial(20, "NBC", c6);
      }
      catch(ShowNotFoundException snfe)
      {
         JOptionPane.showMessageDialog(null, snfe.getMessage());      //System.out.println(snfe);
      }
      catch(NoAvailableCommercialTimeException nacte)
      {
         JOptionPane.showMessageDialog(null, nacte);     //System.out.println(nacte);
      }

      ArrayList<Network> networkList = new ArrayList<Network>();
      networkList.add(n1);
      networkList.add(n2);
      networkList.add(n3);
      networkList.add(n4);

      String msg="";

      for(Network n: networkList)
      {
         msg += n.toString();
      }
      JOptionPane.showMessageDialog(null, msg);
   }
}