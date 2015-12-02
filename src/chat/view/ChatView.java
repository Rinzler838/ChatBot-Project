package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Popup display class for GUI interaction in the Chatbot Project.
 * @author dvil4688
 * @version 1.3 11/5/15 Added icons to popup window.
 */

public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Chatbot: Ancient Robot";
		chatIcon = new ImageIcon(getClass().getResource("images/robot.png"));
	}
	
	/**
	 * Displays a GUI popup for collecting user text with the supplied String.
	 * Usually in the form of a question to collect for further use in the program.
	 * @param myDisplay The text to show in the popup window. Should be a question.
	 *  @return The text supplied by the user.
	 */
	
	public String chatInput(String displayText)
	{
		String userInput = "";
		
		userInput = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Enter text here...").toString();
		
		return userInput;
	}
	
	/**
	 * Displays a String to the user with a standard popup.
	 * @param myDisplay The supplied text to be displayed.
	 */
	
	public void showMessage(String myDisplay)
	{
		JOptionPane.showMessageDialog(null, myDisplay, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon);
	}

}
