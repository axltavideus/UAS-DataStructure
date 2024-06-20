package networkGraph;

import java.util.*;

public class Graph {
    private Map<Integer, user> userMap;
    private Map<user, List<user>> adjacencyList;

    // Constructor
    public Graph() {
        this.userMap = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    public void adduser(user user) {
        userMap.put(user.getId(), user);
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    public void addFriendship(user user1, user user2) {
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);
    }

    public void removeuser(user user) {
        adjacencyList.values().forEach(e -> e.remove(user));
        adjacencyList.remove(user);
        userMap.remove(user.getId());
    }

    public void removeFriendship(user user1, user user2) {
        List<user> friendsOfuser1 = adjacencyList.get(user1);
        List<user> friendsOfuser2 = adjacencyList.get(user2);
        if (friendsOfuser1 != null) friendsOfuser1.remove(user2);
        if (friendsOfuser2 != null) friendsOfuser2.remove(user1);
    }

    public user getUserById(int id) {
        return userMap.get(id);
    }

    public user getUserByName(String name) {
        for (user u : userMap.values()) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }

    public List<user> shortestPath(user start, user end) {
        if (!adjacencyList.containsKey(start) || !adjacencyList.containsKey(end)) {
            return null;
        }
        
        Map<user, user> predecessors = new HashMap<>();
        Queue<user> queue = new LinkedList<>();
        Set<user> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            user current = queue.poll();
            if (current.equals(end)) {
                return constructPath(predecessors, start, end);
            }
            for (user neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    predecessors.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }

    private List<user> constructPath(Map<user, user> predecessors, user start, user end) {
        LinkedList<user> path = new LinkedList<>();
        user step = end;
        while (step != null) {
            path.addFirst(step);
            step = predecessors.get(step);
        }
        if (path.getFirst().equals(start)) {
            return path;
        }
        return null;
    }

    public List<List<user>> connectedComponents() {
        List<List<user>> components = new ArrayList<>();
        Set<user> visited = new HashSet<>();

        for (user u : adjacencyList.keySet()) {
            if (!visited.contains(u)) {
                List<user> component = new ArrayList<>();
                dfs(u, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    private void dfs(user u, Set<user> visited, List<user> component) {
        visited.add(u);
        component.add(u);
        for (user neighbor : adjacencyList.get(u)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, component);
            }
        }
    }

    public List<user> suggestFriends(user user) {
        List<user> suggestions = new ArrayList<>();
        Set<user> friends = new HashSet<>(adjacencyList.get(user));

        for (user friend : friends) {
            for (user friendOfFriend : adjacencyList.get(friend)) {
                if (!friendOfFriend.equals(user) && !friends.contains(friendOfFriend)) {
                    suggestions.add(friendOfFriend);
                }
            }
        }
        return suggestions;
    }

    public void printAdjacencyList() {
        for (Map.Entry<user, List<user>> entry : adjacencyList.entrySet()) {
            user u = entry.getKey();
            List<user> friends = entry.getValue();
            System.out.print("-" + u + ": ");
            for (user friend : friends) {
                System.out.print(friend + " ");
            }
            System.out.println();
            System.out.println();
        }
    }
}
