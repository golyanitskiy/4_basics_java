package guru.qa;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("Количество найденных слов - " + WordsLister.lister().size() + System.lineSeparator());
        System.out.println("Найденные слова: ");

        Map<String, Integer> wordsCount = new HashMap<>();

        for (String word : WordsLister.lister()) {
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 1);
            } else {
                Integer integer = wordsCount.get(word);
                wordsCount.put(word, integer + 1);
            }
        }

        wordsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}