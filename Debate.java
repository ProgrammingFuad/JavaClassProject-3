/**
 * The Debate class is used to simulate a Political Debate
 * The Debate has a location, and two ArrayList of candidates
 * Location is used to determine the location of the debate, due to changed an methods in the Class we used two arraylists of Candidate .
 * @author Fuad Mohamoud
 */
import java.util.ArrayList;
import java.util.Random;
public class Debate
{
    private String location = "DEFAULT";
    private Random rand = new Random();
    private ArrayList<Candidate> candidates= new ArrayList<Candidate>(); 

	public Debate()
	{
	}


    /**
     *toString() is a method used to output a message when Debate output is called. Displays a message with the location, and candidate's in the debate
     * @return output String with specific information about the Debate
     */
    public String toString()
    {
        String output="The location of the debate is " + getLocation() + "\n\tCandidates attending this debate are:" + debateCands(candidates);
        return output;
    }

    /**
     *setCandidates updated candidates arraylist with candidate of the debate
     * @param debateCandidate candidate that will be added to the arraylist
     */
    public void setCandidates(ArrayList<Candidate> debateCandidate)
    {
        for (Candidate candidate: debateCandidate)
        {
            candidates.add(candidate);
        }
    }

    /**
     *getcandidates allows access to the candidate array list 
     * @return the Debate's current arraylist of Candidates
     */
    public ArrayList<Candidate> getCandidates()
    {
        return candidates;
    }


    /**
     *Full parameter Constructor to build a debate using the inputed  parameter value provided
     * @param inLoc will used as the Debate's location
     * @param cands  will be Candidate 1 in the Debate
     * @throws TooLowInPollsException is thrown when 
     */
    public Debate(String inLoc, ArrayList<Candidate> cands) throws TooLowInPollsException
    {
		int totalMoney = 0;
		for(Candidate current: cands)
		{
			totalMoney += current.getMoney();
		}
		for(Candidate current: cands)
		{

			if(current.getMoney() < (3.0/100)*totalMoney)
			{
				throw new TooLowInPollsException();
			}
		}
        setLocation(inLoc);  
        setCandidates(cands);

    }

	/**
	 * Second Full parameter Constructor to ran without an Exception
	 * @param inLoc Value that will become the location of the debate
	 * @param cands Arraylist of Candidates in a given political party
	 * @param party value i created to allow me to do overloading
         */
	public Debate(String inLoc, ArrayList<Candidate> cands, String party)
	{
		 setLocation(inLoc);
		 setCandidates(cands);
		 String unusedvariable=party; //overloading never actually used in the code.
	}

    /**
     *setLocation updates  the Debate location
     * @param inLoc is the String that will become the new location
     */
    public void setLocation(String inLoc)
    {
        location = inLoc;
    }

    /**
     *getLocation allows access to the Debate's location
     * @return the Debate's location
     */
    public String getLocation()
    {
        return location;
    }





    /**
     *declareWinner is a method to randomly determine the winner of the debate
     * @return string declaring the candidate that won the debate, 
     * if the array size is 1 it don't determine a winner, if the array size is 0, we dont determine winner and return a message instead.
     */
    public String declareWinner()
    {
	if(candidates.size() == 1)
	{
		return "Only one Candidate showed up.";
	}
	else if (candidates.size() == 0)
	{
		return "No one showed up for the debate";
	}
	else
	{
		for (int i=0; i < candidates.size(); i++)
		{
		    int candPoints = rand.nextInt(101);
		    double debate_Score= candPoints*candidates.get(i).getDebateMod();
		    candidates.get(i).setDebscore(debate_Score);
		}

		double totalScore=0;

		Candidate winner = candidates.get(0);
		for (int x = 0; x < candidates.size(); x++)
		{
			totalScore+=candidates.get(x).getDebscore();
			if (winner.getDebscore() < candidates.get(x).getDebscore())
			{
				winner = candidates.get(x);
			}
			else if (winner.getDebscore() == candidates.get(x).getDebscore())
			{
				if(rand.nextInt(2) == 1)
				{
					winner = candidates.get(x);
				}
			}
		}
		String losingCand="";
		double MoneyWon=0.0;
		double total=0.0;
		for (int x = 0; x < candidates.size(); x++)
		{

		    if (!(winner.equals( candidates.get(x))))
		    {
			if(totalScore == 0)
			{
				System.out.println("\nTOTAL SCORE == 0\n");
				losingCand = losingCand + candidates.get(x).getName() + " lost $" +  String.format("%.2f",MoneyWon) + "\n\t";
			}
			else
			{
				MoneyWon =  candidates.get(x).getMoney()*(totalScore-
				        candidates.get(x).getDebscore())/ totalScore;
				total += MoneyWon;


				losingCand = losingCand + candidates.get(x).getName() + " lost $" +  String.format("%.2f",MoneyWon) + "\n\t";

				candidates.get(x).addMoney(-MoneyWon);
			}

		    }


		}
		winner.addMoney(total);
		return winner.getName() +" won the debate!!!\n\nLosing Candidates:\n\t" + losingCand ;
	}



    }


    /**
     *debateCands is a method used to get the candidate's name from the arraylist
     * @param Arraylist of Candidates that were getting name from 
     * @return the Debate's location
     */
    public String debateCands(ArrayList<Candidate> candidates)
    {
        String output="";
        for (Candidate current: candidates)
        {
            output += "\n\t\t" + current.getName();
        }
        return output;
    }

}
