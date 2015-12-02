package chat.view;

import javax.swing.*;
import javax.swing.text.*;

import java.awt.Color;
import java.awt.event.*;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController botController;
	private SpringLayout botLayout;
	private JButton sayButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	
	public ChatPanel (ChatController botController)
	{
		this.botController = botController;
		botLayout = new SpringLayout();
		chatArea = new JTextArea(10,30);
		typingField = new JTextField(30);
		promptLabel = new JLabel("| bzzzt...Chat with me...bzzzt |");
		sayButton = new JButton("Say");
		
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
		botLayout.putConstraint(SpringLayout.NORTH, chatArea, 37, SpringLayout.NORTH, this);
		botLayout.putConstraint(SpringLayout.EAST, chatArea, -10, SpringLayout.EAST, this);
		botLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, typingField);
		botLayout.putConstraint(SpringLayout.SOUTH, chatArea, -8, SpringLayout.NORTH, typingField);
		botLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, this);
		botLayout.putConstraint(SpringLayout.SOUTH, typingField, -8, SpringLayout.SOUTH, this);
		botLayout.putConstraint(SpringLayout.EAST, typingField, -91, SpringLayout.EAST, this);
		botLayout.putConstraint(SpringLayout.NORTH, sayButton, 1, SpringLayout.NORTH, typingField);
		botLayout.putConstraint(SpringLayout.WEST, sayButton, 6, SpringLayout.EAST, typingField);
		botLayout.putConstraint(SpringLayout.NORTH, promptLabel, 10, SpringLayout.NORTH, this);
		botLayout.putConstraint(SpringLayout.EAST, promptLabel, -125, SpringLayout.EAST, this);
	}
	
	private void changeColor()
	{
		int red, green, blue;
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}
	
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
		
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent click)
			{
				changeColor();
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public JTextField getTextField()
	{
		return typingField;
	}
}
