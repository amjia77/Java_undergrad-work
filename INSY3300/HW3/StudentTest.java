// Lingjia Zhang
// INSY3300-001

import javax.swing.JOptionPane;

public class StudentTest
{
   public static void main(String args[])
   {
      String dataArray[][] = {{"John", "Smith", "3079", "Undergraduate"},
                              {"Jane", "Jones", "1095", "Graduate"},
                              {"Dean", "Rice", "1381", "Undergraduate"},
                              {"Rachel", "Cole", "8003", "Undergraduate"},
                              {"Brad", "Shelborn", "9780", "Graduate"}};

      int hourArray[] = {12, 3, 9, 18, 6};

      Student studentArray[] = new Student[5];

      studentArray[0] = new Student(dataArray[0][0], dataArray[0][1], Integer.parseInt(dataArray[0][2]), 0.0);
      studentArray[1] = new Student(dataArray[1][0], dataArray[1][1], Integer.parseInt(dataArray[1][2]), 0.0);
      studentArray[2] = new Student(dataArray[2][0], dataArray[2][1], Integer.parseInt(dataArray[2][2]), 0.0);
      studentArray[3] = new Student(dataArray[3][0], dataArray[3][1], Integer.parseInt(dataArray[3][2]), 0.0);
      studentArray[4] = new Student(dataArray[4][0], dataArray[4][1], Integer.parseInt(dataArray[4][2]), 0.0);

      studentArray[0].setStudentType(dataArray[0][3]);
      studentArray[1].setStudentType(dataArray[1][3]);
      studentArray[2].setStudentType(dataArray[2][3]);
      studentArray[3].setStudentType(dataArray[3][3]);
      studentArray[4].setStudentType(dataArray[4][3]);
 
      studentArray[0].calculateTuition(hourArray[0]);
      studentArray[1].calculateTuition(hourArray[1]);
      studentArray[2].calculateTuition(hourArray[2]);
      studentArray[3].calculateTuition(hourArray[3]);
      studentArray[4].calculateTuition(hourArray[4]);

      String message = "";
      message = String.format("%s   %s   $%,.2f\n", studentArray[0].getLastName(), studentArray[0].getStudentType(), studentArray[0].getTuition());
      message = message + String.format("%s   %s   $%,.2f\n", studentArray[1].getLastName(), studentArray[1].getStudentType(), studentArray[1].getTuition());
      message = message + String.format("%s   %s   $%,.2f\n", studentArray[2].getLastName(), studentArray[2].getStudentType(), studentArray[2].getTuition());
      message = message + String.format("%s   %s   $%,.2f\n", studentArray[3].getLastName(), studentArray[3].getStudentType(), studentArray[3].getTuition());
      message = message + String.format("%s   %s   $%,.2f\n", studentArray[4].getLastName(), studentArray[4].getStudentType(), studentArray[4].getTuition());

//when format the message, \t doesn't work in JOptionPane!!

      JOptionPane.showMessageDialog(null, message); 
   }
}