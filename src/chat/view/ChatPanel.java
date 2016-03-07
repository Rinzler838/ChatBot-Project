package chat.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import chat.controller.ChatController;
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
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	private JScrollPane textPane;

	
	public ChatPanel (ChatController botController)
	{
		this.botController = botController;
		botLayout = new SpringLayout();
		chatArea = new JTextArea(10,25);
		typingField = new JTextField(25);
		promptLabel = new JLabel("||| ChatBot |||");
		sayButton = new JButton("Say");
		quitButton = new JButton("Quit");
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatPane()
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
		this.add(textPane);
		this.add(promptLabel);
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
		botLayout.putConstraint(SpringLayout.EAST, promptLabel, 780, SpringLayout.WEST, chatArea);
		botLayout.putConstraint(SpringLayout.NORTH, chatArea, 37, SpringLayout.NORTH, this);
		botLayout.putConstraint(SpringLayout.SOUTH, chatArea, -8, SpringLayout.NORTH, typingField);
		botLayout.putConstraint(SpringLayout.WEST, textPane, 110, SpringLayout.WEST, this);
		botLayout.putConstraint(SpringLayout.EAST, textPane, -20, SpringLayout.EAST, this);
		botLayout.putConstraint(SpringLayout.NORTH, textPane, 35, SpringLayout.NORTH, this);
		botLayout.putConstraint(SpringLayout.WEST, quitButton, 0, SpringLayout.WEST, promptLabel);
		botLayout.putConstraint(SpringLayout.SOUTH, quitButton, 0, SpringLayout.SOUTH, typingField);
		botLayout.putConstraint(SpringLayout.SOUTH, textPane, 600, SpringLayout.NORTH, this);
		botLayout.putConstraint(SpringLayout.SOUTH, sayButton, 0, SpringLayout.SOUTH, typingField);
		botLayout.putConstraint(SpringLayout.EAST, sayButton, 0, SpringLayout.EAST, promptLabel);
		botLayout.putConstraint(SpringLayout.WEST, typingField, 100, SpringLayout.WEST, this);
		botLayout.putConstraint(SpringLayout.SOUTH, typingField, -10, SpringLayout.SOUTH, this);
		botLayout.putConstraint(SpringLayout.EAST, typingField, -100, SpringLayout.EAST, this);
		promptLabel.setFont(new Font("Avenir", Font.BOLD | Font.ITALIC, 17));
		
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
		
//		this.addMouseListener(new MouseListener()
//		{
//			public void mouseClicked(MouseEvent click)
//			{
//				changeColor();
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e)
//			{
//				// Empty Placeholder
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e)
//			{
//				// Empty Placeholder
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e)
//			{
//				// Empty Placeholder
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e)
//			{
//				// Empty Placeholder
//				
//			}
//		});
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
