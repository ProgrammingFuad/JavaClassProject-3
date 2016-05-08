import java.util.ArrayList;
/**
 * The PACFundraiser class is used to simulate a Political Action Committees Fundraiser
 * The PACFundraiser class subclass of Fundraiser
 * The PACFundraiser has a location, and candidate and a Candidate arraylist.
 * @author Josiah Burkhardsmeier
 * @author Elvin Gateri
 * @author Fuad Mohamoud
 */
public class PACFundraiser extends Fundraiser
{
    /**
     *toString method used to output specific information about the current PACFundraiser
     * @return output indicating a PACFundraiser has been ran and the name of candidate running the PACFundraiser
     */
    public String toString()
    {
        String output="This is a PAC Fundraiser for " + getCandidate().getName();
        return output;
    }

    /**
     *Default Constructor to build and empty PACFundraiser
	 * Default Constructor is required in order for program to run, however it not actually used.
     */
    public PACFundraiser()
    {

    }

	/**
	 * Full Parameter Constructor to build a PACFundraiser using the inputted parameter values provided
	 * @param inLoc will be used as the location of the PACFundraiser
	 * @param inCandidate will used as the candidate run the PACFundraiser
	 * @param cands will used to calculate the total amount of money in play
	 * @throws TooLowInPollsException is thrown PACFundraiser’s candidate has less than 1% of the total money currently in play
     */
    public PACFundraiser(String inLoc, Candidate inCandidate, ArrayList<Candidate> cands) throws TooLowInPollsException
    {
	int totalMoney = 0;
	for(Candidate current: cands)
	{
		totalMoney += current.getMoney();
	}
	if(inCandidate.getMoney() < (1.0/100)*totalMoney)
	{
		throw new TooLowInPollsException();
	}
	else
	{
		setLocation(inLoc);
		setCandidate(inCandidate);
		donors = rand.nextInt(201);
		raiseMoney();
		inCandidate.setMoneyMod(inCandidate.getMoneyMod()+.2);
		inCandidate.setDebateMod(inCandidate.getDebateMod()+.1);
	}
    }
}
