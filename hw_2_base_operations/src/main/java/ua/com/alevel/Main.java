package ua.com.alevel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        int password = 1234;
        int secret = ~password * 11;
        System.out.println(secret);
        System.out.println("real " + ~secret / 11);
//        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
//        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,2,3));
//        l1.removeAll(l2);
//        System.out.println(l1);
    }
}