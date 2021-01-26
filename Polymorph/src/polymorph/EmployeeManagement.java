/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;

/**
 *
 * @author Jonathan & Salar
 */

import java.util.ArrayList;

import polymorph.Employees.Employee;

public class EmployeeManagement 
{
    //Alla anställda i företagets 
    ArrayList<Employee> m_employeeList;
    
    public void AddEmployee(Employee employee)
    {
        int possibleEmployeeID = employee.getID();
        String possibleEmployeeName = employee.getName();
        
        for (int i = 0; i < m_employeeList.size(); i++) {
            if(m_employeeList.get(i).getID() == possibleEmployeeID)
            {
                System.out.println("An employee with the ID: " + possibleEmployeeID + " already exists!");
                return;
            }
            else if(m_employeeList.get(i).getName().equals(possibleEmployeeName))
            {
                System.out.println("An employee with the name: " + possibleEmployeeName + " already exists!");
                return;
            }
        }
        
        System.out.println(employee.getName() + " has joined the team!");
        m_employeeList.add(employee);
    }
   
    public void AddEmployee(String name){
        
    }
    
    public void RemoveEmployee(Employee employee)
    {
        System.out.println(employee.getName() + "has been let go, during the pandemic. Way to go, buddy.");
        m_employeeList.remove(employee);
    }
    
    public void ClearAll()
    {
        System.out.println("All employees have been let go. Hope you feel good about yourself");
        m_employeeList.clear();
    }
    
  
    public Employee GetEmployee(int ID)
    {
        for (int i = 0; i < m_employeeList.size(); i++) {
            if(m_employeeList.get(i).getID() == ID)
                return m_employeeList.get(i);
        }
        System.out.println("No employee with the ID: " + ID + "!");
        return null;
    }
    public Employee GetEmployee(String name)
    {
        for (int i = 0; i < m_employeeList.size(); i++) {
            if(m_employeeList.get(i).getName().equals(name))
                return m_employeeList.get(i);
        }
        System.out.println("No employee with the name: " + name + "!");
        return null;
    }
}
