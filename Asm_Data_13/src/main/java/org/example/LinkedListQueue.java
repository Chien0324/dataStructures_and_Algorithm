package org.example;

public class LinkedListQueue {
    private class Node {
        int data;
        Node next;
        public Node(int data) { this.data = data; this.next = null; }
    }

    private Node front, rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int item = front.data;
        front = front.next;
        if (front == null) rear = null; // Queue is empty now
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue contents: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // Output: Queue contents: 10 20 30

        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 10
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display(); // Output: Queue contents: 20 30 40 50

        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 20
        queue.enqueue(60);
        queue.display(); // Output: Queue contents: 30 40 50 60
    }
}
