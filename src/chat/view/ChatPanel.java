package chat.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController botController;
	private SpringLayout botLayout;
	private JButton submitButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	
	public ChatPanel (ChatController botController)
	{
		this.botController = botController;
		botLayout = new SpringLayout();
		chatArea = new JTextArea(10,30);
		typingField = new JTextField(30);
		promptLabel = new JLabel("Chat with me");
		submitButton = new JButton("");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(botLayout);
		this.setBackground(Color.DARK_GRAY);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("Type here");
		chatArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
	public JTextField getTextField()
	{
		return typingField;
	}
}
