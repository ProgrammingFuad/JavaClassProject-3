/**
 * The Candidate class is used to simulate a presidential Candidate
 * A Candidate has a name, slogan message, money, is a member of a political Party,
 * MoneyMod, debateMod,  adPreference, fund preference and a debate score
 * <br><br>
 * @author Fuad Mohamoud
 */
import java.util.Random;
import java.lang.*;
import java.util.*;
public class Candidate implements Comparable<Candidate>
{
    private String name = "DEFAULT";
    private String slogan = "DEFAULT";
    private double money = 0;
    private String party = "DEFAULT";
    private Random rand = new Random();
    private double moneyMod= 0.0;
    private double debateMod=0.0;
    private String adPreference="DEFAULT";
    private Fundraiser fundPreference=null;
    private double debscore=0;


    /**
     *setDebscore updates the Candidate's debatescore
     * @param indebscore value which will become the Candidate's new dabate score
     */
    public void setDebscore(double indebscore)
    {
        debscore=indebscore;
    }

    /**
     *getDebscore allows access to the Candidate's debate score value
     * @return the Candidate's current debate score
     */
    public double getDebscore()
    {
        return debscore;
    }

    /**
     *equalsParty is method used determine if Candidate is in the same political party as another Candidate
     * @param otherCand Candidate to compare the party with- different cand
     * @return boolean if two Candidate have the are in the same Party
     */
    public boolean equalsParty(Candidate otherCand)
    {
        if(getParty().equals(otherCand.getParty()))
        {
            return true;
        }
        return false;
    }

    /**
     *equals is a methond used to determine wither two Candidate's have the same name.
     * @param otherCandidate
     * @return true or false if two candidates have the same name-
     */
    public boolean equals(Candidate otherCandidate)
    {
        if (getName().equals(otherCandidate.getName()))
        {
            return true;
        }
        return false;
    }

    /**
     *toString method is used to display specific information about the Candidate
     * @return String containing the name, Slogan, money and the party.
     */
    public String toString()
    {
        String output="This Candidate's name is " + getName()+":\n\tTheir slogan is " + getSlogan() +
	"\n\tThe candidate has "+ "$"+String.format("%.2f",getMoney())+ "\n\t" + getName() + " is a party member of \"" + getParty() +
	"\"";
        return output;
    }

    /**
     *compareTo is used to determine if two Candidate's have the same money value
     * @param otherCandidate Candidate to compare money value with
     * @return 0 if two candidate have the same money value, -1 if current has less money and 1 if Current cand has more money
     */
    public int compareTo(Candidate otherCandidate)
    {
        int x= (int)this.getMoney();

        int g = (int)otherCandidate.getMoney();


         if(x-g==0)
         {
             return this.getName().compareTo(otherCandidate.getName());
         }
        else
         {
             return x-g;
         }



    }

    /**
     *setAdpreference is a method used to Randomly determine the Candidate's Adpreference
     * Candidate can either prefer to run, issue-based ads, Attack ads or Town Hall.
     * Method helps determine if the Candidate approves the Ad or not
     */
    private void setAdpreference()
    {
        int ad=rand.nextInt(3);

        if (ad==0)
        {
            adPreference="Issue-Based";
        }
        else if (ad==1)
        {
            adPreference="Attack Ads";
        }
        else
        {
            adPreference="Town Hall";
        }
    }

    /**
     *getAdpreference allows access to the Candidate's Adpreference
     * @return the Candidate's Adpreference
     */
    public String getAdpreference()
    {
        return adPreference;
    }

    /**
     *setFundrasingprefer is a method used to Randomly determine the Candidate's Fundrasingprefer
     * Candidate can either select Social Events,Automated Phone Calls,  Political Action Committees"
     * Method helps determine the fundraiser type that they prefer to go to
     */
    private void setFundrasingprefer()
    {
        int ad=rand.nextInt(3);

        if(ad == 0)
        {
           // fundPreference="Social Events";
            fundPreference= new SocialFundraiser();
        }
        else if (ad==1)
        {
        //    fundPreference="Automated Phone Calls";
            fundPreference= new PhoneFundraiser();
        }
        else
        {
           // fundPreference="Political Action Committees";
            fundPreference= new PACFundraiser();
        }
    }

    /**
     *getFundraisingprefer allows access the Candidate's current Fundraising prefer
     * @return Fundraising prefer
     */
    public Fundraiser getFundraisingprefer()
    {
        return fundPreference;
    }

    /**
     *Pull Parameter constructor to build a Candidate using the inputed parameter value provided
     * @param inName will be used as the Candidate's Name
     * @param inSlogan will be used as the Candidate's Slogan
     * @param inParty will be used as the Candidate's Party
     */
    public Candidate(String inName, String inParty, String inSlogan)
    {
        setName(inName);
        setSlogan(inSlogan);
        setParty(inParty);
        money = rand.nextDouble()*100;
        setMoneyMod(1.0);
        setDebateMod(1.0);
        setFundrasingprefer();
        setAdpreference();
    }

    /**
     *setMoneyMod update's the Candidate's Money modifier value
     * @param inMod is the value which will become the Candidate's new Money Modifier rating
     */
    public void setMoneyMod(double inMod)
    {
        moneyMod=inMod;
    }

    /**
     *getMoneyMod allows access the the Candidate's money modifier
     * @return the candidate's current Money Modifier rating
     */
    public double getMoneyMod()
    {
        if (moneyMod < 0)
        {
            return 0;
        }
        return moneyMod;
    }

    /**
     *setDebateMod update's the Candidate's debate modifier value
     * @param inMod is the value which will become the Candidate's new debate Modifier rating
     */
    public void setDebateMod(double inMod)
    {
        debateMod=inMod;
    }

    /**
     *getDebateMod allows access the the Candidate's debate modifier
     * @return the candidate's current debate Modifier rating
     */
    public double getDebateMod()
    {
        if (debateMod < 0)
        {
            return 0;
        }
        else
        {
            return debateMod;
        }
    }


    /**
     *setName updates the Candidate's Name
     * @param inName is the Value which will become the Candidate's new Name
     */
    public void setName(String inName)
    {
        name = inName;
    }

    /**
     *getName allows access to the Candidate's name
     * @return the Candidate's current Name
     */
    public String getName()
    {
        return name;
    }

    /**
     *setSlogan updates Candidate's Slogan
     * @param inSlogan is the value that will become the Candidate's  new slogan
     */
    public void setSlogan(String inSlogan)
    {
        slogan = inSlogan;
    }


    /**
     *getSlogan allows access to the Candidate's Slogan
     * @return the Candidate's current Slogan
     */
    public String getSlogan()
    {
        return slogan;
    }


    /**
     *setParty updates Candidate's Party
     * @param inParty is the value that will become the Candidate's new Party
     */
    public void setParty(String inParty)
    {
        party = inParty;
    }


    /**
     *getParty allows access to the Candidate's Party
     * @return the Candidate's current Party
     */
    public String getParty()
    {
        return party;
    }




    /**
     * getMoney allows access to the Candidate's money value
     * @return the candidate's current money value
     */
    public double getMoney()
    {
	if(money <= 0.0)
	{
		money = 0.00;
		return money;
	}
	else
	{
        	return money;
	}
    }

    /**
     *addMoney is a method for adding money to the Candidate current money value
     * @param newMoney is value that will be added to Candidate's money
     */
    public void addMoney(double newMoney)
    {
        money += newMoney;
    }

    /**
     * endorse is a method for Candidate to endorse something
     * @return String value containing his name
     */
    public boolean endorse(Advertisement advert)
    {
        if(adPreference.equals(advert.getType()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

	/**
	 * simpleAI is a method which changes the candidate's Ad and Fundraiser preferences
	 * if the candidate is too far behind in the race and it is before day 305
	 * @param cands is an ArrayList of ArrayLists which hold the candidates sorted by party
	 */
	public void simpleAI(ArrayList<ArrayList<Candidate>> cands)
	{
		for(ArrayList<Candidate> curr: cands)
		{
			for(int x = 0; x < curr.size(); x++)
			{
				if(curr.get(x).getMoney() < curr.get(0).getMoney()/100)
				{
						curr.get(x).setFundrasingprefer();
						curr.get(x).setAdpreference();
				}
			}
		}
	}

	/**
	 * simpleAI2 is a method which changes the candidate's Ad and Fundraiser preferences
	 * if the candidate is too far behind in the race and it is after day 305
	 * @param cands is an ArrayList which holds the remaining candidates
	 */
	public void simpleAI2(ArrayList<Candidate> cands)
	{
		for(Candidate curr: cands)
		{

			if(curr.getMoney() < cands.get(0).getMoney()/100)
			{
				curr.setFundrasingprefer();
				curr.setAdpreference();

			}
		}
	}
}
