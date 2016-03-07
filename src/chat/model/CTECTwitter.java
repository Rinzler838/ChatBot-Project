package chat.model;

import java.util.ArrayList;
import twitter4j.*;

/**
 * @author Deigen Villalobos
 * @version 0.2 Reference to Twitter4j
 * This Class will allow ChatBot to access Twitter, interact with other users Tweets, and Tweet itself.
 */
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>(); 
	}
}
