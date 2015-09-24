// Lingjia Zhang
// INSY3300-001

public abstract class Student implements Fees
{
   private String firstName;
   private String lastName;
   private int studentID;
   private Address address;
   private double tuition;

   public Student()
   {
      setFirstName("");
      setLastName("");
      setStudentID(0);
      setAddress(new Address());
      setTuition(0.0);
   }

   public Student(String fn, String ln, int id, Address address, double tuition)     
   {
      setFirstName(fn);
      setLastName(ln);
      setStudentID(id);
      setAddress(address);
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
 
   public void setAddress(Address address)
   {
      this.address = address;
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

   public double getTuition()
   {
      return tuition;
   }

   public Address getAddress()
   {
      return address;
   }

   public String toString()
   {
      return("First Name "+ firstName + " Last Name " + lastName + " Student ID " + studentID + " Address " + address.toString() + " Tuition " + tuition);
   }

   public abstract void calculateTuition(int hours);

   public void calculateFees(double tuition)
   {
      setTuition (tuition+100);
   }
                                               
/*若写成tuition+=100;却不能执行+100的行为，因为if a method contains a local variable with the same name as one of its class's fields, the local variable shadows the field in that methold's scope.若改写parameter就可行，见下面：

   public void calculateFees(double t)
   {
      tuition = t + 100;
   }
*/

}