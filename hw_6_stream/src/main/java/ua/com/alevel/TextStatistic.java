package ua.com.alevel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextStatistic {

    public List<String> toList(String userString) {
        String replaceAll = userString.replaceAll("(\\s+)|([\\p{P}\\p{S}])", " ");
        List<String> stringList = Arrays.stream(replaceAll.split("\\s+")).toList();

        return stringList;
    }

    public Map<String, Long> rating(List<String> stringList) {
        Map<String, Long> rating = stringList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return rating;
    }


}
