// Lingjia Zhang
// INSY3300-001

import javax.swing.JOptionPane;

public class StudentTest
{
   public static void main(String args[])
   {
      String dataArray[][] = {{"Undergraduate", "John", "Smith", "615 Bowen", "Arlington",  "Texas", "76019", "3079"},
                              {"Graduate", "Jane", "Jones", "221 Davis", "Fort Worth", "Texas", "76134", "1095", "MSIS"},
                              {"Undergraduate", "Dean", "Rice", "1001 HWY 2", "Dallas", "Texas", "75010", "1381"},
                              {"Undergraduate", "Rachel", "Cole", "789 Crowley", "Arlington", "Texas", "76015", "8003"},
                              {"Graduate", "Brad", "Shelborn", "942 Baird Road", "Grand Prairier", "Texas", "75050", "9780", "PHD"}};

      int hourArray[] = {12, 3, 9, 18, 6};

      Student studentArray[] = createInstances(dataArray);

      calcTuition(studentArray, hourArray);

      printInstances(studentArray, dataArray);
   }

   public static Student[] createInstances(String[][] dataArray)
   { 
      Student studentArray[] = new Student[dataArray.length];

      for (int i=0; i < studentArray.length; i++)
      {
         if (dataArray[i][0].equals("Undergraduate"))
            studentArray[i] = new Undergraduate(dataArray[i][1], dataArray[i][2], Integer.parseInt(dataArray[i][7]), new Address(dataArray[i][3], dataArray[i][4], dataArray[i][5], Integer.parseInt(dataArray[i][6])), 0.0, 125); 
         else if (dataArray[i][0].equals("Graduate"))
            studentArray[i] = new Graduate(dataArray[i][1], dataArray[i][2], Integer.parseInt(dataArray[i][7]), new Address(dataArray[i][3], dataArray[i][4], dataArray[i][5], Integer.parseInt(dataArray[i][6])), 0.0, 295, dataArray[i][8]);
      }

      return studentArray;
   }

   public static void calcTuition(Student[] studentArray, int[] hourArray)
   {
      for (int i=0; i < studentArray.length; i++)
         studentArray[i].calculateTuition(hourArray[i]);
   }

   public static void printInstances(Student[] studentArray, String[][] dataArray)
   {
      String message = "";
      double totalTuition = 0.0;
   
      for(int i=0; i < studentArray.length; i++)
      {
         totalTuition += studentArray[i].getTuition();

         if(studentArray[i] instanceof Undergraduate)
            message += String.format("%s %s     %s     $%.2f\n", studentArray[i].getFirstName(), studentArray[i].getLastName(), dataArray[i][0], studentArray[i].getTuition());
         else if(studentArray[i] instanceof Graduate)
            message += String.format("%s %s     %s     $%.2f     %s\n", studentArray[i].getFirstName(), studentArray[i].getLastName(), dataArray[i][0], studentArray[i].getTuition(), ((Graduate)studentArray[i]).getProgram());
      }

      message += String.format("%s      $%.2f", "Total Tuition", totalTuition);

      JOptionPane.showMessageDialog(null, message); 
   }
}