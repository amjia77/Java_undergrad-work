//Lingjia Zhang
//INSY4305-001

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class StringServer
{
	public static void main(String args[])
	{
		ServerSocket serverSocket;
		Socket connection;

		try
		{
			serverSocket = new ServerSocket(8000);
			System.out.println("Waiting for a connection...\n");

			int clientNo = 1;

			ExecutorService threadExecutor = Executors.newCachedThreadPool();

			while(true)
			{
				connection = serverSocket.accept();

				System.out.println("Start thread for client " + clientNo);

				HandleAClient client = new HandleAClient(connection, clientNo);

				threadExecutor.execute(client);

				clientNo++;
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}

	}
}

class HandleAClient implements Runnable
{
	Scanner input;
	Formatter output;
	Socket connection;
	int clientNo;
	StringBuilder buffer;
	int length;

	public HandleAClient(Socket connection, int clientNo)
	{
		this.connection = connection;
		this.clientNo = clientNo;
	}

	public void run()
	{
		try
		{
			System.out.println("Waiting to input");

			input = new Scanner(connection.getInputStream());
			output = new Formatter(connection.getOutputStream());

			while(input.hasNext())
			{
				buffer =  new StringBuilder(input.nextLine());
				System.out.println("String received from client " + clientNo + ": " + buffer.toString());

				length = buffer.length();

				buffer.reverse();

				output.format("%s %d\n", buffer, length);

				output.flush();
			}	

			System.out.println("Thread " + clientNo + " ended!");

		}
		catch(IOException ex)
		{
			System.err.println(ex);
		}
	}

}