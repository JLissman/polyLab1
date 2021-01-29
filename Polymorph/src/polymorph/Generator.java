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
 * @author Jonathan & Salar
 */

public class Generator {
  
    static Random RNG = new Random();
    static ArrayList<String>  firstNameList = new ArrayList<>(Arrays.asList("Maria", "Erik", "Anna", "Lars", "Margareta", "Karl", "Elisabeth", "Anders", "Eva", "Johan", "Kristina", "Per", "Birgitta", "Nils", "Karin", "Carl", "Marie", "Mikael", "Elisabet", "Jan", "Ingrid", "Hans", "Christina", "Peter", "Sofia", "Olof", "Linnéa", "Lennart", "Kerstin", "Gunnar", "Lena", "Sven", "Helena", "Fredrik", "Marianne", "Daniel", "Emma", "Bengt", "Linnea", "Bo", "Johanna", "Alexander", "Inger", "Gustav", "Sara", "Göran", "Cecilia", "Åke", "Elin", "Magnus"));
    static ArrayList<String> surNameList   = new ArrayList<>(Arrays.asList("Andersson", "Johansson", "Karlsson", "Nilsson", "Eriksson", "Larsson", "Olsson", "Persson", "Svensson", "Gustafsson", "Pettersson", "Jonsson", "Jansson", "Hansson", "Bengtsson", "Jönsson", "Lindberg", "Jakobsson", "Magnusson", "Olofsson", "Lindström", "Lindqvist", "Lindgren", "Axelsson", "Berg", "Bergström", "Lundberg", "Lind", "Lundgren", "Lundqvist", "Mattsson", "Berglund", "Fredriksson", "Sandberg", "Henriksson", "Forsberg", "Sjöberg", "Wallin", "Ali", "Engström", "Mohamed", "Eklund", "Danielsson", "Lundin", "Håkansson", "Björk", "Bergman", "Gunnarsson", "Holm", "Wikström", "Samuelsson", "Isaksson", "Fransson", "Bergqvist", "Nyström", "Holmberg", "Arvidsson", "Löfgren", "Söderberg", "Nyberg", "Blomqvist", "Claesson", "Nordström", "Mårtensson", "Lundström", "Ahmed", "Viklund", "Björklund", "Eliasson", "Pålsson", "Hassan", "Berggren", "Sandström", "Lund", "Nordin", "Ström", "Åberg", "Hermansson", "Ekström", "Falk", "Holmgren", "Dahlberg", "Hellström", "Hedlund", "Sundberg", "Sjögren", "Ek", "Blom", "Abrahamsson", "Martinsson", "Öberg", "Andreasson", "Strömberg", "Månsson", "Åkesson", "Hansen", "Norberg", "Lindholm", "Dahl", "Jonasson"));

    public static String[] GenerateFullName()
    {
        int index;
        index = RNG.nextInt(firstNameList.size());
        String[] fname = new String[2];

        fname[0] = firstNameList.get(index);
        fname[1] = surNameList.get(index);
        return fname;
    }

    
    public static int GenerateAge()
    {
        int minAge = 20, maxAge = 65;
        return NextMinMax(minAge, maxAge);
    }

    //TODO: Non-binary if necessary
    //kanske vi kan göra om kön till en enum med Male, female, non-binary etc...
    public static String EvaluateGender(String Name)
    {
        int index = firstNameList.indexOf(Name);
        if (index % 2 == 0) {
            return "Female";
        } else {
            return "Male";
        }
    }

    public static JobBranch GenJobBranch()
    {
        int random = RNG.nextInt(4);
        switch (random) {
            case (0):
                return JobBranch.HR;
            case (1):
                return JobBranch.Sales;
            case (2):
                return JobBranch.Secretary;
            case (3):
                return JobBranch.Technician;
            default:
                return JobBranch.None;
        }

    }

    //Vi borde kanske göra detta direkt i konstruktorn av en employee
    public static int GenerateRandomSalary(JobBranch position)
    {
        int min = 20000;
        switch (position) {
            case HR:         return NextMinMax(min, 35000);
            case Sales:      return NextMinMax(min, 40000);
            case Secretary:  return NextMinMax(min, 30000);
            case Technician: return NextMinMax(min, 35000);

            //If position isn't a possible branch, return -1(error)
            default: return -1;
        }
    }

    public static EmployeeManagement GenerateWorkers(int count)
    {
        EmployeeManagement business = new EmployeeManagement();
        for (int i = 0; i < count; i++)
        {
            //Generate names for each employee and put it inside an array of strings
            //where the first index is the first name and second index is the surname
            String[] fullName = GenerateFullName();
            String fname = fullName[0];
            String lname = fullName[1];

            int age = GenerateAge();
            String sex = EvaluateGender(fname);
            String name = fname+" "+lname;
            JobBranch position = GenJobBranch();
            int salary = GenerateRandomSalary(position);
            
            switch(position)
            {
                case HR:
                business.AddEmployee(new HR(name, age, sex, salary));
                break;

                case Sales:
                business.AddEmployee(new Sales(name, age, sex, salary));
                break;

                case Secretary:
                business.AddEmployee(new Secretary(name, age, sex, salary));
                break;

                case Technician:
                business.AddEmployee(new Technician(name, age, sex, salary));
                break;
              }

        }
        return business;
    }

    //Generate a number between (inclusive) MIN - (inclusive) MAX
    public static int NextMinMax(int min, int max)
    {
        return RNG.nextInt((max + 1) - min) + min;
    }

}
