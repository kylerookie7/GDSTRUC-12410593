// array linked list practice main

public class Main {
    public static void main(String[] args) {
        PlayerLinkedList playerList = new PlayerLinkedList();

        playerList.addToFront(new Player(1, "keeeeeeenji", 999));
        playerList.addToFront(new Player(2, "Denji", 900));
        playerList.addToFront(new Player(3, "Makima", 950));
        playerList.printList();

        System.out.println("\nBefore adding a new player: ");
        playerList.printList();

        System.out.println("\nAfter adding a new player:");
        playerList.addToFront(new Player(4, "Power", 750));
        playerList.printList();

        System.out.println("\nList size: " + playerList.size());

        System.out.println("\nRemoving first element...");
        playerList.removeFirst();
        playerList.printList();
        System.out.println("\nList size after removal: " + playerList.size());

        System.out.println("\nContains Makima? " + playerList.contains(new Player(3, "Makima", 950)));
        System.out.println("Contains Aki? " + playerList.contains(new Player(5, "Aki", 800)));

        System.out.println("\nIndex of Denji: " + playerList.indexOf(new Player(2, "Denji", 900)));
        System.out.println("Index of Power: " + playerList.indexOf(new Player(4, "Power", 750)));
    }
}
