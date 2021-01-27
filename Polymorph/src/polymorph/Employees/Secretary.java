/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph.Employees;

/**
 *
 * @author Jonathan & Salar
 */
public class Secretary extends Employee{
    
    public Secretary(String Name, int Age, String Sex, int Pay) {
        super(Name, Age, Sex, Pay);
    }

    
    public int getBonus(int hoursWorked){
        int payout = 100 * hoursWorked;        
        return payout;
    }
        public String getPosition(){
    return "Secretary";
}
    
    
    
    
}
