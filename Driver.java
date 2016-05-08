/**
 * This is the Driver class for this assignment. It will run the program
 * and meet all requirements of the out of lab 2
 * @author Josiah Burkhardsmeier
 * @author Elvin Gateri
 * @author Fuad Mohamoud
 */

import java.util.*;
import java.io.*;

public class Driver {
	/**
	 * This is the main method for the Driver class. Within it our code
	 * will be tested to meet the assignments requirements
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		for(int o = 0; o < 10; o++)
			{
			Random rand = new Random();
			File cList = new File("Candidate.txt");
			Scanner cScanner = new Scanner(cList);

			// Create an array of type Candidate
			ArrayList<Candidate> candidates = new ArrayList<Candidate>();

			//Read input file and parse the data, then add into the Arraylist
			int cCounter = 0;
			while (cScanner.hasNext()) {
				String line = cScanner.nextLine();
				String[] token = line.split("1");
				candidates.add(new Candidate(token[0], token[1], token[2]));

				cCounter++;

			}
			cScanner.close();


			//Makes a List of Parties, ignoring duplicates


			ArrayList<String> partys = new ArrayList<String>();

			for (int x = 0; x < candidates.size(); x++) {
				int counter = 0;
				for (int y = 0; y < partys.size(); y++) {

					if (candidates.get(x).getParty().equals(partys.get(y))) {
						counter++;
					} else {
					}
				}
				if (counter == 0) {
					partys.add(candidates.get(x).getParty());
				}

			}


			File lList = new File("location.txt");
			Scanner lScanner = new Scanner(lList);

			//create an location arraylist of String
			ArrayList<String> locations = new ArrayList<String>();

			// read file and add line to the location array
			while (lScanner.hasNext()) {
				locations.add(lScanner.next());
			}

			lScanner.close();


			//Starting from day 1, until day 365
			for (int x = 1; x <= 305; x++)
			{
				System.out.println("\n----------------------------------- DAY " + x + " -----------------------------------\n");

				for (Candidate current : candidates) 
				{
					if (x < 250) {
						int action = (rand.nextInt(100) + 1);
						if (action <= 30) {
							String lc = locations.get(rand.nextInt(locations.size()));

							if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
								Fundraiser fund = new PhoneFundraiser(lc, current);
								System.out.println(fund + "\n");
							}
							if (current.getFundraisingprefer() instanceof SocialFundraiser) {
								Fundraiser fund = new SocialFundraiser(lc, current);
								System.out.println(fund + "\n");
							}
							if (current.getFundraisingprefer() instanceof PACFundraiser) {
								try {
									Fundraiser fund = new PACFundraiser(lc, current, candidates);
									System.out.println(fund + "\n");
								} catch (TooLowInPollsException e) {
									System.err.println(e.getMessage());
									int t = rand.nextInt(2);
									if (t == 0) {
										Fundraiser fund = new PhoneFundraiser(lc, current);
										System.out.println(fund + "\n");
									} else {
										Fundraiser fund = new SocialFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
								}
							}


						} else {
							int randAd = rand.nextInt(3);

							if (randAd == 0) {
								try {
									TownHallAdvertisement ad = new TownHallAdvertisement(current);
									String output = ad.runAd();
									System.out.println(output);
									System.out.println(ad + "\n");
								} catch (OutOfMoneyException a) {
									System.err.println(a.getMessage());
									String lc = locations.get(rand.nextInt(locations.size()));

									if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
										Fundraiser fund = new PhoneFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof SocialFundraiser) {
										Fundraiser fund = new SocialFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof PACFundraiser) {
										try {
											Fundraiser fund = new PACFundraiser(lc, current, candidates);
											System.out.println(fund + "\n");
										} catch (TooLowInPollsException e) {
											System.err.println(e.getMessage());
											int t = rand.nextInt(2);
											if (t == 0) {
												Fundraiser fund = new PhoneFundraiser(lc, current);
												System.out.println(fund + "\n");
											} else {
												Fundraiser fund = new SocialFundraiser(lc, current);
												System.out.println(fund + "\n");
											}
										}
									}

								}
							} else if (randAd == 1) {
								try {
									AttackAdvertisement ad = new AttackAdvertisement(current, candidates);
									String output = ad.runAd();
									System.out.println(output);
									System.out.println(ad + "\n");
								} catch (OutOfMoneyException a) {
									System.err.println(a.getMessage());
									String lc = locations.get(rand.nextInt(locations.size()));

									if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
										Fundraiser fund = new PhoneFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof SocialFundraiser) {
										Fundraiser fund = new SocialFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof PACFundraiser) {
										try {
											Fundraiser fund = new PACFundraiser(lc, current, candidates);
											System.out.println(fund + "\n");
										} catch (TooLowInPollsException e) {
											System.err.println(e.getMessage());
											int t = rand.nextInt(2);
											if (t == 0) {
												Fundraiser fund = new PhoneFundraiser(lc, current);
												System.out.println(fund + "\n");
											} else {
												Fundraiser fund = new SocialFundraiser(lc, current);
												System.out.println(fund + "\n");
											}
										}
									}

								}
							} else {
								try {
									IssueBasedAdvertisement ad = new IssueBasedAdvertisement(current);
									String output = ad.runAd();
									System.out.println(output);
									System.out.println(ad + "\n");
								} catch (OutOfMoneyException a) {
									System.err.println(a.getMessage());
									String lc = locations.get(rand.nextInt(locations.size()));

									if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
										Fundraiser fund = new PhoneFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof SocialFundraiser) {
										Fundraiser fund = new SocialFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof PACFundraiser) {
										try {
											Fundraiser fund = new PACFundraiser(lc, current, candidates);
											System.out.println(fund + "\n");
										} catch (TooLowInPollsException e) {
											System.err.println(e.getMessage());
											int t = rand.nextInt(2);
											if (t == 0) {
												Fundraiser fund = new PhoneFundraiser(lc, current);
												System.out.println(fund + "\n");
											} else {
												Fundraiser fund = new SocialFundraiser(lc, current);
												System.out.println(fund + "\n");
											}
										}
									}

								}
							}
						}
					}
					else
					{

						int action = (rand.nextInt(100) + 1);
						if (action <= 60) {
							String lc = locations.get(rand.nextInt(locations.size()));

							if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
								Fundraiser fund = new PhoneFundraiser(lc, current);
								System.out.println(fund + "\n");
							}
							if (current.getFundraisingprefer() instanceof SocialFundraiser) {
								Fundraiser fund = new SocialFundraiser(lc, current);
								System.out.println(fund + "\n");
							}
							if (current.getFundraisingprefer() instanceof PACFundraiser) {
								try {
									Fundraiser fund = new PACFundraiser(lc, current, candidates);
									System.out.println(fund + "\n");
								} catch (TooLowInPollsException e) {
									System.err.println(e.getMessage());
									int t = rand.nextInt(2);
									if (t == 0) {
										Fundraiser fund = new PhoneFundraiser(lc, current);
										System.out.println(fund + "\n");
									} else {
										Fundraiser fund = new SocialFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
								}
							}


						} else {
							int randAd = rand.nextInt(3);

							if (randAd == 0) {
								try {
									TownHallAdvertisement ad = new TownHallAdvertisement(current);
									String output = ad.runAd();
									System.out.println(output);
									System.out.println(ad + "\n");
								} catch (OutOfMoneyException a) {
									System.err.println(a.getMessage());
									String lc = locations.get(rand.nextInt(locations.size()));

									if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
										Fundraiser fund = new PhoneFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof SocialFundraiser) {
										Fundraiser fund = new SocialFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof PACFundraiser) {
										try {

											Fundraiser fund = new PACFundraiser(lc, current, candidates);
											System.out.println(fund + "\n");
										} catch (TooLowInPollsException e) {
											System.err.println(e.getMessage());
											int t = rand.nextInt(2);
											if (t == 0) {
												Fundraiser fund = new PhoneFundraiser(lc, current);
												System.out.println(fund + "\n");
											} else {
												Fundraiser fund = new SocialFundraiser(lc, current);
												System.out.println(fund + "\n");
											}
										}
									}

								}
							} else if (randAd == 1) {
								try {
									AttackAdvertisement ad = new AttackAdvertisement(current, candidates);
									String output = ad.runAd();
									System.out.println(output);
									System.out.println(ad + "\n");
								} catch (OutOfMoneyException a) {
									System.err.println(a.getMessage());
									String lc = locations.get(rand.nextInt(locations.size()));

									if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
										Fundraiser fund = new PhoneFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof SocialFundraiser) {
										Fundraiser fund = new SocialFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof PACFundraiser) {
										try {
											Fundraiser fund = new PACFundraiser(lc, current, candidates);
											System.out.println(fund + "\n");
										} catch (TooLowInPollsException e) {
											System.err.println(e.getMessage());
											int t = rand.nextInt(2);
											if (t == 0) {
												Fundraiser fund = new PhoneFundraiser(lc, current);
												System.out.println(fund + "\n");
											} else {
												Fundraiser fund = new SocialFundraiser(lc, current);
												System.out.println(fund + "\n");
											}
										}
									}

								}
							} else {
								try {
									IssueBasedAdvertisement ad = new IssueBasedAdvertisement(current);
									String output = ad.runAd();
									System.out.println(output);
									System.out.println(ad + "\n");
								} catch (OutOfMoneyException a) {
									System.err.println(a.getMessage());
									String lc = locations.get(rand.nextInt(locations.size()));

									if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
										Fundraiser fund = new PhoneFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof SocialFundraiser) {
										Fundraiser fund = new SocialFundraiser(lc, current);
										System.out.println(fund + "\n");
									}
									if (current.getFundraisingprefer() instanceof PACFundraiser) {
										try {
											Fundraiser fund = new PACFundraiser(lc, current, candidates);
											System.out.println(fund + "\n");
										} catch (TooLowInPollsException e) {
											System.err.println(e.getMessage());
											int t = rand.nextInt(2);
											if (t == 0) {
												Fundraiser fund = new PhoneFundraiser(lc, current);
												System.out.println(fund + "\n");
											} else {
												Fundraiser fund = new SocialFundraiser(lc, current);
												System.out.println(fund + "\n");
											}
										}
									}

								}
							}
						}
					}
					ArrayList<Candidate> otherCands = new ArrayList<Candidate>();
					for (Candidate cur : candidates)
					{
						otherCands.add(cur);

					}

					ArrayList<ArrayList<Candidate>> newArray = new ArrayList<ArrayList<Candidate>>();

					listofList(otherCands, newArray);
					current.simpleAI(newArray);
				}

				if (x % 10 == 0 && x < 305)
				{
					System.out.println("\n------------------------- DEBATES -------------------------\n");

					//Compares possible partys from partys array against all candidates one by one
					// Adds candidates that match partys element being searched by to PARTY array
					//Creates a different list that has a debate amongst all same party 7 times
					for (int c = 0; c < partys.size(); c++) {
						String lc = locations.get(rand.nextInt(locations.size()));
						ArrayList<Candidate> party = new ArrayList<Candidate>();
						for (int y = 0; y < candidates.size(); y++) {
							if (partys.get(c).equals(candidates.get(y).getParty())) {
								party.add(candidates.get(y));
							}
						}

						//Code is correctly setup to try the exception even before day 305
						//UNLESS all of the debate’s candidates are from the same political party
						String overloading1 = "Overloading";
						Debate debate = new Debate(lc, party, overloading1);

						String output = debate.declareWinner();
						System.out.println(debate);
						System.out.println(output + "\n");

					}

				}


				//candidates = sort(candidates);
				Collections.sort(candidates);
				Collections.reverse(candidates);


				System.out.println("\n-------------------- DAILY MONEY SUMMARY --------------------\n");
				for (Candidate current : candidates)
				{
					System.out.println(current + "\n");
				}
			}

			ArrayList<Candidate> otherCands = new ArrayList<Candidate>();
			for (Candidate current : candidates) {
				otherCands.add(current);
			}

			ArrayList<ArrayList<Candidate>> newArray = new ArrayList<ArrayList<Candidate>>();

			listofList(otherCands, newArray);

			for (ArrayList<Candidate> c: newArray)
			{
				int q = c.size();
				for(int count=1; count < q;count++)
				{
						c.get(0).addMoney(c.get(1).getMoney());
						c.remove(1);
				}
			}


			for(int x=306; x<=365; x++)
			{
				System.out.println("\n----------------------------------- DAY " + x + " -----------------------------------\n");
				ArrayList<Candidate> temp = new ArrayList<Candidate>();
				for(int r = 0; r < newArray.size(); r++)
				{
					for (Candidate p : newArray.get(r))
					{
						temp.add(p);
					}
				}
				for(int y = 0; y < newArray.size(); y++)
				{
					for(Candidate current: newArray.get(y))
					{

							int action = (rand.nextInt(100) + 1);
							if (action <= 60) {
								String lc = locations.get(rand.nextInt(locations.size()));

								if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
									Fundraiser fund = new PhoneFundraiser(lc, current);
									System.out.println(fund + "\n");
								}
								if (current.getFundraisingprefer() instanceof SocialFundraiser) {
									Fundraiser fund = new SocialFundraiser(lc, current);
									System.out.println(fund + "\n");
								}
								if (current.getFundraisingprefer() instanceof PACFundraiser) {
									try {
										Fundraiser fund = new PACFundraiser(lc, current, candidates);
										System.out.println(fund + "\n");
									} catch (TooLowInPollsException e) {
										System.err.println(e.getMessage());
										int t = rand.nextInt(2);
										if (t == 0) {
											Fundraiser fund = new PhoneFundraiser(lc, current);
											System.out.println(fund + "\n");
										} else {
											Fundraiser fund = new SocialFundraiser(lc, current);
											System.out.println(fund + "\n");
										}
									}
								}


							} else {
								int randAd = rand.nextInt(3);

								if (randAd == 0) {
									try {
										TownHallAdvertisement ad = new TownHallAdvertisement(current);
										String output = ad.runAd();
										System.out.println(output);
										System.out.println(ad + "\n");
									} catch (OutOfMoneyException a) {
										System.err.println(a.getMessage());
										String lc = locations.get(rand.nextInt(locations.size()));

										if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
											Fundraiser fund = new PhoneFundraiser(lc, current);
											System.out.println(fund + "\n");
										}
										if (current.getFundraisingprefer() instanceof SocialFundraiser) {
											Fundraiser fund = new SocialFundraiser(lc, current);
											System.out.println(fund + "\n");
										}
										if (current.getFundraisingprefer() instanceof PACFundraiser) {
											try {

												Fundraiser fund = new PACFundraiser(lc, current, candidates);
												System.out.println(fund + "\n");
											} catch (TooLowInPollsException e) {
												System.err.println(e.getMessage());
												int t = rand.nextInt(2);
												if (t == 0) {
													Fundraiser fund = new PhoneFundraiser(lc, current);
													System.out.println(fund + "\n");
												} else {
													Fundraiser fund = new SocialFundraiser(lc, current);
													System.out.println(fund + "\n");
												}
											}
										}

									}
								} else if (randAd == 1) {
									try {
										AttackAdvertisement ad = new AttackAdvertisement(current, candidates);
										String output = ad.runAd();
										System.out.println(output);
										System.out.println(ad + "\n");
									} catch (OutOfMoneyException a) {
										System.err.println(a.getMessage());
										String lc = locations.get(rand.nextInt(locations.size()));

										if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
											Fundraiser fund = new PhoneFundraiser(lc, current);
											System.out.println(fund + "\n");
										}
										if (current.getFundraisingprefer() instanceof SocialFundraiser) {
											Fundraiser fund = new SocialFundraiser(lc, current);
											System.out.println(fund + "\n");
										}
										if (current.getFundraisingprefer() instanceof PACFundraiser) {
											try {
												Fundraiser fund = new PACFundraiser(lc, current, candidates);
												System.out.println(fund + "\n");
											} catch (TooLowInPollsException e) {
												System.err.println(e.getMessage());
												int t = rand.nextInt(2);
												if (t == 0) {
													Fundraiser fund = new PhoneFundraiser(lc, current);
													System.out.println(fund + "\n");
												} else {
													Fundraiser fund = new SocialFundraiser(lc, current);
													System.out.println(fund + "\n");
												}
											}
										}

									}
								} else {
									try {
										IssueBasedAdvertisement ad = new IssueBasedAdvertisement(current);
										String output = ad.runAd();
										System.out.println(output);
										System.out.println(ad + "\n");
									} catch (OutOfMoneyException a) {
										System.err.println(a.getMessage());
										String lc = locations.get(rand.nextInt(locations.size()));

										if (current.getFundraisingprefer() instanceof PhoneFundraiser) {
											Fundraiser fund = new PhoneFundraiser(lc, current);
											System.out.println(fund + "\n");
										}
										if (current.getFundraisingprefer() instanceof SocialFundraiser) {
											Fundraiser fund = new SocialFundraiser(lc, current);
											System.out.println(fund + "\n");
										}
										if (current.getFundraisingprefer() instanceof PACFundraiser) {
											try {
												Fundraiser fund = new PACFundraiser(lc, current, candidates);
												System.out.println(fund + "\n");
											} catch (TooLowInPollsException e) {
												System.err.println(e.getMessage());
												int t = rand.nextInt(2);
												if (t == 0) {
													Fundraiser fund = new PhoneFundraiser(lc, current);
													System.out.println(fund + "\n");
												} else {
													Fundraiser fund = new SocialFundraiser(lc, current);
													System.out.println(fund + "\n");
												}
											}
										}

									}
								}
							}
						Collections.sort(temp);
						Collections.reverse(temp);
						current.simpleAI2(temp);
					}
				}

				if (x % 10 == 0)
				{
					System.out.println("\n------------------------- DEBATES -------------------------\n");
					String lc = locations.get(rand.nextInt(locations.size()));

					try {
						Debate debate = new Debate(lc, temp);
						String output = debate.declareWinner();
						System.out.println(debate);
						System.out.println(output + "\n");

					} catch (TooLowInPollsException e) {
						System.err.println(e.getMessage());

						int totalMoney = 0;
						ArrayList<Candidate> debCands = new ArrayList<Candidate>();
						for (Candidate curren : temp) {
							debCands.add(curren);
						}
						for (Candidate curren : debCands) {
							totalMoney += curren.getMoney();

						}

						for (int t = 0; t < debCands.size(); t++) {

							if (debCands.get(t).getMoney() < (3.0 / 100) * totalMoney) {
								debCands.remove(t);
							}
						}
						String overloading2 = "Overloading";
						Debate debate2 = new Debate(lc, debCands, overloading2);

						String output = debate2.declareWinner();
						System.out.println(debate2);
						System.out.println(output + "\n");

					}


				}

				Collections.sort(temp);
				Collections.reverse(temp);

				System.out.println("\n-------------------- DAILY MONEY SUMMARY --------------------\n");
				for(Candidate curre: temp)
				{
					System.out.println(curre + "\n");
				}

			}
			Election election = new Election("President of the United States of America", candidates);
			System.out.println(election);
		}


	}


	// Recursive lists of lists
	public static void listofList(ArrayList<Candidate> Cands, ArrayList<ArrayList<Candidate>> newArray)
	{

		if (Cands.size() != 0)
		{
			Candidate temp = Cands.remove(0);

			boolean updated = false;

			for (int y = 0; y < newArray.size(); y++)
			{

					if (temp.getParty().equals(newArray.get(y).get(0).getParty()))
					{
						newArray.get(y).add(temp);

						ArrayList<Candidate> tempL = newArray.get(y);
						newArray.remove(y);
						newArray.add(y, sort(tempL));

						updated = true;
						//solve(Cands, newArray, partys);
						//break;
					}

			}

				if (!updated) {
					newArray.add(new ArrayList<Candidate>());
					newArray.get(newArray.size()-1).add(temp);
				}
			listofList(Cands,newArray);


		}




	}

	public static ArrayList<Candidate> sort(ArrayList<Candidate> candidates)
	{
		Candidate temp = null;

		int z = candidates.size();

		for(int x = 0; x < z; x++)
		{
			temp = candidates.get(x);
			for (int y=x; y < z; y++)
			{
				if(temp.getMoney() < candidates.get(y).getMoney())
				{
					temp = candidates.get(y);
					//System.out.println("found new higher");
				}
				else if(temp.getMoney() == candidates.get(y).getMoney())
				{
					if(temp.getName().compareTo(candidates.get(y).getName()) < 0)
					{
						temp = candidates.get(y);
					}
					else
					{
					}
				}
				else
				{
				}
			}
			candidates.remove(temp);
			candidates.add(x,temp);
		}
		//System.out.println(candidates);
		return candidates;
	}




}


