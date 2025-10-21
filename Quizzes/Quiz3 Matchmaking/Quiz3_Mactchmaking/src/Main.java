import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayQueue playerQueue = new ArrayQueue(50);
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        int totalGames = 0;
        int playerId = 1;

        System.out.println("=== MATCHMAKING SIMULATION START ===\n");

        while (totalGames < 10) {
            System.out.println("Press [ENTER] to start the next turn...");
            scanner.nextLine();

            int newPlayers = rand.nextInt(7) + 1;
            System.out.println("→ " + newPlayers + " players joined the queue!");

            for (int i = 0; i < newPlayers; i++) {
                Player newPlayer = new Player(playerId, "Player_" + playerId, rand.nextInt(100) + 1);
                playerQueue.enqueue(newPlayer);
                playerId++;
            }

            System.out.println("\nCurrent Queue (" + playerQueue.size() + " players):");
            playerQueue.printQueue();

            if (playerQueue.size() >= 5) {
                System.out.println("\n=== GAME " + (totalGames + 1) + " STARTED! ===");
                System.out.println("Matched Players:");

                for (int i = 0; i < 5; i++) {
                    Player matchedPlayer = playerQueue.dequeue();
                    System.out.println(matchedPlayer);
                }

                totalGames++;

                System.out.println("=== GAME " + totalGames + " FINISHED ===");
                System.out.println(totalGames + " out of 10 games successfully made!\n");
            } else {
                System.out.println("\nNot enough players to start a game. Waiting for more...\n");
            }
        }

        System.out.println("You won — 10 GAMES SUCCESSFULLY MADE!");
        scanner.close();
    }
}
