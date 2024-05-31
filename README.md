# binary-max-heap

Finding K Largest Items in a List

This project explores two approaches for efficiently finding the k largest elements from a list:

1) Binary Max Heap: This data structure provides a fast and efficient way to identify the k largest elements.

2) Java's Sort Method: Although convenient, sorting the entire list might be less efficient for large datasets.
Problem

Given a list of elements, you want to find the k largest ones. This problem is often encountered in various applications, such as finding top-selling products, identifying most frequent words, or selecting highly rated reviews.

Requirements

The project involves implementing several classes:

1) Provided Interface:

- PriorityQueue<E> interface: Defines operations for a priority queue, which your BinaryMaxHeap class will implement. The provided comments specify the expected Big-O behavior of these operations.

2) BinaryMaxHeap Class:

- Create a BinaryMaxHeap<E> class within the assign10 package that implements the PriorityQueue interface. This class represents a binary max heap using a basic array:


Constructors:
   
- public BinaryMaxHeap(): For an empty heap with elements ordered using their natural ordering (E implements Comparable<? super E>).
- public BinaryMaxHeap(Comparator<? super E>): For an empty heap with elements ordered using a provided Comparator.
- public BinaryMaxHeap(List<? extends E>): Constructs a heap from the given list (natural ordering assumed). Uses buildHeap for efficient construction (O(N) time).
- public BinaryMaxHeap(List<? extends E>, Comparator<? super E>): Constructs a heap from the list using a provided Comparator. Employs buildHeap for O(N) construction.

Helper Methods (Strongly Recommended):

- buildHeap: Constructs a heap from a list in O(N) time.
- percolateUp: Maintains heap property by moving an element upwards if necessary.
- percolateDown: Maintains heap property by moving an element downwards if necessary.
- innerCompare: Compares elements using either Comparable or Comparator within the class.

3) FindKLargest Class:

The provided FindKLargest class contains partially implemented methods for finding the k largest items. You'll need to complete these methods.
