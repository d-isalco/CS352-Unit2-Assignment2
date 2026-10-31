import java.util.ArrayList;

public class ContestDriver {

	public static void main(String[] args) {
		System.out.println("Starting Simulation");

		// Step -1 Compile the program as is to be sure it runs
		// Step 0 - Uncomment the two lines below, then add code to the Contestant class to make this compile
		//This creates a single Contestant and prints its attributes, just to show it can be done
		//Contestant ac = new Contestant("Billy",22);
		//System.out.println(ac);
		
		// Step 2
		// Create multiple Contestants and add them to an ArrayList
		// Do something simple to get started, but remember, you will need
		// to generate up to 1,000,000 Contestants	
		int numberOfContestants = 10;

		ArrayList<Contestant> contestants = new ArrayList<>();
			// Create Contestants and add them to the ArrayList
			for (int i=0; i < numberOfContestants; i++){
				Contestant contestant = new Contestant("Player " + (i+1), 48);
				contestants.add(contestant);
			}
			
			// Print out the Contestants to verify they were created and added to the ArrayList
			for (Contestant contestant : contestants){
				System.out.println(contestant);
			}	

		// Steps 3 and 4
		// Play a round
		// For each Contestant, flip a coin, then move the Contestant to
		// one end of the ArrayList or the other.
		
		
		// Steps 5 - 7
		// Repeat Steps 3 and 4 many times to gather data.
		// You will need to modify the Contestant class so each Contestant
		// will keep track of its individual statistics. Be smart about how you record its
		// position at the end of each round.
		System.out.println("Finished");
	}

}
