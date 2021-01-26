/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;

/**
 *
 * @author Jonathan
 */
public class Anstalld {
    String Name, Sex;
    int Age, Pay;
    
    public Anstalld(String Name, int Age, String Sex, int Pay){
        this.Name = Name;
        this.Age = Age;
        this.Sex = Sex;
        this.Pay = Pay;

    }
    
    public void getBonus(){
        System.out.println("Everybody got a bonus");
    }

    public String getName() {
        return Name;
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
        return "Anstalld{" + "Name=" + Name + ", Sex=" + Sex + ", Age=" + Age + ", Pay=" + Pay + '}';
    }
    

    
    
}
