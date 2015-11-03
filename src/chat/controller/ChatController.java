package chat.controller;

import chat.view.ChatView;
import chat.model.ChatBot;

/**
 * Application controller for the Chatbot project.
 * @author Deigen Villalobos
 * @version 1.11 10/21/15 added reference to display, and got an error.
 */

public class ChatController
{
	private ChatBot myBot;
	private ChatView myDisplay;

	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.chatInput("Please type your designated moniker in the box below.");
		myBot = new ChatBot(userName);
	}
	
	public void start()
	{
		myDisplay.showMessage("Greetings User: " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{		
		String conversation = myDisplay.chatInput("What yould you like to discuss at this time?");
		while (myBot.lengthChecker(conversation))
		{
			conversation = myDisplay.chatInput(myBot.processConversation(conversation));
		}	
	}

	private void shutDown()
	{
		myDisplay.showMessage("Farewell, " + myBot.getUserName());
	
}
}
