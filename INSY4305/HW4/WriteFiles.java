//Lingjia Zhang
//INSY4305-001

import java.util.*;
import java.io.*;

public class WriteFiles
{
	public static void main(String args[])
	{
		writeActors();
		writeShows();
		writeNetworks();
	}

	public static void writeActors()
	{
		Formatter output;
		
		try
		{
			output = new Formatter("actors.txt");

			output.format("%s;%s;%d%n", "Big Bang Theory", "Johnny Galecki", 28);
			output.format("%s;%s;%d%n", "Big Bang Theory", "Jim Parsons", 30);
			output.format("%s;%s;%d%n", "Big Bang Theory", "Kaley Cuoco", 26);
			output.format("%s;%s;%d%n", "Hawaii Five O", "Alex O'Loughlin", 35);
			output.format("%s;%s;%d%n", "Hawaii Five O", "Scott Caan", 33);
			output.format("%s;%s;%d%n", "Hawaii Five O", "Daniel Kim", 36);
			output.format("%s;%s;%d%n", "Hawaii Five O", "Grace Park", 32);
			output.format("%s;%s;%d%n", "ABC World News", "Diane Sawyer", 60);
			output.format("%s;%s;%d%n", "ABC World News", "David Muir", 45);
			output.format("%s;%s;%d%n", "CEO", "Cullum", 58);

			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public static void writeShows()
	{
		Formatter output;

		try
		{
			output = new Formatter("shows.txt");

			output.format("%s;%s;%s;%s;%d%n", "CBS", "Big Bang Theory", "Lorre", "Comedy", 300);
			output.format("%s;%s;%s;%s;%d%n", "CBS", "Hawaii Five O", "Kurtzman", "Drama", 600);
			output.format("%s;%s;%s;%s;%d%n", "ABC", "ABC World News", "Arlidge", "News", 250);
			output.format("%s;%s;%s;%s;%d%n", "PBS", "CEO", "Cullum", "News", 150);

			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public static void writeNetworks()
	{
		Formatter output;

		try
		{
			output = new Formatter("networks.txt");

			output.format("%s;%s;%s;%s;%s%n", "Public", "PBS", "Paula Kerger", "2100 Chrystal Drive,Arlington,Virginia,22202", "Public Radio");
			output.format("%s;%s;%s;%s;%s;%s%n", "Commercial", "CBS", "Leslie Moonves", "51 West 52nd Street,New York,New York,10019", "Philippe Dauman", "Viacom");
			output.format("%s;%s;%s;%s;%s;%s%n", "Commercial", "ABC", "Ben Sherwood", "54 West 67th Street,New York,New York,10017", "Ed Noble", "Disney");
			output.format("%s;%s;%s;%s;%s;%s%n", "Commercial", "NBC", "Jeff Zucker", "30 Rockefeller Center,New York,New York,10112", "Burke Cox", "General Electric");


			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}