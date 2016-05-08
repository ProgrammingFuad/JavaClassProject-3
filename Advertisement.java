import java.util.*;
/**
 * Advertisement Class is a superclass that is used to simulate a political advertisment
 * Sub-class of this superclass are AttackAdvertisement, IssueBasedAdvertisement and TownHallAdvertisement
 * The candidate, determines which candidate is putting out the Advertisement
 * The Cost is the Money value of the Advertisement
 * @author Fuad Mohamoud
 */
public class Advertisement
{
    protected String message="DEFAULT";
    protected int cost=0;
    protected String type = "";
    protected Candidate ourCand = null;
    protected Random rand= new Random();

    /**
     * Advertisement is a default Parameter constructor with no arg,
     * this constructor is not used to create any new instances of Advertisment, we use the full constructor instead
     */
    public Advertisement()
    {

    }

    /**
     *Full Parameter constructor for creating more instances of Advertisement
     * Advertisement also get's a Type and a Message for the Advertisement.
     * @param adCandidate will be used as the Advertisement's Candidate
     * @throws OutOfMoneyException is thrown when an Advertisement cost more than the candidate's current money Value
     */
    public Advertisement(Candidate adCandidate) throws OutOfMoneyException
    {
        setCandidate(adCandidate);
        setType("Generic Advertisement");
        setMessage("This is a generic Advertisement");
	if(cost > adCandidate.getMoney())
	{
		throw new OutOfMoneyException();
	}
    }

    /**
     *setCost updates the Advertisement's money value
     * @param inCost is the value that will become the Advertisement's new money value
     */
    public void setCost(int inCost)
    {
        cost=inCost;
    }

    /**
     *getCost allows access to the Advertisment's cost
     * @return the current Ad's cost
     */
    public int getCost()
    {
        return cost;
    }

    /**
     *setMessage update's the Ad's Message String
     * @param inMessage is the String that will become the Ad's new message
     */
    public void setMessage(String inMessage)
    {
        message=inMessage;
    }

    /**
     *getMessage allows access to the current Ad's message
     * @return the Ad's current Message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     *setCandidate update's Ad's Candidate, as every Ad should have a Candidate
     * @param adCandidate is the person that will become the Ad's new Candidate
     */
    public void setCandidate(Candidate adCandidate)
    {
	    ourCand = adCandidate;
    }

    /**
     *getCandidate allows access the the Ad's Candidate
     * @return the Ad's current Candidate
     */
    public Candidate getCandidate()
    {
        return ourCand;
    }

    /**
     *toString is String that's outputted when the Advertisement object is called to print an output
     * toString is Overridden by the subclass, that can provide more specific data
     * @return output message about the Advertisment
     */
    public String toString()
    {
        String output="This object is a generic Advertisment";
        return output;
    }

    /**
     *setType update's the Ad's type.
     * ALl this subclass have a type to help determine the type of Ad it is
     * @param inType Value that which becomes the Ad's new Type
     */
	public void setType(String inType)
	{
		type = inType;
	}

    /**
     *getType allows access the the current Ad's type to determine the Subclass
     * @return the Ad's current type
     */
	public String getType()
	{
		return type;
	}

}
