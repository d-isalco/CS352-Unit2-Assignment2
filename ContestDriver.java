import java.util.LinkedList;
import java.util.Random;

public class ContestDriver {

	public static void main(String[] args) {
		System.out.println("Starting Simulation");

		// Step -1 Compile the program as is to be sure it runs
		// Step 0 - Uncomment the two lines below, then add code to the Contestant class to make this compile
		//This creates a single Contestant and prints its attributes, just to show it can be done
		
		// Step 2
		// Create multiple Contestants and add them to an ArrayList
		// Do something simple to get started, but remember, you will need
		// to generate up to 1,000,000 Contestants	
        int numberOfContestants = 10;
        int[] roundCounts = {10, 100, 1000, 10000};

		System.out.printf(
            "%12s %12s %16s%n",
            "Contestants", "Rounds", "Time (seconds)"
        );

		// Run a separate test for each round count.
		for (int numberOfRounds : roundCounts) {

            // Start each test with new contestants and fresh statistics.
            LinkedList<Contestant> contestantList = new LinkedList<>();

            for (int i = 0; i < numberOfContestants; i++) {
                contestantList.add(
                    new Contestant("Contestant " + (i + 1), 25)
                );
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

		// A fixed seed makes the coin flips repeatable.
            Random random = new Random(12345);

            long startTime = System.nanoTime();
		
			// Actually perform the requested number of rounds.
            for (int round = 0; round < numberOfRounds; round++) {

                // Preserve the order at the beginning of this round.
                LinkedList<Contestant> startingOrder =
                    new LinkedList<>(contestantList);

                for (int i = 0; i < startingOrder.size(); i++) {
                    Contestant currentContestant =
                        startingOrder.get(i);

                    boolean correctCoinFlip = random.nextBoolean();

                    contestantList.remove(currentContestant);

                    if (correctCoinFlip) {
                        contestantList.add(0, currentContestant);
                    } else {
                        contestantList.add(currentContestant);
                    }
                }

                // Record each contestant's position after this round.
                for (int i = 0; i < contestantList.size(); i++) {
                    contestantList.get(i).recordPosition(i);
                }
            }

            long endTime = System.nanoTime();

            double elapsedTimeInSeconds =
                (endTime - startTime) / 1_000_000_000.0;

            System.out.printf(
                "%12d %12d %16.6f%n",
                numberOfContestants,
                numberOfRounds,
                elapsedTimeInSeconds
            );
        }

		System.out.println("Finished");
	}

}
