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
    
    
    
    public String getLowestSalary(){
        int min = EmpolyeeManagement.m_employeeList.get(0).getSalary();
        String name = EmpolyeeManagement.m_employeeList.get(0).getName();
        
        for (Employee e : EmpolyeeManagement.m_employeeList) {
            if (e.getSalary() < min){
                min = e.getSalary();
            
            }
            
        }
        
            return "The lowest salary is "+min+" and is held by "+name+" that works at position "+pos;
         
    
    }

    public String getHighestSalary(){
    int max = Employees.get(0).getSalary();
    String name = Employees.get(0).getName();
    String pos = Employees.get(0).getPo
        for (Anstalld e : Employees) {
            if (e.getSalary() > max){
                max = e.getSalary();
                name = e.getName();
            }
            
        }
        
            return "The highest salary is "+max+" and is held by "+name+" that works at position "+pos;
        
        
    }
    

    public static String getOverallAverageSalary(){
        double tot = 0;
        
        for (Anstalld e : Employees) {
            tot = tot + e.getSalary();
        }
        
        double avg = tot / Employees.size();
        return "The average salary across the compary is "+avg;    
    }
    public static String getAverageSalaryByPos(){
        double totTech = 0, totSales = 0, totHR = 0, totSec = 0;
        double avgTech = 0, avgSales = 0, avgHR = 0, avgSec = 0;
        int techC = 0, saleC = 0, hrC = 0, secC = 0;
        for (Anstalld e : Employees) {
            if (e instanceof Tekniker){
                techC++;
                totTech = totTech + e.getSalary();      
            }
            if (e instanceof HR){
                hrC++;
                totHR = totHR + e.getSalary();
            }
            if (e instanceof Sales){
                saleC++;
                totSales = totSales + e.getSalary();
                
            }
            if (e instanceof Secretary){
                secC++;
                totSec = totSec + e.getSalary();
            
            }
            
        }
        avgTech = totTech / techC;
        avgHR = totHR / hrC;
        avgSales = totSales / saleC;
        avgSec = totSec / secC;
    
    return "Average salary for a technician is "+avgTech+" average salary for a salesperson is "+avgSales+" average salary for HR is "+avgHR+" and the average salary for a secretary is "+avgSec;
    }
    
}
