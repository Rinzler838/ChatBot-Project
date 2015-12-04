package chat.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import chat.controller.ChatController;
import chat.model.*;

/**
 * Panel class for GUI interaction in the Chatbot Project
 * @author dvil4688
 * @version 1.3 12/4/15 Added panel layout in Design tab, added new quitButton, and changed some Strings.
 */

public class ChatPanel extends JPanel
{
	private ChatController botController;
	private SpringLayout botLayout;
	private JButton sayButton;
	private JButton quitButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	
	public ChatPanel (ChatController botController)
	{
		this.botController = botController;
		botLayout = new SpringLayout();
		chatArea = new JTextArea(10,30);
		typingField = new JTextField(30);
		promptLabel = new JLabel("| ChatBot |");
		sayButton = new JButton("Say");
		quitButton = new JButton("Quit");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Helper method used to load all GUI components into the panel.
	 */
	private void setupPanel()
	{
		this.setLayout(botLayout);
		this.setBackground(Color.RED);
		this.add(chatArea);
		this.add(typingField);
		this.add(sayButton);
		this.add(quitButton); 
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
		botLayout.putConstraint(SpringLayout.SOUTH, typingField, -8, SpringLayout.SOUTH, this);
		botLayout.putConstraint(SpringLayout.EAST, typingField, -91, SpringLayout.EAST, this);
		botLayout.putConstraint(SpringLayout.SOUTH, quitButton, -6, SpringLayout.SOUTH, this);
		botLayout.putConstraint(SpringLayout.WEST, typingField, 6, SpringLayout.EAST, quitButton);
		botLayout.putConstraint(SpringLayout.WEST, quitButton, 0, SpringLayout.WEST, chatArea);
		botLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		botLayout.putConstraint(SpringLayout.EAST, chatArea, -10, SpringLayout.EAST, this);
		botLayout.putConstraint(SpringLayout.WEST, sayButton, 6, SpringLayout.EAST, typingField);
		botLayout.putConstraint(SpringLayout.SOUTH, sayButton, -6, SpringLayout.SOUTH, this);
		botLayout.putConstraint(SpringLayout.WEST, promptLabel, 0, SpringLayout.WEST, chatArea);
		botLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -6, SpringLayout.NORTH, chatArea);
		botLayout.putConstraint(SpringLayout.EAST, promptLabel, 780, SpringLayout.WEST, chatArea);
		botLayout.putConstraint(SpringLayout.NORTH, chatArea, 37, SpringLayout.NORTH, this);
		botLayout.putConstraint(SpringLayout.SOUTH, chatArea, -8, SpringLayout.NORTH, typingField);
		
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
