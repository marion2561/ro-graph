package main.java.ch.hegarc.ig.business;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Node {

    private final String name;
    private final File current = new File();
    private final HashMap<String, Edge> ExitingEdge = new HashMap<String, Edge>();
    private final HashMap<String, Edge> EnteringEdge = new HashMap<String, Edge>();

    //Constructor
    public Node(String name) {
        this.name = name;
    }

    //Getter
    public String getName() {
        return name;
    }

    public HashMap<String, Edge> getExitingEdge() {
        return ExitingEdge;
    }

    public HashMap<String, Edge> getEnteringEdge() {
        return EnteringEdge;
    }

    // TO DO
    public void mark() {
    }

    //Add an edge with the destination node and the metric and the name of the edge
    public void addEdge1(Node dest, double metric, String name) {
        if (ExitingEdge.containsKey(name)) {
            System.out.println("Edge already exist");
        } else {
            ExitingEdge.put(name, new Edge(dest, metric, name));
        }
    }
    public void addEdge2(Node dest, Node src, double metric, String name) {
        if (ExitingEdge.containsKey(name)) {
            System.out.println("Edge already exist");
        } else {
            Edge ed = new Edge(dest, src, metric, name);
            src.ExitingEdge.put(ed.getName(), ed);
            dest.EnteringEdge.put(ed.getName(), ed);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("W(").append(name).append(") = ");
        sb.append(ExitingEdge.values());
        sb.append("\n");
        return sb.toString();

    }
}
