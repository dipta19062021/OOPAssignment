package service;

import adtInterface.Queue;
public class OperatorService<T> implements Queue<T> {
    private java.util.LinkedList<T> queue = new java.util.LinkedList<T>();

    @Override
    public void enqueue(T element) {
        queue.addLast(element);
        System.out.println("Ticket generated for customer " + element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("No customers in the queue");
            return null;
        } else {
            T removedCustomer = queue.removeFirst();
            System.out.println("Customer serviced and removed from the queue");
            return removedCustomer;
        }
    }

    private boolean isEmpty() {
        return queue.isEmpty();
    }
}