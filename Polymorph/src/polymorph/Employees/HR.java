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
public class HR extends Employee
{
    
    public HR(String Name, int Age, String Sex, int Pay)
    {
        super(Name, Age, Sex, Pay);
    }

    public HR(String Name, int Age, String Sex)
    {
        super(Name, Age, Sex, Generator.NextMinMax(20000, 35000));
    }
    
    
    public int getBonus(int cases){
        int payout = 1000 * cases;
        return payout;
        
    
    }
    
    public String getPosition(){
    return "HR";
    }
    
}
