package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Popup display class for GUI interaction in the Chatbot Project
 * @author dvil4688
 * @version 1.3 11/5/15 Added icons to popup window
 */

public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Greetings, it's your friendly neighborhood chat bot...";
		chatIcon = new ImageIcon(getClass().getResource("images/robot.png"));
	}

	public void showMessage(String myDisplay)
	{
		JOptionPane.showMessageDialog(null, myDisplay, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
	}
	
	public String chatInput(String displayText)
	{
		String userInput = "";
		
		userInput = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Enter text here...").toString();
		
		return userInput;
	}

}
