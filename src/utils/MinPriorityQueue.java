package utils;
import java.util.*;

public class MinPriorityQueue<T extends Comparable<T>> {
    // has to run with O(log2N)
    /**

    // Linked List structure (singly or doubly linked link)

     * Creates an empty queue.
     */
     int pointer;
     ArrayList heap;
     int size;
    public MinPriorityQueue() {
       pointer = 0; // Keeps track of the next available index
       heap = new ArrayList();
       
        // Compare between parent and child node, if the child one is greater, switch the two keys
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        // TODO implement this method
        return 0;
    }
    /**
     * Adds elem to the queue.
     */
    public void add(T elem) {
        // TODO implement this method
        // increment the pointer
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
    public T remove() {
      // returns the smallest element, and remove it from the queue
        // TODO implement this method
        // return the smallest element
        // Remove it, take the bottom right node and put it at the top
        // After that, compare the two children nodes,

        // Decrement the pointer
        return null;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO implement this method
        return false;
    }

}
