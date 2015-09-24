//Lingjia Zhang
//INSY4305-001

import java.io.*;
import java.net.*;
import java.util.*;


public class StringClient
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		Socket connection;
		Scanner sInput;
		Formatter output;
		StringBuilder buffer;
		int length;

		try
		{
			connection = new Socket("localhost", 8000);
			sInput = new Scanner(connection.getInputStream());
			output = new Formatter(connection.getOutputStream());

			while(true)
			{
				System.out.println("Please enter a string");

				buffer = new StringBuilder(input.nextLine());
	
				output.format("%s\n", buffer.toString());
				output.flush();

				buffer = new StringBuilder(sInput.next());
				length = sInput.nextInt();

				System.out.println(" Reversed string is " + buffer.toString() + ", " + "string length is " + length);
				
			}	
			
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}