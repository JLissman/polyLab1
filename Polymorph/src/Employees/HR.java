/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polymorph.src.Employees;

import Polymorph.src.Tools.Generator;

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
    
    @Override
    public double getBonus()
    {
        return 1000 * Cases;
    }
    
    public String getPosition(){
    return "HR";
    }
    
}
