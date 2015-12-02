 package chat.controller;

import chat.view.ChatFrame;
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
	private ChatFrame baseFrame;

	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.chatInput("bzzzt...Please type your designated moniker in the box below...bzzzt");
		myBot = new ChatBot(userName);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		myDisplay.showMessage("Greetings, User: " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{		
		String conversation = myDisplay.chatInput("bzzzt...What yould you like to discuss at this time?");
		//while (myBot.lengthChecker(conversation))
		//{
		//	conversation = myDisplay.chatInput(myBot.processConversation(conversation));
		//}	
	}
	
	public String userToChatBot(String conversationText)
	{
		String response = "";
		
		if (myBot.quitChecker(conversationText))
		{
			shutDown();
		}
		
		response = myBot.processConversation(conversationText);
		
		return response;
	}

	private void shutDown()
	{
		myDisplay.showMessage("bzzzt...Farewell " + myBot.getUserName() + ", I'll be going now...bzzzt");
		System.exit(0);
	}
	
	public ChatBot getChatBot()
	{
		return myBot;
	}
	
	public ChatView getChatView()
	{
		return myDisplay;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
}

