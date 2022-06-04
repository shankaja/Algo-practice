import java.util.*;

public class SumOfPrimes {

    private static final Set<Integer> primes = new HashSet<>();
    private static int largestPrime = 7;

    public static void main(String[] args) {
//        Collections.addAll(primes, 2, 3, 5, 7);
//        int range = 2000000;
//        long sum = 0L;
//        for (int i = 2; i < range; i++) {
//            if (isPrime(i))
//                sum += i;
//        }
//        System.out.println(sum);

        String[][] dishes = {
                {"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"}
        };

        System.out.println(Arrays.deepToString(solution(dishes)));
    }

    static boolean isPrime(int value) {
        if (value < 1)
            return false;
        for (int prime : primes) {
            if (prime == value)
                return true;
            if (value % prime == 0)
                return false;
        }
        if (value > largestPrime) {
            for (int i = largestPrime + 1; i < value / 2; i++) {
                if (value % i == 0)
                    return false;
            }
        }
        primes.add(value);
        largestPrime = value;
        return true;
    }

    static String[][] solution(String[][] dishes) {
        Set<String> ingredients = new TreeSet<>();
        //key - ingredient
        //value - set of dishes
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < dishes.length; i++) {
            String dishName = dishes[i][0];
            for (int j = 1; j < dishes[i].length; j++) {
                if (!map.containsKey(dishes[i][j])) {
                    map.put(dishes[i][j], new TreeSet<>());
                }
                map.get(dishes[i][j]).add(dishName);
                ingredients.add(dishes[i][j]);
            }
        }

        String[][] resp = new String[ingredients.size()][];
        int i = 0;
        for (String ingredient : ingredients) {
            resp[i] = new String[map.get(ingredient).size() + 1];
            resp[i][0] = ingredient;
            Set<String> dishSet = map.get(ingredient);
            int j = 1;
            for (String dish : dishSet) {
                resp[i][j] = dish;
                j++;
            }
            i++;
        }

        for (Map.Entry<String, Set<String>> stringSetEntry : map.entrySet()) {

        }


        return resp;
    }
}
