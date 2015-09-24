//Lingjia Zhang
//INSY4305-001

import java.io.*;
import java.util.*;

public class ReadFile
{
	public static void main(String args[])
	{
		ObjectInputStream input;
		Network n;

		try
		{
			input = new ObjectInputStream(new FileInputStream("networks.ser"));

			while(true)
			{
				n = (Network)input.readObject();
				System.out.println(n.toString());
			} 
		}
		catch(EOFException eof)
		{
			return;
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}