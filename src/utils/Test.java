package utils;
import java.util.*;
import utils.MinPriorityQueue;

public class Test{
  public static void main(String[] args) {
    MinPriorityQueue<Integer> queue = new MinPriorityQueue<Integer>();
     queue.add(5);
     queue.add(4);
     queue.add(7);
     queue.add(9);
     queue.add(2);
     queue.add(1);
     queue.add(0);
     queue.print_queue();
     queue.remove();
     queue.print_queue();
  }
}
