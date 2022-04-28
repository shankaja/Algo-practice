import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SkillAssesment {

    public static void main(String[] args) {
        String x = "hgiiccfchbeadgebc\n" +
                "biiga\n" +
                "edchgb\n" +
                "ccfdbeajaeid\n" +
                "ijgbeecjbj\n" +
                "bcfbbacfbfcfbhcbfjafibfhffac\n" +
                "ebechbfhfcijcjbcehbgbdgbh\n" +
                "ijbfifdbfifaidje\n" +
                "acgffegiihcddcdfjhhgadfjb\n" +
                "ggbdfdhaffhghbdh\n" +
                "dcjaichjejgheiaie\n" +
                "d\n" +
                "jeedfch\n" +
                "ahabicdffbedcbdeceed\n" +
                "fehgdfhdiffhegafaaaiijceijdgbb\n" +
                "beieebbjdgdhfjhj\n" +
                "ehg\n" +
                "fdhiibhcbecddgijdb\n" +
                "jgcgafgjjbg\n" +
                "c\n" +
                "fiedahb\n" +
                "bhfhjgcdbjdcjjhaebejaecdheh\n" +
                "gbfbbhdaecdjaebadcggbhbchfjg\n" +
                "jdjejjg\n" +
                "dbeedfdjaghbhgdhcedcj\n" +
                "decjacchhaciafafdgha\n" +
                "a\n" +
                "hcfibighgfggefghjh\n" +
                "ccgcgjgaghj\n" +
                "bfhjgehecgjchcgj\n" +
                "bjbhcjcbbhf\n" +
                "daheaggjgfdcjehidfaedjfccdafg\n" +
                "efejicdecgfieef\n" +
                "ciidfbibegfca\n" +
                "jfhcdhbagchjdadcfahdii\n" +
                "i\n" +
                "abjfjgaghbc\n" +
                "bddeejeeedjdcfcjcieceieaei\n" +
                "cijdgbddbceheaeececeeiebafgi\n" +
                "haejgebjfcfgjfifhihdbddbacefd\n" +
                "bhhjbhchdiffb\n" +
                "jbbdhcbgdefifhafhf\n" +
                "ajhdeahcjjfie\n" +
                "idjajdjaebfhhaacecb\n" +
                "bhiehhcggjai\n" +
                "bjjfjhiice\n" +
                "aif\n" +
                "gbbfjedbhhhjfegeeieig\n" +
                "fefdhdaiadefifjhedaieaefc\n" +
                "hgaejbhdebaacbgbgfbbcad\n" +
                "heghcb\n" +
                "eggadagajjgjgaihjdigihfhfbijbh\n" +
                "jadeehcciedcbjhdeca\n" +
                "ghgbhhjjgghgie\n" +
                "ibhihfaeeihdffjgddcj\n" +
                "hiedaegjcdai\n" +
                "bjcdcafgfjdejgiafdhfed\n" +
                "fgdgjaihdjaeefejbbijdbfabeie\n" +
                "aeefgiehgjbfgidcedjhfdaaeigj\n" +
                "bhbiaeihhdafgaciecb\n" +
                "igicjdajjdegbceibgebedghihihh\n" +
                "baeeeehcbffd\n" +
                "ajfbfhhecgaghgfdadbfbb\n" +
                "ahgaccehbgajcdfjihicihhc\n" +
                "bbjhih\n" +
                "a\n" +
                "cdfcdejacaicgibghgddd\n" +
                "afeffehfcfiefhcagg\n" +
                "ajhebffeh\n" +
                "e\n" +
                "hhahehjfgcj\n" +
                "ageaccdcbbcfidjfc\n" +
                "gfcjahbbhcbggadcaebae\n" +
                "gi\n" +
                "edheggceegiedghhdfgabgcd\n" +
                "hejdjjbfacggdccgahiai\n" +
                "ffgeiadgjfgecdbaebagij\n" +
                "dgaiahge\n" +
                "hdbaifh\n" +
                "gbhccajcdebcig\n" +
                "ejdcbbeiiebjcagfhjfdahbif\n" +
                "g\n" +
                "ededbjaaigdhb\n" +
                "ahhhcibdjhidbgefggdjebfcf\n" +
                "bdigjaehfchebiedajcjdh\n" +
                "fjehjgbdbaiifi\n" +
                "fbgigbdcbcgffdicfcidfdafghajc\n" +
                "ccajeeijhhb\n" +
                "gaaagfacgiddfahejhbgdfcfbfeedh\n" +
                "gdajaigfbjcdegeidgaccjfi\n" +
                "fghechfchjbaebcghfcfbdicgaic\n" +
                "cfhigaciaehacdjhfcgajgbhhgj\n" +
                "edhjdbdjccbfihiaddij\n" +
                "cbbhagjbcadegicgifgghai\n" +
                "hgdcdhieji\n" +
                "fbifgbhdhagch\n" +
                "cbgcdjea\n" +
                "dggjafcajhbbbaja\n" +
                "bejihed\n" +
                "eeahhcggaaidifdigcfjbficcfhjj\n";
        String[] split = x.split("\n");
        noPrefix(Arrays.asList(split));
    }

    public static void noPrefix(List<String> words) {
        // Write your code here
        Map<String, List<String>> hm = new HashMap<>();
        //prefixes with indices
        Map<Integer, String> prefixes = new HashMap<>();
        for (String word : words) {
            String firstLetter = word.substring(0, 1);
            hm.putIfAbsent(firstLetter, new ArrayList<>());
            if (hm.get(firstLetter).contains(word)) {
                prefixes.put(words.indexOf(word), word);
            }
            hm.get(firstLetter).add(word);
        }

        for (List<String> d : hm.values()) {
            for (int i = 0; i < d.size(); i++) {
                for (int j = 0; j < d.size(); j++) {
                    if (i == j) continue;
                    if (isSubString(d.get(i), d.get(j))) {
                        if (words.indexOf(d.get(i)) > words.indexOf(d.get(j))) {
                            prefixes.put(words.indexOf(d.get(i)), d.get(i));
                        } else {
                            prefixes.put(words.indexOf(d.get(j)), d.get(j));
                        }
                    }
                }
            }
        }
        if (prefixes.size() > 0) {
            int minKey = words.size();
            for (Integer integer : prefixes.keySet()) {
                if (minKey > integer) {
                    minKey = integer;
                }
            }
            System.out.println("BAD SET");
            System.out.print(words.get(minKey));
            return;
        }
        System.out.print("GOOD SET");
    }

    private static boolean isSubString(String a, String b) {
        char[] w1, w2;
        if (a.length() > b.length()) {
            w1 = b.toCharArray();
            w2 = a.toCharArray();
        } else {
            w1 = a.toCharArray();
            w2 = b.toCharArray();
        }

        for (int i = 0; i < w1.length; i++) {
            if (w1[i] != w2[i]) return false;
        }
        return true;
    }


    public static String caesarCipher(String s, int k) {
        // Write your code here
        int shift = k % 26;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(chars[i])) {
                if (Character.isUpperCase(chars[i])) {
                    shiftChar(shift, chars, i, 'Z', 'A');
                } else {
                    shiftChar(shift, chars, i, 'z', 'a');
                }
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private static void shiftChar(int shift, char[] chars, int i, char z, char a) {
        int gap = z - chars[i];
        if (gap < shift)
            chars[i] = (char) (a + shift - gap - 1);
        else
            chars[i] = (char) (chars[i] + shift);
    }

    public static int towerBreakers(int n, int m) {
        // Write your code here
        if (m > 1) {
            if (n % 2 == 0)
                return 2;
            return 1;
        }
        return 2;
    }

    public static void findZigZagSequence(int[] a, int n) {
        Arrays.sort(a);
        int mid = n / 2;    //1
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while (st < ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;        //2
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int sum = 0;
        int maxId = matrix.size() - 1;
        for (int i = 0; i < matrix.size() / 2; i++) {
            for (int j = 0; j < matrix.size() / 2; j++) {
                sum += getMax(matrix.get(i).get(j), matrix.get(i).get(maxId - j), matrix.get(maxId - i).get(j), matrix.get(maxId - i).get(maxId - j));
            }
        }
        return sum;
    }

    public static int getMax(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        //first, min max values

        List<Integer> countArray = new ArrayList<>(Collections.nCopies(100, 0));

        for (Integer integer : arr) {
            countArray.set(integer, countArray.get(integer) + 1);
        }

        return countArray;
    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> m = new HashMap<>();
        for (Integer n : a) {
            m.putIfAbsent(n, 0);
            m.put(n, m.get(n) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : m.entrySet()) {
            if (integerIntegerEntry.getValue() == 1) {
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }

    public static String timeConversion(String s) {
        // Write your code here
        boolean am = s.toCharArray()[s.length() - 2] == 'A';
        int hh = Integer.parseInt(s.substring(0, 2));
        if (hh == 12) {
            if (am)
                return "00" + s.substring(2, 8);
            else
                return s.substring(0, 8);
        } else {
            if (am)
                return s.substring(0, 8);
            else
                return (hh + 12) + s.substring(2, 8);
        }
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        Long x = 0L;
        int size = arr.size();

        for (int i = 1; i < size - 1; i++) {
            x += arr.get(i);
        }
        System.out.print((x + arr.get(0)) + " " + (x + arr.get(size - 1)));
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        AtomicInteger z = new AtomicInteger();
        AtomicInteger p = new AtomicInteger();
        AtomicInteger m = new AtomicInteger();
        arr.forEach(i -> {
            if (i > 0)
                p.incrementAndGet();
            else if (i < 0)
                m.incrementAndGet();
            else
                z.incrementAndGet();
        });
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println(df.format(p.get() / 1.0 * arr.size()));
        System.out.println(df.format(m.get() / 1.0 * arr.size()));
        System.out.println(df.format(z.get() / 1.0 * arr.size()));
    }

    /*
    password decryption
     */
    public static String decryptPassword(String s) {
        // Write your code here
        char[] chars = s.toCharArray();
        List<Character> r = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != '0' && Character.isDigit(c)) {
                stack.push(c);
            } else if (c == '*' && Character.isUpperCase(r.get(r.size() - 2)) && Character.isLowerCase(r.get(r.size() - 1))) {
                Character c1 = r.get(r.size() - 2);
                Character c2 = r.get(r.size() - 1);
                r.set(r.size() - 1, c1);
                r.set(r.size() - 2, c2);
            } else if (c == '0') {
                r.add(stack.pop());
            } else {
                r.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : r) {
            sb.append(String.valueOf(character));
        }
        return sb.toString();
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        // Write your code here
        List<Integer> r = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String w : dictionary) {
            String sw = sort(w);
            if (!map.containsKey(sw)) {
                map.put(sw, 1);
            } else {
                map.put(sw, map.get(sw) + 1);
            }
        }

        for (int i = 0; i < query.size(); i++) {
            r.add(0);
            for (String d : map.keySet()) {
                if (isAnagram(d, query.get(i))) {
                    r.set(i, r.get(i) + map.get(d));
                }
            }
        }
        return r;
    }

    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(String.valueOf(aChar));
        }
        return sb.toString();
    }

    public static boolean isAnagram(String s, String t) {

        char[] cA = s.toCharArray();
        char[] cB = t.toCharArray();
        //length mismatch case
        if (cA.length != cB.length) {
            return false;
        }

        Arrays.sort(cA);
        Arrays.sort(cB);

        return Arrays.equals(cA, cB);
    }

}
