import java.util.*;
/**
 * The IssueBasedAdvertisement class is used to simulate an IssueBased Advertisement put out by a candidate
 * IssueBasedAdvertisement is a subclass of Advertisement
 * @author Josiah Burkhardsmeier
 * @author Elvin Gateri
 * @author Fuad Mohamoud
 */
public class IssueBasedAdvertisement extends Advertisement
{
    /**
     * Full Parameter Constructor to build a IssueBasedAdvertisement using the inputted parameter values provided
     * @param adCand will be used as the Candidate running the IssueBased Advertisement
     * @throws OutOfMoneyException is thrown when the Ad's cost is greater than Candidate's money value
     */
    public IssueBasedAdvertisement (Candidate adCand) throws OutOfMoneyException
    {
	setType("Issue-Based");
	setCost(rand.nextInt(15001)+5000);
	setCandidate(adCand);
	setMessage("This is an Issue based Advertisement for " + ourCand.getName());
	if(cost > adCand.getMoney())
	{
		throw new OutOfMoneyException();
	}
    }

	/**
     * RunAd is a Method used Change a candidate's debate modifier and Money modifier after an IssueAd is been executed
     * RunAd changed the Money mod, deb mod for the Ad running the IssueBased Ad
     * @return string indicating wither ad was approved by Candidate or not
     */
    public String runAd()
    {
	if(ourCand.endorse(this) == true)
	{
		ourCand.setDebateMod(.1 + ourCand.getDebateMod());
		return "My name is " + ourCand.getName() + " and I approve this message.";
	}
	else
	{
		ourCand.setDebateMod(.05 + ourCand.getDebateMod());
		return "This message has not been approved by " + ourCand.getName();
	}
    }

	/**
	 *toString to used output information about the current Issuebased ad. Shows the cost and name of Candidate running the Add
	 * @return Output string with information about the IssueBased Ad
     */
    public String toString()
    {
        String output="This is an Issue based Advertisement. \n\tIt costs " + getCost() + " dollars. \n\tIt's Candidate is " + ourCand.getName();
        return output;
    }


}
