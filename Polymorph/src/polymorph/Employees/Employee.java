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
public class Employee {
    int ID;
    String Name, Sex;
    int Age, Pay;
    
    public Employee(String Name, int Age, String Sex, int Pay){
        this.Name = Name;
        this.Age = Age;
        this.Sex = Sex;
        this.Pay = Pay;

    }
   
    public void setID(int ID){
        this.ID = ID;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setSex(String Sex) {
        this.Sex = Sex;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }

   
    public String getName() {
        return Name;
    }
    public String getSex() {
        return Sex;
    }
    public int getAge() {
        return Age;
    }
    public int getID(){
        return this.ID;
    }
    public int getBonus(){
        return 0;
    }
    @Override
    public String toString() {
        return "Anställd: \n " + "Name=" + Name + ", \n Sex=" + Sex + ", \n Age=" + Age + ", \n Pay=" + Pay + '}';
    }
    
    
}
