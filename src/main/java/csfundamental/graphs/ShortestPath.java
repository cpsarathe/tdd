package csfundamental.graphs;

import java.util.*;

public class ShortestPath {

    public static void main(String[] ar) {
        Graph graph = new Graph();
        Vertex zero = new Vertex("0",0);
        graph.addVertex(zero);
        Vertex one = new Vertex("1",1);
        graph.addVertex(one);
        Vertex two = new Vertex("2",2);
        graph.addVertex(two);
        Vertex three = new Vertex("3",3);
        graph.addVertex(three);
        Vertex four = new Vertex("4",4);
        graph.addVertex(four);
        Vertex five = new Vertex("5",5);
        graph.addVertex(five);
        Vertex six = new Vertex("6",6);
        graph.addVertex(six);
        Vertex seven = new Vertex("7",7);
        graph.addVertex(seven);
        Vertex eight = new Vertex("8",8);
        graph.addVertex(eight);

        graph.addEdge(new Edge(zero, one, 4));
        graph.addEdge(new Edge(zero, seven, 8));
        graph.addEdge(new Edge(one, seven, 11));
        graph.addEdge(new Edge(one, two, 8));
        graph.addEdge(new Edge(seven, eight, 7));
        graph.addEdge(new Edge(two, eight, 2));
        graph.addEdge(new Edge(seven, six, 1));
        graph.addEdge(new Edge(eight, six, 6));
        graph.addEdge(new Edge(two, five, 4));
        graph.addEdge(new Edge(six, five, 2));
        graph.addEdge(new Edge(two, three, 7));
        graph.addEdge(new Edge(three, five, 14));
        graph.addEdge(new Edge(three, four, 9));
        graph.addEdge(new Edge(five, four, 10));

        graph.printGraphWithEdges();

        ShortestPath shortestPath = new ShortestPath();
        shortestPath.findShortestPathDjikstra(graph, two, four);

    }

    public void findShortestPathDjikstra(Graph graph, Vertex source, Vertex destination) {
        if (source.name.equals(destination.name)) {
            System.out.println("same source destination");
            return;
        }
        HashSet<Vertex> visitedSet = new HashSet<>();

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        //find all vertices
        Set<Vertex> vertices = graph.adjacencyEdgeMap.keySet();

        //Initially, distance value of source vertex is 0 and INF (infinite) for all other vertices.
        int[] distance = new int[vertices.size()];
        int x = 0;
        for (Vertex v : vertices) {
            distance[x++] = Integer.MAX_VALUE;
        }
        priorityQueue.add(new Edge(null, source, 0));
        distance[source.val] = 0; //source to source distance is always zero


        while (!priorityQueue.isEmpty()) {
            Vertex vertex = priorityQueue.poll().end;
            if (visitedSet.contains(vertex)) {
                continue;
            }
            visitedSet.add(vertex);

            List<Edge> edges = graph.getChildNodes(vertex);
            for (Edge e : edges) {
                Vertex endVertex = e.getEnd();
                int d = e.getDistance();
                if (!visitedSet.contains(endVertex)
                        && distance[vertex.val] + d < distance[endVertex.val]) {
                    distance[endVertex.val] = distance[vertex.val] + d;
                    e.distance = distance[vertex.val] + d;
                    priorityQueue.add(e);
                }
            }
        }
        System.out.println(distance[destination.val]);
    }
}
