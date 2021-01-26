/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;

import polymorph.Employees.*;
import polymorph.EmployeeManagement.*;

/**
 *
 * @author Jonathan
 */
public class Statistics {

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
        return "The average salary across the compary is " + avg;
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

        return "Average salary for a technician is " + avgTech + " average salary for a salesperson is " + avgSales + " average salary for HR is " + avgHR + " and the average salary for a secretary is " + avgSec;
    }

}
