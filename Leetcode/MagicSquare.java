import java.util.List;

public class MagicSquare {

    public static void main(String[] args) {

    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int[][][] solutions = {
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{8, 1, 4}, {3, 5, 7}, {4, 9, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}}
        };

        int minDist = Integer.MAX_VALUE;

        for (int[][] solution : solutions) {
            int solDist = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    solDist += Math.abs(s.get(i).get(j) - solution[i][j]);
                }
            }
            if (solDist < minDist) {
                minDist = solDist;
            }
        }
        return minDist;
    }
}
