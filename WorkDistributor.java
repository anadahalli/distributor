/*
 * WorkDistributor.java
 *
 * Distribute the given the work into pieces each of chunk size among the given no of machines as equally as possible
 *
 * Algorithm: 
 *
 * 		Step1: Create a List with size noOfMachines and initialize it to zero
 *
 * 		Step2: totalChunks <- totalSize / chunkSize
 *
 * 		Step3: while totalChunks > 0
 * 					for i <- 0 to noOfMachines
 * 						if totalChunks > 0
 * 							List(i)++
 * 							totalChunks--
 *
 * 				(here we end up with a list of distribution ratio for the chunks.
 * 				 all we need to do now is assign he numbers based on the ratio)
 *
 * 		Step4: replace the list with actual distribution numbers
 *
 * 		Step5: add reamaining numbers to the end of list
 *
 * Author: Ashwath Nadahalli
 *
 * Date: 17 Nov 2013
 *
 * Usage: java WorkDistributor <totalSize> <chunkSize> <noOfMachines>
 *
 * Input: totalSize(Integer), chunkSize(Integer), noOfMachines(Integer)
 *
 * Output: List(Distribution of work)
 *
 */

import java.util.*;

public class WorkDistributor {

	public static void main(String[] args) {

		try {
			
			// check for number of arguments
			if (args.length != 3)
				throw new IllegalArgumentException();

			// read from arguments
			int totalSize = Integer.parseInt(args[0]);
			int chunkSize = Integer.parseInt(args[1]);
			int noOfMachines = Integer.parseInt(args[2]);

			// check sanity of arguments
			if (totalSize == 0 || chunkSize == 0 || noOfMachines == 0)
				throw new IllegalArgumentException();

			// call Split function
			System.out.print(Split(totalSize, chunkSize, noOfMachines));

		} catch (IllegalArgumentException e) {

			System.err.println("All the three arguments must be integers and greater than 0");
			System.exit(1);
		}
	}

	// Split function
	// args: totalSize, chunkSize, noOfMachines
	// returns: List(distribution)
	static List<Integer> Split(int totalSize, int chunkSize, int noOfMachines) {

		// initialize the list
		List<Integer> result = new ArrayList<Integer>();
		
		// total chunks
		int totalChunks = totalSize / chunkSize;

		// add 0 x noOfMachines to list
		for (int i = 0; i < noOfMachines; i++)
			result.add(i, 0);

		// main logic to compute the distribution
		while (totalChunks > 0) {

			// iterate through the list and increase the distribution till totalChunks becomes 0
			for (int i = 0; i < noOfMachines; i++) {

				// only if totalChunks > 0
				if (totalChunks > 0) {
					result.set(i, result.get(i) + 1);
					totalChunks--;
				}
			}
		}

		// current chunk
		int cur = 0;

		// assign the chunk numbers based on distribution ratio
		for (int i = 0; i < noOfMachines; i++) {

			cur += (chunkSize * result.get(i)); 
			result.set(i, cur);
		}

		// add 0 to the start of list
		result.add(0, 0);

		// add remaining numbers to the last machine
		if (cur < totalSize) {

			result.set((result.size() - 1), totalSize);
		}

		// return the result list
		return result; 
	}
}
