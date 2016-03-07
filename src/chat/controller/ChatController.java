 package chat.controller;

import chat.view.*;
import chat.model.ChatBot;
import chat.model.CTECTwitter;

/**
 * Application controller for the Chatbot project.
 * @author Deigen Villalobos
 * @version 1.6 3/7/16 Added sendTweet method.
 */

public class ChatController
{
	private CTECTwitter chatTwitter;
	private ChatBot myBot;
	private ChatView myDisplay;
	private ChatFrame baseFrame;

	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.chatInput("Please type your Username below:");
		myBot = new ChatBot(userName);
		baseFrame = new ChatFrame(this);
		chatTwitter = new CTECTwitter(this);
	}
	
	/**
	 * Method to initiate program via Runner, and getting the user's name.
	 */
	public void start()
	{
		myDisplay.showMessage("Username: " + myBot.getUserName() + " \n Please press \"ENTER\" to continue");
	}
	
	/**
	 * Allows Chatbot to process text and return a response.
	 * 
	 * @param conversationText
	 * @return A response
	 */
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

	/**
	 * Kills program after bidding a fond farewell.
	 */
	private void shutDown()
	{
		myDisplay.showMessage("bzzzt...Farewell " + myBot.getUserName() + ", I'll be going now...bzzzt");
		System.exit(0);
	}
	
	public void sendTweet(String tweetText)
	{
		chatTwitter.sendTweet(tweetText);
	}
	
	public void handleErrors(String errorMessage)
	{
		myDisplay.showMessage(errorMessage);
	}
	
	/**
	 * Returns instance of Chatbot when it is called.
	 * 
	 * @return myBot
	 */
	public ChatBot getChatBot()
	{
		return myBot;
	}
	
	/**
	 * Returns instance of ChatView when it is called.
	 * 
	 * @return myDisplay
	 */
	public ChatView getChatView()
	{
		return myDisplay;
	}
	
	/**
	 * Returns instance of ChatFrame when it is called.
	 * 
	 * @return baseFrame
	 */
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
}

