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
        int position = size;
        heap[position] = value;

        // While position is not at the top,
        // compare it with child nodes.
        while( position > 0){
          int parent = (position + 1) / 2 - 1;
          // If heap[parent] is the smallest, break the while loop
          if(heap[parent] <= heap[position]) break;
          swap(parent, position);
          position = parent;
        }
        size ++;
    }

    private void swapIndex(arr, int i, int j){
      T temp = heap[i];
      heap[i] = heap[j];
      heap[j] = temp;
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
    public T remove() {
      // returns the smallest element, and remove it from the queue
        // return the smallest element
        // Remove it, take the bottom right node and put it at the top
        // After that, compare the two children nodes,

        // If empty, throw an exception
        if(isEmpty()) throw new IllegalStateException();
        int min_value = heap[0];
        // Move end of array to the beginning
        heap[0] = heap[size-1];
        int position = 0;

        // Example of tree structure for the priority queue
        // Parent -> Child, Children
        // 0      -> 1,     2
        // 1      -> 3,     4
        // 2      -> 5,     6

        // Children are multiple 2 away from the parent
        while(position > size / 2){
          int left_child_index = position * 2 + 1; // look at the above example
          int right_child_index = left_child_index + 1;
          // If right child exists and is less than left child,
          // swap it with parent node
          if (right_child_index < size && heap[left_child_index] > heap[right_child_index]){
            if(heap[position] <= heap[right_child_index]) break;
            swapIndex(position, right_child_index);
            position = right_child_index;
          }else{
            // If the left child is less than parent, swap it.
            if(heap[position] <= heap[left_child_index]) break;
            swapIndex(position, left_child_index);
            position = left_child_index;
          }
        }

        size--;
        return min_value;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }

}
