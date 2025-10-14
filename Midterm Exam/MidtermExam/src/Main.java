import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        CardStack playerDeck = new CardStack();
        CardStack playerHand = new CardStack();
        CardStack discardPile = new CardStack();

        // Fill deck with 30 random cards (duplicates allowed)
        String[] cardNames = {
                "Basketball Card", "Football Card", "Goku Card", "Naruto Card", "Kaiji Card",
                "Saitama Card", "Luffy Card", "Baseball Card", "Hockey Card", "Soccer Card"
        };

        for (int i = 0; i < 30; i++) {
            String randomCard = cardNames[random.nextInt(cardNames.length)];
            playerDeck.push(new Card(randomCard));
        }

        System.out.println("=== GAME START ===\n");

        // Continue until deck is empty
        while (!playerDeck.isEmpty()) {
            int command = random.nextInt(3); // 0 = Draw, 1 = Discard, 2 = Get from Discard

            System.out.println("------ NEW TURN ------");
            if (command == 0) {
                int drawCount = random.nextInt(5) + 1; // 1–5 cards
                System.out.println("Command: Draw " + drawCount + " cards");

                for (int i = 0; i < drawCount && !playerDeck.isEmpty(); i++) {
                    Card drawn = playerDeck.pop();
                    playerHand.push(drawn);
                    System.out.println("You drew: " + drawn);
                }

            } else if (command == 1) {
                int discardCount = random.nextInt(3) + 1; // 1–3 cards
                System.out.println("Command: Discard " + discardCount + " cards");

                for (int i = 0; i < discardCount && !playerHand.isEmpty(); i++) {
                    Card discarded = playerHand.pop();
                    discardPile.push(discarded);
                    System.out.println("You discarded: " + discarded);
                }

            } else if (command == 2) {
                int getCount = random.nextInt(2) + 1; // 1–2 cards
                System.out.println("Command: Get " + getCount + " cards from discard pile");

                for (int i = 0; i < getCount && !discardPile.isEmpty(); i++) {
                    Card retrieved = discardPile.pop();
                    playerHand.push(retrieved);
                    System.out.println("You retrieved: " + retrieved);
                }
            }

            // Show info after each round
            System.out.println("\n--- STATUS ---");
            System.out.println("Cards in hand: " + playerHand.size());
            System.out.println("Cards left in deck: " + playerDeck.size());
            System.out.println("Cards in discard pile: " + discardPile.size());
            System.out.println("----------------------\n");

            System.out.print("Press ENTER to continue...");
            scanner.nextLine();
        }

        System.out.println("\n=== GAME OVER ===");
        System.out.println("The player deck is empty!");

        System.out.println();
        playerHand.printStack("Final Player Hand");
        discardPile.printStack("Final Discard Pile");
    }
}

