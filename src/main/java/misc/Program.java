package misc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    public static void main(String[] args) {
        defangIPaddr("1.1.1.1.1");
        System.out.println(numJewelsInStones("aabc", "aaAAb"));
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(interpret("G()()()()(al)"));
        String ruleKey = "color", ruleValue = "silver";
        List<List<String>> list = List.of(List.of("phone", "blue", "pixel"), List.of("computer", "silver", "lenovo"), List.of("phone", "gold", "iphone"));
        System.out.println(countMatches(list, ruleKey, ruleValue));

    }
}
