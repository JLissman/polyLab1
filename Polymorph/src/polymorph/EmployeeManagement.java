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
import java.util.Random;

import polymorph.Employees.Employee;

public class EmployeeManagement 
{
    //Alla anställda i företagets 
    ArrayList<Employee> m_employeeList;

    public void AddEmployee(Employee employee)
    {
        //Cache-a ID och namnet på den anställda för att kolla om det redan finns en anställd med samma information.
        String possibleEmployeeName = employee.getName();
        
        for (int i = 0; i < m_employeeList.size(); i++) 
        {
            //Finns det redan en anställd med samma namn?
            if(m_employeeList.get(i).getName().equals(possibleEmployeeName))
            {
                System.out.println("An employee by the name: " + possibleEmployeeName + " already exists!");
                return;
            }
        }
        
        int uniqueID = GenerateID();
        employee.setID(uniqueID);
        
        System.out.println(employee.getName() + " has joined the team!");
        m_employeeList.add(employee);
    }
    
    public void RemoveEmployee(Employee employee)
    {
        System.out.println(employee.getName() + "has been let go, during the pandemic. Way to go, buddy.");
        m_employeeList.remove(employee);
    }
    public void RemoveEmployee(int ID)
    {
        //Hämta employee med angivna ID
        Employee employeeToBeFired = GetEmployee(ID);
        
        //Dubbell-kolla att vi faktist har en employee med det ID.
        if(employeeToBeFired != null){
        RemoveEmployee(employeeToBeFired);
        }    
    }
    public void RemoveEmployee(String name)
    {
        //Hämta employee med angivna namn
        Employee employeeToBeFired = GetEmployee(name);
        
        //Dubbell-kolla att vi faktist har en employee med namnet.
        if(employeeToBeFired != null){
        RemoveEmployee(employeeToBeFired);
        }    
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
    
    
    public final int GenerateID(){
        
        Random randomNumberGenerator = new Random();
        int tempId;
        do{
            tempId = randomNumberGenerator.nextInt(10000);
            if(m_employeeList.size() <= 0)
                return tempId;
        
            for (int i = 0; i < m_employeeList.size(); i++) {
                if(m_employeeList.get(i).getID() == tempId)
                    tempId = -1;
            }
        }while(tempId == -1);
        
        return tempId;
    }
}
