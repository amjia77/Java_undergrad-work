// Lingjia Zhang
// INSY3300-001

public class Student
{
   private String firstName;
   private String lastName;
   private int studentID;
   private String studentType;
   private double tuition;
  
   public Student()
   {
      setFirstName("");
      setLastName("");
      setStudentID(0);
      setStudentType("");
      setTuition(0.0);
   }

   public Student(String fn, String ln, int id, double tuition)
   {
      setFirstName(fn);
      setLastName(ln);
      setStudentID(id);
      setTuition(tuition);
   }

   public void setFirstName(String fn)
   {
      firstName = fn;
   }

   public void setLastName(String ln)
   {
      lastName = ln;
   }

   public void setStudentID(int id)
   {
      studentID = id;
   }

   public void setStudentType(String studentType)
   {
      this.studentType = studentType;
   }
 
   public void setTuition(double tuition)
   {
      this.tuition = tuition;    
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public int getStudentID()
   {
      return studentID;
   }

   public String getStudentType()
   {
      return studentType;
   }

   public double getTuition()
   {
      return tuition;
   }

   public String toString()
   {
      return("First Name "+ firstName + "Last Name " + lastName + "student ID " + studentID + "Student Type " + studentType + "Tuition " + tuition);
   }

   public void calculateTuition(int hours)
   {
      if(studentType.equals("Undergraduate"))
         setTuition(125 * hours);
      else if(studentType.equals("Graduate"))
         setTuition(295 * hours);                   //setTuition method is public, so is not hidden from method calculateTuition.
   }

/*写成这样也可：
   public void calculateTuition(int hours)
   {
      if(studentType.equals("Undergraduate"))
         tuition = 125 * hours;
      else if(studentType.equals("Graduate"))
         tuition = 295 * hours;                   
   }
*/

}