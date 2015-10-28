package chat.view;

import javax.swing.JOptionPane;

public class ChatView
{
	
	public void showMessage(String myDisplay)
	{
		JOptionPane.showMessageDialog(null, myDisplay);
	}
	
	public String chatInput(String displayText)
	{
		String returnedText = "";
		
		returnedText = JOptionPane.showInputDialog(null, displayText);
		
		return returnedText;
	}

}
