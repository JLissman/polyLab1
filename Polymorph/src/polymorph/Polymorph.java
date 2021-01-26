/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;

import java.util.ArrayList;


public class Polymorph {
    public static ArrayList<Anstalld> Employees = new ArrayList<>();

    public static void main(String[] args) {
        EmployeeManagement.loadEmployees();
        System.out.println(Employees);
        
                
        
    }
    
    
    
    
}
