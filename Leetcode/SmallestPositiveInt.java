import java.util.*;

public class SmallestPositiveInt {

    public static void main(String[] args) {
        System.out.println(arithmaticMeans(new int[]{2, 1, 3}, 2));
    }

    public int solution(String[] T, String[] R) {

        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < T.length; i++) {
            String testNo = T[i].replaceAll("[^0-9]", "");
            if ("OK".equalsIgnoreCase(R[i])) {
                map.put(testNo, map.getOrDefault(testNo, true));
            } else {
                map.put(testNo, false);
            }
        }
        int c = 0;
        for (Map.Entry<String, Boolean> stringBooleanEntry : map.entrySet()) {
            if (stringBooleanEntry.getValue()) {
                c++;
            }
        }
        return 100 * c / map.size();

    }

    public static int arithmaticMeans(int[] A, int S) {

        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int c = 0;
        int cases = 0;
        for (int i = 0; i < n; i++) {
            c += A[i];
            int key = c - (S * (i + 1));
            if (map.containsKey(key)) {
                cases += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return cases;
    }


    public static int solution(int[] A) {
        Arrays.sort(A);
        int min = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > min) {
                return min;
            }
            if (A[i] > 0) {
                min = A[i] + 1;
            }
        }
        return min;
    }

    public static int shortestVacation(int[] A) {
        List<Integer> L = new ArrayList<>();
        List<Integer> S = new ArrayList<>();


        for (int j : A) {
            if (!L.contains(j)) {
                L.add(j);
            } else if (L.indexOf(j) == 0) {
                L.remove((Integer) j);
                L.add(j);
            } else {
                L.add(j);
            }
        }


        for (int i = L.size() - 1; i >= 0; i--) {
            if (!S.contains(L.get(i))) {
                S.add(L.get(i));
            } else if (S.indexOf(L.get(i)) == 0) {
                S.remove(L.get(i));
                S.add(L.get(i));
            } else {
                S.add(L.get(i));
            }
        }

        return S.size();
    }

}
