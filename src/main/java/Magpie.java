/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        //String statementtwo = statement;
        String response = "";
        
        if (findWord(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }

        else if (findWord(statement, "cat") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        
         else if (findWord(statement, "dog") >= 0)
        {
            response = "Tell me more about your pets.";
        }

        else if (findWord(statement, "Nathan") >= 0)
        {
            response = "He sounds like a great teacher!";
        }

        else if (findWord(statement, "chicken") >= 0)
        {
            response = "Great point, but i don't like chicken";
        }

        else if (findWord(statement, "rocket") >= 0)
        {
            response = "I think space is pretty cool";
        }

        else if (findWord(statement, "music") >= 0)
        {
            response = "Woah tell me more about music";
        }

        else if (findWord(statement, "mother") >= 0
                || findWord(statement, "father") >= 0
                || findWord(statement, "sister") >= 0
                || findWord(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }

        else if (statement.trim().length() == 0)
        {
            response = "Say something, please.";
        }

        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "huh, keep talking.";
        }
        else if (whichResponse == 5)
        {
            response = "I'm intrigued";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        String strtwo = str.toLowerCase();
        //System.out.println(strtwo);
        String wordtwo = word.toLowerCase();
        //System.out.println(wordtwo);
        String[] parts = str.split(" ");
        int p = 0;

        for(int i = 0; i < parts.length; i++) {
            String w = parts[i].toLowerCase();
          if(w.equals(wordtwo)) {
            p = p + 1;
          }
          else {
            p = p + 0;
          }
        }
        if (p >= 1) {
          return strtwo.indexOf(wordtwo);
        }
        else {
          return -1;
        }
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        //creating variables, triming original statement so it wont return a blank space
        String statementtwo = statement.trim();
        //code for last, using substring like we did in class
        String getlast = statementtwo.substring(0, statementtwo.length() - 1);
        if (getlast.equals("!")) {
            //another substring
            statementtwo = statementtwo.substring(0, statementtwo.length() - 1);
        }
        int k = findWord(statementtwo, "I want to");
        //add 8 because "i want to" is 9 long and i want it to read the first letter of the word after it
        String rest = statementtwo.substring(k + 8).trim();
        return "Would you really be happy if you had " + rest + "?";
        
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        //using pretty much the same code as previous method, slight changes
        String statementtwo = statement.trim();
        String getlast = statementtwo.substring(0, statement.length() - 1);
        if (getlast.equals("!")) {
            statementtwo = statementtwo.substring(0, statementtwo.length() - 1);
        }
        //2 int variables needed, they are in separate locations
        int getI = findWord(statementtwo, "I");
        int getYou = findWord(statementtwo, "you");
        String rest = statementtwo.substring(getI + 1, getYou).trim();
        return "Why do you " + rest + " me?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        // your code here
        return "";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        // your code here
        return "";
    }
}
