package Polymorph.src.Tools;

import Polymorph.src.Managers.EmployeeManager;
import Polymorph.src.Employees.*;

import java.text.DecimalFormat;
/**
 *
 * @author Jonathan & Salar
 */
public class Statistics
{
    static DecimalFormat formaterare = new DecimalFormat("#0.00");
    public static String getLowestSalary(EmployeeManager business)
    {
        double min = Integer.MAX_VALUE;
        Employee temp = new Employee();

        for (Employee e : business.GetAllEmployees()) {
            if (e.getSalary() < min) {
                min = e.getSalary();
                temp = e;
            }
        }
        return "The lowest salary is currently held by " +  temp.getName() + " with " + min + "kr.";
    }
    public static String getHighestSalary(EmployeeManager business)
    {
        double max = Integer.MIN_VALUE;
        Employee temp = new Employee();

        for (Employee e : business.GetAllEmployees()) {
            if (e.getSalary() > max) {
                max = e.getSalary();
                temp = e;
            }
        }
        return "The highest salary is currently held by " + temp.getName() + " with " + max + "kr.";
    }
    public static String getOverallAverageSalary(EmployeeManager business)
    {
        double tot = 0;

        for (Employee e : business.GetAllEmployees()) {
            tot = tot + e.getSalary();
        }

        double avg = tot / business.GetAllEmployees().size();
        return "The average salary across the compary is " + formaterare.format(avg) + "kr.";
    }

    public static String[] getAverageSalaryByPos(EmployeeManager business)
    {
        double totTech = 0, totSales = 0, totHR = 0, totSec = 0;
        double avgTech = 0, avgSales = 0, avgHR = 0, avgSec = 0;
        int techC = 0, saleC = 0, hrC = 0, secC = 0;
        for (Employee employee : business.GetAllEmployees())
        {
            if (employee instanceof Technician) {
                techC++;
                totTech = totTech + employee.getSalary();
            }
            if (employee instanceof HR) {
                hrC++;
                totHR = totHR + employee.getSalary();
            }
            if (employee instanceof Sales) {
                saleC++;
                totSales = totSales + employee.getSalary();

            }
            if (employee instanceof Secretary) {
                secC++;
                totSec = totSec + employee.getSalary();

            }
        }
        avgTech = totTech / techC;
        avgHR = totHR / hrC;
        avgSales = totSales / saleC;
        avgSec = totSec / secC;

        String[] temp = new String[] {
                "The average salary for a Technician is  "  + formaterare.format(avgTech) + "kr.",
                "The average salary for a salesperson is " + formaterare.format(avgSales) + "kr.",
                "The average salary for a HR-rep is      "            + formaterare.format(avgHR) + "kr.",
                "The average salary for a secretary is   "   + formaterare.format(avgSec) + "kr."
        };
        return temp;
    }
    
    public static String getOverallAveragesSex(EmployeeManager business)
    {
        double male = 0, female = 0;
        for (Employee e : business.GetAllEmployees()) {
            String sex = e.getSex();
            if (sex == "Male"){
                male++;
            }else if (sex == "Female"){
                female++;
            }else{
                System.out.println("No sex??");
            }
        }
        double tot = male+female;
        double malePerc = male/tot*100;
        double fmalePerc = female/tot*100;
                
        return "Out of all "+tot+" employees, "+formaterare.format(malePerc)+"% is male and "+formaterare.format(fmalePerc)+"% is female";
    }
    
    public static String[] getAverageSexByPos(EmployeeManager business)
    {
        double techM = 0, hrM = 0, saleM = 0, secM = 0;
        double techF = 0, hrF = 0, saleF = 0, secF = 0;
        for (Employee e : business.GetAllEmployees()){
            String sex = e.getSex();
            String pos = e.getPosition();
            switch(sex)
            {
                case("Male"):
                {
                    switch(pos)
                    {
                        case("HR"):
                            hrM++;
                            break;
                        case("Sales"):
                            saleM++;
                            break;
                        case("Secretary"):
                            secM++;
                            break;
                        case("Technician"):
                            techM++;
                            break;
                        default:
                            System.out.println("no position found");
                            break;
                    }
                }
                case("Female"):
                {
                    switch(pos)
                    {
                        case("HR"):
                            hrF++;
                            break;
                        case("Sales"):
                            saleF++;
                            break;
                        case("Secretary"):
                            secF++;
                            break;
                        case("Technician"):
                            techF++;
                            break;
                        default:
                            System.out.println("no position found");
                            break;
                    }
                }
            }
        }
        String[] temp = new String[] {
                "Out of "+(techM+techF)+" technicians there are "+formaterare.format((techM/(techM+techF))*100)+"% males and "+formaterare.format((techF/(techM+techF))*100)+"% females.",
                "Out of "+(hrM+hrF)+" in HR there is "+formaterare.format((hrM/(hrM+hrF))*100)+"% males and "+formaterare.format((hrF/(hrM+hrF))*100)+"% females. ",
                "Out of "+(saleM+saleF)+" in Sales there is "+formaterare.format((saleM/(saleM+saleF))*100)+"% males and "+formaterare.format((saleF/(saleM+saleF))*100)+"% females. ",
                "Out of "+(secM+secF)+" Secretaries there is "+formaterare.format((secM/(secM+secF))*100)+"% males and "+formaterare.format((secF/(secM+secF))*100)+"% females. "
        };
        return temp;
    }

    public static String getOverallBonus(EmployeeManager business){
        double overallBonus = 0;
        for (Employee employee : business.GetAllEmployees())
        {
            overallBonus += employee.getBonus();
        }
        return "The total amount of all bonuses from all branches is" + overallBonus + "kr.";
    }
    public static String[] getOverallBonusByPos(EmployeeManager business)
    {
        double totTech = 0, totHR = 0, totSales = 0, totSec = 0;
        for(Employee employee : business.GetAllEmployees())
        {
            if (employee instanceof Technician) {
                totTech = employee.getSalary();
            }
            if (employee instanceof HR) {
                totHR = employee.getSalary();
            }
            if (employee instanceof Sales) {
                totSales = employee.getSalary();

            }
            if (employee instanceof Secretary) {
                totSec = employee.getSalary();
            }
        }
        String[] temp = new String[]
        {
                "The total amount of all bonuses for the tech-role: " + totTech + "kr.",
                "The total amount of all bonuses for the HR-role: " + totHR + "kr.",
                "The total amount of all bonuses for the Secretary-role: " + totSec + "kr.",
                "The total amount of all bonuses for the Sales-role: " + totSales + "kr.",
        };
        return temp;
    }
}
