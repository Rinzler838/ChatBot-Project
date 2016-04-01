package chat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import twitter4j.*;
import chat.controller.ChatController;

/**
 * @author Deigen Villalobos
 * @version 0.4 3/7/16 - Added code for sendTweet to handle errors.
 * This class will allow ChatBot to access Twitter, interact with other users' Tweets, and Tweet itself.
 */
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I (Deigen Villalobos) just tweeted from my Java Chatbot program! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
	
	public void loadTweets(String twitterHandle)throws TwitterException
	{
		statusList.clear();
		wordList.clear();
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for (Status currentStatus : statusList)
		{
			String [] tweetText = currentStatus.getText().split(" ");
			for (String word : tweetText)
			{
				wordList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordList);
		removeEmptyText();
	}
	
	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		
		Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		while (wordFile.hasNext())
		{
			wordCount++;
			wordFile.next();
		}
		wordFile.reset();
		wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		boringWords = new String[wordCount];
		int boringWordCount = 0;
		while (wordFile.hasNext())
		{
			boringWords[boringWordCount] = wordFile.next();
			boringWordCount++;
		}
		wordFile.close();
		return boringWords;
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!;\"(){}^[]<>-";
		
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return currentString;
	}
	
	private void removeEmptyText()
	{
		for (int spot = 0; spot < wordList.size(); spot++)
		{
			if (wordList.get(spot).equals(""))
			{
				wordList.remove(spot);
				spot--;	//Needed to go back a spot and re-check the list for redundant characters.
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private List removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		
		for (int count = 0; count < wordList.size(); count++)
		{
			for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if (wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		removeTwitterUserNamesFromList(wordList);
		return wordList;
	}
	
	private void removeTwitterUserNamesFromList(List<String> wordLsit)
	{
		for (int wordCount = 0; wordCount < wordList.size(); wordCount++)
		{
			if (wordList.get(wordCount).length() >= 1 && wordList.get(wordCount).charAt(0) == '@')
			{
				wordList.remove(wordCount);
				wordCount--;
			}
		}
	}
	
	public String topResults()
	{
		String tweetResults = "";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for (int index = 0; index < wordList.size(); index++)
		{
			int wordUseCount = 1;
			
			for (int spot = index + 1; spot < wordList.size(); spot++)
			{
				if (wordList.get(index).equals(wordList.get(spot)))
				{
					wordUseCount++;
				}
				
				if (wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		tweetResults = "the top word in their tweets was " + wordList.get(topWordLocation) + " and it was used " + topCount + " times.";
		return tweetResults;
	}
	
	public String getData()
	{
		String results = "";
		
		Query myQuery = new Query("Infinity Blade");
		myQuery.setCount(100);
		myQuery.setGeoCode(new GeoLocation(40.556498, -111.858935), 50, Query.MILES);
		myQuery.setSince("2010-12-9");
		try
		{
			QueryResult result = chatbotTwitter.search(myQuery);
			results += "Count: " + result.getTweets().size();
			for (Status tweet : result.getTweets())
			{
				results += "@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n";
			}
		}
		catch (TwitterException error)
		{
			error.printStackTrace();
		}
		return results;
		
	}
}
