/**
 *TooLowInPollsException is an exception that's thrown during a debate’s constructor if a one or more of the debate’s candidate has less than 3% of the total money currently in play 
 *(total of all money from all candidates)UNLESS all of the debate’s candidates are from the same political party
 * 
 * Exception is also thrown thrown during a PACFundraiser’s constructor if the PACFundraiser’s candidate has less than 1% of the total money currently in play
*/
public class TooLowInPollsException extends Exception
{
	/**
	 *getMessage() method has a string that's returned when TooLowInPollsException is trigged
	 * @return the string to containing the error that occurred
        */
	public String getMessage()
	{
		return "One or more Candidates are too low in the polls (funds too low) to complete this action.";
	}
}
