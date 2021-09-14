package misc;

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
    }
}
