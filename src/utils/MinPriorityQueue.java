package utils;

import java.util.*;

/**
* @author Kiyo Kunii and Sagar Doshi
* @param <T>
*/
public class MinPriorityQueue<T extends Comparable<T>> {
    // has to run with O(log2N)
    ArrayList<T> heap;

    public MinPriorityQueue() {
        heap = new ArrayList<T>();
        // Compare between parent and child node, if the child one is greater, switch the two keys
    }

    /**
    * Returns the number of elements currently in the queue
    */
    public int size() {
        return heap.size();
    }

    /**
    * Adds elem to the queue and repositions array
    */
    public void add(T elem) {
        int position = size();
        heap.add(position, elem); // Adds elem to END of queue

        // While position is not at top, compare with child nodes
        while (position > 0) {
            int parent = (position + 1) / 2 - 1;

            // If heap[parent] is the smallest item, break the while loop
            if (heap.get(parent).compareTo(heap.get(position)) <= 0) {
                break;
            }

            // Otherwise, swap parent with child, and reset indices
            swapIndex(parent, position);
            position = parent;
        }
    }

    /**
    * Helper function to change generic items within an array
    */
    private void swapIndex(int i, int j) {
        T temp = (T) heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
    * Removes (and returns) element at top of the queue and repositions queue
    */
    public T remove() {
        // Make sure there's at least one item in queue first
        if (heap.isEmpty()) throw new IllegalStateException();

        // Saves smallest element (that which is at top of queue)
        T min_value = (T) heap.get(0);

        // Move node at end of array (bottom-rightmost of tree) to top
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        int position = 0;

        // Example of tree structure for the priority queue
        // Parent -> heap[leftChild], heap[rightChild]
        // 0      -> 1              , 2
        // 1      -> 3              , 4
        // 2      -> 5              , 6
        // leftChild is (x * 2 + 1) from parent, and rightChild is one further

        // Restructure tree before returning top of queue
        while (position < size() / 2) {
            // Get INDICES of children
            int leftChild = position * 2 + 1;
            int rightChild = leftChild + 1;

            // If right child exists and is < left, consider swap with top
            if (rightChild < size() &&
                heap.get(leftChild).compareTo(heap.get(rightChild)) > 0) {

                // Don't swap with top of queue if top is <= right child
                if (heap.get(position).compareTo(heap.get(rightChild)) <= 0) {
                    break;
                }

                // Otherwise, do swap top of queue with right child
                swapIndex(position, rightChild);
                position = rightChild;

            } else { // Either right child nonexistent or <= to left child
                     // So just perform above check with left child only

                if (heap.get(position).compareTo(heap.get(leftChild)) <= 0) {
                    break; // Don't do anything if top is already smallest
                }

                // Otherwise, if left child is smaller, move to top of queue
                swapIndex(position, leftChild);
                position = leftChild;
            }
        }

        return min_value;
    }

    /**
    * Returns true if the queue is empty, false otherwise.
    */
    public boolean isEmpty() {
        return (size() == 0);
    }

}
