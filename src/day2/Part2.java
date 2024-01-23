package day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Part2
{
    static List<Integer> red = new ArrayList<>(), blue = new ArrayList<>(), green = new ArrayList<>();
    public static int findPower(String line)
    {

        String[] game;
        game = line.split(";");
        for (String round : game)
        {
            String[] temp = round.split(" ");
            for (int i = 0; i < temp.length; i += 2)
            {
                if (Objects.equals(temp[i], ""))    i++;
                if (Objects.equals(temp[i + 1], "red"))     red.add(Integer.parseInt(temp[i]));
                if (Objects.equals(temp[i + 1], "green"))   green.add(Integer.parseInt(temp[i]));
                if (Objects.equals(temp[i + 1], "blue"))    blue.add(Integer.parseInt(temp[i]));
            }
        }
        return Collections.max(red) * Collections.max(blue) * Collections.max(green);
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        String temp;
        int sum = 0;
        Scanner data = new Scanner(new File("C:\\Users\\Admin\\Desktop\\AdventOfCode23\\src\\day2\\data.txt"));
        while (data.hasNextLine())
        {
            red.clear(); green.clear(); blue.clear();
            temp = data.nextLine();
            temp = temp.substring(temp.indexOf(":")+2).replace(",", "");

            sum += findPower(temp);
        }
        System.out.println(sum);
    }
}