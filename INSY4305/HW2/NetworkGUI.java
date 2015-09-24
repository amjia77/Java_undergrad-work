//Lingjia Zhang
//INSY4305-001

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class NetworkGUI extends JFrame		
{
	private JLabel chooseLabel;
	private JLabel networkLabel;
	private JLabel ntsLabel;
	private JLabel ppaLabel;
	private JLabel ageLabel;
	private JLabel streetLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel networkTypeLabel;
	private JLabel soLabel;
	private JLabel parentCompanyLabel;
	private JLabel showTypeLabel;
	private JLabel commercialTimeLabel;

	private JCheckBox networkBox;
	private JCheckBox showBox;
	private JCheckBox actorBox;

	private JTextField networkField;
	private JTextField ntsField;
	private JTextField ppaField;
	private JTextField ageField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	private JTextField soField;
	private JTextField parentCompanyField;
	private JTextField commercialTimeField;

	private JComboBox<String> networkTypeBox; 
	private String[] networkType = {"SELECT ONE", "PUBLIC", "COMMERCIAL"};

	private JRadioButton dramaButton;
	private JRadioButton comedyButton;
	private JRadioButton varietyButton;
	private JRadioButton newsButton;

	private JButton submitButton;
	private JButton finishButton;

	private ButtonGroup chooseGroup;
	private ButtonGroup showTypeGroup;

	private JPanel choosePanel;
	private JPanel showTypePanel;

	static ArrayList<Network> networkList = new ArrayList<Network>();	


	public NetworkGUI()
	{
		super("Network Schedules");
		setLayout(new GridLayout(15,4));

		createNetworks();
		createShows();
		createActors();

		//for(Network n: networkList)
			//System.out.println(n.toString());   //****check read in original files***


		chooseLabel = new JLabel(" Choose one");
		networkLabel = new JLabel(" Network Name");
		ntsLabel = new JLabel(" Name/Title/Show");
		ppaLabel = new JLabel(" President/Producer/Actor");
		ageLabel = new JLabel(" Age");
		streetLabel = new JLabel(" Street");
		cityLabel = new JLabel(" City");
		stateLabel = new JLabel(" State");
		zipLabel = new JLabel(" Zip");
		networkTypeLabel = new JLabel(" Network Type");
		soLabel = new JLabel(" Sponsor/Owner");
		parentCompanyLabel = new JLabel(" Parent Company");
		showTypeLabel = new JLabel(" Type of Show");
		commercialTimeLabel = new JLabel(" Available Commercial Time");

		networkField = new JTextField(15);
		ntsField = new JTextField(15);
		ppaField = new JTextField(15);
		ageField = new JTextField(15);
		streetField = new JTextField(15);
		cityField = new JTextField(15);
		stateField = new JTextField(15);
		zipField = new JTextField(15);
		soField = new JTextField(15);
		parentCompanyField = new JTextField(15);
		commercialTimeField = new JTextField(15);

		networkBox = new JCheckBox("Add Network");
		showBox = new JCheckBox("Add Show");
		actorBox = new JCheckBox("Add Actor");

		chooseGroup = new ButtonGroup();
		chooseGroup.add(networkBox);
		chooseGroup.add(showBox);
		chooseGroup.add(actorBox);
		
		choosePanel = new JPanel(new GridLayout(1,3));
		choosePanel.add(networkBox);
		choosePanel.add(showBox);
		choosePanel.add(actorBox);

		networkTypeBox = new JComboBox<String> (networkType);   

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

		submitButton = new JButton(" SUBMIT");
		finishButton = new JButton(" FINISH");

		//*********add********
		add(chooseLabel);
		add(choosePanel);
		add(networkLabel);
		add(networkField);
		add(ntsLabel);
		add(ntsField);
		add(ppaLabel);
		add(ppaField);
		add(ageLabel);
		add(ageField);
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
		add(showTypeLabel);
		add(showTypePanel);
		add(commercialTimeLabel);
		add(commercialTimeField);
		add(submitButton);
		add(finishButton);

		networkBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				networkLabel.setEnabled(true);
				networkField.setEnabled(true);
				ntsLabel.setEnabled(false);
				ntsField.setEnabled(false);
				ageLabel.setEnabled(false);
				ageField.setEnabled(false);
				streetLabel.setEnabled(true);
				streetField.setEnabled(true);
				cityLabel.setEnabled(true);
				cityField.setEnabled(true);
				stateLabel.setEnabled(true);
				stateField.setEnabled(true);
				zipLabel.setEnabled(true);
				zipField.setEnabled(true);
				networkTypeLabel.setEnabled(true);
				networkTypeBox.setEnabled(true);
				soLabel.setEnabled(true);
				soField.setEnabled(true);
				parentCompanyLabel.setEnabled(true);
				parentCompanyField.setEnabled(true);
				showTypeLabel.setEnabled(false);
				dramaButton.setEnabled(false);
				comedyButton.setEnabled(false);
				varietyButton.setEnabled(false);
				newsButton.setEnabled(false);
				commercialTimeLabel.setEnabled(false);
				commercialTimeField.setEnabled(false);

			}
		});

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

		showBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				networkLabel.setEnabled(true);
				networkField.setEnabled(true);
				ntsLabel.setEnabled(true);
				ntsField.setEnabled(true);
				ageLabel.setEnabled(false);
				ageField.setEnabled(false);
				streetLabel.setEnabled(false);
				streetField.setEnabled(false);
				cityLabel.setEnabled(false);
				cityField.setEnabled(false);
				stateLabel.setEnabled(false);
				stateField.setEnabled(false);
				zipLabel.setEnabled(false);
				zipField.setEnabled(false);
				networkTypeLabel.setEnabled(false);
				networkTypeBox.setEnabled(false);
				soLabel.setEnabled(false);
				soField.setEnabled(false);
				parentCompanyLabel.setEnabled(false);
				parentCompanyField.setEnabled(false);
				showTypeLabel.setEnabled(true);
				dramaButton.setEnabled(true);
				comedyButton.setEnabled(true);
				varietyButton.setEnabled(true);
				newsButton.setEnabled(true);
				commercialTimeLabel.setEnabled(true);
				commercialTimeField.setEnabled(true);
			}
		});

		actorBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				networkLabel.setEnabled(false);
				networkField.setEnabled(false);
				ntsLabel.setEnabled(true);
				ntsField.setEnabled(true);
				ageLabel.setEnabled(true);
				ageField.setEnabled(true);
				streetLabel.setEnabled(false);
				streetField.setEnabled(false);
				cityLabel.setEnabled(false);
				cityField.setEnabled(false);
				stateLabel.setEnabled(false);
				stateField.setEnabled(false);
				zipLabel.setEnabled(false);
				zipField.setEnabled(false);
				networkTypeLabel.setEnabled(false);
				networkTypeBox.setEnabled(false);
				soLabel.setEnabled(false);
				soField.setEnabled(false);
				parentCompanyLabel.setEnabled(false);
				parentCompanyField.setEnabled(false);
				showTypeLabel.setEnabled(false);
				dramaButton.setEnabled(false);
				comedyButton.setEnabled(false);
				varietyButton.setEnabled(false);
				newsButton.setEnabled(false);
				commercialTimeLabel.setEnabled(false);
				commercialTimeField.setEnabled(false);
			}
		});

		ButtonHandler handler = new ButtonHandler();
		submitButton.addActionListener(handler);
		finishButton.addActionListener(handler);

	}   //end NetworkGUI constructer

	public void createNetworks()
	{
		Scanner input;
		String sentence;
		String[] tokenArray;

		try
		{
			input = new Scanner(new File("networks.txt"));

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
		
	public void createShows()
	{
		Scanner input;
		String sentence;
		String[] tokenArray;

		try
		{
			input = new Scanner(new File("shows.txt"));		

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

	public void createActors()
	{
		Scanner input;
		String sentence;
		String[] tokenArray;
	
		try
		{
			input = new Scanner(new File("actors.txt"));

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

	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == submitButton)
			{
				if(networkBox.isSelected())
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
					chooseGroup.clearSelection();
					networkField.requestFocus();
					}
				}

				if(showBox.isSelected())
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
					chooseGroup.clearSelection();
					showTypeGroup.clearSelection();
					networkField.requestFocus();
					}
				}

				if(actorBox.isSelected())
				{
					if(checkActorInput())
					{for(Network n: networkList)
						for(Show s: n.getSchedule())
							if(s.getTitle().equals(ntsField.getText()))
								s.addActor(new Actor(ppaField.getText(), Integer.parseInt(ageField.getText())));

					ntsField.setText("");
					ppaField.setText("");
					ageField.setText("");
					chooseGroup.clearSelection();
					networkField.requestFocus();
					}
				}	
			}

			if(ae.getSource() == finishButton)
			{
			/****	for(Network n: networkList)
					System.out.println(n.toString());  *****/ //***print out old and new added networks***
				writeNewNetworks();
				writeNewShows();
				writeNewActors();
				System.exit(0);
			}	
		}
	}  //end class ButtonHandler

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
			JOptionPane.showMessageDialog(null, "Enter sponsor / owner");
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

	public static void writeNewNetworks()
	{
		Formatter output;

		try
		{
			output = new Formatter("networks.txt");
	
			for(int i = 0; i < networkList.size(); i++)
			{
				if(networkList.get(i) instanceof PublicNetwork)
					output.format("%s;%s;%s;%s;%s%n", "Public", networkList.get(i).getName(), networkList.get(i).getPresident(), networkList.get(i).getHeadquarters().toString(), ((PublicNetwork)networkList.get(i)).getSponsor());
				else 
					output.format("%s;%s;%s;%s;%s;%s%n", "Commercial", networkList.get(i).getName(), networkList.get(i).getPresident(), networkList.get(i).getHeadquarters().toString(), ((CommercialNetwork)networkList.get(i)).getOwner(), ((CommercialNetwork)networkList.get(i)).getParentCompany());
			}

			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public static void writeNewShows()
	{
		Formatter output;

		try
		{
			output = new Formatter("shows.txt");

			for(Network n: networkList)
				for(Show s: n.getSchedule())
					output.format("%s;%s;%s;%s;%d%n", n.getName(), s.getTitle(), s.getProducer(), s.getType(), s.getAvailableCommercialTime());

			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public static void writeNewActors()
	{
		Formatter output;

		try
		{
			output = new Formatter("actors.txt");

			for(Network n: networkList)
				for(Show s: n.getSchedule())
					for(Actor a: s.getActorList())
						output.format("%s;%s;%d%n", s.getTitle(), a.getName(), a.getAge());

			output.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}