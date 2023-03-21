package main.java.ch.hegarc.ig.business;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;

public class Graph {
    private final String name;

    private final HashMap<String, Node> nodeList = new HashMap<String, Node>();
    private List<Node> widthWay (Node start, int levelMax) {
        reinitAll();
        LinkedList file = new LinkedList(); //Mémoire de travail
        List <Node> returnList = new List<Node>() ;
        file.addFirst(start);
        start.mark();
            while(!file.isEmpty()){
                Node current = file.removeLast();
                returnList.add(current);
                    if (current < levelMax){
                        for (Edge : current.getExitingEdge())
                    }

            }

    }

    private void reinitAll() {
    }

    //Constructor
    public Graph(String name) {
        this.name = name;
    }

    //Parcours de graph


    //Add a node with only his name and find if it's already exist
    public void addNode(String name) {
        if (nodeList.containsKey(name)) {
            System.out.println("Node already exist");
        } else {
            nodeList.put(name, new Node(name));
        }
    }
    //Del node with only his name and del arcs
    public void deleteNode1(String name){
        if (nodeList.containsKey(name)) {
            for (Node node :this.nodeList.values()){
                Iterator<Edge> iteEdge = node.getExitingEdge().values().iterator();
                while (iteEdge.hasNext()){
                    Edge edge = iteEdge.next();
                    if (name == edge.getDest().getName()){
                        iteEdge.remove();
                    }
                }
            }
            nodeList.remove(name);
        }
        else {
            System.out.println("Node does not exist");
        }
    }

    //Del node with only his name and del arcs
    public void deleteNode2(String name){
        Iterator <Edge> iteEdge = nodeList.get(name).getEnteringEdge().values().iterator();
        while (iteEdge.hasNext()){
            Edge edge = iteEdge.next();
           iteEdge.remove();
        }
        nodeList.remove(name);
    }


    //Add an edge between two nodes with the source node and the destination node and the metric and the name of the edge and find if the nodes exist and if not create them and use the findNode method
    // Unoriented
    public void addEdge1(String source,String dest, double metric, String name) {
        if (nodeList.containsKey(source)) {
            if (nodeList.containsKey(dest)) {
                nodeList.get(source).addEdge1(nodeList.get(dest), metric, name);
            } else {
                nodeList.get(source).addEdge1(findNode(dest), metric, name);
            }
        } else {
            if (nodeList.containsKey(dest)) {
                findNode(source).addEdge1(nodeList.get(dest), metric, name);
            } else {
                findNode(source).addEdge1(findNode(dest), metric, name);
            }
        }
    }

    public void addEdge2(String source, String dest, double metric, String name) {
        if (nodeList.containsKey(source)) {
            if (nodeList.containsKey(dest)) {
                nodeList.get(source).addEdge2(nodeList.get(dest),nodeList.get(source), metric, name);
            } else {
                nodeList.get(source).addEdge2(findNode(dest), findNode(source), metric, name);
            }
        } else {
            if (nodeList.containsKey(dest)) {
                findNode(source).addEdge2(nodeList.get(dest), nodeList.get(source),metric, name);
            } else {
                findNode(source).addEdge2(findNode(dest), findNode(source), metric, name);
            }
        }
    }

    //Add findNode method to find a node with his name and if it's not exist create it using add node method
    public Node findNode(String name) {
        if (nodeList.containsKey(name)) {
            return nodeList.get(name);
        } else {
            addNode(name);
            return nodeList.get(name);
        }
    }

    //To string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- Graph: ").append(name).append(" -- \n");
        for (String key : nodeList.keySet()) {
            sb.append(nodeList.get(key));
        }
        return sb.toString();
    }

}
