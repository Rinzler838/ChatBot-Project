package chat.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import chat.controller.ChatController;
import chat.controller.IOController;
import chat.model.*;

/**
 * Panel class for GUI interaction in the Chatbot Project
 * @author dvil4688
 * @version 1.5 3/7/16 Added actionListener for tweetButton.
 */

public class ChatPanel extends JPanel
{
	private ChatController botController;
	private SpringLayout botLayout;
	private JButton sayButton;
	private JButton quitButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton tweetButton;
	private JButton analyzeTweetButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	private JScrollPane textPane;

	
	public ChatPanel (ChatController botController)
	{
		this.botController = botController;
		botLayout = new SpringLayout();
		chatArea = new JTextArea(25,30);
		typingField = new JTextField(25);
		promptLabel = new JLabel("||| ChatBot |||");
		sayButton = new JButton("Say");
		quitButton = new JButton("Quit");
		tweetButton = new JButton("Tweet!");
		analyzeTweetButton = new JButton("Analyze Tweets");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		
		setupChatPanel();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatPanel()
	{
		textPane = new JScrollPane(chatArea);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	/**
	 * Helper method used to load all GUI components into the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(botLayout);
		this.setBackground(Color.RED);
		this.add(typingField);
		this.add(sayButton);
		this.add(quitButton); 
		this.add(tweetButton);
		this.add(analyzeTweetButton);
		this.add(textPane);
		this.add(promptLabel);
		this.add(saveButton);
		this.add(loadButton);
		typingField.setToolTipText("Type here");
		chatArea.setEnabled(false);
	}
	
	/**
	 * Helper method for arranging panel.
	 * Dumping ground for generated code/garbage panel code.
	 */
	private void setupLayout()
	{
		botLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		botLayout.putConstraint(SpringLayout.EAST, chatArea, -10, SpringLayout.EAST, this);
		botLayout.putConstraint(SpringLayout.WEST, promptLabel, 0, SpringLayout.WEST, chatArea);
		botLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -6, SpringLayout.NORTH, chatArea);
		botLayout.putConstraint(SpringLayout.NORTH, chatArea, 37, SpringLayout.NORTH, this);
		botLayout.putConstraint(SpringLayout.SOUTH, chatArea, -8, SpringLayout.NORTH, typingField);
		botLayout.putConstraint(SpringLayout.WEST, typingField, 100, SpringLayout.WEST, this);
		botLayout.putConstraint(SpringLayout.SOUTH, typingField, -10, SpringLayout.SOUTH, this);
		botLayout.putConstraint(SpringLayout.EAST, typingField, -100, SpringLayout.EAST, this);
		promptLabel.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 17));
		botLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -6, SpringLayout.NORTH, sayButton);
		botLayout.putConstraint(SpringLayout.EAST, tweetButton, 0, SpringLayout.EAST, sayButton);
		botLayout.putConstraint(SpringLayout.WEST, textPane, 20, SpringLayout.WEST, this);
		botLayout.putConstraint(SpringLayout.EAST, textPane, -21, SpringLayout.EAST, this);
		botLayout.putConstraint(SpringLayout.SOUTH, sayButton, -10, SpringLayout.SOUTH, this);
		botLayout.putConstraint(SpringLayout.EAST, sayButton, -10, SpringLayout.EAST, this);
		botLayout.putConstraint(SpringLayout.WEST, quitButton, 10, SpringLayout.WEST, this);
		botLayout.putConstraint(SpringLayout.SOUTH, quitButton, -10, SpringLayout.SOUTH, this);
		botLayout.putConstraint(SpringLayout.NORTH, analyzeTweetButton, 0, SpringLayout.NORTH, tweetButton);
		botLayout.putConstraint(SpringLayout.WEST, analyzeTweetButton, 0, SpringLayout.WEST, quitButton);
		botLayout.putConstraint(SpringLayout.EAST, analyzeTweetButton, 123, SpringLayout.WEST, quitButton);
		botLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, sayButton);
		botLayout.putConstraint(SpringLayout.EAST, loadButton, -6, SpringLayout.WEST, saveButton);
		botLayout.putConstraint(SpringLayout.SOUTH, saveButton, -665, SpringLayout.SOUTH, this);
		botLayout.putConstraint(SpringLayout.EAST, promptLabel, -6, SpringLayout.WEST, loadButton);
		botLayout.putConstraint(SpringLayout.SOUTH, loadButton, -2, SpringLayout.NORTH, textPane);
		botLayout.putConstraint(SpringLayout.NORTH, textPane, 2, SpringLayout.SOUTH, saveButton);
		botLayout.putConstraint(SpringLayout.SOUTH, textPane, -6, SpringLayout.NORTH, tweetButton);
		
	}
	
	/**
	 * Method creates random color when called.
	 */
	private void changeColor()
	{
		int red, green, blue;
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}
	
	/**
	 * Tells program procedure to follow when mouse or button is clicked.
	 */
	private void setupListeners()
	{
		sayButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = typingField.getText();	//Grab user text
				chatArea.append("\nYou: " + userText);		//Display text
				typingField.setText("");
				String response = botController.userToChatBot(userText);	//Send text to Chatbot, Process text
				chatArea.append("\nChatbot: " + response);					//Display response
			}
		});
		
		quitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shutDown();
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				botController.sendTweet("No txt to send");
			}
			
		});
		
		analyzeTweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = typingField.getText();
				String results = botController.analyze(user);
				chatArea.setText(results);
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String file = IOController.saveFile(chatArea.getText());
				promptLabel.setText(file);
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String loadedText = IOController.readTextFromFile(promptLabel.getText());
				chatArea.setText(loadedText);
			}
		});
		
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent click)
			{
				changeColor();
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				// Empty Placeholder
				
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				// Empty Placeholder
				
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// Empty Placeholder
				
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				// Empty Placeholder
				
			}
		});
	}
	
	/**
	 * Kills program after bidding a fond farewell.
	 */
	protected void shutDown()
	{
		JOptionPane.showMessageDialog(null, "bzzzt...Farewell friend, I'll be going now...bzzzt");
		System.exit(0);
		
	}

	/**
	 * Returns instance of JTextField when called.
	 * @return typingField
	 */
	public JTextField getTextField()
	{
		return typingField;
	}
}
