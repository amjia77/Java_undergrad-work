//Lingjia Zhang
//INSY4305-001

import java.util.ArrayList;

public class Show
{
   private String title;
   private String producer;
   private ArrayList<Actor> actorList = new ArrayList<Actor>(); 
   public enum ShowType{DRAMA, COMEDY, VARIETY, NEWS};
   private ShowType type;
   private int availableCommercialTime;

   public Show()
   {
      setTitle("");
      setProducer("");
      setAvailableCommercialTime(0);
   }

   public Show(String t, String p, ShowType s, int a)  
   {
      setTitle(t);
      setProducer(p);
      setType(s);
      setAvailableCommercialTime(a);
   }

   public void setTitle(String t)
   {
      title = t;
   }

   public void setProducer(String p)
   {
      producer = p;
   }

   public void setType(ShowType t)
   {
      type = t;
   }

   public void setAvailableCommercialTime(int a)
   {
      availableCommercialTime = a;
   }

   public String getTitle()
   {
      return title;
   }

   public String getProducer()
   {
      return producer;
   }

   public ArrayList<Actor> getActorList()
   {
      return actorList;
   }

   public void addActor(Actor a)
   {
      actorList.add(a);  
   }

   public ShowType getType()
   {
      return type;
   }

   public int getAvailableCommercialTime()
   {
      return availableCommercialTime;
   }

   public String toString()
   {
      return(" Title " + title + " Producer " + producer + " Show Type " + type + " Commercial Time " + availableCommercialTime + "\n" + " Actors " + "\n" + makeActorList() );
   }

   public String makeActorList()
   {
      String msg = "";
      for(Actor a: actorList)
         msg += a.toString() + "\n";
      return msg;
   }
}