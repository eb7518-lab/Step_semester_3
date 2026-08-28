package week2.assignment_problems;

import java.util.*;

public class StopWordFilteredWordFrequencyReport {

    static void generateReport(String text, String stopWordsInput) {

        text = text.toLowerCase();
        text = text.replaceAll("[^a-z0-9\\s]", "");

        String[] words = text.split("\\s+");

        String[] stopWords = stopWordsInput.toLowerCase().split("\\s+");

        HashSet<String> stopSet = new HashSet<>();

        for (String word : stopWords) {
            stopSet.add(word);
        }

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (word.isEmpty() || stopSet.contains(word)) {
                continue;
            }

            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort((a, b) -> {
            int frequencyCompare = b.getValue().compareTo(a.getValue());

            if (frequencyCompare != 0) {
                return frequencyCompare;
            }

            return a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter stop words separated by spaces: ");
        String stopWords = sc.nextLine();

        generateReport(text, stopWords);

        sc.close();
    }
}