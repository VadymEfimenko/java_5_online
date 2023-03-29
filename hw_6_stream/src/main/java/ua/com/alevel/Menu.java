package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Menu {

    TextStatistic textStatistic = new TextStatistic();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the Text Statistics");
        System.out.println("Enter your string:");
        String userString;
        while ((userString = bf.readLine()) != null) {
            System.out.printf("%-15s %-15s %-15s %s %n", "word", "rating", "count", "percentage");
            displayStatistics(userString);
        }
    }

    public void displayStatistics(String userString) {
        List<String> userWordsString = textStatistic.toList(userString);
        Map<String, Long> wordCount = textStatistic.countByWordSorted(userWordsString);
        Map<Long, Long> countRating = textStatistic.rating(wordCount.values().stream().toList());
        Map<Long, Double> countPercentage = textStatistic.percentage(wordCount.values().stream().toList());
        List<TableRow> tableRows = new ArrayList<>();
        for (int i = 0; i < wordCount.size(); i++) {
            String word = wordCount.keySet().stream().toList().get(i);
            Long count = wordCount.get(word);
            Long rating = countRating.get(count);
            Double percentage = countPercentage.get(count);
            tableRows.add(new TableRow(word, rating, count, percentage));
        }
        tableRows.sort(Comparator.comparingLong(TableRow::getRating));
        for (TableRow tableRow : tableRows) {
            System.out.printf("%-15s %-15d %-15d %f %n", tableRow.word, tableRow.rating, tableRow.count, tableRow.percentage);
        }
    }

    private class TableRow {
        String word;
        Long count;
        Long rating;
        Double percentage;

        public TableRow(String word, Long rating, Long count, Double percentage) {
            this.word = word;
            this.count = count;
            this.rating = rating;
            this.percentage = percentage;
        }

        public Long getRating() {
            return rating;
        }
    }
}
