package chat.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController botController;
	private SpringLayout botLayout;
	
	public ChatPanel (ChatController botController)
	{
		this.botController = botController;
		botLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(botLayout);
		this.setBackground(Color.DARK_GRAY);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
}
