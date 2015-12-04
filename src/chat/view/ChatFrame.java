package chat.view;

import java.awt.Container;
import javax.swing.*;
import chat.controller.ChatController;

/**
 * Frame class for GUI Interaction in the Chatbot Project
 * @author dvil4688
 * @version 1.11 12/4/15 Changed size of window, and title.
 */

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
		this.setSize(800,700);
		this.setTitle("Welcome to Chatbot");
		this.setResizable(true);
		this.setVisible(true);
	}
	
	/**
	 * Returns instance of ChatController when called.
	 * @return botController
	 */
	public ChatController getBaseController()
	{
		return botController;
	}
}
