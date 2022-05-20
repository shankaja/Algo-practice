import java.util.*;

public class LeetcodeAssesment {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6,7);
        reverseList(integers);
        System.out.println(integers);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        bannedSet.addAll(Arrays.asList(banned));
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int maxFreq = 0;
        String word = "";
        for (String key : map.keySet()) {
            if (maxFreq < map.get(key)) {
                maxFreq = map.get(key);
                word = key;
            }
        }
        return word;
    }

    static void reverseList(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            //swapping each item with the mirror item
            Integer swap = list.get(i);
            int mirrorIndex = size - 1 - i;
            list.set(i, list.get(mirrorIndex));
            list.set(mirrorIndex, swap);
        }
    }

}

