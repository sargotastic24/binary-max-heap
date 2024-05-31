import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * This class is used to test max heap and its respective operations.
 * 
 * @author Sarthak Goyal
 */

class BinaryMaxHeapTesting {

	@Test
	void addFirst() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(100);
		assertEquals(heap.size(), 1);
	}
	
	@Test
	void addMultipleItems() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(4);
		heap.add(3);
		heap.add(5);
		heap.add(2);
		heap.add(1);
		assertEquals(heap.size(), 5);
	}
	
	
	@Test
	void addMultipleItemsRandom() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(4);
		heap.add(2);
		heap.add(3);
		heap.add(1);
		assertEquals(heap.size(), 4);
	}
	
	@Test
	void peek() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		int a = heap.peek();
		assertEquals(a, 4);
	}
	
	@Test
	void extractMaxSmall() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		heap.extractMax();
		heap.add(0);
		assertEquals(heap.size(), 4);
	}
	
	@Test
	void extractMaxMedium() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(20);
		heap.add(19);
		heap.add(17);
		heap.add(15);
		heap.add(14);
		heap.add(10);
		heap.add(6);
		heap.add(5);
		heap.extractMax();
		assertEquals(heap.size(), 7);
	}
	
	@Test
	void extractMaxMediumStrings() {
		BinaryMaxHeap<String> heap = new BinaryMaxHeap<>();
		heap.add("z");
		heap.add("a");
		heap.add("x");
		heap.add("c");
		heap.add("b");
		heap.add("y");
		heap.extractMax();
		assertEquals(heap.size(), 5);
	}
	
	@Test
	void size() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		assertEquals(heap.size(), 4);
	}
	
	@Test
	void isEmptyFalse() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		assertFalse(heap.isEmpty());
	}
	
	@Test
	void isEmptyTrue() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		assertTrue(heap.isEmpty());
	}

	@Test
	void clear() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		heap.clear();
		assertTrue(heap.isEmpty());
	}
	
	@Test
	void addPercolate() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(4);
		heap.add(1);
		heap.add(3);
		heap.add(2);
		Object[] a = heap.toArray();
		Object[] b = new Object[] {4,2,3,1};
		assertArrayEquals(a, b);
	}
	
	@Test
	void addPercolateMed() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(11);
		heap.add(9);
		heap.add(7);
		heap.add(6);
		heap.add(10);
		Object[] a = heap.toArray();
		Object[] b = new Object[] {11,10,7,6,9};
		assertArrayEquals(a, b);
	}
	
	@Test
	void addPercolateResize() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(11);
		heap.add(9);
		heap.add(7);
		heap.add(6);
		heap.add(10);
		heap.add(14);
		heap.add(18);
		heap.add(19);
		heap.add(60);
		heap.add(100);
		heap.add(111);
		heap.add(91);
		heap.add(72);
		heap.add(67);
		heap.add(150);
		heap.add(31);
		heap.add(76);
		assertEquals(heap.size(), 17);
	}

	

	

	
	
	
//**********************************************************************************************************************************************
//															FindKLargest
//**********************************************************************************************************************************************	
	


	
	
	@Test
	void kLargestComparable() {
		List<Integer> lst = new ArrayList<>();
		List<Integer> lst2 = new ArrayList<>();
		lst.add(11);
		lst.add(9);
		lst.add(7);
		lst.add(6);
		lst.add(10);
		
		lst2.add(11);
		lst2.add(10);
		
		assertEquals(FindKLargest.findKLargestHeap(lst,2),lst2);
	}
	
	@Test
	void kLargestComparableString() {
		List<String> lst = new ArrayList<>();
		List<String> lst2 = new ArrayList<>();
		lst.add("d");
		lst.add("f");
		lst.add("g");
		lst.add("a");
		lst.add("b");
		lst.add("c");
		
		lst2.add("g");
		lst2.add("f");
		
		assertEquals(FindKLargest.findKLargestHeap(lst,2),lst2);
	}
	
	@Test
	void kLargestComparator() {
		List<Integer> lst = new ArrayList<>();
		List<Integer> lst2 = new ArrayList<>();
		lst.add(11);
		lst.add(9);
		lst.add(7);
		lst.add(6);
		lst.add(10);
		
		lst2.add(11);
		lst2.add(10);
		
		cmpTestIntegers b = new cmpTestIntegers();
		assertEquals(FindKLargest.findKLargestHeap(lst,2,b),lst2);
	}
	
	@Test
	void kLargestComparatorString() {
		List<String> lst = new ArrayList<>();
		List<String> lst2 = new ArrayList<>();
		lst.add("d");
		lst.add("f");
		lst.add("g");
		lst.add("a");
		lst.add("b");
		lst.add("c");
		
		lst2.add("g");
		lst2.add("f");
		
		cmpTestStrings b = new cmpTestStrings();
		assertEquals(FindKLargest.findKLargestHeap(lst,2,b),lst2);
	}
	
	@Test
	void kLargestSort() {
		List<Integer> lst = new ArrayList<>();
		List<Integer> lst2 = new ArrayList<>();
		lst.add(9);
		lst.add(10);
		lst.add(7);
		lst.add(11);
		lst.add(14);
		
		lst2.add(14);
		lst2.add(11);
		assertEquals(FindKLargest.findKLargestSort(lst,2),lst2);
	}
	
	@Test
	void kLargestSortStrings() {
		List<String> lst = new ArrayList<>();
		List<String> lst2 = new ArrayList<>();
		lst.add("d");
		lst.add("f");
		lst.add("g");
		lst.add("a");
		lst.add("b");
		lst.add("c");
		
		lst2.add("g");
		lst2.add("f");
		assertEquals(FindKLargest.findKLargestSort(lst,2),lst2);
	}
	
	@Test
	void kLargestSortComparator() {
		List<Integer> lst = new ArrayList<>();
		List<Integer> lst2 = new ArrayList<>();
		lst.add(9);
		lst.add(10);
		lst.add(7);
		lst.add(11);
		lst.add(14);
		lst.add(15);
		lst.add(17);
		lst.add(34);
		
		lst2.add(34);
		lst2.add(17);
		
		cmpTestIntegers b = new cmpTestIntegers();
		assertEquals(FindKLargest.findKLargestSort(lst,2,b),lst2);
	}
	
	@Test
	void kLargestSortComparatorString() {
		List<String> lst = new ArrayList<>();
		List<String> lst2 = new ArrayList<>();
		lst.add("d");
		lst.add("f");
		lst.add("g");
		lst.add("a");
		lst.add("b");
		
		lst2.add("g");
		lst2.add("f");
		
		cmpTestStrings b = new cmpTestStrings();
		assertEquals(FindKLargest.findKLargestSort(lst,2,b),lst2);
	}

	/**
	 *  Comparator method for Integers
	 */
	private class cmpTestIntegers implements Comparator<Integer>{
		public int compare(Integer a1, Integer a2) {
			return a1.compareTo(a2);
		}
	}
	
	/**
	 *	Comparator method for String
	 */
	private class cmpTestStrings implements Comparator<String>{
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}
	}
}
