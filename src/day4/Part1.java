package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException
    {
        String temp;
        int sum = 0, points, countWinningNumbers;
        Scanner data = new Scanner(new File("C:\\Users\\Admin\\Desktop\\AdventOfCode23\\src\\day4\\data.txt"));
        while (data.hasNextLine())
        {
            String[] card, winningtemp, numstemp;
            temp = data.nextLine();
            temp = temp.substring(temp.indexOf(":")+2);
            card = temp.split("\\|");

            winningtemp = card[0].split(" ");
            numstemp = card[1].split(" ");

            List<String> winning = new ArrayList<>(List.of(winningtemp));
            winning.removeAll(Arrays.asList("", null));
            List<String> nums = new ArrayList<>(List.of(numstemp));
            nums.removeAll(Arrays.asList("", null));

            countWinningNumbers = 0;
            for(String a : nums)
                for(String b : winning)
                    if(a.equals(b))
                        countWinningNumbers++;

            points = 1;
            if (countWinningNumbers > 0) {
                for (int i= 1; i < countWinningNumbers; i++)
                    points *= 2;
                sum += points;
            }
        }
        System.out.println(sum);
    }
}
