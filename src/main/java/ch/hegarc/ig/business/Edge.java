package main.java.ch.hegarc.ig.business;

public class Edge {

    private final String name;
    private final double metric;
    private final Node dest;
    private final Node src;

    //Constructor
      //Without src

      //With src
   public Edge(Node destination, Node src, double metric, String name) {
        this.dest = destination;
        this.src = src;
        this.metric = metric;
        this.name = name;
   }

   public Edge(Node destination, double metric, String name) {
       this.dest = destination;
       this.metric = metric;
       this.name = name;
       this.src = null;
   }

    // GETTER
    public String getName() {
        return name;
    }

    public double getMetric() {
        return metric;
    }

    public Node getDest() {
        return dest;
    }

    public Node getSrc() {
        return src;
    }

    //To string that print the name of the edge and the metric and the destination node but without the exiting edges of it
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (").append(metric).append(", ").append(dest.getName()).append(")");
        return sb.toString();
    }

}
