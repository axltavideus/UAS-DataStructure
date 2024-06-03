package networkGraph;

import java.util.List;
import java.util.Scanner;

public class socialNetwork {
    private static Scanner scanner = new Scanner(System.in);
    private static Graph graph = new Graph();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1: adduser(); break;
                case 2: addFriendship(); break;
                case 3: removeuser(); break;
                case 4: removeFriendship(); break;
                case 5: findShortestPath(); break;
                case 6: displayConnectedComponents(); break;
                case 7: suggestFriends(); break;
                case 8: System.exit(0);
                default: System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Add user");
        System.out.println("2. Add Friendship");
        System.out.println("3. Remove user");
        System.out.println("4. Remove Friendship");
        System.out.println("5. Find Shortest Path");
        System.out.println("6. Display Connected Components");
        System.out.println("7. Suggest Friends");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void adduser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user = new user(name, id);
        graph.adduser(user);
        System.out.println("user added: " + user);
    }

    private static void addFriendship() {
        System.out.print("Enter first user id: ");
        int id1 = scanner.nextInt();
        System.out.print("Enter second user id: ");
        int id2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user1 = new user("", id1); // Placeholder name
        user user2 = new user("", id2); // Placeholder name
        graph.addFriendship(user1, user2);
        System.out.println("Friendship added between " + user1 + " and " + user2);
    }

    private static void removeuser() {
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user = new user("", id); // Placeholder name
        graph.removeuser(user);
        System.out.println("user removed: " + user);
    }

    private static void removeFriendship() {
        System.out.print("Enter first user id: ");
        int id1 = scanner.nextInt();
        System.out.print("Enter second user id: ");
        int id2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user1 = new user("", id1); // Placeholder name
        user user2 = new user("", id2); // Placeholder name
        graph.removeFriendship(user1, user2);
        System.out.println("Friendship removed between " + user1 + " and " + user2);
    }

    private static void findShortestPath() {
        System.out.print("Enter start user id: ");
        int startId = scanner.nextInt();
        System.out.print("Enter end user id: ");
        int endId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user startUser = new user("", startId); // Placeholder name
        user endUser = new user("", endId); // Placeholder name
        List<user> path = graph.shortestPath(startUser, endUser);
        if (path != null && !path.isEmpty()) {
            System.out.println("Shortest path: ");
            for (user u : path) {
                System.out.print(u + " ");
            }
            System.out.println();
        } else {
            System.out.println("No path found between " + startUser + " and " + endUser);
        }
    }

    private static void displayConnectedComponents() {
        List<List<user>> components = graph.connectedComponents();
        System.out.println("Connected Components: ");
        for (List<user> component : components) {
            for (user u : component) {
                System.out.print(u + " ");
            }
            System.out.println();
        }
    }

    private static void suggestFriends() {
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user = new user("", id); // Placeholder name
        List<user> suggestions = graph.suggestFriends(user);
        System.out.println("Friend suggestions for " + user + ": ");
        for (user u : suggestions) {
            System.out.println(u);
        }
    }
}
