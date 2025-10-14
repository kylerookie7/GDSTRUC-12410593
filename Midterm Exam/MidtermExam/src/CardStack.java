import java.util.LinkedList;
import java.util.ListIterator;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack() {
        stack = new LinkedList<Card>();
    }

    public void push(Card card) {
        stack.push(card);
    }

    public Card pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    public Card peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void printStack(String name) {
        System.out.println(name + " contents:");
        ListIterator<Card> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }
}