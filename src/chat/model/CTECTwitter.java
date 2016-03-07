package chat.model;

import java.util.ArrayList;

import twitter4j.*;

/**
 * @author Deigen Villalobos
 * @version 0.3 Constructed ArrayLists
 * This Class will allow ChatBot to access Twitter, interact with other users Tweets, and Tweet itself.
 */
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>(); 
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
