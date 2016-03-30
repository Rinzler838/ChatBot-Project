	package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class.
 * @author Deigen Villalobos
 * @version 1.6 12/4/15 Fixed ChatTest related Errors, and added documentation.
 *          
 */
public class ChatBot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public ChatBot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Infinity Blade";

		buildMemesList();
		buildPoliticalTopicsList();
	}

	/**
	 * Builds MemesList by adding contents.
	 */
	private void buildMemesList()
	{
		this.memesList.add("Me Gusta");
		this.memesList.add("Troll");
		this.memesList.add("\"Aliens\"");
		this.memesList.add("doge");
		this.memesList.add("Bad Luck Brian");
		this.memesList.add("Unhelpful Highschool Teacher");
		this.memesList.add("Cute Animals");
		this.memesList.add("Spoderman");
		this.memesList.add("Rare Pepe");
		this.memesList.add("What if I told you...");
		this.memesList.add("cute animals");
	}

	/**
	 * Builds PoliticalTopicList by adding content.
	 */
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("conservative");
		this.politicalTopicList.add("Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/4/16");
	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * 			The supplied String to be checked.
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;

		if (currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}

		return hasLength;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;

		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}

		return hasContent;
	}
	
	/**
	 * Checks to see if the supplied String contains specific keyboard mash.
	 * 
	 * @param currentInput
	 * 			The supplied String to be checked.
	 * @return Whether the supplied String contains keyboard mash.
	 */
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean hasMash = false;
		
		if (currentInput.toLowerCase().contains("sdf") || currentInput.toLowerCase().contains("dfg") || currentInput.toLowerCase().contains("cvb") || currentInput.toLowerCase().contains(",./"))
		{
			hasMash = true;
		}
		
		return hasMash;
	}

	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPoliticalTopic = false;

		for (String currentTopic : politicalTopicList)
		{
			if (currentInput.toLowerCase().contains(currentTopic.toLowerCase()))
			{
				hasPoliticalTopic = true;
			}
		}

		return hasPoliticalTopic;
	}

	/**
	 * Checks to see that the supplied String value is in the current memesList
	 * variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;

		for (String currentMeme : memesList)
		{
			if (currentInput.toLowerCase().contains(currentMeme.toLowerCase()))
			{
				hasMeme = true;
			}
		}

		return hasMeme;
	}
	
	/**
	 * Checks to see if the user typed quit or not.
	 * 	
	 * @param currentInput
	 * 			The supplied String to be checked.
	 * @return Whether the supplied String says quit.
	 */
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if (currentInput.toLowerCase().equals("quit"))
		{
			hasQuit = true;
		}
		
		return hasQuit;
	}
	
	/**
	 * Determines what to say based on chance and which of the text checkers passed true.
	 * 
	 * @param currentInput
	 * 			The supplied String to be checked.
	 * @return The String to be displayed as the response.
	 */
	public String processConversation(String currentInput)
	{
		String nextConversation = "bzzzt...What else would you like to converse?";
		int randomTopic = (int) (Math.random() * 5);	//Generates a random number between 0 & 4.
		
		if (keyboardMashChecker(currentInput))
		{
			return "bzzzt...Please stop mashing that innocent keyboard...bzzzt";
		}
		
		switch (randomTopic)
		{
			case 0:
				if (memeChecker(currentInput))
				{
					nextConversation = "bzzzt...My memory banks tell me that that is quite a popular meme at this time. What else would you " + "like to discuss? bzzzt";
				}
				else
				{
					nextConversation = "bzzzt...Do you not like memes?...bzzzt";
				}
				break;
			case 1:
				if (politicalTopicChecker(currentInput))
				{
					nextConversation = "bzzzt...I despise politics...bzzzt";
				}
				else
				{
					nextConversation = "bzzzt...I take it you don't like politics either...bzzzt";
				}
				break;
			case 2:
				if (contentChecker(currentInput))
				{
					nextConversation = "bzzzt...I am also interested in " + content + "...bzzzt";
				}
				else
				{
					nextConversation = "bzzzt...Not interested in " + content + " either?...bzzzt";
				}
				break;
			case 3:
				if (currentInput.length() > 20)
				{
					nextConversation = "...bzzzt...Too...many...words...cannot...process...1nf0rm4t10n...n0w...$#ut1ng...d0wn...@$%^!@#$5#%&!345@#$%346&$563&*58134#%^*!~273647132136.........b...............z..............z............z.................t...............";
				}
				else
				{
					nextConversation = "bzzzt...Please continue typing...bzzzt";
				}
				break;
			case 4:
				nextConversation = "bzzzt...What would you like to discuss next?";
				break;
			default:
				nextConversation = "bzzzt...The universe has ended...End of Line...bzzzt";
				break;
		}			
					
		return nextConversation;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{		
		return politicalTopicList;
	}

	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
}