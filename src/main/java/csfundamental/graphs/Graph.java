package csfundamental.graphs;

import java.util.*;

public class Graph {

    Map<Vertex, List<Vertex>> adjacencyMap = new HashMap<>();
    Map<Vertex, List<Edge>> adjacencyEdgeMap = new HashMap<>();
    List<Vertex> visitedNodes = new ArrayList<>();

    public static void main(String[] ar) {
        Graph graph = new Graph();
        Vertex Delhi = new Vertex("Delhi",0);
        graph.addVertex(Delhi);
        Vertex Pune = new Vertex("Pune",1);
        graph.addVertex(Pune);
        Vertex Mumbai = new Vertex("Mumbai",2);
        graph.addVertex(Mumbai);
        Vertex Bangalore = new Vertex("Bangalore",3);
        graph.addVertex(Bangalore);
        Vertex Nagpur = new Vertex("Nagpur",4);
        graph.addVertex(Nagpur);
        Vertex Agra = new Vertex("Agra",5);
        graph.addVertex(Agra);
        Vertex Gwalior = new Vertex("Gwalior",6);
        graph.addVertex(Gwalior);

        graph.addEdge(new Edge(Delhi, Agra ,200));
        graph.addEdge(new Edge(Gwalior, Delhi,230));
        graph.addEdge(new Edge(Mumbai, Gwalior,680));
        graph.addEdge(new Edge(Mumbai, Pune,190));
        graph.addEdge(new Edge(Mumbai, Bangalore,800));
        graph.addEdge(new Edge(Pune, Nagpur,600));
        graph.addEdge(new Edge(Gwalior, Agra,500));

        graph.printGraph();

        graph.removeEdge(Mumbai, Gwalior);

        System.out.println("*********************************");
        graph.printGraph();

        System.out.println("*********************************");
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(Mumbai);
        graph.breadthFirstSearch(Mumbai,queue);

        System.out.println("*********************************");
        graph.visitedNodes.clear();
        Stack<Vertex> stack = new Stack<>();
        stack.add(Mumbai);
        graph.depthFirstSearch(Mumbai,stack);

    }

    public void addVertex(Vertex vertex) {
        adjacencyMap.putIfAbsent(vertex, new ArrayList<>());
        adjacencyEdgeMap.putIfAbsent(vertex,new ArrayList<>());
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        if (adjacencyMap.get(vertex1) != null) {
            adjacencyMap.get(vertex1).add(vertex2);
        }
    }

    public void addEdge(Edge edge) {
        if (adjacencyEdgeMap.get(edge.getStart()) == null) {
            List<Edge> edges = new ArrayList<>();
            edges.add(edge);
            adjacencyEdgeMap.put(edge.getStart(),edges);
        } else {
            adjacencyEdgeMap.get(edge.getStart()).add(edge);
        }
    }

    public void removeEdge(Vertex start, Vertex end) {
        removeVertex(start);
        removeVertex(end);
    }

    public void removeVertex(Vertex vertex) {
        if (adjacencyMap.get(vertex) != null) {
            List<Vertex> list = adjacencyMap.get(vertex);
            Vertex temp = null;
            for (Vertex v : list) {
                if (v.equals(vertex)) {
                    temp = vertex;
                }
            }
            list.remove(temp);
        }
    }

    public void printGraph() {
        for (Map.Entry<Vertex, List<Vertex>> entry : adjacencyMap.entrySet()) {
            Vertex key = entry.getKey();
            List<Vertex> vertices = entry.getValue();
            System.out.println(key + "-->" + vertices);
        }
    }

    public void printGraphWithEdges() {
        for (Map.Entry<Vertex, List<Edge>> entry : adjacencyEdgeMap.entrySet()) {
            Vertex key = entry.getKey();
            List<Edge> edges = entry.getValue();
            System.out.println(key + "-->" + edges);
        }
    }

    public int getVertexCount(){
        return adjacencyEdgeMap.keySet().size();
    }

    /**
     * 1. vertex from where to start visiting
     * 2. use queue data structure for achieving BFS
     * 3. use List of visitedNodes to avoid infinite loop
     * 4. check if queue is not empty
     * 5. find listOfVertices for current vertex
     * 6. print the name of vertex
     * 7. add vertex in visitedNodes list
     * 8. remove vertex from queue
     * 9. now add listOfVertices in queue
     * 10.pick the headElement of queue and  pass it to breadthFirstSearch for recursively executing it
     * @param vertex
     * @param queue
     */
    public void breadthFirstSearch(Vertex vertex,Queue<Vertex> queue) {
        if(!queue.isEmpty()){
            System.out.println(vertex.name);
            List<Vertex> vertices = adjacencyMap.get(vertex);
            visitedNodes.add(queue.peek());
            queue.poll();
            for(Vertex v : vertices) {
                if(!visitedNodes.contains(v)){
                    queue.add(v);
                }
            }
            Vertex v = queue.peek();
            breadthFirstSearch(v, queue);
        }
    }

    /**
     * 1. vertex from where to start visiting
     * 2. use stack data structure for achieving DFS
     * 3. use List of visitedNodes to avoid infinite loop
     * 4. check if stack is not empty
     * 5. find listOfVertices for current vertex
     * 6. print the name of vertex
     * 7. if listOfVertices is empty , remove vertex from stack
     * 8. if listOfVertices is not empty , continue exploring all vertext in this list recursively.
     * @param vertex
     * @param stack
     */
    public void depthFirstSearch(Vertex vertex,Stack<Vertex> stack) {
        if(!stack.isEmpty()){
            if(vertex==null) return;
            if(visitedNodes.contains(vertex)){
              return;
            }
            visitedNodes.add(vertex);
            System.out.println(vertex.name);
            List<Vertex> vertices = adjacencyMap.get(vertex);
            if(vertices==null || vertices.isEmpty()){
                stack.pop();
                return;
            } else {
                stack.push(vertex);
                for(Vertex v : vertices) {
                    depthFirstSearch(v,stack);
                }
            }

        }
    }

    public List<Edge> getChildNodes(Vertex vertex) {
        return this.adjacencyEdgeMap.get(vertex);
    }



}

class Vertex {
    String name;
    int val;

    Vertex(String name,int val) {
        this.name = name;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Edge {
    Vertex start;
    Vertex end;
    int distance;
    Edge(Vertex start , Vertex end , int distance){
       this.start = start;
       this.end = end;
       this.distance = distance;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return distance == edge.distance &&
                start.equals(edge.start) &&
                end.equals(edge.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, distance);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", distance=" + distance +
                '}';
    }


}
