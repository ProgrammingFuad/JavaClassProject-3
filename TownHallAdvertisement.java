import java.util.ArrayList;
/**
 * The TownHallAdvertisement class is used to simulate a TownHall Advertisement
 * The TownHallAdvertisement is a subclass of Advertisement
 * @author Fuad Mohamoud
 */

public class TownHallAdvertisement extends Advertisement
{

    private int attendees=0;

    /**
     * Full Parameter Constructor to build a TownHallAdvertisement using the inputted parameter values provided
     * @param adCand will be used as the Candidate running the TownHall Advertisement
     * @throws OutOfMoneyException is thrown when the TownHallAdvertisement's cost is greater than Candidate's money value
     */
    public TownHallAdvertisement(Candidate adCand) throws OutOfMoneyException
    {
	setType("Town Hall");
	setCost(rand.nextInt(95001)+5000);
	setCandidate(adCand);
	setAttend();
	setMessage("This is an Town Hall Advertisement for " + ourCand.getName());
	if(cost > adCand.getMoney())
	{
		throw new OutOfMoneyException();
	}
    }

    /**
     * RunAd is a Method used Change a candidate's debate modifier and Money modifier after TownHall Advertisement been executed
     * RunAd changed the Money modifier for the candidate conducting the Advertisement
     * @return string indicating wither the TownHall Advertisement was successfully or not
     */
    public String runAd()
    {
	if(ourCand.endorse(this) == true)
	{
		ourCand.setMoneyMod(ourCand.getMoneyMod() + (attendees/500.0));
		return ourCand.getName() + " holds a successful Town Hall.";
	}
	else
	{
		ourCand.setMoneyMod(ourCand.getMoneyMod() + (attendees/2000.0));
		return ourCand.getName() + " holds a Town Hall.";
	}
    }

    /**
     *setAttend randomly updates the number of people attending the TownHall Advertisement
     * No param needed as it Random
     */
    public void setAttend()
    {
        attendees=rand.nextInt(151);
    }

    /**
     *getAttend allows access to the number of people attending the TownHall Advertisement
     * @return the value for attendees
     */
    public int getAttend()
    {
        return attendees;
    }

    /**
     *toString is method used to output specific information about the current TownHallAdvertisement
     * @return an output string indicating the cost of it, the candidate conducting a TownHall Advertisement and number of people attending the TownHall Advertisement
     */
    public String toString()
    {
        String output="This is a Town Hall Advertisement. \n\tIt costs " + getCost() + " dollars. \n\tIt's Candidate is " + ourCand.getName() + " \n\tIt had " + getAttend() + " attendees.";
        return output;
    }
}
