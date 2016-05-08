import java.util.*;
/**
 * The AttackAdvertisement is used to simulate a Candidate attacking another Candidate
 * AttackAdvertisement is a subclass of Advertisement, it has a cost, Target Candidate, Candidate running the add and a Type
 * The cost determines how much money a Candidate must have in order to run the AttackAdvertisement
 * TargetCand is the Candidate that's being attacked by the AttachAd
 * Type helps tell that the AttackAdvertisement is a "Attack Ads"
 * @author Fuad Mohamoud
 */
public class AttackAdvertisement extends Advertisement
{

    private Candidate target = null;

	/**
	 * Full Parameter Constructor to build an AttackAdvertisement using the inputed parameter values provided
	 * @param adCand will become the candidate running the Ad
	 * @param targetCand will become thee Candidate being attached by the Ad
	 * @throws OutOfMoneyException is thrown when the Ad's cost is greater than Candidate's money value
     */
    public AttackAdvertisement(Candidate adCand, ArrayList<Candidate> targetCand) throws OutOfMoneyException
    {
	setType("Attack Ads");
	setCost(rand.nextInt(25001)+50000);
	setCandidate(adCand);
	setTarget(targetCand);
	setMessage("This is an Attack Advertisement for " + ourCand.getName());
	if(cost > adCand.getMoney())
	{
		throw new OutOfMoneyException();
	}
    }

	/**
	 *toString Overrided Superclass's toString to output useful information about the AttackAd
	 * Information display are, the cost of the Ad, the Candidate running the Ad, and the Target of the Ad
	 * @return String containing specific information about the AttackAdvertisement
     */
    public String toString()
    {
        String output="This is an Attack Advertisement. \n\tIt costs " + getCost() + " dollars. \n\tIt's Candidate is " + ourCand.getName() + ". \n\tIt targets " + target.getName();
        return output;
    }

	/**
	 *setTarget updates the Candidate that's the target of the attackAd
	 * Randomly selected from Arraylist of Candidate, verifies that Candidate is not attacking self
	 * @param targets current AttackAdvertisement's target
     */
    public void setTarget(ArrayList<Candidate> targets)
    {
        target = targets.get(rand.nextInt(targets.size()));
	while(target.equals(ourCand))
	{
        	target = targets.get(rand.nextInt(targets.size()));
	}
    }

    /**
     *getTarget allows access to the Candidate's current Target
     * @return the AttackAdvertisement's current Target Candidate
     */
    public Candidate getTarget()
    {
        return target;
    }

	/**
	 * RunAd is a Method used Change a candidate's debate modifier and Money modifier after an AttackAd is been executed
	 * RunAd changed the Money mod, deb mod for both the Target ad and Ad running the Attackad
	 * @return string indicating wither ad was approved by Candidate or not
     */
    public String runAd()
    {
	if(ourCand.endorse(this) == true)
	{
		ourCand.setDebateMod(.2 + ourCand.getDebateMod());
		ourCand.setMoneyMod(ourCand.getMoneyMod() - .2);
		target.setDebateMod(target.getDebateMod() - .15);
		target.setMoneyMod(target.getMoneyMod() - .25);
		return "My name is " + ourCand.getName() + " and I approve this message.";
	}
	else
	{
		ourCand.setDebateMod(.1 + ourCand.getDebateMod());
		ourCand.setMoneyMod(ourCand.getMoneyMod() - .05);
		target.setDebateMod(target.getDebateMod() - .05);
		target.setMoneyMod(target.getMoneyMod() - .1);
		return "This message has not been approved by " + ourCand.getName();
	}
    }
}
