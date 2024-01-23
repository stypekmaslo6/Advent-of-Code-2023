package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1
{
    public static boolean isSpecial(char s) {
        String specialChars = "!\"#$%&'()*+,-/:;<=>?@[\\]^_`{|}`";
        for (int i = 0; i < specialChars.length(); i++) {
            if (specialChars.charAt(i) == s) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        List<String> schematic = new ArrayList<>();
        int sum = 0;
        Scanner data = new Scanner(new File("C:\\Users\\Admin\\Desktop\\AdventOfCode23\\src\\day3\\data.txt"));
        while (data.hasNextLine())
            schematic.add(data.nextLine());
        for (int i = 0; i < schematic.size(); i++)
        {
            int indexFirst, indexLast;
            String num = "";
            for (int n = 0; n < schematic.get(i).length(); n++)
                if(schematic.get(i).charAt(n) >= '0' && schematic.get(i).charAt(n) <= '9')
                {
                    num = "";
                    indexFirst = n;
                    while (n < schematic.get(i).length() && (schematic.get(i).charAt(n) >= '0' && schematic.get(i).charAt(n) <= '9'))
                    {
                        num += schematic.get(i).charAt(n);
                        n++;
                    }

                    indexLast = n - 1;
                    //check if it's the first line
                    int j;
                    if (i == 0)
                    {
                        //check if first digit is a first char in line
                        if (indexFirst == 0)
                        {
                            for (j = indexFirst; j <= indexLast + 1; j++)
                                if(isSpecial(schematic.get(i+1).charAt(j)) || isSpecial(schematic.get(i).charAt(indexLast + 1)))
                                {
                                    sum += Integer.parseInt(num);
                                    break;
                                }
                        }
                        //check if last digit is a last char in line
                        else if (indexLast == schematic.get(i).length() - 1)
                        {
                            for (j = indexFirst - 1; j <= indexLast; j++)
                                if(isSpecial(schematic.get(i+1).charAt(j)) || isSpecial(schematic.get(i).charAt(indexFirst-1)))
                                {
                                    sum += Integer.parseInt(num);
                                    break;
                                }
                        }
                        //else it's in the middle of line
                        else
                        {
                            for (j = indexFirst - 1; j <= indexLast + 1; j++)
                                if(isSpecial(schematic.get(i+1).charAt(j)) || isSpecial(schematic.get(i).charAt(indexFirst-1)) || isSpecial(schematic.get(i).charAt(indexLast + 1)))
                                {
                                    sum += Integer.parseInt(num);
                                    break;
                                }
                        }
                    }
                    //check if it's the last line
                    else if ( i == schematic.size() -1)
                    {
                        //check if first digit is a first char in line
                        if (indexFirst == 0)
                        {
                            for (j = indexFirst; j <= indexLast + 1; j++)
                                if(isSpecial(schematic.get(i-1).charAt(j)) || isSpecial(schematic.get(i).charAt(indexLast+1)))
                                {
                                    sum += Integer.parseInt(num);
                                    break;
                                }
                        }
                        //check if last digit is a last char in line
                        else if (indexLast == schematic.get(i).length()-1)
                        {
                            for (j = indexFirst - 1; j <= indexLast; j++)
                                if(isSpecial(schematic.get(i-1).charAt(j)) || isSpecial(schematic.get(i).charAt(indexFirst-1)))
                                {
                                    sum += Integer.parseInt(num);
                                    break;
                                }
                        }
                        else
                        {
                            for (j = indexFirst - 1; j <= indexLast + 1; j++)
                                if(isSpecial(schematic.get(i-1).charAt(j)) || isSpecial(schematic.get(i).charAt(indexFirst-1)) || isSpecial(schematic.get(i).charAt(indexLast + 1)))
                                {
                                    sum += Integer.parseInt(num);
                                    break;
                                }
                        }
                    }
                    //else it's in the middle
                    else
                    {
                        //check if first digit is a first char in line
                        if (indexFirst == 0)
                        {
                            for (j = indexFirst; j <= indexLast + 1; j++)
                                if(isSpecial(schematic.get(i-1).charAt(j)) || isSpecial(schematic.get(i+1).charAt(j)) || isSpecial(schematic.get(i).charAt(indexLast + 1)))
                                {
                                    sum += Integer.parseInt(num);
                                    break;
                                }
                        }
                        //check if first digit is a last char in line
                        else if (indexLast == schematic.get(i).length() - 1)
                        {
                            for (j = indexFirst - 1; j <= indexLast; j++)
                                if(isSpecial(schematic.get(i-1).charAt(j)) || isSpecial(schematic.get(i+1).charAt(j)) || isSpecial(schematic.get(i).charAt(indexFirst-1)))
                                {
                                    sum += Integer.parseInt(num);
                                    break;
                                }
                        }
                        else
                        {

                            for (j = indexFirst - 1; j <= indexLast + 1; j++)
                                if(isSpecial(schematic.get(i-1).charAt(j)) || isSpecial(schematic.get(i+1).charAt(j)) || isSpecial(schematic.get(i).charAt(indexFirst-1)) || isSpecial(schematic.get(i).charAt(indexLast + 1)))
                                {
                                    sum += Integer.parseInt(num);
                                    break;
                                }
                        }
                    }
                }
        }
        System.out.println(sum);
    }
}