package org.example;
import java.util.*;

public class PrimGraph {
    private final Map<Integer, List<Edge>> adjacencyList;

    public PrimGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    public List<Edge> prim(int start) {
        List<Edge> mst = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        visited.add(start);
        priorityQueue.addAll(adjacencyList.get(start));

        while (!priorityQueue.isEmpty() && visited.size() < adjacencyList.size()) {
            Edge edge = priorityQueue.poll();

            if (!visited.contains(edge.destination)) {
                visited.add(edge.destination);
                mst.add(edge);

                for (Edge neighbor : adjacencyList.get(edge.destination)) {
                    if (!visited.contains(neighbor.destination)) {
                        priorityQueue.add(neighbor);
                    }
                }
            }
        }
        return mst;
    }

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("Edge to node %d with weight %d", destination, weight);
        }
    }

    public static void main(String[] args) {
        PrimGraph graph = new PrimGraph();
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        int startNode = 0;
        List<Edge> mst = graph.prim(startNode);

        System.out.println("Minimum Spanning Tree starting from node " + startNode + ":");
        for (Edge edge : mst) {
            System.out.println(edge);
        }
    }
}
