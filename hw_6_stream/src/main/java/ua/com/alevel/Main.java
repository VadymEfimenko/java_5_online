package ua.com.alevel;

import org.w3c.dom.Text;

public class Main {
    public static void main(String[] args) {
        TextStatistic textStatistic = new TextStatistic();
        System.out.println(textStatistic.rating(textStatistic.toList("hello hello world, how are you bitch?")));
    }
}