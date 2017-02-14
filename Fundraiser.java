/**
 * The Fundraiser is a superclass used to simulate a Fundraiser for a candidate
 * The child(subclass) of Fundraiser are PhoneFundraiser, SocialFundraiser, PAC Fundraiser
 * Fundraiser has a location, Candidate, and donors
 * The Candidate is presidential candidate that's is going to a fundraiser
 * The Donor is the people attending and contributing the the candidate's presidential run
 * @author Fuad Mohamoud
 */
import java.util.Random;
public class Fundraiser
{
    protected String location = "DEFAULT";
    protected Candidate candidate = null;
    protected int donors;
    protected Random rand = new Random();

    /**
     *toString is used to display the location, candidate and number of donors attending the fundraiser
     * This method is overridden by subclasses
     * @return String indicating information about the fundraiser
     */
    public String toString()
    {
        String output="The location of the fundraiser is" + getLocation() +"the candidate going is "+ getCandidate()+
                "number of donors are " + getDonors();
        return output;
    }



    /**
     *Default Constructor to build debate with random number of donors
     * Had to create this default contructor for sub objects to work
     */
    public Fundraiser()
    {
       donors= rand.nextInt(201);
    }



    /**
     *Full Parameter contructor to build a Fundraiser using teh inputed parameter value provided
     * @param inLoc wil become the location of the fundraiser
     * @param inCandidate will become teh candidate dong to the fundraiser
     */
    public Fundraiser(String inLoc, Candidate inCandidate)
    {
        setLocation(inLoc);
        setCandidate(inCandidate);
        donors = rand.nextInt(201);
    }

    /**
     *setLocation updated the Fundraiser's location
     * @param inLoc is the value that willcoem teh new fundraiser location
     */
    public void setLocation(String inLoc)
    {
        location = inLoc;
    }

    /**
     *getLocation allows access to the Fundraiser location
     * @return the debate's current location
     */
    public String getLocation()
    {
        return location;
    }

    /**
     *setCandidate updates the Fundraiser' candidate
     * @param inCandidate is the value that will become the candidate going to a fundraiser
     */
    public void setCandidate(Candidate inCandidate)
    {
        candidate = inCandidate;
    }


    /**
     *getCandidate allows access to the Candidate
     * @return the Fundraiser's current Candidate
     */
    public Candidate getCandidate()
    {
        return candidate;
    }


    /**
     *getDonors allows access to the fundraiser's donors
     * @return the number of donor attending the fundraiser
     */
    public int getDonors()
    {
        return donors;
    }


    /**
     *raiseMoney that allows Fundraiser's candidate to raise money
     */
    public void raiseMoney()
    {
        double total = 0;
        for (int x = 0; x < donors; x++)
        {
            total += rand.nextInt(151);
        }

        double total2=total*candidate.getMoneyMod();


        candidate.addMoney(total2);
    }
}
