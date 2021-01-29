/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;


import Polymorph.*;
/**
 *
 * @author Jonathan
 */
public class EmployeeManagement {

    
    public static void loadEmployees(){
    
    Tekniker e1 = new Tekniker("Dennis",49,"Male",40000);
    Tekniker e2 = new Tekniker("Gustav", 38, "Male", 45000);
    Tekniker e3 = new Tekniker("Niklas", 44,"Male", 45000 );
    Sales e4 = new Sales("Robin", 35, "Male", 45000);
    HR e5 = new HR("Alex", 35, "Male", 40000);
    Secretary e6 = new Secretary("Annakarin", 65, "Female", 35000);
    
    
    Polymorph.Employees.add(e1);
    Polymorph.Employees.add(e2);
    Polymorph.Employees.add(e3);
    Polymorph.Employees.add(e4);
    Polymorph.Employees.add(e5);
    Polymorph.Employees.add(e6);
    }
}
