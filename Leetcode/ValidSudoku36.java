import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku36 {

    public static void main(String[] args) {
        char[][] sudoku = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                , {'5', '.', '.', '.', '.', '.', '.', '.', '.'}
                , {'.', '7', '1', '.', '.', '.', '4', '.', '.'}
                , {'.', '.', '.', '.', '.', '.', '.', '.', '5'}
                , {'8', '5', '.', '.', '.', '3', '.', '.', '.'}
                , {'.', '.', '4', '.', '.', '7', '.', '5', '6'}
                , {'.', '.', '.', '.', '.', '.', '8', '.', '.'}
                , {'.', '.', '.', '2', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '6', '.', '.', '.'}
        };
        long start = System.currentTimeMillis();
        System.out.println(isValidSudoku(sudoku));
        long normal = System.currentTimeMillis();
        System.out.println("Time for normal execution : " + (normal - start));
        System.out.println(isValidSudokuOptimized(sudoku));
        System.out.println("Time for optimized execution : " + (System.currentTimeMillis() - normal));
    }

    public static boolean isValidSudoku(char[][] board) {
        //rows
        Set<String> boxSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            Map<Character, Integer> mapLeft = new HashMap<>();
            Map<Character, Integer> mapDown = new HashMap<>();
            for (int j = 0; j < board.length; j++) {
                char charLeft = board[i][j];
                if (mapLeft.containsKey(charLeft)) {
                    return false;
                }
                if (charLeft != '.') {
                    mapLeft.put(charLeft, 1);
                }
                char charDown = board[j][i];
                if (mapDown.containsKey(charDown)) {
                    return false;
                }
                if (charDown != '.') {
                    mapDown.put(charDown, 1);
                }

                String box = String.valueOf(charLeft) + "-" + i / 3 + "-" + j / 3;
                if (boxSet.contains(box)) {
                    return false;
                }
                if (charLeft != '.') {
                    boxSet.add(box);
                }

            }
        }

        return true;
    }

    public static boolean isValidSudokuOptimized(char[][] board) {
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    String rowElem = board[i][j] + "r-" + i;
                    if (hashSet.contains(rowElem)) {
                        return false;
                    }
                    hashSet.add(rowElem);

                    String box = board[i][j] + "-" + i / 3 + "-" + j / 3;
                    if (hashSet.contains(box)) {
                        return false;
                    }
                    hashSet.add(box);
                }
                if (board[j][i] != '.') {
                    String colElem = board[j][i] + "c-" + j;
                    if (hashSet.contains(colElem)) {
                        return false;
                    }
                    hashSet.add(colElem);
                }
            }
        }

        return true;
    }
}
