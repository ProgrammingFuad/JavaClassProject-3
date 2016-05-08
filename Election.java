/**
 * The Election class is used to simulate a presidential election
 * An election has all Candidates, and title- it used this information to determine the winner of the presidential run.
 * The candidates is an Arraylist of all Candidates
 * The title is the name of the election that's being conducted
 * @author Josiah Burkhardsmeier
 * @author Elvin Gateri
 * @author Fuad Mohamoud
 */
import java.util.*;
public class Election
{
    private String title = "DEFAULT";
    private ArrayList<Candidate> candidates= new ArrayList<Candidate>();
    private Random rand = new Random();

    /**
     *toString is used to display the winner of a given election.
     * @return output string declareWinner the winner of the election
     */
    public String toString()
    {
        String output="The winner of the "+ getTitle() +" election is "+ declareWinner();
        return output;
    }




    /**
     *Full parameter constructor to build a election using teh inputed parameter values provided
     * @param inTitle will be used as the title of the election
     * @param candidates will be used as candidate list
     */
    public Election(String inTitle,ArrayList<Candidate> candidates)
    {
        setTitle(inTitle);
        setCandidates(candidates);
    }

    /**
     *setTitle Updates the Election's title
     * @param inTitle value that will become the new Title
     */
    public void setTitle(String inTitle)
    {
        title = inTitle;
    }



    /**
     *getTitle allows access the Title of the election
     * @return the election's current Title
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * setCandidates updates the candidate's going the election process
     * @param electionCandidate candidate that's being added to list of candidate's in the election
     */
    public void setCandidates(ArrayList<Candidate> electionCandidate)
    {
        for (Candidate candidate: electionCandidate)
        {
            candidates.add(candidate);
        }
    }

    /**
     *getcandidates allows access to the Candidate ArrayList
     * @return ArrayList of candidate in the election
     */
    public ArrayList<Candidate> getCandidates()
    {
        return candidates;
    }


    /**
     *declareWinner is method used to determine the winner of the election
     * @return the winner of the election
     */
    public String declareWinner()
    {

        Candidate winner = candidates.get(0);
        for (int x = 1; x < candidates.size(); x++)
        {
            if (winner.getMoney() < candidates.get(x).getMoney())
            {
                winner = candidates.get(x);
            }
            else if (winner.getMoney() == candidates.get(x).getMoney())
            {
                if(rand.nextInt(2) == 1)
                {
                    winner = candidates.get(x);
                }
            }

        }

        return winner.getName();
    }

}
