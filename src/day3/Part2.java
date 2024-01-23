package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part2
{
    public static Integer findNum(int idx, String line) {
        if (Character.isDigit(line.charAt(idx))) {
            int lastIndex = idx;
            while(lastIndex != line.length() && Character.isDigit(line.charAt(lastIndex)))
                lastIndex++;
            int firstIndex = lastIndex - 1;
            while(firstIndex != 0 && Character.isDigit(line.charAt(firstIndex)))
                firstIndex--;
            if (firstIndex != 0 || !Character.isDigit(line.charAt(firstIndex))) firstIndex++;

            return Integer.parseInt(line.substring(firstIndex, lastIndex));
        }
        return 0;
    }
    public static boolean isAsterisk(char s) {
        return s == '*';
    }
    public static void main(String[] args) throws FileNotFoundException {
        List<String> schematic = new ArrayList<>();
        int sum = 0;
        Scanner data = new Scanner(new File("C:\\Users\\Admin\\Desktop\\AdventOfCode23\\src\\day3\\data.txt"));
        while (data.hasNextLine())
            schematic.add(data.nextLine());
        for (int i = 1; i < schematic.size(); i++) {
            for (int n = 1; n < schematic.get(i).length(); n++) {
                if (isAsterisk(schematic.get(i).charAt(n))) {
                    List<Integer> nums = new ArrayList<>();
                    nums.add(findNum(n + 1, schematic.get(i)));
                    nums.add(findNum(n - 1, schematic.get(i)));
                    nums.add(findNum(n - 1, schematic.get(i - 1)));
                    nums.add(findNum(n - 1, schematic.get(i + 1)));
                    nums.add(findNum(n + 1, schematic.get(i - 1)));
                    nums.add(findNum(n + 1, schematic.get(i + 1)));
                    nums.add(findNum(n, schematic.get(i + 1)));
                    nums.add(findNum(n, schematic.get(i - 1)));
                    Set<Integer> finalnums = new HashSet<>(nums);
                    if (finalnums.size() == 3) {
                        nums = new ArrayList<>(finalnums);
                        nums.remove((Integer) 0);
                        sum += nums.get(0) * nums.get(1);
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
