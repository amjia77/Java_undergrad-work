//Lingjia Zhang
//INSY4305-001

public class NoAvailableCommercialTimeException extends RuntimeException
{
   public NoAvailableCommercialTimeException()
   {
      super("There is no available commercial time");
   }
}