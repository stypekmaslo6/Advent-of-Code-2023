package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Character.isDigit;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner data = new Scanner(new File("C:\\Users\\Admin\\Desktop\\AdventOfCode23\\src\\day5\\data.txt"));
        String[] seedsStr = data.nextLine().split(" ");
        List<String> temp = new ArrayList<>(Arrays.asList(seedsStr));
        temp.removeFirst();
        List<Long> seeds = new ArrayList<>(temp.size());
        for (String s : temp) {
            seeds.add(Long.valueOf(s));
        }
        while (data.hasNextLine()) {
            String line = data.nextLine();
            int[] wasChosen = new int[seeds.size()];
            for (int i = 0; i < seeds.size(); i++) {
                wasChosen[i] = 0;
            }
            while (!line.isEmpty() && isDigit(line.charAt(0))) {
                String[] splitted = line.split(" ");
                long range = Long.parseLong(splitted[2]);
                long tempFrom = Long.parseLong(splitted[1]);
                long tempTo = Long.parseLong(splitted[0]);
                System.out.println(Arrays.toString(splitted));

                for (int j = 0; j < seeds.size(); j++) {
                    long iteration = -1;
                    if (wasChosen[j] != 1) {
                        for (long i = tempFrom; i < tempFrom + range; i++) {
                            iteration++;
                            if (i == seeds.get(j)) {
                                seeds.set(j, iteration + tempTo);
                                wasChosen[j] = 1;
                                break;
                            }
                        }
                    }
                }
                if (data.hasNextLine()) line = data.nextLine();
                else break;
            }
        }
        System.out.println(Collections.min(seeds));
    }
}