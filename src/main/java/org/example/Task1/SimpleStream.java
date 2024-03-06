package org.example.Task1;

import java.util.List;

/* Дан лист строк "BigBen", "BigBob", "Big", "Ben", "Big Bob".
Сколько раз объект «Big» встречается в коллекции? */
public class SimpleStream {
    public static void main(String[] args) {
        List<String> listString = List.of("BigBen", "BigBob", "Big", "Ben", "Big Bob");
        System.out.println(countWord(listString));
    }

    private static int countWord(List<String> listString) {
        return (int) listString.stream()
                .filter(word -> word.equals("Big"))
                .count();
    }
}
