//import java.util.HashMap;
//import java.util.Map;
//
////leetcode - 36
//public class ValidSudoku {
//
//    public static void main(String[] args) {
//
//    }
//
//    public static boolean isValidSudoku(char[][] board) {
//        for (int i = 0; i < 9; i++) {
//            Map<Character, Integer> hm = new HashMap<>();
//            Map<Character, Integer> vm = new HashMap<>();
//            for (int j = 0; j < 9; j++) {
//                // contains a duplicate value
//                if (!isValidChar(board[i][j])){
//                    return false;
//                }
//                if (board[i][j] != '.' && hm.get(board[i][j]) != null) {
//                    return false;
//                }
//                hm.put(board[i][j], 1);
//
//                // contains a duplicate value
//                if (!isValidChar(board[j][i])){
//                    return false;
//                }
//                if (board[j][i] != '.' && hm.get(board[j][i]) != null) {
//                    return false;
//                }
//                vm.put(board[j][i], 1);
//            }
//        }
//
//        for (int i = 0; i < ; i++) {
//
//        }
//    }
//
//    static boolean isValidChar(char c) {
//        return c == '.' || c >= '1' && c <= '9';
//    }
//}
