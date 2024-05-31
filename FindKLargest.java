import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class contains generic static methods for finding the k largest items in a list.
 * 
 * @author Sarthak Goyal
 */
public class FindKLargest {
	
	/**
	 * Determines the k largest items in the given list, using a binary max heap and the 
	 * natural ordering of the items.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E extends Comparable<? super E>> List<E> findKLargestHeap(List<E> items, int k) throws IllegalArgumentException {
		if(k < 0 || k > items.size() - 1) {
			throw new IllegalArgumentException("k is either negative or exceeds the list size");
		}
	
		List<E> kLargest = new ArrayList<>();
		BinaryMaxHeap<E> heap = new BinaryMaxHeap<E>(items);
		for(int i = 0; i < k; i++) {
			kLargest.add(heap.extractMax());
		}
		return kLargest;
	}

	/**
	 * Determines the k largest items in the given list, using a binary max heap.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @param cmp - the comparator defining how to compare items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E> List<E> findKLargestHeap(List<E> items, int k, Comparator<? super E> cmp) throws IllegalArgumentException {
		if(k < 0 || k > items.size() - 1) {
			throw new IllegalArgumentException("k is either negative or exceeds the list size");
		}
		
		List<E> kLargest = new ArrayList<>();
		BinaryMaxHeap<E> heap = new BinaryMaxHeap<E>(items, cmp);
		for(int i = 0; i < k; i++) {
			kLargest.add(heap.extractMax());
		}
		return kLargest;
	}

	/**
	 * Determines the k largest items in the given list, using Java's sort routine and the 
	 * natural ordering of the items.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E extends Comparable<? super E>> List<E> findKLargestSort(List<E> items, int k) throws IllegalArgumentException {
		if(k < 0 || k > items.size() - 1) {
			throw new IllegalArgumentException("k is either negative or exceeds the list size");
		}
		
		int size = 0;
		List<E> KLargestSorted = new ArrayList<>();
		Collections.sort(items);
		size = items.size() - 1;
		
		for(int i = 0; i < k; i++) {
			KLargestSorted.add(items.get(size--));
		}
		return KLargestSorted;
	}

	/**
	 * Determines the k largest items in the given list, using Java's sort routine.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @param cmp - the comparator defining how to compare items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E> List<E> findKLargestSort(List<E> items, int k, Comparator<? super E> cmp) throws IllegalArgumentException {
		if(k < 0 || k > items.size() - 1) {
			throw new IllegalArgumentException("k is either negative or exceeds the list size");
		}
		
		List<E> KLargestSorted = new ArrayList<>();
		int size = items.size() - 1;
		
		Collections.sort(items, cmp);
		
		for(int i = 0; i < k; i++) {
			KLargestSorted.add(items.get(size--));
		}
		return KLargestSorted;
	}
}