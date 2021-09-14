package misc;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Program {
    public static String defangIPaddr(String address) {
        return Stream.of(address)
                .map(x -> x.replace(".", "[.]"))
                .collect(Collectors.joining());
    }

    public static int numJewelsInStones(String jewels, String stones) {
        return (int) Stream.of(stones.split(""))
                .filter(jewels::contains)
                .count();
    }

    // goal parser
    public static String interpret(String command) {
        return Stream.of(command)
                .map(x -> x.replaceAll("\\(al\\)", "al"))
                .map(x -> x.replaceAll("\\(\\)", "o"))
                .collect(Collectors.joining());
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int a = 0;
        int counter = 0;
        switch (ruleKey) {
            case "type" -> a = 0;
            case "color" -> a = 1;
            case "name" -> a = 2;
        }
        for (List list : items) {
            if (list.get(a).equals(ruleValue)) {
                counter++;
            }
        }

        return counter;
    }

    public static String restoreString(String s, int[] indices) {
        char[] target = new char[indices.length];
        for (int i = 0; i < s.length(); i++) {
            target[indices[i]] = s.charAt(i);
        }
        return String.valueOf(target);
    }

    public static char[] swap(char[] array, int index1, int index2) {
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }


    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> list = new ArrayList<>();

        // Start in the kings position and go out in all directions until we hit a queen.
        int[][] DIRS = new int[][]{{1, 1}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}, {1, -1}};
        int[][] chessBoard = new int[8][8];

        chessBoard[king[0]][king[1]] = 2;

        for (int[] queen : queens) chessBoard[queen[0]][queen[1]] = 9;
        int[] position = new int[2];
        position[0] = king[0];
        position[1] = king[1];
        boolean run = true;
        //direction right
        for (int i = 0; i < DIRS.length; i++) {
            position[0] = king[0];
            position[1] = king[1];
            while (run) {
                if (position[0] + DIRS[i][0] > chessBoard.length - 1 || position[1] + DIRS[i][1] > chessBoard.length - 1 || position[0] + DIRS[i][0] < 0 || position[1] + DIRS[i][1] < 0) {
                    run = false;
                } else {
                    position[0] += DIRS[i][0]; //Increment x based on the direction we are moving in
                    position[1] += DIRS[i][1]; //Increment y based on the direction we are moving in
                }

                if (chessBoard[position[0]][position[1]] == 9) {
                    run = false;
                    list.add(List.of(position[0], position[1]));
                }
            }

            run = true;
        }

        return list;
    }


    public static void main(String[] args) {
        defangIPaddr("1.1.1.1.1");
        System.out.println(numJewelsInStones("aabc", "aaAAb"));
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(interpret("G()()()()(al)"));
        String ruleKey = "color", ruleValue = "silver";
        List<List<String>> list = List.of(List.of("phone", "blue", "pixel"), List.of("computer", "silver", "lenovo"), List.of("phone", "gold", "iphone"));
        System.out.println(countMatches(list, ruleKey, ruleValue));
        int[][] queens = new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = new int[]{0, 0};
        System.out.println(queensAttacktheKing(queens, king));

    }
}
