package chat.view;

import javax.swing.JOptionPane;

public class ChatView
{
	
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText);
	}
	
	public String chatInput(String displayText)
	{
		String returnedText = "";
		
		returnedText = JOptionPane.showInputDialog(null, returnedText);
		
		return returnedText;
	}

}
