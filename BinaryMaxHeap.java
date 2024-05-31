import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Sarthak Goyal
 */

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * This class is used to implement a Binary max heap and its respective operations.
 * 
 * @author Erin Parker, Sarthak Goyal and Vignesh Iyer.
 * @version April 3, 2019
 */

public class BinaryMaxHeap<E> implements PriorityQueue<E> {
	
	private E[] arr;
	private int size;
	private Comparator<? super E> cmp;
	
	/**
	 * Constructors
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap() {
		cmp = null;
		this.size = 0;
		arr = (E[]) new Object[15];		
	}
	
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(Comparator<? super E> comptor) {
		cmp = comptor;
		this.size = 0;
		arr = (E[]) new Object[15];	
	}
	
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> list) {
		this.size = 0;
		arr = (E[]) new Object[15];
		buildHeap(list);
	}
	
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> cmp) {
		this.cmp = cmp;
		this.size = 0;
		arr = (E[]) new Object[15];
		buildHeap(list);
	}

	/**
	 * Adds the given item to this priority queue.
	 * O(1) in the average case, O(log N) in the worst case
	 * 
	 * @param item
	 */
	@Override
	public void add(E item) {
		if(size == arr.length - 1) {
			this.resize(arr.length * 2 + 1);
		}
		
		arr[++size] = item;		
		percolateUp(size);
	}
	
	/*
	 * Helper method to resize the array
	 */
	private void resize(int size) {
		@SuppressWarnings("unchecked")
		E[] arr2 = (E[]) new Object[size];
		for(int i = 1; i <= this.size; i++) {
			arr2[i] = this.arr[i];
		}
		this.arr = arr2;
	}

	/**
	 * Returns, but does not remove, the maximum item this priority queue.
	 * O(1)
	 * 
	 * @return the maximum item
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	@Override
	public E peek() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("Elements non existent");
		}
		E maxItem = arr[1];
		return maxItem;
	}

	/**
	 * Returns and removes the maximum item this priority queue.
	 * O(log N)
	 * 
	 * @return the maximum item
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	@Override
	public E extractMax() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("Elements non existent");
		}
		E maxTemp = arr[1];
		arr[1] = arr[size];
		size--;
		percolateDown(1);
		return maxTemp;
	}

	/**
	 * Returns the number of items in this priority queue.
	 * O(1)
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if this priority queue is empty, false otherwise.
	 * O(1)
	 */
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Empties this priority queue of items.
	 * O(1)
	 */
	@Override
	public void clear() {
		size = 0;
		arr = null;
	}

	/** 
	 * Creates and returns an array of the items in this priority queue,
	 * in the same order they appear in the backing array.
	 * O(N)
	 * 
	 * (NOTE: This method is needed for grading purposes. The root item 
	 * must be stored at index 0 in the returned array, regardless of 
	 * whether it is in stored there in the backing array.) 
	 */
	@Override
	public Object[] toArray() {
		Object[] toArr = new Object[size];
		for(int i = 1; i <= size; i++) {
			toArr[i-1] = this.arr[i];
		}
		return toArr;
	}
	
	/**
	 * Helper method that percolates up the Binary Max Heap
	 */
	public void percolateUp(int n) {
		int parentIdx = n/2;
	    int currentIdx = n;
	    while (currentIdx > 0 && innerCompare(arr[parentIdx], arr[currentIdx]) < 0) {
	    	E temp = arr[currentIdx];
	    	arr[currentIdx] = arr[parentIdx];
	    	arr[parentIdx] = temp;
	    	currentIdx = parentIdx;
	    	parentIdx = parentIdx/2;
	     }
	}
	
	/**
	 * Helper method that percolates down the Binary Max Heap.
	 */
	//https://www.cs.wcupa.edu/rkline/ds/heaps.html
	public void percolateDown(int n) {		
		int child;
		E tmp = arr[n];
		int hole;

		for(hole = n; hole *2 <= size; hole = child ) {
			child = hole * 2;
			if( child != size && innerCompare(arr[child+1], arr[child]) > 0) {
					child++;
			}
			if( innerCompare(arr[child], tmp) > 0) {
				arr[hole] = arr[child];
			} 
			else {
				break;
			}
		}
		arr[hole] = tmp;
	}
	
	/**
	 * Builds the heap for that constructor.
	 */
	public void buildHeap(List<? extends E> list) { 
		for (int i = 0; i < list.size(); i++) {
			 this.add(arr[i+1] = list.get(i));
	      }
	}

	/**
	 * 
	 * @param left the left child
	 * @param right the right child
	 * @return the comparator or the comparable.
	 */
	@SuppressWarnings({ "unchecked" })
	private int innerCompare(E left, E right) {
		if(left == null || right == null) {
			return 0;
		}
		if(cmp == null) {
			return ((Comparable<? super E>) left).compareTo(right); 
		}	
		return cmp.compare(left, right); //Comparator
	}

}
