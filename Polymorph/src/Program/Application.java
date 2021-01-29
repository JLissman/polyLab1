package Polymorph.src.Program;
import Polymorph.src.Menu.Input;
import Polymorph.src.Menu.UIManager;
import Polymorph.src.Tools.ErrorHandler.Validator;

public class Application {

    public static void main(String[] args)
    {
        while (true)
        {
            try
            {

                UIManager.Instance().DisplayMultiChoice("MenuShit", "do x", "do y");
                int choice = Input.GetInt(0,1,2);


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
                String option = Input.GetString(false, "y", "n");

                if(!Validator.IsValid(option) || option.equals("n"))
                return;
            }
        }



    }

}

