package Polymorph.src.Program;
import Polymorph.src.Managers.InputManager;
import Polymorph.src.Tools.ErrorHandler.Validator;
import Polymorph.src.Tools.Generator;

public class Application {

    public static void main(String[] args)
    {
        while (true)
        {
            try
            {

                //UIManager.Instance().DisplayMultiChoice("MenuShit", "do x", "do y");

                InputManager.GetInt();
                /*
                EmployeeManagement someRandomBusiness = Generator.GenerateWorkers(30);
                someRandomBusiness.PrintAllEmployees();



                System.out.println(Statistics.getAverageSalaryByPos(someRandomBusiness));
                System.out.println(Statistics.getOverallAverageSalary(someRandomBusiness));
                System.out.println(Statistics.getLowestSalary(someRandomBusiness));
                System.out.println(Statistics.getHighestSalary(someRandomBusiness));
                System.out.println(Statistics.getSexAverages(someRandomBusiness));
                System.out.println(Statistics.getSexByPosition(someRandomBusiness));
                 */
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("\n\nContinue (y/n)?");
                System.out.print(" > ");
                String option = InputManager.GetString(false, "y", "n");

                if(!Validator.IsValid(option) || option.equals("n"))
                return;
            }
        }



    }

}

