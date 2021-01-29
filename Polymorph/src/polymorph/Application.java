/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorph;

import polymorph.Menu.Input;
import polymorph.Menu.UIManager;

public class Application {

    public static void main(String[] args)
    {
        System.out.println("Välkommen!");

        String x = Input.Instance().GetString(false, "test");
        if(x == null){
            System.out.print("error");
        }
        //EmployeeManagement someRandomBusiness = Generator.GenerateWorkers(30);
        //someRandomBusiness.PrintAllEmployees();

        //UIManager.Instance().DisplayMultiChoice("MenuShit", "do x",  "do y" );


        /*
        System.out.println(Statistics.getAverageSalaryByPos(someRandomBusiness));
        System.out.println(Statistics.getOverallAverageSalary(someRandomBusiness));
        System.out.println(Statistics.getLowestSalary(someRandomBusiness));
        System.out.println(Statistics.getHighestSalary(someRandomBusiness));
        System.out.println(Statistics.getSexAverages(someRandomBusiness));
        System.out.println(Statistics.getSexByPosition(someRandomBusiness));
         */

        }

}
