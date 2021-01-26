/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;

public class Polymorph {

    public static void main(String[] args) {
        Generator gen = new Generator();
        EmployeeManagement business = gen.Business(30);
        business.PrintAllEmployees();
        System.out.println(Statistics.getAverageSalaryByPos(business));
        System.out.println(Statistics.getOverallAverageSalary(business));
        System.out.println(Statistics.getLowestSalary(business));
        System.out.println(Statistics.getHighestSalary(business));
    }

}
