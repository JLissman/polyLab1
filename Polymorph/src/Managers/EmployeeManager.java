package Polymorph.src.Managers;

/**
 *
 * @author Jonathan & Salar
 */

import java.util.ArrayList;
import java.util.Random;

import Polymorph.src.Employees.*;

public class EmployeeManager
{
    //Alla anställda i företagets 
    ArrayList<Employee> m_employeeList = new ArrayList();

    public void AddEmployee(Employee employee)
    {
        //Cache-a ID och namnet på den anställda för att kolla om det redan finns en anställd med samma information.
        String possibleEmployeeName = employee.getName();
        
        for (int i = 0; i < m_employeeList.size(); i++) 
        {
            //Finns det redan en anställd med samma namn?
            if(m_employeeList.get(i).getName().equals(possibleEmployeeName))
                return;

        }
        
        int uniqueID = GenerateID();
        employee.setID(uniqueID);
        m_employeeList.add(employee);
    }
    
    public void RemoveEmployee(Employee employee)
    {
        if(m_employeeList.contains(employee))
            m_employeeList.remove(employee);
    }
    public void RemoveEmployee(int ID)
    {
        if(IDCheck(ID)) {
            Employee employeeToBeFired = GetEmployee(ID);

            if (employeeToBeFired != null) {
                RemoveEmployee(employeeToBeFired);
            }
        }
    }
    public void RemoveEmployee(String name)
    {
        if(NameCheck(name)) {
            //Hämta employee med angivna namn
            Employee employeeToBeFired = GetEmployee(name);

            //Dubbell-kolla att vi faktist har en employee med namnet.
            if (employeeToBeFired != null) {
                RemoveEmployee(employeeToBeFired);
            }
        }
    }

    public void UpdateEmployeeName(int ID, String name)
    {
        if(IDCheck(ID))
            GetEmployee(ID).setName(name);
    }

    public Employee GetEmployee(int ID)
    {
        for (int i = 0; i < m_employeeList.size(); i++) {
            if(m_employeeList.get(i).getID() == ID)
                return m_employeeList.get(i);
        }
        return null;
    }
    public Employee GetEmployee(String name)
    {
        for (int i = 0; i < m_employeeList.size(); i++) {
            if(m_employeeList.get(i).getName().equals(name))
                return m_employeeList.get(i);
        }
        return null;
    }

    public ArrayList<Employee> GetAllEmployees(){
        return m_employeeList;
    }
    public final int GenerateID()
    {
        Random randomNumGen = new Random();
        int tempId = 0;
        do{
            tempId = randomNumGen.nextInt(10000);
            if(m_employeeList.size() <= 0)
                return tempId;

            for (int i = 0; i < m_employeeList.size(); i++) {
                if(m_employeeList.get(i).getID() == tempId)
                    tempId = -1;
            }
        }while(tempId == -1);
        
        return tempId;
    }
    public boolean NameCheck(String name)
    {
        for(Employee emp : m_employeeList){
            if(emp.getName().equals(name))
                return true;
        }
        System.out.println("Employee with the name " + name);
        return false;
    }

    public boolean IDCheck(int ID)
    {
        for(Employee emp : m_employeeList){
            if(emp.getID() == ID)
                return true;
        }
        System.out.println("Employee with the ID " + ID);
        return false;
    }
}
