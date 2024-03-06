package org.example.Task2;

import java.util.Arrays;
import java.util.List;

/* 2) Найти самый маленький элемент: Arrays.asList("a1", "b5", "a2", "b4") */
public class Task2 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a1", "b5", "a2", "b4");
        System.out.println(minElement(stringList));
    }

    private static String minElement(List<String> stringList) {
        return stringList.stream()
                .sorted()
                .findFirst()
                .get();
    }
}
