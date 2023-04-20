package ua.com.alevel;

import java.util.*;

public class Graph {

    private final int size;
    private final Vertex[] vertices;
    private final HashMap<String, String> previous;
    private final HashMap<String, List<Vertex>> adjacencyList;
    int i = 0;
    private int pointer;

    public Graph(int size) {
        this.size = size;
        this.pointer = 0;
        this.vertices = new Vertex[this.size];
        this.previous = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String label) {
        if (this.pointer == this.size)
            return;
        Vertex vertex = new Vertex(label, Integer.MAX_VALUE, this.pointer);
        this.vertices[this.pointer++] = vertex;
        this.previous.put(label, null);
        this.adjacencyList.put(label, new ArrayList<>());
    }

    public void addEdge(String label1, String label2, int weight) {
        int index = this.getIndexByLabel(label2);
        Vertex vertex = new Vertex(label2, weight, index);
        this.adjacencyList.get(label1).add(vertex);
    }

    public void dijkstra(String label) {
        int index = this.getIndexByLabel(label);
        this.vertices[index].setWeight(0);
        BinaryHeap pq = new BinaryHeap(this.size);
        for (int i = 0; i < this.pointer; i++)
            pq.insert(this.vertices[i]);
        Vertex current;
        while (!pq.isEmpty()) {
            current = pq.deleteMin();
            for (Vertex vertex : this.adjacencyList.get(current.getLabel())) {
                if (current.getWeight() + vertex.getWeight() < this.vertices[vertex.getIndex()].getWeight()) {
                    this.vertices[vertex.getIndex()].setWeight(current.getWeight() + vertex.getWeight());
                    this.previous.put(this.vertices[vertex.getIndex()].getLabel(), current.getLabel());
                    pq.decreaseKey(this.vertices[vertex.getIndex()].getKey());
                }
            }
        }
    }

    public String getPath(String label) {
        if (this.previous.get(label) == null) {
            return label;
        } else {
            i = i + 1;
            if (i < size)
                return this.getPath(this.previous.get(label)) + " -> " + label;
        }
        return "null";
    }

    public int getCost(String label, List<Edge> edges) {
        String path = getPath(label);
        List<String> vertexes = Arrays.stream(path.split(" -> ")).toList();
        List<Edge> wayEdgesNoCost = new ArrayList<>();
        int sumCost = 0;
        for (int i = 0; i < vertexes.size() - 1; i++) {
            Edge edge = new Edge();
            edge.setStart(vertexes.get(i));
            edge.setFinish(vertexes.get(i + 1));
            wayEdgesNoCost.add(edge);
        }
        for (Edge value : wayEdgesNoCost) {
            for (Edge edge : edges) {
                if (value.equals(edge)) {
                    sumCost = sumCost + edge.getWeight();
                }
            }
        }
        return sumCost;
    }

    public Integer getIndexByLabel(String label) {
        boolean found = false;
        int count = 0;
        while (count < this.pointer && !found) {
            if (this.vertices[count].getLabel().equals(label))
                found = true;
            else
                count++;
        }
        if (found)
            return count;
        else
            throw new NoSuchElementException();
    }
}
