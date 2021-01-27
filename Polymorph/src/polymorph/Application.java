/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;

public class Application {

    public static void main(String[] args)
    {
        System.out.println("Välkommen!");
        Generator gen = new Generator();
        EmployeeManagement business = gen.Business(30);
        business.PrintAllEmployees();
        System.out.println(Statistics.getAverageSalaryByPos(business));
        System.out.println(Statistics.getOverallAverageSalary(business));
        System.out.println(Statistics.getLowestSalary(business));
        System.out.println(Statistics.getHighestSalary(business));
        System.out.println(Statistics.getSexAverages(business));
        System.out.println(Statistics.getSexByPosition(business));
    }
 
}
