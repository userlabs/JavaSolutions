/*
 * Given a set e.g. [1,2,3] write a function which will output all the sub-sets [[],[1],[2],[3],[1,2],[2,3],[3,1],[1,2,3]]
 * The algorithm should be generic for any size of the input set.
 */

package org.nayars.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class FindSubsets {

	// example input
	static Set<Integer> input= new HashSet<Integer>();
	static {
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4); 
		input.add(5);
		input.add(6);
	}

	
	static List<List<Integer>> getSuperSets(Set<Integer> set) {

		// list of lists representing all subsets
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			// get the next element e in the input set
			Integer e = it.next();
			
			// create a temporary output list of lists
			List<List<Integer>> tempOutput = new ArrayList<List<Integer>>();
			Iterator<List<Integer>> itOutput = output.iterator();
			// iterate through all current subsets in output
			while(itOutput.hasNext()) {
				List<Integer> outputList = itOutput.next();
				// create a new subset = existing subset in output + e
				List<Integer> newList = new ArrayList<Integer>();
				newList.addAll(outputList);
				newList.add(e);
				// add the subset to tempOutput
				// note you cannot modify a list(output) directly
				// when iterating it
				tempOutput.add(newList);
			}
			System.out.println("1 "+output);
			// add the element e in a separate subset and add to tempOutput
			// we could have added it directly to output too
			List<Integer> eList = new ArrayList<Integer>();
			eList.add(e);
			tempOutput.add(eList);
//			System.out.println(tempOutput);
			
			// append all tempOutput subsets to output
			output.addAll(tempOutput);
			System.out.println("2 "+output);
		}
		
		return output;
	}
	
	public static void main( String [] args) {

		List<List<Integer>> output = getSuperSets(input);
		output.add(new ArrayList<Integer>());
		
		System.out.println(output.size()+" "+output);
	}
}
