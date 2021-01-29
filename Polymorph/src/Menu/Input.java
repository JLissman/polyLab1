package Polymorph.src.Menu;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jonathan & Salar
 */

public class Input
{
    static Scanner sc = new Scanner(System.in);

    //Vår egna get metod för att mata in en int/double/String
    public static int GetInt()
    {
        int temp = Integer.parseInt(GetString());
        return temp;
    }
    public static double  GetDouble()
    {
        double temp = Double.parseDouble(GetString());
        return temp;
    }
    public static String GetString()
    {
        return sc.nextLine();
    }

    //Med dessa metoder kan vi nu begränsa vilka värden som passeras in.
    //Om värdet inte matchar vår constraint returnerar den antingen  -1 eller null.
    public static int GetInt(int... constraint)
    {
        int temp = GetInt();

        // Om värdet i temp inte matchar en enda constraint ses det som en fail och returnerar -1
        if(Arrays.stream(constraint).noneMatch(i -> temp == i))
        {
            return -1;
        }

        return temp;
    }
    public static int GetBetween(int start, int end)
    {
        int temp = GetInt();
        if(temp < start || temp > end)
            return -1;

        return temp;
    }
    public static double GetDouble(double... constraint)
    {
        double temp = GetDouble();

        // Om värdet i temp inte matchar en enda constraint ses det som en fail och returnerar -1
        if(Arrays.stream(constraint).noneMatch(i -> temp == i))
        {
            return -1;
        }

        return temp;
    }
    public static double GetBetween(double start, double end)
    {
        double temp = GetDouble();
        if(temp < start || temp > end)
            return -1;

        return temp;
    }
    public static String GetString(boolean isCaseSensitive, String... constraint)
    {
        if(!isCaseSensitive)
        {
            String lowerCaseInput = GetString();
            for (int i = 0; i < constraint.length; i++)
            {
                constraint[i] = constraint[i].toLowerCase();
            }
            if(Arrays.stream(constraint).noneMatch(i -> lowerCaseInput.equals(i)))
                return null;

            return lowerCaseInput;
        }
        else
        {
            String normalCase = GetString();
            if(Arrays.stream(constraint).noneMatch(i -> normalCase.equals(i)))
                return null;

            return normalCase;
        }

    }
}
