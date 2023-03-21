package main.java.ch.hegarc.ig.application;

import main.java.ch.hegarc.ig.business.Graph;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph("Graph");

        graph.addEdge2("X1", "X2", 1, "U1");
        graph.addEdge2("X2", "X3", 2, "U2");
        graph.addEdge2("X3", "X2", 3, "U3");
        graph.addEdge2("X2", "X2", 4, "U4");

        System.out.println(graph);

        graph.deleteNode2("X2");

        System.out.println(graph);
    }




}