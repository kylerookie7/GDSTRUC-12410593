import java.util.NoSuchElementException;

public class ArrayQueue {
    private Player[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Player[capacity];
        front = 0;
        back = 0;
    }

    public void enqueue(Player player) {
        if (back == queue.length) {
            Player[] newQueue = new Player[queue.length * 2];
            System.arraycopy(queue, front, newQueue, 0, size());
            queue = newQueue;
            back = size();
            front = 0;
        }

        queue[back++] = player;
    }

    public Player dequeue() {
        if (size() == 0) {
            return null;
        }

        Player removedPlayer = queue[front];
        queue[front++] = null;

        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return removedPlayer;
    }

    public Player peek() {
        if (size() == 0) {
            return null;
        }

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        if (size() == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
