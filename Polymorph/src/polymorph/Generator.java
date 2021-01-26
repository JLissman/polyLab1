/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import polymorph.Employees.HR;
import polymorph.Employees.Sales;
import polymorph.Employees.Secretary;
import polymorph.Employees.Technician;
/**
 *
 * @author Jonathan
 */
public class Generator {
    Random RNG = new Random();
    int index;
    ArrayList<String> randomNames = new ArrayList<>(Arrays.asList("Maria","Erik","Anna","Lars","Margareta","Karl","Elisabeth","Anders","Eva","Johan","Kristina","Per","Birgitta","Nils","Karin","Carl","Marie","Mikael","Elisabet","Jan","Ingrid","Hans","Christina","Peter","Sofia","Olof","Linnéa","Lennart","Kerstin","Gunnar","Lena","Sven","Helena","Fredrik","Marianne","Daniel","Emma","Bengt","Linnea","Bo","Johanna","Alexander","Inger","Gustav","Sara","Göran","Cecilia","Åke","Elin","Magnus"));
    ArrayList<String> efterNamn = new ArrayList<>(Arrays.asList("Andersson","Johansson","Karlsson","Nilsson","Eriksson","Larsson","Olsson","Persson","Svensson","Gustafsson","Pettersson","Jonsson","Jansson","Hansson","Bengtsson","Jönsson","Lindberg","Jakobsson","Magnusson","Olofsson","Lindström","Lindqvist","Lindgren","Axelsson","Berg","Bergström","Lundberg","Lind","Lundgren","Lundqvist","Mattsson","Berglund","Fredriksson","Sandberg","Henriksson","Forsberg","Sjöberg","Wallin","Ali","Engström","Mohamed","Eklund","Danielsson","Lundin","Håkansson","Björk","Bergman","Gunnarsson","Holm","Wikström","Samuelsson","Isaksson","Fransson","Bergqvist","Nyström","Holmberg","Arvidsson","Löfgren","Söderberg","Nyberg","Blomqvist","Claesson","Nordström","Mårtensson","Lundström","Ahmed","Viklund","Björklund","Eliasson","Pålsson","Hassan","Berggren","Sandström","Lund","Nordin","Ström","Åberg","Hermansson","Ekström","Falk","Holmgren","Dahlberg","Hellström","Hedlund","Sundberg","Sjögren","Ek","Blom","Abrahamsson","Martinsson","Öberg","Andreasson","Strömberg","Månsson","Åkesson","Hansen","Norberg","Lindholm","Dahl","Jonasson"));
    public String Name(){
        index = RNG.nextInt(50);
        String fname = randomNames.get(index);
        int indexTwo = RNG.nextInt(100);
        String lname = efterNamn.get(indexTwo);
        return fname+" "+lname;
    }
    
    
    public int Age(){
        int min = 25, result = 0;
        while (result < min){
        result = RNG.nextInt(65);
        }
               return result;
    }
    
    public String Sex(String Name){
        int index = randomNames.indexOf(Name);
        
        
        if (index % 2 == 0){
        return "Female";
        }else
        {
        return "Male";
        }
    }
    public String Position(){
        
    int random = RNG.nextInt(4);
    String pos="";
    switch(random){
        case(0):
            pos = "HR";
            break;
        case(1):
            pos = "Sales";
            break;
        case(2):
            pos = "Secretary";
            break;
        case(3):
            pos = "Technician";
            break;
        default:
            break;
    }
    return pos;
    }
    
    
    public int Salary(String position){
        int min = 20000, salary=0;
        switch (position) {
            case "HR":
                while (salary < min){
                    salary = RNG.nextInt(35000);
                }
                break;
            case "Sales":
                while (salary < min){
                    salary = RNG.nextInt(40000);
                }
                break;
            case "Secretary":
                while (salary < min){
                    salary = RNG.nextInt(30000);
                }
                break;
            case "Technician":
                while (salary < min){
                    salary = RNG.nextInt(35000);
                }
                break;
            default:
                break;
        }
    return salary;
    }

    public EmployeeManagement Business(int workers){
    EmployeeManagement business = new EmployeeManagement();
    Generator gen = new Generator();
        int x = RNG.nextInt(200);
        for (int i = 0; i < workers; i++) {
            String name = gen.Name();
            int age = gen.Age();
            String sex = gen.Sex(name);
            String position = gen.Position();
            int salary = gen.Salary(position);
            if (position.equals("HR")) {
                HR e1 = new HR(name, age, sex, salary);
                business.AddEmployee(e1);
            } else if (position.equals("Sales")) {
                Sales e1 = new Sales(name, age, sex, salary);
                business.AddEmployee(e1);

            } else if (position.equals("Secretary")) {
                Secretary e1 = new Secretary(name, age, sex, salary);
                business.AddEmployee(e1);

            } else if (position.equals("Technician")) {
                Technician e1 = new Technician(name, age, sex, salary);
                business.AddEmployee(e1);

            }
            

        }
    return business;
    }

}



