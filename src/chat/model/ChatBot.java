package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part of the project.
 * 
 * @author Deigen Villalobos
 * @version 1.2 10/23/15 Completed the length checker method. Fixed the
 *          Constructor and getter for userName.
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

	private void buildMemesList()
	{
		this.memesList.add("Me Gusta");
		this.memesList.add("Troll");
		this.memesList.add("\"Aliens\"");
		this.memesList.add("Doge");
		this.memesList.add("Bad Luck Brian");
		this.memesList.add("Unhelpful Highschool Teacher");
		this.memesList.add("Cute Animals");
		this.memesList.add("Spoderman");
		this.memesList.add("Rare Pepe");
		this.memesList.add("What if I told you...");
	}

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
	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;

		if (currentInput != null)
		{
			if (currentInput.length() != 1)
			{
				hasLength = true;
			}
		}

		// Alternate method: Compound "if"

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

	public String processConversation(String currentInput)
	{
		String nextConversation = "What else would you like to converse?";
		int randomTopic = (int) (Math.random() * 5);	//Generates a random number between 0 & 4.
		switch (randomTopic)
		{
			case 0:
				if (memeChecker(currentInput))
				{
					nextConversation = "I'm told that that is quite a popular meme at this time. What else would you " 
							+ "like to discuss?";
				}
				break;
			case 1:
				if (politicalTopicChecker(currentInput))
				{
					nextConversation = "I despise politics...";
				}
				break;
			case 2:
				if (contentChecker(currentInput))
				{
					nextConversation = "I am also interested in " + content;
				}
				break;
			case 3:
				if (currentInput.length() > 20)
				{
					nextConversation = "Too...many...words...can't...process...1nf0rm4t10n...n0w...$#ut1ng...d0wn...@$%^!@#$5#%&!345@#$%346&$563&*58134#%^*!~273647132136";
				}
				break;
			case 4:
				nextConversation = "Insert words here...";
				break;
			default:
				nextConversation = "The universe has ended. End of Line.";
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
		return null;
	}

	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{

	}
}