//All of these imports are required. The tutorial does not explicitly mention this.
import java.util.stream.Collectors;
import java.util.*;

class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;
    
    public int graphSize;

//A construtor is required to allocate memory for the Map.
    Graph() {
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	System.out.println(label + " added to Graph!");
	graphSize++;
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
	System.out.println("Edge between " + label1 + " and " + label2 + " established!");
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
    
    String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Vertex v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v) + "\n");
        }
        return sb.toString();
    }

    class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
        
        //This method is required to be overridden in order for the Map to properly function.
        @Override
	    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }
        
        //This method is also required for the same reason as the previous method.
        @Override
	    public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        //Not entirely sure why this method is required.
	@Override
	    public String toString() {
            return label;
        }

	//Not entirely sure why this method is required.
        private Graph getOuterType() {
            return Graph.this;
        }
    }
    
	Set<String> breadthFirstTraversal(Graph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Queue<String> queue = new LinkedList<String>();
	    
	    queue.add(root);
	    visited.add(root);
	    while (!queue.isEmpty()) {
	        String vertex = queue.poll();
	        for (Vertex v : graph.getAdjVertices(vertex)) 
	            if (!visited.contains(v.label)) {
	                visited.add(v.label);
	                queue.add(v.label);
	            }
	    }
	    return visited;
	}
    
	Set<String> depthFirstTraversal(Graph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Stack<String> stack = new Stack<String>();

	    stack.push(root);
	    while (!stack.isEmpty()) {
	        String vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (Vertex v : graph.getAdjVertices(vertex)) {            
	            	stack.push(v.label);
	            }
	        }
	    }

	    return visited;
	}
	
	public void sortthing(Graph graph, String root) {
		Set<String> visited = new LinkedHashSet<String>();
		Stack<String> stack = new Stack<String>();
		
		int maxpath = graphSize - 1;

	    stack.push(root);
	    while (!stack.isEmpty()) {
	        String vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (Vertex v : graph.getAdjVertices(vertex))             
	            	stack.push(v.label);
	        	}
        	if (graph.getAdjVertices(vertex).stream().filter(s->!visited.contains(s.label)).count() == 0) {
        		System.out.println(visited);
        		graph.removeVertex(vertex);
        		visited.remove(vertex);
        		maxpath--;
        	}
	    }// end of loop
	}
}
public class GraphApp {
    public static void main(String[] args) {
	Graph ex = new Graph();
	
	ex.addVertex("Science");
	ex.addVertex("Mathematics");
    ex.addVertex("English");
	ex.addVertex("History");
	ex.addVertex("Spanish");
	ex.addVertex("Statistics");
	ex.addVertex("Calculus");
	
	ex.addEdge("Science","Mathematics");
    ex.addEdge("Science","English");
    ex.addEdge("English","History");
    ex.addEdge("English","Spanish");
    ex.addEdge("Mathematics", "Calculus");
    ex.addEdge("Mathematics", "Statistics");
    
    System.out.println("\nDepthFirstTraversal: \n" + ex.depthFirstTraversal(ex, "Science"));
    System.out.println();
    System.out.println("BreadthFirstTraversal: \n" + ex.breadthFirstTraversal(ex, "Science"));
    System.out.println("\nEvery route in the list:");
    ex.sortthing(ex, "Science");

	
    }
}