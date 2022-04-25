import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        System.out.println(groupAnagrams(new String[]{"ABC","XYZ","abc","ACB","YXZ","xyz","CAB"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for (String str : strs) {
            //sorting logic
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (hm.get(key) == null) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(str);
        }

        //this prepares the response in expected method
        List<List<String>> r = new ArrayList<>();
        for (List<String> value : hm.values()) {
            r.add(value);
        }

        return r;
    }
}
