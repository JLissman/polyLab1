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
public class Technician extends Employee {
    int fkup;
    
    public Technician(String Name, int Age, String Sex, int Pay) {
        super(Name, Age, Sex, Pay);
    }
    
    
    public int getBonus(int fkup){
        int payout = 30000 / fkup;
        return payout;
    }
        public String getPosition(){
    return "Technician";
}
}
