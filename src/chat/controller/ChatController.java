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
		String userName = myDisplay.chatInput("What is your name?");
		myBot = new ChatBot(userName);
	}
	
	public void start()
	{
		myDisplay.showMessage("Hello " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String conversation = myDisplay.chatInput("What yould you like to talk about today?");
		while (myBot.lengthChecker(conversation))
		{
		if (myBot.contentChecker(conversation))
			{
			myDisplay.chatInput("Wow, I had no idea you were interested in " + myBot.getContent());
			} 
		
			conversation = myDisplay.chatInput(conversation);
		}
		
}

	
	//private void shutDown()
	
}
