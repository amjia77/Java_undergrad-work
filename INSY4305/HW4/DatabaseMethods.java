//Lingjia Zhang
//INSY4305-001

import java.sql.*;
import java.util.ArrayList;

public class DatabaseMethods
{
	static final String DATABASE_URL = "jdbc:mysql://localhost/networks";
	static ArrayList<Network> results = new ArrayList<Network>();

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	ResultSetMetaData metaData = null;

	int numberOfColumns = 0;
	int res = 0;

	private	PreparedStatement selectPublicNetworks = null;
	private	PreparedStatement selectCommercialNetworks = null;
	private	PreparedStatement selectShows = null;
	private	PreparedStatement selectActors = null;

	private	PreparedStatement insertPublicNetworks = null;
	private	PreparedStatement insertCommercialNetworks = null;
	private	PreparedStatement insertShows = null;
	private PreparedStatement insertActors = null;

	public DatabaseMethods()
	{	
		try
		{
			connection = DriverManager.getConnection(DATABASE_URL, "cdavis", "fall2013");

			statement = connection.createStatement();

			selectPublicNetworks = connection.prepareStatement("SELECT * FROM PublicNetworks" );
			selectCommercialNetworks = connection.prepareStatement("SELECT * FROM CommercialNetworks" );
			selectShows = connection.prepareStatement("SELECT * FROM Shows" );
			selectActors = connection.prepareStatement("SELECT * FROM Actors" );


			insertPublicNetworks = connection.prepareStatement("INSERT INTO PublicNetworks (Name, President, Headquarters, Sponsor) VALUES(?, ?, ?, ?)");
			insertCommercialNetworks = connection.prepareStatement("INSERT INTO CommercialNetworks (Name, President, Headquarters, Owner, ParentCompany) VALUES (?, ?, ?, ?, ?)");
			insertShows = connection.prepareStatement("INSERT INTO Shows (Network, Title, Producer, Type, AvailableCommercialTime) VALUES(?, ?, ?, ?, ?)");
			insertActors = connection.prepareStatement("INSERT INTO Actors (Title, Name, Age) VALUES(?, ?, ?)");
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			System.exit(1);
		}
	}   //end DatabaseMethods constructor

	public ArrayList<Network> getNetworks()
	{
		getPublicNetworks();
		getCommercialNetworks();
		getShows();
		getActors();
		return results;
	}

	public void getPublicNetworks()
	{
		ResultSet resultSet = null;

		try
		{
			resultSet=selectPublicNetworks.executeQuery();
			
			while(resultSet.next())
			{
				results.add(new PublicNetwork(resultSet.getString("Name"), resultSet.getString("President"), convertAddress(resultSet.getString("Headquarters")), resultSet.getString("Sponsor")));
			}
		}
      		catch ( SQLException sqlException )
    		{
			sqlException.printStackTrace();         
		} 
   		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} 
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			close();
         		} 
      		} 
	} 

	public void getCommercialNetworks()
	{
		ResultSet resultSet = null;

		try
		{
			resultSet=selectCommercialNetworks.executeQuery();
			
			while(resultSet.next())
			{
				results.add(new CommercialNetwork(resultSet.getString("Name"), resultSet.getString("President"), convertAddress(resultSet.getString("Headquarters")), resultSet.getString("Owner"), resultSet.getString("ParentCompany")));
			}
		}
      		catch ( SQLException sqlException )
    		{
			sqlException.printStackTrace();         
		} 
   		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} 
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			close();
         		} 
      		} 
	}

	public static Address convertAddress(String s)
	{
		String[] values;
		values = s.split(",");

		return new Address(values[0], values[1], values[2], Integer.parseInt(values[3]));
	}

	public void getShows()
	{
		ResultSet resultSet = null;

		try
		{
			resultSet=selectShows.executeQuery();
			
			while(resultSet.next())
			{
				for(Network n: results)
					if(n.getName().equals(resultSet.getString("Network")))
						n.addShow(new Show(resultSet.getString("Title"), resultSet.getString("Producer"), getShowType(resultSet.getString("Type")), Integer.parseInt(resultSet.getString("AvailableCommercialTime"))));
			}
		}
      		catch ( SQLException sqlException )
    		{
			sqlException.printStackTrace();         
		} 
   		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} 
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			close();
         		} 
      		} 
	}

	public static Show.ShowType getShowType(String s)
	{
		if(s.equals("Comedy"))
			return Show.ShowType.COMEDY;
		if(s.equals("Drama"))
			return Show.ShowType.DRAMA;
		if(s.equals("News"))
			return Show.ShowType.NEWS;
		else
			return Show.ShowType.VARIETY;
	}

	public void getActors()
	{
		ResultSet resultSet = null;

		try
		{
			resultSet=selectActors.executeQuery();
			
			while(resultSet.next())
			{
				for(Network n: results)
					for(Show s: n.getSchedule())
						if(s.getTitle().equals(resultSet.getString("Title")))
							s.addActor(new Actor(resultSet.getString("Name"), Integer.parseInt(resultSet.getString("Age"))));
			}
		}
      		catch ( SQLException sqlException )
    		{
			sqlException.printStackTrace();         
		} 
   		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} 
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			close();
         		} 
      		} 
	}

	public int addPublicNetworks(String name, String president, String headquarters, String sponsor)
	{
		try
		{
			insertPublicNetworks.setString(1, name);
			insertPublicNetworks.setString(2, president);
			insertPublicNetworks.setString(3, headquarters);
			insertPublicNetworks.setString(4, sponsor);

			res = insertPublicNetworks.executeUpdate();
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			close();
		}

		return res;
	}

	public int addCommercialNetworks(String name, String president, String headquarters, String owner, String parentCompany)
	{
		try
		{
			insertCommercialNetworks.setString(1, name);
			insertCommercialNetworks.setString(2, president);
			insertCommercialNetworks.setString(3, headquarters);
			insertCommercialNetworks.setString(4, owner);
			insertCommercialNetworks.setString(5, parentCompany);

			res = insertCommercialNetworks.executeUpdate();
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			close();
		}

		return res;
	}

	public int addShows(String network, String title, String producer, String type, int availableCommercialTime)
	{
		try
		{
			insertShows.setString(1, network);
			insertShows.setString(2, title);
			insertShows.setString(3, producer);
			insertShows.setString(4, type);
			insertShows.setInt(5, availableCommercialTime);

			res = insertShows.executeUpdate();
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			close();
		}

		return res;
	}

	public int addActors(String title, String name, int age)
	{
		try
		{
			insertActors.setString(1, title);
			insertActors.setString(2, name);
			insertActors.setInt(3, age);

			res = insertActors.executeUpdate();
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			close();
		}

		return res;
	}

	public void close()
	{
		try
		{
			connection.close();
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
	}

	public void writePublicTable()
	{
		try
		{
			resultSet = statement.executeQuery("Select * from PublicNetworks");
			metaData = resultSet.getMetaData();
			numberOfColumns = metaData.getColumnCount();

			System.out.println("Public Networks Table\n");

			for(int i=1; i <= numberOfColumns; i++)
				System.out.printf("%-8s\t", metaData.getColumnName(i));
			System.out.println();
			

			while(resultSet.next())
			{
				for(int i=1; i <= numberOfColumns; i++)
					System.out.printf("%-8s\t", resultSet.getObject(i));
				System.out.println();	
				System.out.println();		
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
   		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} 
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			close();
         		} 
      		}

	}

	public void writeCommercialTable()
	{
		try
		{
			resultSet = statement.executeQuery("Select * from CommercialNetworks");
			metaData = resultSet.getMetaData();
			numberOfColumns = metaData.getColumnCount();

			System.out.println("Commercial Networks Table\n");

			for(int i=1; i <= numberOfColumns; i++)
				System.out.printf("%-8s\t", metaData.getColumnName(i));
			System.out.println();
			

			while(resultSet.next())
			{
				for(int i=1; i <= numberOfColumns; i++)
					System.out.printf("%-8s\t", resultSet.getObject(i));
				System.out.println();
				System.out.println();			
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
   		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} 
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			close();
         		} 
      		}

	}

	public void writeShowsTable()
	{

		try
		{
			resultSet = statement.executeQuery("Select * from Shows");
			metaData = resultSet.getMetaData();
			numberOfColumns = metaData.getColumnCount();

			System.out.println("Shows Table\n");

			for(int i=1; i <= numberOfColumns; i++)
				System.out.printf("%-8s\t", metaData.getColumnName(i));
			System.out.println();
			

			while(resultSet.next())
			{
				for(int i=1; i <= numberOfColumns; i++)
					System.out.printf("%-8s\t", resultSet.getObject(i));
				System.out.println();
				System.out.println();			
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
   		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} 
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			close();
         		} 
      		}

	}

	public void writeActorsTable()
	{
		try
		{
			resultSet = statement.executeQuery("Select * from Actors");
			metaData = resultSet.getMetaData();
			numberOfColumns = metaData.getColumnCount();

			System.out.println("Actors Table\n");

			for(int i=1; i <= numberOfColumns; i++)
				System.out.printf("%-8s\t", metaData.getColumnName(i));
			System.out.println();
			

			while(resultSet.next())
			{
				for(int i=1; i <= numberOfColumns; i++)
					System.out.printf("%-8s\t", resultSet.getObject(i));
				System.out.println();	
				System.out.println();		
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
   		finally
      		{
         		try 
         		{
            			resultSet.close();
         		} 
         		catch ( SQLException sqlException )
         		{
            			sqlException.printStackTrace();         
            			close();
         		} 
      		}

	}

}   //end class DatabaseMethods


	