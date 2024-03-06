package org.example.Task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* 3) Выполнить сортировку в обратном алфавитном порядке и удалить дубликаты.
Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1"); */
public class Task3 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1");
        System.out.println(charSort(stringList));
    }

    private static List<String> charSort(List<String> stringList) {
        return stringList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }
}
