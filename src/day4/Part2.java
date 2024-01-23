package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        String temp;
        int countWinningNumbers;
        String[] card, winningtemp, numstemp;
        Scanner data = new Scanner(new File("C:\\Users\\Admin\\Desktop\\AdventOfCode23\\src\\day4\\data.txt"));
        List<String> cards = new ArrayList<>();

        while (data.hasNextLine())
            cards.add(data.nextLine());

        List<String> cardsWithCopies = new ArrayList<>(cards);
        for (int i = 0; i < cards.size(); i++) {
            temp = cards.get(i);
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

            int tmp = Collections.frequency(cardsWithCopies, cards.get(i));
            for (int n = 0; n < tmp; n++)
                for (int j = 1; j <= countWinningNumbers; j++)
                    cardsWithCopies.add(cards.get(i + j));
        }
        System.out.println(cardsWithCopies.size());
    }
}
