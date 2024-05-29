package networkGraph;

import java.util.*;

public class Graph {
    private Map<user, List<user>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void adduser(user user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    public void addFriendship(user user1, user user2) {
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);
    }

    public void removeuser(user user) {
        adjacencyList.values().forEach(e -> e.remove(user));
        adjacencyList.remove(user);
    }

    public void removeFriendship(user user1, user user2) {
        List<user> friendsOfuser1 = adjacencyList.get(user1);
        List<user> friendsOfuser2 = adjacencyList.get(user2);
        if (friendsOfuser1 != null) friendsOfuser1.remove(user2);
        if (friendsOfuser2 != null) friendsOfuser2.remove(user1);
    }

    public List<user> shortestPath(user start, user end) {
        // Implement BFS or Dijkstra's algorithm
        return new ArrayList<>(); // Placeholder
    }

    public List<List<user>> connectedComponents() {
        // Implement connected components algorithm
        return new ArrayList<>(); // Placeholder
    }

    public List<user> suggestFriends(user user) {
        // Implement friend suggestion logic
        return new ArrayList<>(); // Placeholder
    }

    
}
