package Polymorph.src.Program;

import Polymorph.src.Managers.*;

public class Application
{


    public static void main(String[] args)
    {
        EmployeeManager someRandomBusiness = new EmployeeManager();
        try
        {
           MenuManager.Instance().StartProgram(someRandomBusiness);
        }
        catch(Exception e)
        {
            System.out.println("\n");
            System.out.println(e);
            e.printStackTrace(System.out);
            System.out.println("\n");
        }
    }


}

