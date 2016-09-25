/*
   Samir Giad
   Sep 24th, 2016
   IT 206-207
   Programming Assignment 2
   Description:
   I was asked to create an object-oriented application that prompt the 
   user for a valid name, ID number, hourly pay rate (default rate would 
   be entered if user did not input anything), hours worked, and if the
   employee is a senior or not. After getting that info from the user, an
   employee report would be displayed showing that info. After displaying
   employee's report, the user would be asked if he/she wants to enter
   another employee's info (YES/NO question). If yes, then the user will 
   be prompted again for employee's name, ID number, hourly pay rate, 
   hours worked, and whether the employee is a senior or not. However, 
   if no, the application will display a final report that shows total of
   employees entered and total amount of payrolls for all employees. After
   that a goodbye message shows up to close up the application. 
*/

import javax.swing.JOptionPane;

public class Payroll
{
   public static void main (String[] args) 
   {
      //Declare an employee object
      Employee employee;
      
      //Continue to prompt for employee's info until the user is done
      do
      {
         //Create a new employee report
         employee = addEmp();
         
         //Displays employee's info after getting it from the user
         toString(employee);
         
      }while(JOptionPane.showConfirmDialog(null,"Enter another employee?","Add Employee Prompt",
             JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
      
      /*
      This report will: 
      Display the total of employees entered
      Display the total amount for all employees
      */
      printEmpInfo(employee); 
   }
   
   /*
   Method Purpose: Creates employee's info by getting it from the user
   @param: none
   @return: employee's info
   */
   public static Employee addEmp() 
   {
      //Initialize employee object 
      Employee employee = new Employee();
      
      //Set valid to false so we can use it for validation 
      boolean valid = false;
      
      //Prompt for employee's name
      do
      {
         valid = employee.setName(JOptionPane.showInputDialog("Enter Employee's Name: "));
         if(!valid)
         {
            JOptionPane.showMessageDialog(null, "Please enter a valid name!");
         }
      }while(!valid);
      
      //Reset flag
      valid = false;
      
      //Prompt for employee's ID #
      do
      {
         try
         {
            valid = employee.setNumID(Integer.parseInt(JOptionPane.showInputDialog("Enter " + employee.getName() + "'s ID#: ")));
         }
         catch (NumberFormatException e) 
         {
            JOptionPane.showMessageDialog(null, "Invalid input, please enter a number!");
         } 
         if(!valid)
         {
            JOptionPane.showMessageDialog(null, "Please enter a valid ID# between 0 and " + Employee.MAX_ID);
         }
      }while(!valid);
      
      //Reset flag
      valid = false;
      
      /*
      To determine whether the employee makes a default wage of $12.63
      or not. If yes, then $12.63 will automatically be set to employee's
      hourly pay rate. If no, then the user will be prompted to enter the 
      hourly pay rate of the employee.
      */
      double defWage = JOptionPane.showConfirmDialog(null, "Does " + employee.getName() + " make the default wage an hour ($12.63)?", "Default Wage?", 
                    JOptionPane.YES_NO_OPTION);
      if(defWage == JOptionPane.YES_OPTION)
      {
         double rate = employee.DEFAULT_WAGE;
      }
      
      //
      else
      {
      //Prompt for hourly pay rate
         do 
         {
            try
            {
               valid = employee.setPayRate(Double.parseDouble(JOptionPane.showInputDialog("Enter " + employee.getName() + "'s Hourly Pay Rate: ")));
               if(!valid)
               {
                  JOptionPane.showMessageDialog(null, "Please enter a valid pay rate between $0 and " + (String.format("$%.2f", Employee.MAX_WAGE)));
               }
            }
            catch (NumberFormatException e)
            {
               JOptionPane.showMessageDialog(null, "Invalid input, please enter a number!");
            }
         }while(!valid);
      }
      //Reset flag
      valid = false;
 
      //Prompt for hours worked
      do 
      {
         try
         {
            valid = employee.setHoursWorked(Integer.parseInt(JOptionPane.showInputDialog("Enter " + employee.getName() + "'s hours worked: ")));
         }
         catch (NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null, "Invalid input, please enter a number!");
         }
         if(!valid) 
         {
            JOptionPane.showMessageDialog(null, "Please enter a valid number of hours between 0 and " + Employee.MAX_HOURS + " hours!");
         }
      }while(!valid);
     
      //Validating for whether the employee is a senior or not
      int senior = JOptionPane.showConfirmDialog(null,"Is " + employee.getName() + " a senior?","Seniority",
                   JOptionPane.YES_NO_OPTION);
         if (senior ==0)
         {
            employee.setSenior (true);
         }
         else
         {
            employee.setSenior (false);
         }
      
      return employee;
   }
   
   /*
   Method Purpose: Displays employee's report with the info prompted from 
   the user.
   @param: employee info
   @return: void
   */
   public static void toString(Employee employee)
   {
      JOptionPane.showMessageDialog(null, employee.toString());
   } 
   
   /*
   Method Purpose: Displays total employees entered and amount for all 
   employees.
   @param: employee info
   @return: void
   */
   public static void printEmpInfo(Employee employee)
   {
      JOptionPane.showMessageDialog(null, "---Final Report---\n\n" +
                                          "Total Employees Entered: " + Employee.getNumEmp() + " employee(s)" +
                                          "\nTotal Amount for All Employees: " + (String.format("$%.2f", Employee.getTotalAmount())));
   } 
}