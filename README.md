# Presidental Election Project


This was my third project of the Spring 2016 Semester and I learned a TON of new programming concepts. 
I learned what data structures were and used a simple sort, implemented a recursive method, and succesfully implemented a class
with only the java api as a resource-- The Comparable Class--. This project also taught me how to analyze data and find out why the program output was the way it was. This project was not done on my own, but through a collaboration of 
3 great minds who are noted as authors in the program as well. Below are the list of requirements the program must adhere by in order to get a perfect score on the project.




RULES UPDATE SECTION:
After Day 305’s events happen, remove all but the top Candidate in each party. All money from removed candidates should now go to the candidate from their party with the most money. This will be how we handle Party Primaries wrapping up. If there is a tie, the Candidate with the name closer to “A” will win.
Debates will now house all remaining candidates who have enough money to be allowed in, so only 1 debate is possible per Debate Day.

RECURSION SECTION: You must include a driver method which uses recursion to build a List of Lists (can uses arrays, ArrayLists, or any other 1D list structure in java). This List of Lists should be configured so that there is a list of Candidate Lists, where the sub-lists only contain Candidates from the same party. The Candidates within a sub list should be ordered from Candidate with the least money to the Candidate with the most money.

SORTING SECTION: 2 sorts will be used in OoL #3
You must create a new method using one of the 5 sorting algorithms we discuss in class for sorting a list of Candidates from least money to most money (if tie, use candidates’ name as a tie breaker). This method should be used by EXACLTY 1 of the following locations:
The Recursive method
The End of a Day Candidate Update
You must correctly implement the Comparable interface with Candidate so you can use the
Collections.sort to sort candidates from least money to most money (if tie, use candidates’ name as a tie breaker). This sort must be used in whichever location you DID NOT use the sort you wrote for the first part of this section.
      
ANALYSIS SECTION: Run your code enough times for each of the below scenarios to get a feel for how the current rules work and answer the below questions (include your definitions of Many and Few as well as number of runs and final result data which led you to make your claims): NOTE, you may want to include advert and fundraising preferences as part of you file input so you can better control what candidates end up preferring what. This should section should be included in your TLDDR.
Given MANY parties and FEW candidates per party:
What Advert/Fundraising strategies seem to work best? Why do you think so?What Advert/Fundraising strategies seem to work worst? Why do you think so?
Given MANY parties and MANY candidates per party:
What Advert/Fundraising strategies seem to work best? Why do you think so?What Advert/Fundraising strategies seem to work worst? Why do you think so?
Given FEW parties and FEW candidates per party:
What Advert/Fundraising strategies seem to work best? Why do you think so?What Advert/Fundraising strategies seem to work worst? Why do you think so?
Given FEW parties and MANY candidates per party:
What Advert/Fundraising strategies seem to work best? Why do you think so?What Advert/Fundraising strategies seem to work worst? Why do you think so?
If everyone uses your “best” Advert/Fundraising strategy, what tends to happen? Why do you think so?
If everyone uses your “worst” Advert/Fundraising strategy, what tends to happen? Why do you think so?
If a Candidate switches from your “best” Advert/Fundraising strategy to your “worst” Advert/Fundraising strategy half way through the initial 305 days, what tends to happen? Why do you think so?
If a Candidate switches from your “worst” Advert/Fundraising strategy to your “best” Advert/Fundraising strategy half way through the initial 305 days, what tends to happen? Why do you think so?
SIMPLE AI SECTION: Based on what you learned in the Analysis Section, add a new method to each Candidate which should be run after each “day”. This method should evaluate where the Candidate is in the polls (i.e., money compared to: their party’s leader before Day 305 or to the overall leader after Day 305) and randomly adjust the Candidates Advert/Fundraising preferences if they are a certain percentage behind.
ANALYSIS II SECTION: Run your code enough times for each of the below scenarios to get a feel for how the current rules work and answer the below questions (include your number of runs and final result data which led you to make your claims): NOTE, you may want to include advert and fundraising preferences as part of you file input so you can better control what candidates end up preferring what. This should section should be included in your TLDDR.
Given MANY parties and FEW candidates per party do the Simple AI changes make the races more or less competitive? Why do you think so?
Given MANY parties and MANY candidates per party do the Simple AI changes make the races more or less competitive? Why do you think so?
     
Given FEW parties and FEW candidates per party do the Simple AI changes make the races more or less competitive? Why do you think so?
Given FEW parties and MANY candidates per party do the Simple AI changes make the races more or less competitive? Why do you think so?

RESULTS SECTION: The goal of this section is play with the rules of the system in order to reliably produce the below situations. Include your definition of “Close”, what rules you needed to get the best results and data generated by your program to support you claims. NOTE: I’m not expecting perfection, just good attempts and sufficient trials/effort. This should section should be included in your TLDDR.
Close “Primaries” with MANY candidates per party
Close “Primaries” with FEW candidates per party
Close “Primaries” with regardless of number of candidates per party
Close “Election” with all party winners starting Day 306 fairly close moneywise
Close “Election” with all party winners starting Day 306 are NOT close moneywise
Close “Election” with 2 party winners starting Day 306 very close in money, but the other parties
(at least 1 other party candidate) with significantly less money than the main 2.
Best emulation of a “normal” US Presidential Election:
Many parties
2 parties will end the “Primaries” with a large lead over the other parties. These 2
parties will have:
1 party with a close Primary
1 party WITHOUT a close Primary
Winner is from one of the 2 parties which had a large lead over the other parties
