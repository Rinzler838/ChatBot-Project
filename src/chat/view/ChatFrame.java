package chat.view;

import java.awt.Container;
import javax.swing.*;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController botController;
	private ChatPanel botPanel;
	
	public ChatFrame(ChatController baseController)
	{
		this.botController = baseController;
		botPanel = new ChatPanel(botController);
		setupFrame();
	}
	
	/**
	 * Required helper method to prepare the frame.
	 */
	
	private void setupFrame()
	{
		this.setContentPane(botPanel);
		this.setSize(450,305);
		this.setTitle("Welcome to Chatbot");
		this.setResizable(true);
		this.setVisible(true);
	}
	
	public ChatController getBaseController()
	{
		return botController;
	}
}
