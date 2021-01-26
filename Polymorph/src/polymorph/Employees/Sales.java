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
public class Sales extends Employee {
    
    public Sales(String Name, int Age, String Sex, int Pay) {
        super(Name, Age, Sex, Pay);

    }


    
    public int getBonus(int nrSales){
    int payout = 1000*nrSales;
    return payout;
    
    }
    
    
}
