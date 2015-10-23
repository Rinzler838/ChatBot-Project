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
	private ChatView displayText;

	public ChatController()
	{
		displayText = new ChatView();
		String userName = displayText.chatInput("What is your name?");
		myBot = new ChatBot(userName);
	}
	
	public void start()
	{
		displayText.chatInput("Hello " + myBot.getUserName());
	}
}
