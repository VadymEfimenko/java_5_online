package ua.com.alevel;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindCheapestWay {
    private final File file = new File("CitiesFile.txt");

    public Integer getCountOfCities() {
        return Integer.valueOf(allLines().get(0));
    }

    public List<String> citiesList() {
        List<String> digits = allLines().stream().filter(s -> Character.isDigit(s.charAt(0))).toList();
        int indexOfCountCities = allLines().lastIndexOf(digits.get(digits.size() - 1));
        return allLines().subList(0, indexOfCountCities).stream()
                .filter(line -> line.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$"))
                .toList();
    }

    public Map<Integer, String> cityIndex(List<String> citiesList) {
        List<Integer> integers = new ArrayList<>(IntStream.range(1, citiesList.size() + 1).boxed().toList());
        return IntStream.range(0, citiesList.size())
                .boxed()
                .collect(Collectors.toMap(integers::get, citiesList::get));
    }

    public List<Edge> getEdges() {
        List<String> digits = new ArrayList<>(allLines().stream().filter(s -> Character.isDigit(s.charAt(0))).toList());
        digits.remove(0);
        digits.remove(digits.size() - 1);
        List<Integer> indexes = new ArrayList<>();
        List<List<String>> sublists = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < digits.size(); i++) {
            if (!digits.get(i).contains(" ")) {
                indexes.add(i);
            }
        }

        for (int i = 0, j = 1; i <= indexes.size() - 1; i++, j++) {
            if (i == indexes.size() - 1) {
                sublists.add(digits.subList(indexes.get(indexes.size() - 1), digits.size()));
            }
            if (i < indexes.size() - 1) {
                sublists.add(digits.subList(indexes.get(i), indexes.get(j)));
            }
        }

        for (int i = 0; i < sublists.size(); i++) {
            for (int j = 0; j < sublists.get(i).size(); j++) {
                if (sublists.get(i).get(j).contains(" ")) {
                    String[] cityCost = sublists.get(i).get(j).split(" ");
                    Edge edge = new Edge();
                    edge.setStart(cityIndex(citiesList()).get(i + 1));
                    edge.setFinish(cityIndex(citiesList()).get(Integer.valueOf(cityCost[0])));
                    edge.setWeight(Integer.valueOf(cityCost[1]));
                    edges.add(edge);
                }
            }
        }
        return edges;
    }

    public List<String> getWays() {
        List<String> allLines = allLines();
        List<String> digits = allLines().stream().filter(s -> Character.isDigit(s.charAt(0))).toList();
        int countOfWays = Integer.parseInt(digits.get(digits.size() - 1));
        List<String> ways = allLines.subList(allLines.lastIndexOf(String.valueOf(countOfWays)) + 1, allLines.size());
        return ways;
    }

    public List<String[]> searchedRoutsSplit() {
        List<String> ways = getWays();
        List<String[]> waysSplit = new ArrayList<>();
        ways.forEach(s -> waysSplit.add(s.split(" ")));
        return waysSplit;
    }

    public List<String> allLines() {
        List<String> allLines;
        try {
            allLines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allLines;
    }
}
