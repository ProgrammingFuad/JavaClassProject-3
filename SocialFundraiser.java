/**
 * @author Josiah Burkhardsmeier
 * @author Elvin Gateri
 * @author Fuad Mohamoud
 */
public class SocialFundraiser extends Fundraiser
{
    /**
     *toString method used to output specific information about the current SocialFundraiser
     * @return output indicating a SocialFundraiser has been ran and the name of candidate running the PhoneFundraiser
     */
    public String toString()
    {
        String output="This is a Social Fundraiser for " + getCandidate().getName();
        return output;
    }

    /**
     *Default Constructor to build and empty PhoneFundraiser
     * Default Constructor is required in order for program to run, however it not actually used.
     */
    public SocialFundraiser()
    {

    }

    /**
     * Full Parameter Constructor to build a SocialFundraiser using the inputted parameter values provided
     * @param inLoc will be used as the location of the SocialFundraiser
     * @param inCandidate will used as the candidate run the SocialFundraiser
     */
    public SocialFundraiser(String inLoc, Candidate inCandidate)
    {
        setLocation(inLoc);
        setCandidate(inCandidate);
        donors = rand.nextInt(201);
        raiseMoney();
        inCandidate.setMoneyMod(inCandidate.getMoneyMod()+.1);
    }
}
