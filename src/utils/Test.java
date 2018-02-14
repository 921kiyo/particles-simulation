package utils;

import utils.MinPriorityQueue;

public class Test{
  public static void main(String[] args) {
    System.out.println("hello");
    MinPriorityQueue<Integer> queue = new MinPriorityQueue<Integer>();
    queue.add(2);
    queue.add(1);
    queue.add(4);
    queue.add(5);
//    queue.print_queue();
  }
}
