//Lingjia Zhang
//INSY4305-001

import java.io.*;

public class Actor implements Serializable
{
   private String name;
   private int age;

   public Actor()
   {
      setName("");
      setAge(0);
   }

   public Actor(String n, int a)
   {
      setName(n);
      setAge(a);
   }

   public void setName(String n)
   {
      name = n;
   }

   public void setAge(int a)
   {
      age = a;
   }

   public String getName()
   {
      return name;
   }

   public int getAge()
   {
      return age;
   }

   public String toString()
   {
      return("Name " + name + " Age " + age);
   }
}