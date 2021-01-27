/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;

import polymorph.Employees.*;
import polymorph.EmployeeManagement.*;
import java.text.DecimalFormat;
/**
 *
 * @author Jonathan & Salar
 */
public class Statistics {
    static DecimalFormat formaterare = new DecimalFormat("#0.00");
    public static String getLowestSalary(EmployeeManagement business) {
        int min = 140000;
        String name = "", pos = "";

        for (Employee e : business.GetAllEmployees()) {
            if (e.getSalary() < min) {
                min = e.getSalary();
                name = e.getName();
                pos = e.getPosition();

            }

        }

        return "The lowest salary is " + min + " and is held by " + name + " that works at position " + pos;

    }

    public static String getHighestSalary(EmployeeManagement business) {
        int max = 0;
        String name = "", pos = "";
        for (Employee e : business.GetAllEmployees()) {
            if (e.getSalary() > max) {
                max = e.getSalary();
                name = e.getName();
                pos = e.getPosition();
            }

        }

        return "The highest salary is " + max + " and is held by " + name + " that works at position " + pos;

    }

    public static String getOverallAverageSalary(EmployeeManagement business) {
        double tot = 0;

        for (Employee e : business.GetAllEmployees()) {
            tot = tot + e.getSalary();
        }

        double avg = tot / business.GetAllEmployees().size();
        return "The average salary across the compary is " + formaterare.format(avg);
    }

    public static String getAverageSalaryByPos(EmployeeManagement business) {
        double totTech = 0, totSales = 0, totHR = 0, totSec = 0;
        double avgTech = 0, avgSales = 0, avgHR = 0, avgSec = 0;
        int techC = 0, saleC = 0, hrC = 0, secC = 0;
        for (Employee e : business.GetAllEmployees()) {
            if (e instanceof Technician) {
                techC++;
                totTech = totTech + e.getSalary();
            }
            if (e instanceof HR) {
                hrC++;
                totHR = totHR + e.getSalary();
            }
            if (e instanceof Sales) {
                saleC++;
                totSales = totSales + e.getSalary();

            }
            if (e instanceof Secretary) {
                secC++;
                totSec = totSec + e.getSalary();

            }

        }
        avgTech = totTech / techC;
        avgHR = totHR / hrC;
        avgSales = totSales / saleC;
        avgSec = totSec / secC;

        return "The average salary for a Technician is " + formaterare.format(avgTech) + " \nThe average salary for a salesperson is " + formaterare.format(avgSales) + " \nThe average salary for HR is " + formaterare.format(avgHR) + "\nThe average salary for a secretary is " + formaterare.format(avgSec);
    }
    
    public static String getSexAverages(EmployeeManagement business){
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
    
    public static String getSexByPosition(EmployeeManagement business){
        double techM = 0, hrM = 0, saleM = 0, secM = 0;
        double techF = 0, hrF = 0, saleF = 0, secF = 0;
        for (Employee e : business.GetAllEmployees()){
            String sex = e.getSex();
            String pos = e.getPosition();
            switch(sex){
                case("Male"):{
                
                switch(pos){
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
                case("Female"):{
                switch(pos){
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
            }}
            
        }
        System.out.println(techM);
        System.out.println(techF);
    return "Out of "+(techM+techF)+" technicians there is "+formaterare.format((techM/(techM+techF))*100)+"% males and "+formaterare.format((techF/(techM+techF))*100)+"% females.\nOut of "+(hrM+hrF)+" in HR there is "+formaterare.format((hrM/(hrM+hrF))*100)+"& males and "+formaterare.format((hrF/(hrM+hrF))*100)+"% females. \nOut of "+(saleM+saleF)+" in Sales there is "+formaterare.format((saleM/(saleM+saleF))*100)+"& males and "+formaterare.format((saleF/(saleM+saleF))*100)+"% females. \nOut of "+(secM+secF)+" Secretaries there is "+formaterare.format((secM/(secM+secF))*100)+"& males and "+formaterare.format((secF/(secM+secF))*100)+"% females. ";
    }
}
