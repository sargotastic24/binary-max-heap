import java.util.ArrayList;

/**
 * This class is used to time Binary max heap and its respective operations.
 * 
 * @author Sarthak Goyal
 */

public class BinaryMaxHeapTiming {

	public static void main(String[] args) {
		  // Do 10000 lookups and use the average running time.
	 int timesToLoop = 500;
	 
	 ArrayList<Integer> a = new ArrayList<>();
	 for(int i = 1002; i > 0; i--) {
		 a.add(i);
	 }
	    
	    // For each problem size n . . .
	    for (int n = 100; n <= 1000; n += 100) {
	      long startTime, midpointTime, stopTime;
	     
	     BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
	     
	     for(int i = 1001; i > 0; i--) {
			 heap.add(i);
		 }
	     
	      startTime = System.nanoTime();
	      while (System.nanoTime() - startTime < 1000000000) { // empty block 
	      }
	      
	      // Now, run the test.  
	      startTime = System.nanoTime();
	     
	      /*for(int i = 0; i < n; i++) {               //add
	    	  heap.add(i);
		   }*/
	      
	    /*  for(int i = 0; i < n; i++) {				//extract max
	    	  heap.extractMax();  
	      }*/
	      
	      /*for(int i = 0; i < n; i++) {					//peek
	    	  heap.peek();
	      }*/
	      
	      /*for(int i = 0; i < n; i++) {
	    	  FindKLargest.findKLargestHeap(a, 10);
	      }*/
	      
	    /*  for(int i = 0; i < n; i++) {
	    	  FindKLargest.findKLargestSort(a, 3);
	      }*/
	
	      midpointTime = System.nanoTime();

	      for(int i = 0; i < 1; i++) {				//empty loop to account for the "for loop" runtime.
	    		
	    	}
	      stopTime = System.nanoTime();

	      // Compute the time, subtract the cost of running the loop
	      // from the cost of running the loop and doing the lookups.
	      // Average it over the number of runs.
	      double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
	          / timesToLoop;

	      System.out.println(n + "\t" + averageTime);
	  }

	}
}
