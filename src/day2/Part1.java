package day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Part1
{
    public static boolean isValid(String line)
    {
        String[] game;
        game = line.split(";");
        for (String round : game)
        {
            String[] temp = round.split(" ");
            for (int i = 0; i < temp.length; i += 2)
            {
                if (Objects.equals(temp[i], ""))    i++;
                if (Integer.parseInt(temp[i]) > 12 && Objects.equals(temp[i + 1], "red"))   return false;
                if (Integer.parseInt(temp[i]) > 13 && Objects.equals(temp[i + 1], "green"))   return false;
                if (Integer.parseInt(temp[i]) > 14 && Objects.equals(temp[i + 1], "blue"))   return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        String temp;
        int game = 1, sum = 0;
        Scanner data = new Scanner(new File("C:\\Users\\Admin\\Desktop\\AdventOfCode23\\src\\day2\\data.txt"));
        while (data.hasNextLine())
        {
            temp = data.nextLine();
            temp = temp.substring(temp.indexOf(":")+2).replace(",", "");

            if (isValid(temp))  sum += game;
            game++;
        }
        System.out.println(sum);
    }
}