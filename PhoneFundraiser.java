/**
 * The PhoneFundraiser class is used to simulate a Automated Phone Calls Fundraiser
 * The PhoneFundraiser class subclass of Fundraiser
 * The PhoneFundraiser has a location, and candidate.
 * @author Fuad Mohamoud
 */
public class PhoneFundraiser extends Fundraiser
{
    /**
     *toString method used to output specific information about the current PhoneFundraiser
     * @return output indicating a PhoneFundraiser has been ran and the name of candidate running the PhoneFundraiser
     */
    public String toString()
    {
        String output="This is a Phone Fundraiser for " + getCandidate().getName();
        return output;
    }

    /**
     *Default Constructor to build and empty PhoneFundraiser
     * Default Constructor is required in order for program to run, however it not actually used.
     */
    public PhoneFundraiser()
    {

    }

    /**
     *
     * Full Parameter Constructor to build a PhoneFundraiser using the inputted parameter values provided
     * @param inLoc will be used as the location of the PhoneFundraiser
     * @param inCandidate will used as the candidate run the PhoneFundraiser
     */
    public PhoneFundraiser(String inLoc, Candidate inCandidate)
    {
        setLocation(inLoc);
        setCandidate(inCandidate);
        donors = rand.nextInt(201);
        raiseMoney();
        inCandidate.setMoneyMod(inCandidate.getMoneyMod()+.05);
    }
}
