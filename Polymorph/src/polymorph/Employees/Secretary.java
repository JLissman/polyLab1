/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph.Employees;

import polymorph.Generator;

/**
 *
 * @author Jonathan & Salar
 */
public class Secretary extends Employee{
    
    public Secretary(String Name, int Age, String Sex, int Pay) {
        super(Name, Age, Sex, Pay);
    }

    public Secretary(String Name, int Age, String Sex)
    {
        super(Name, Age, Sex, Generator.NextMinMax(20000, 30000));
    }

    public int getBonus(int hoursWorked){
        int payout = 100 * hoursWorked;        
        return payout;
    }
        public String getPosition(){
    return "Secretary";
}
    
    
    
    
}
