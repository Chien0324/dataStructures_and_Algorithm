package org.example;
import java.util.*;

public class DijkstraGraph {
    private final Map<Integer, List<Edge>> adjacencyList;

    public DijkstraGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight)); // if it's an undirected graph
    }

    public Map<Integer, Integer> dijkstra(int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE); // Start with "infinity"
        }
        distances.put(start, 0); // Distance to start node is 0

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        priorityQueue.add(new Edge(start, 0));

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            int currentNode = currentEdge.destination;

            for (Edge neighbor : adjacencyList.getOrDefault(currentNode, Collections.emptyList())) {
                int newDist = distances.get(currentNode) + neighbor.weight;
                if (newDist < distances.get(neighbor.destination)) {
                    distances.put(neighbor.destination, newDist);
                    priorityQueue.add(new Edge(neighbor.destination, newDist));
                }
            }
        }

        return distances;
    }

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        DijkstraGraph graph = new DijkstraGraph();
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);

        int startNode = 0;
        Map<Integer, Integer> distances = graph.dijkstra(startNode);

        System.out.println("Shortest distances from node " + startNode + ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("Node " + entry.getKey() + " - Distance: " + entry.getValue());
        }
    }
}
