/**
 *OutOfMoneyException an exception that's thrown during an advertisement’s constructor if the ad will 
 *cost more than the Candidate has money.  
*/
public class OutOfMoneyException extends Exception
{
	/**
	 *getMessage() method has a string that's returned when OutOfMoneyException is trigged
	 * @return the string to indicated that an candidate doesn't have enough money for a give add
        */
	public String getMessage()
	{
		return "The advertisement cost more money than the Candidate's current money value";
	}


}
