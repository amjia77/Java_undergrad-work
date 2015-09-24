//Lingjia Zhang
//INSY4305-001

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class NetworkMDI extends JFrame		
{
	private JDesktopPane theDesktop;

	static ArrayList<Network> networkList = new ArrayList<Network>();	

	public NetworkMDI()
	{
		super("Network System");

		theDesktop = new JDesktopPane();

		JMenuBar bar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);

		JMenu addMenu = new JMenu("Add");
		JMenuItem networkItem = new JMenuItem("Add Network");
		JMenuItem showItem = new JMenuItem("Add Show");
		JMenuItem actorItem = new JMenuItem("Add Actor");
		addMenu.add(networkItem);
		addMenu.add(showItem);
		addMenu.add(actorItem);

		JMenu commercialMenu = new JMenu("Commercial");
		JMenuItem commercialItem = new JMenuItem("Buy Commercial");
		commercialMenu.add(commercialItem);

		JMenu exitMenu = new JMenu("Exit");
		JMenuItem writeItem = new JMenuItem("Write Files");
		JMenuItem aboutItem = new JMenuItem("About");
		JMenuItem exitItem = new JMenuItem("Exit Program");
		exitMenu.add(writeItem);
		exitMenu.add(aboutItem);
		exitMenu.add(exitItem);

		bar.add(fileMenu);
		bar.add(addMenu);
		bar.add(commercialMenu);
		bar.add(exitMenu);

		setJMenuBar(bar);

		add(theDesktop);

		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{

				File file = getFile();	

				if(file.getName().equals("networks.txt"))	
					createNetworks(file);
				else if(file.getName().equals("shows.txt"))	
					createShows(file);
				else if(file.getName().equals("actors.txt"))	
					createActors(file);


			}
		});	


		networkItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JInternalFrame frame = new JInternalFrame("Add Network", true, true, true, true);

				NetworkPanel myPanel = new NetworkPanel();

				frame.add(myPanel);
				frame.pack();
				theDesktop.add(frame);
				frame.setVisible(true);					
					
			}
		});

		showItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JInternalFrame frame = new JInternalFrame("Add Show", true, true, true, true);

				ShowPanel myPanel = new ShowPanel();

				frame.add(myPanel);
				frame.pack();
				theDesktop.add(frame);
				frame.setVisible(true);
			}
		});

		actorItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JInternalFrame frame = new JInternalFrame("Add Actor", true, true, true, true);

				ActorPanel myPanel = new ActorPanel();

				frame.add(myPanel);
				frame.pack();
				theDesktop.add(frame);
				frame.setVisible(true);
			}
		});	

		commercialItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
      				Customer c1 = new Customer("Toyota", 0.0);
      				Customer c2 = new Customer("General Mills", 0.0);  
      				Customer c3 = new Customer("Apple", 0.0);
      				Customer c4 = new Customer("Microsoft", 0.0);
      				Customer c5 = new Customer("Greenpeace", 0.0);
      				Customer c6 = new Customer("Google", 0.0);
  
      				try
      				{
         				buyCommercialTime(15, "Big Bang Theory", c1);
         				buyCommercialTime(20, "Hawaii Five O", c2);
         				buyCommercialTime(30, "Big Bang Theory", c3);
         				buyCommercialTime(15, "ABC World News", c4);
         				buyCommercialTime(10, "CEO", c5);
         				buyCommercialTime(45, "Hawaii Five O", c2);
         				buyCommercialTime(20, "NBC", c6);
      				}
      				catch(ShowNotFoundException snfe)
      				{
         				JOptionPane.showMessageDialog(null, snfe.getMessage());     
      				}
      				catch(NoAvailableCommercialTimeException nacte)
      				{
         				JOptionPane.showMessageDialog(null, nacte);     
      				}  
			}
		});	

		writeItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				ObjectOutputStream output;

				try
				{
					output = new ObjectOutputStream(new FileOutputStream("networks.ser"));

					for(Network n: networkList)
						output.writeObject(n);

					output.close();					
				}
				catch(IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
		});	

		aboutItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null, "Version 7 Update 11  " + " Lingjia Zhang ");
			}
		});

		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				//for(Network n: networkList)
					//System.out.println(n.toString());

				System.exit(0);
			}
		});


	}   //end NetworkMDI constructer

	public static void main(String args[])
	{
		NetworkMDI n1 = new NetworkMDI();

		n1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		n1.setSize(700, 400);

		n1.setLocationRelativeTo(null);

		n1.setVisible(true);
	}

	public File getFile()
	{
		JFileChooser fileChooser = new JFileChooser();
	
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int result = fileChooser.showOpenDialog(this);

		if(result == JFileChooser.CANCEL_OPTION)
			System.exit(1);

		File f = fileChooser.getSelectedFile();
	
		return f;
	}

	public void createNetworks(File f)
	{
		Scanner input;
		String sentence;
		String[] tokenArray;

		try
		{
			input = new Scanner(f);

			while(input.hasNext())
			{
				sentence = input.nextLine();
				tokenArray = sentence.split(";");

				if(tokenArray[0].equals("Public"))  
					networkList.add(new PublicNetwork(tokenArray[1], tokenArray[2], tokenAddress(tokenArray[3]), tokenArray[4]));
				else if(tokenArray[0].equals("Commercial"))
					networkList.add(new CommercialNetwork(tokenArray[1], tokenArray[2], tokenAddress(tokenArray[3]), tokenArray[4], tokenArray[5]));	
				
				
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public static Address tokenAddress(String s)
	{
		String[] values;
		values = s.split(",");

		return new Address(values[0], values[1], values[2], Integer.parseInt(values[3]));

	}
		
	public void createShows(File f)
	{
		Scanner input;
		String sentence;
		String[] tokenArray;

		try
		{
			input = new Scanner(f);		

			while(input.hasNext())
			{
				sentence = input.nextLine();
				tokenArray = sentence.split(";");
	
				for(Network n: networkList)
				{
					if(n.getName().equals(tokenArray[0]))
						n.addShow(new Show(tokenArray[1], tokenArray[2], getShowType(tokenArray[3]), Integer.parseInt(tokenArray[4])));
					
				}

			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
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

	public void createActors(File f)
	{
		Scanner input;
		String sentence;
		String[] tokenArray;
	
		try
		{
			input = new Scanner(f);

			while(input.hasNext())
			{
				sentence = input.nextLine();
				tokenArray = sentence.split(";");

				for(Network n: networkList)
					for(Show s: n.getSchedule())	
						if(s.getTitle().equals(tokenArray[0]))
							s.addActor(new Actor(tokenArray[1], Integer.parseInt(tokenArray[2])));

			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	class NetworkPanel extends JPanel
	{	
		private JLabel networkLabel;
		private JLabel ppaLabel;
		private JLabel streetLabel;
		private JLabel cityLabel;
		private JLabel stateLabel;
		private JLabel zipLabel;
		private JLabel networkTypeLabel;
		private JLabel soLabel;
		private JLabel parentCompanyLabel;
		private JLabel submitLabel;

		private JTextField networkField;
		private JTextField ppaField;
		private JTextField streetField;
		private JTextField cityField;
		private JTextField stateField;
		private JTextField zipField;
		private JTextField soField;
		private JTextField parentCompanyField;

		private JComboBox<String> networkTypeBox; 
		private String[] networkType = {"SELECT ONE", "PUBLIC", "COMMERCIAL"};

		private JButton submitButton;
	
		public NetworkPanel()
		{
			setLayout(new GridLayout(10,2));

			networkLabel = new JLabel(" Network Name");
			ppaLabel = new JLabel(" President");
			streetLabel = new JLabel(" Street");
			cityLabel = new JLabel(" City");
			stateLabel = new JLabel(" State");
			zipLabel = new JLabel(" Zip");
			networkTypeLabel = new JLabel(" Network Type");
			soLabel = new JLabel(" Sponsor/Owner");
			parentCompanyLabel = new JLabel(" Parent Company");
			submitLabel = new JLabel(" Click Submit");

			networkField = new JTextField(15);
			ppaField = new JTextField(15);
			streetField = new JTextField(15);
			cityField = new JTextField(15);
			stateField = new JTextField(15);
			zipField = new JTextField(15);
			soField = new JTextField(15);
			parentCompanyField = new JTextField(15);

			networkTypeBox = new JComboBox<String> (networkType);   

			submitButton = new JButton("SUBMIT");

			add(networkLabel);
			add(networkField);
			add(ppaLabel);
			add(ppaField);
			add(streetLabel);
			add(streetField);
			add(cityLabel);
			add(cityField);
			add(stateLabel);
			add(stateField);
			add(zipLabel);
			add(zipField);
			add(networkTypeLabel);
			add(networkTypeBox);
			add(soLabel);
			add(soField);
			add(parentCompanyLabel);
			add(parentCompanyField);
			add(submitLabel);
			add(submitButton);

			networkTypeBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					if(networkTypeBox.getSelectedIndex() == 1)
					{
						parentCompanyLabel.setEnabled(false);
						parentCompanyField.setEnabled(false);
					}
					else if(networkTypeBox.getSelectedIndex() == 2)
					{
						parentCompanyLabel.setEnabled(true);
						parentCompanyField.setEnabled(true);
					}
				}
			});

			submitButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					if(checkNetworkInput())
					{
					if(networkTypeBox.getSelectedIndex() == 1)
						networkList.add(new PublicNetwork(networkField.getText(), ppaField.getText(), new Address(streetField.getText(), cityField.getText(), stateField.getText(), Integer.parseInt(zipField.getText())), soField.getText()));
					else
						networkList.add(new CommercialNetwork(networkField.getText(), ppaField.getText(), new Address(streetField.getText(), cityField.getText(), stateField.getText(), Integer.parseInt(zipField.getText())), soField.getText(), parentCompanyField.getText()));

					networkField.setText("");
					ppaField.setText("");
					streetField.setText("");
					cityField.setText("");
					stateField.setText("");
					zipField.setText("");
					soField.setText("");
					parentCompanyField.setText("");
					networkTypeBox.setSelectedIndex(0);
					networkField.requestFocus();
					}
				}
			});

		}   //end NetworkPanel constructor 

		public boolean checkNetworkInput()
		{
			if(networkField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter network name");
				networkField.requestFocus();
				return false;
			}
			else if(ppaField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter president name");
				ppaField.requestFocus();
				return false;
			}
			else if(streetField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter street");
				streetField.requestFocus();
				return false;
			}
			else if(cityField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter city");
				cityField.requestFocus();
				return false;
			}
			else if(stateField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter state");
				stateField.requestFocus();
				return false;
			}
			else if(zipField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter zip code");
				zipField.requestFocus();
				return false;
			}
			else if(networkTypeBox.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(null, "Choose network type");
				return false;
			}
			else if(soField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter sponsor or owner");
				soField.requestFocus();
				return false;
			}
			else if((networkTypeBox.getSelectedIndex() == 2) && parentCompanyField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter parent company");
				parentCompanyField.requestFocus();
				return false;
			}
			else if(!zipField.getText().isEmpty())
			{
				try
				{
					Integer.parseInt(zipField.getText());
					return true;
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null, "Zip code must be an integer");
					zipField.setText("");
					zipField.requestFocus();
					return false;
				}
			}

			return true;
		}

	}   //end class NetworkPanel

	class ShowPanel extends JPanel
	{
		private JLabel networkLabel;
		private JLabel ntsLabel;
		private JLabel ppaLabel;
		private JLabel showTypeLabel;
		private JLabel commercialTimeLabel;
		private JLabel submitLabel;

		private JTextField networkField;
		private JTextField ntsField;
		private JTextField ppaField;
		private JTextField commercialTimeField;

		private JRadioButton dramaButton;
		private JRadioButton comedyButton;
		private JRadioButton varietyButton;
		private JRadioButton newsButton;

		private ButtonGroup showTypeGroup;

		private JPanel showTypePanel;

		private JButton submitButton;
	
		public ShowPanel()
		{
			setLayout(new GridLayout(6,4));

			networkLabel = new JLabel(" Network Name");
			ntsLabel = new JLabel(" Title");
			ppaLabel = new JLabel(" Producer");
			showTypeLabel = new JLabel(" Type of Show");
			commercialTimeLabel = new JLabel(" Available Commercial Time");
			submitLabel = new JLabel(" Click Submit");

			networkField = new JTextField(15);
			ntsField = new JTextField(15);
			ppaField = new JTextField(15);
			commercialTimeField = new JTextField(15);

			dramaButton = new JRadioButton("Drama");
			comedyButton = new JRadioButton("Comedy");
			varietyButton = new JRadioButton("Variety");
			newsButton = new JRadioButton("News");

			showTypeGroup = new ButtonGroup();
			showTypeGroup.add(dramaButton);
			showTypeGroup.add(comedyButton);
			showTypeGroup.add(varietyButton);
			showTypeGroup.add(newsButton);
	
			showTypePanel = new JPanel(new GridLayout(1,4));
			showTypePanel.add(dramaButton);
			showTypePanel.add(comedyButton);
			showTypePanel.add(varietyButton);
			showTypePanel.add(newsButton);

			submitButton = new JButton("SUBMIT");

			add(networkLabel);
			add(networkField);
			add(ntsLabel);
			add(ntsField);
			add(ppaLabel);
			add(ppaField);
			add(showTypeLabel);
			add(showTypePanel);
			add(commercialTimeLabel);
			add(commercialTimeField);
			add(submitLabel);
			add(submitButton);

			submitButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					if(checkShowInput())
					{
					for(Network n: networkList)
						if(n.getName().equals(networkField.getText()))
							n.addShow(new Show(ntsField.getText(), ppaField.getText(), getShowType(convertShowType()), Integer.parseInt(commercialTimeField.getText())));

					networkField.setText("");
					ntsField.setText("");
					ppaField.setText("");
					commercialTimeField.setText("");
					showTypeGroup.clearSelection();
					networkField.requestFocus();
					}
				}
			});
		}   //end ShowPanel constructor

		public String convertShowType()
		{
			if(dramaButton.isSelected())
				return "Drama";
			else if(comedyButton.isSelected())
				return "Comedy";
			else if(newsButton.isSelected())
				return "News";
			else
				return "Variety";
		}

		public boolean checkShowInput()
		{
			if(networkField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter show's network name");
				networkField.requestFocus();
				return false;
			}
			else if(ntsField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter title");
				ntsField.requestFocus();
				return false;
			}
			else if(ppaField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter producer");
				ppaField.requestFocus();
				return false;
			}
			else if((!dramaButton.isSelected()) && (!comedyButton.isSelected()) && (!newsButton.isSelected()) && (!varietyButton.isSelected()))
			{
				JOptionPane.showMessageDialog(null, "Choose show type");
				dramaButton.requestFocus();
				return false;
			}
			else if(commercialTimeField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter available commercial time");
				commercialTimeField.requestFocus();
				return false;
			}
			else if(!commercialTimeField.getText().isEmpty())
			{
				try
				{
					Integer.parseInt(commercialTimeField.getText());
					return true;
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null, "Available time must be an integer");
					commercialTimeField.setText("");
					commercialTimeField.requestFocus();
					return false;
				}
			}

			return true;
		}
	}   //end class ShowPanel

	class ActorPanel extends JPanel
	{
		private JLabel ntsLabel;
		private JLabel ppaLabel;
		private JLabel ageLabel;
		private JLabel submitLabel;

		private JTextField ntsField;
		private JTextField ppaField;
		private JTextField ageField;

		private JButton submitButton;

		public ActorPanel()
		{
			setLayout(new GridLayout(4,2));

			ntsLabel = new JLabel(" Show");
			ppaLabel = new JLabel(" Actor");
			ageLabel = new JLabel(" Age");
			submitLabel = new JLabel(" Click Submit");

			ageField = new JTextField(15);
			ntsField = new JTextField(15);
			ppaField = new JTextField(15);

			submitButton = new JButton("SUBMIT");

			add(ntsLabel);
			add(ntsField);
			add(ppaLabel);
			add(ppaField);
			add(ageLabel);
			add(ageField);
			add(submitLabel);
			add(submitButton);

			submitButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					if(checkActorInput())
					{for(Network n: networkList)
						for(Show s: n.getSchedule())
							if(s.getTitle().equals(ntsField.getText()))
								s.addActor(new Actor(ppaField.getText(), Integer.parseInt(ageField.getText())));

					ntsField.setText("");
					ppaField.setText("");
					ageField.setText("");
					ntsField.requestFocus();
					}
				}
			});
		}   //end ActorPanel constructer

		public boolean checkActorInput()
		{
			if(ntsField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter Show Name");
				ntsField.requestFocus();
				return false;
			}
			else if(ppaField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter actor name");
				ppaField.requestFocus();
				return false;
			}
			else if(ageField.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Enter age");
				ageField.requestFocus();
				return false;
			}
			else if(!ageField.getText().isEmpty())
			{
				try
				{
					Integer.parseInt(ageField.getText());
					return true;
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(null, "Age must be an integer");
					ageField.setText("");
					ageField.requestFocus();
					return false;
				}
			}
	
			return true;
		}
	}   //end class ActorPanel 

	public static void buyCommercialTime(int sec, String t, Customer c) 
		throws ShowNotFoundException, NoAvailableCommercialTimeException   
	{
		for (Network n: networkList)
			for (Show s: n.getSchedule())
				if(t.equals(s.getTitle()))
				{
					if(s.getAvailableCommercialTime()-sec >= 0)
					{
						s.setAvailableCommercialTime(s.getAvailableCommercialTime()-sec);
						n.addCustomer(c);  
						c.setAmountOwed(c.getAmountOwed() + n.calculateCommercialCost(sec));
					}
					else 
						throw new NoAvailableCommercialTimeException();

					return;
				}

      		throw new ShowNotFoundException("Show does not exist" + "\n" + "Dateline");
	}	

}
