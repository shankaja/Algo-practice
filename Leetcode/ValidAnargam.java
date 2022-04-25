import java.util.HashMap;
import java.util.Map;

public class ValidAnargam {

    public static void main(String[] args) {
        System.out.println(new AnagramSolution().isAnagram("ABC", "ACBD"));
    }


}

class AnagramSolution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hm = new HashMap<>();

        char[] cA = s.toCharArray();
        char[] cB = t.toCharArray();
        //length mismatch case
        if (cA.length != cB.length) {
            return false;
        }
        //building up the hashmap
        // each char in s -> +1 value
        //each char in t -> -1 in to the hm
        for (int i = 0; i < cA.length; i++) {
            if (hm.get(cA[i]) == null) {
                hm.put(cA[i], 0);
            }
            if (hm.get(cB[i]) == null) {
                hm.put(cB[i], 0);
            }
            hm.put(cA[i], hm.get(cA[i]) + 1);
            hm.put(cB[i], hm.get(cB[i]) - 1);
        }

        for (Integer value : hm.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

}
