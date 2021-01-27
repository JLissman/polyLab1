/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph.Employees;

/**
 *
 * @author Jonathan
 */
public class HR extends Employee {
    
    public HR(String Name, int Age, String Sex, int Pay) {
        super(Name, Age, Sex, Pay);
    }

    
    
    public int getBonus(int cases){
        int payout = 1000 * cases;
        return payout;
        
    
    }
    
    public String getPosition(){
    return "HR";
    }
    
}
