package polymorph.Menu;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Input
{
    Scanner sc;
    private Input(){
        sc = new Scanner(System.in);
    }
    private static Input m_instance = null;
    public  static Input Instance()
    {
        if(m_instance == null)
            m_instance = new Input();

        return m_instance;
    }


    //Vår egna get metod för att mata in en int/double/String
    public int GetInt()
    {
        int temp = sc.nextInt();
        sc.nextLine();
        return temp;
    }
    public double  GetDouble()
    {
        double temp = sc.nextDouble();
        sc.nextLine();
        return temp;
    }
    public String GetString()
    {
        return sc.nextLine();
    }

    //Med dessa metoder kan vi nu begränsa vilka värden som passeras in.
    //Om värdet inte matchar vår constraint returnerar den antingen  -1 eller null.
    public int GetInt(int... constraint)
    {
        int temp = GetInt();

        // Om värdet i temp inte matchar en enda constraint ses det som en fail och returnerar -1
        if(!Arrays.stream(constraint).anyMatch(i -> temp == i))
        {
            return -1;
        }

        return temp;
    }
    public double GetDouble(double... constraint)
    {
        double temp = GetDouble();

        // Om värdet i temp inte matchar en enda constraint ses det som en fail och returnerar -1
        if(!Arrays.stream(constraint).anyMatch(i -> temp == i))
        {
            return -1;
        }

        return temp;
    }
    public String GetString(boolean isCaseSensitive, String... constraint)
    {
        if(!isCaseSensitive)
        {
            String lowerCaseInput = GetString();
            for (int i = 0; i < constraint.length; i++)
            {
                constraint[i] = constraint[i].toLowerCase();
            }
            if(!Arrays.stream(constraint).anyMatch(i -> lowerCaseInput.equals(i)))
                return null;

            return lowerCaseInput;
        }
        else
        {
            String normalCase = GetString();
            if(!Arrays.stream(constraint).anyMatch(i -> normalCase.equals(i)))
                return null;

            return normalCase;
        }

    }
}
