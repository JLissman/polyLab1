package Polymorph.src.Managers;

import Polymorph.src.Employees.*;
import Polymorph.src.Tools.ErrorHandler;
import Polymorph.src.Tools.Generator;
import Polymorph.src.Tools.Statistics;

public class MenuManager
{
    private static MenuManager m_instance = null;
    public  static MenuManager Instance(){
        if(m_instance == null)
            m_instance = new MenuManager();

        return m_instance;
    }

    public static int PrintMultiChoice(String title, String... options)
    {
        int choice = 0;
        do {
            DisplayManager.Instance().MultiInputChoice(title, options);
            DisplayManager.Instance().InputChoice("INPUT");
            choice = InputManager.GetBetween(0, options.length);
            System.out.println(choice);
        }while(!ErrorHandler.Input.IsValid(choice));

        return choice;
    }
    public static void PrintInformation(String title, String... line)
    {
        DisplayManager.Instance().MultiInfoLine(title, line);
        InputManager.GetString();
    }
    public static void Exit()
    {
        System.exit(0);
    }

    public void StartProgram(EmployeeManager business)
    {
        int choice = 0;
        choice = PrintMultiChoice("Pre Main-Menu",
                "Generate 20 random employees",
                        "Continue with empty business");

        switch (choice)
        {
            case 0:
                Exit();
                break;
            case 1:
                business = Generator.GenerateWorkers(20);
                System.out.println("Generated 20 workers");
                break;

        }

        do
        {
            choice = PrintMultiChoice("Main Menu",
                    "Statistics",
                    "Worker-Manager");
            switch (choice)
            {
                case 1:
                    DisplayStatistics(business);
                    break;
                case 2:
                    DisplayEmployeeManager(business);
                    break;
            }
        }while(choice != 0);
    }
    public void DisplayStatistics(EmployeeManager business)
    {
        int choice = 0;
        String title = "Statistics Menu";
        do
        {
            choice = PrintMultiChoice(title,
                    "Get Lowest Salary",
                    "Get Overall Average Salary",
                    "Get Average Salary By Position",
                    "Get Overall Average Sex Distribution",
                    "Get Average Sex By Position");

            switch (choice)
            {

                case 1:
                    PrintInformation(title, Statistics.getLowestSalary(business));
                    break;

                case 2:
                    PrintInformation(title, Statistics.getOverallAverageSalary(business));
                    break;

                case 3:
                    PrintInformation(title, Statistics.getAverageSalaryByPos(business));
                    break;

                case 4:
                    PrintInformation(title, Statistics.getOverallAveragesSex(business));
                    break;

                case 5:
                    PrintInformation(title, Statistics.getAverageSexByPos(business));
                    break;
            }
        }while (choice != 0);
    }

    public void DisplayEmployeeManager(EmployeeManager business)
    {
        int choice = 0;
        String title = "Manager Menu";
        do
        {
            choice = PrintMultiChoice(title,
                    "Print All Employees",
                    "Add Employee",
                    "Remove Employee",
                    "Change Employee Name",
                    "Get Employee-information"
                    );

            switch (choice)
            {
                case 1:
                    String[] temp = new String[business.GetAllEmployees().size()];
                    for(int i = 0; i < temp.length; i++){
                        temp[i] = business.GetAllEmployees().get(i).toString();
                    }
                    PrintInformation("Employee OverView", temp);
                    break;
                case 2:
                    AddEmployee(business);
                    break;
                case 3:
                    RemoveEmployee(business);
                    break;
                case 4:
                    UpdateEmployeeName(business);
                    break;
                case 5:
                    GetUniqueEmployeeInfo(business);
                    break;
            }
        }while(choice != 0);
    }

    private void AddEmployee(EmployeeManager business)
    {

        DisplayManager.Instance().DisplayLines("Enter name of new employee");
        DisplayManager.Instance().InputChoice("NAME");
        String name = InputManager.GetString();

        DisplayManager.Instance().DisplayLines("Enter sex of new employee");
        DisplayManager.Instance().InputChoice("SEX");
        String sex = InputManager.GetString();

        DisplayManager.Instance().DisplayLines("Enter age of new employee");
        DisplayManager.Instance().InputChoice("AGE");
        int age = InputManager.GetInt();

        int posChoice = PrintMultiChoice("POSITION", "Human resources", "Salesman", "Secretary", "Technician");
        switch(posChoice)
        {
            case 1:
                business.AddEmployee(new HR(name, age,sex));
                break;
            case 2:
                business.AddEmployee(new Sales(name, age,sex));
                break;
            case 3:
                business.AddEmployee(new Secretary(name, age,sex));
                break;
            case 4:
                business.AddEmployee(new Technician(name, age,sex));
                break;
        }

    }
    private void RemoveEmployee(EmployeeManager business)
    {
        DisplayManager.Instance().DisplayLines("Enter ID of employee");
        DisplayManager.Instance().InputChoice("ID");
        int ID = InputManager.GetInt();
        business.RemoveEmployee(ID);
    }
    private void UpdateEmployeeName(EmployeeManager business)
    {
        DisplayManager.Instance().DisplayLines("Enter ID of employee");
        DisplayManager.Instance().InputChoice("ID");
        int ID = InputManager.GetInt();
        DisplayManager.Instance().DisplayLines("Enter new name of employee");
        DisplayManager.Instance().InputChoice("NAME");
        String name = InputManager.GetString();
        business.UpdateEmployeeName(ID, name);
    }
    private void GetUniqueEmployeeInfo(EmployeeManager business)
    {
        DisplayManager.Instance().DisplayLines("Enter ID of employee");
        DisplayManager.Instance().InputChoice("ID");
        int ID = InputManager.GetInt();

        Employee emp = business.GetEmployee(ID);
        if(emp == null)
            return;
        PrintInformation(emp.getName() + " - Info", emp.toString());

    }
}
