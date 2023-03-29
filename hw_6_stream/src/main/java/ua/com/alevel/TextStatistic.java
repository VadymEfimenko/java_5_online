package ua.com.alevel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class TextStatistic {

    public List<String> toList(String userString) {
        String replaceAll = userString.replaceAll("(\\s+)|([\\p{P}\\p{S}])", " ");
        List<String> stringList = Arrays.stream(replaceAll.split("\\s+")).toList();

        return stringList;
    }

    public LinkedHashMap<String, Long> countByWordSorted(List<String> stringList) {
        LinkedHashMap<String, Long> countByWordSorted = stringList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        },
                        LinkedHashMap::new
                ));
        return countByWordSorted;
    }

    public Map<Long, Long> rating(List<Long> wordCount) {
        List<Long> counts = wordCount.stream().mapToLong(value -> value).distinct().boxed().toList();
        List<Long> rating = new ArrayList<>(LongStream.range(1, counts.size() + 1).boxed().toList());

        return combineTwoLists(counts, rating);
    }

    public Map<Long, Double> percentage(List<Long> wordCount) {
        List<Long> counts = wordCount.stream().mapToLong(value -> value).distinct().boxed().toList();
        List<Double> percentage;
        long sum = wordCount.stream().mapToLong(value -> value).sum();
        percentage = wordCount.stream().mapToDouble(value -> value * 1.0 / sum * 100)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toList();

        return combineTwoLists(counts, percentage);
    }


    private <K, V> Map<K, V> combineTwoLists(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size())
                .boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }
}
