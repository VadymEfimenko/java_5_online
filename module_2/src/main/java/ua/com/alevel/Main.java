package ua.com.alevel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] arg) {
        FindCheapestWay findCheapestWay = new FindCheapestWay();
        List<String[]> routs = findCheapestWay.searchedRoutsSplit();
        List<Integer> results = new ArrayList<>();

        for (String[] rout : routs) {
            Graph graph = new Graph(findCheapestWay.getCountOfCities());
            List<Edge> edges = findCheapestWay.getEdges();
            findCheapestWay.citiesList().forEach(graph::addVertex);
            edges.forEach(edge -> graph.addEdge(edge.getStart(), edge.getFinish(), edge.getWeight()));
            graph.dijkstra(rout[0].trim());
            results.add(graph.getCost(rout[1].trim(), edges));
        }

        try (FileWriter writer = new FileWriter("output.txt")) {
            for (Integer result : results) {
                writer.write(result + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
