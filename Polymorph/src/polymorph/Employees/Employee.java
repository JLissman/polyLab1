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
public class Employee {
    int ID;
    String Name, Sex;
    int Age, Salary;
    
    public Employee(String Name, int Age, String Sex, int Salary){
        this.Name = Name;
        this.Age = Age;
        this.Sex = Sex;
        this.Salary = Salary;

    }
    public Employee(String Name, int Age, String Sex){
        this.Name = Name;
        this.Age = Age;
        this.Sex = Sex;

        //basically an intern
        this.Salary = Generator.NextMinMax(0, 1000);
    }
    
    public void getBonus(){
        System.out.println("No bonus");
    }
   
    public String getPosition(){
        return "No position";
    }
    public int getID(){
        return this.ID;
    }
    public String getName() {
        return Name;
    }

    public int getSalary() {
        return Salary;
    }
    
    public void setID(int employeeId) {
        this.ID = employeeId;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    @Override
    public String toString() {
        return "Employee[" + "Name=" + Name + ", Sex=" + Sex + ", Age=" + Age + ", Pay=" + Salary + ", Position =" + ']';
    }

}
