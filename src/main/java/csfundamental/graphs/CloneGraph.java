package csfundamental.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {

    List<GraphNode> visitedNodes = new ArrayList<>();


    public static void main(String[] ar){
        CloneGraph graph = new CloneGraph();
        GraphNode node1 = new GraphNode(10);
        GraphNode node2 = new GraphNode(20);
        GraphNode node3 = new GraphNode(30);
        GraphNode node4 = new GraphNode(40);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node3);
        node2.neighbors.add(node1);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);



        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node1);
        graph.levelOrderTraversal(node1, queue);

        graph.visitedNodes.clear();
        queue.clear();

        System.out.println("***********************");
        GraphNode clonedNode = graph.cloneGraph(node1);
        queue.add(clonedNode);
        graph.levelOrderTraversal(clonedNode,queue);
    }


    public void levelOrderTraversal(GraphNode node,Queue<GraphNode> queue) {
        if(!queue.isEmpty()){
            System.out.println(node.val);
            List<GraphNode> neighbors = node.neighbors;
            visitedNodes.add(queue.peek());
            queue.poll();
            for(GraphNode v : neighbors) {
                if(!visitedNodes.contains(v)){
                    queue.add(v);
                }
            }
            GraphNode v = queue.peek();
            levelOrderTraversal(v, queue);
        }
    }

    public GraphNode cloneGraph(GraphNode node) {
        Queue<NodeRef> queue = new LinkedList<>();
        GraphNode newNode = new GraphNode(node.val);
        NodeRef nodeRef = new NodeRef(node,newNode);
        queue.add(nodeRef);
        visitedNodes.add(node);
        while(!queue.isEmpty()) {
            NodeRef top = queue.poll();
            List<GraphNode> neighbors = top.oldNode.neighbors;
            for(GraphNode nd : neighbors) {
                GraphNode n = new GraphNode(nd.val);
                NodeRef nRef = new NodeRef(nd,n);
                if(!visitedNodes.contains(nd)){
                    visitedNodes.add(nd);
                    queue.add(nRef);
                } else {
                    continue;
                }
                top.newNode.neighbors.add(n);
            }
        }
        return nodeRef.newNode;
    }
}



class NodeRef {
    GraphNode oldNode;
    GraphNode newNode;
    NodeRef(GraphNode oldNode, GraphNode newNode){
        this.oldNode = oldNode;
        this.newNode = newNode;
    }
}
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}