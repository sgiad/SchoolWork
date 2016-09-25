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
public class Employee
{
   //Constants
   public static final double DEFAULT_WAGE = 12.63;
   public static final double MAX_WAGE = 25.0;
   public static final int MAX_HOURS = 100;
   public static final int MAX_ID = 999999;
   public static final double SENIOR_BONUS = 206.26;
   private static int numEmp = 0;
   private static double totalAmount = 0.0;
   
   //Instance Variables 
   private String name; 
   private int numID;
   private double payRate;
   private int hoursWorked; 
   private boolean senior = false;
   
   //---Constructors---
   //Default Constructor
   public Employee ()
   {
      this("", 0, DEFAULT_WAGE, 0);
   }
   
   //Specific Constructor
   public Employee (String Name, int numID, double payRate, int hoursWorked /*boolean senior*/)
   {
      this.name = name;
      this.numID = numID;
      this.payRate = payRate;
      this.hoursWorked = hoursWorked;
      numEmp++;
   }
   
   //Accessors
   public String getName() { return this.name; }
   public int getNumID() { return this.numID; }
   public double getPayRate() { return this.payRate; }
   public int getHoursWorked() { return this.hoursWorked; } 
   
   //Mutators
   public boolean setName(String name) 
   {
      if(!name.equals(""))
      {
         this.name = name;
         return true;
      }
      else { return false; }
   }
   
   public boolean setNumID(int numID)
   {
      if(isValid(numID, 0, MAX_ID))
      {
         this.numID = numID;
         return true; 
      }
      else { return false; }
   }
   
   public boolean setPayRate(double payRate)
   {
      if(isValid(payRate, 0, MAX_WAGE))
      {
         this.payRate = payRate;
         return true;
      }
      else { return false; }
   }
   
   public boolean setHoursWorked(int hoursWorked) 
   {
      if(isValid(hoursWorked, 0, MAX_HOURS))
      {
         this.hoursWorked = hoursWorked;
         return true;
      }
      else { return false; }
   }
   
   public boolean setSenior(boolean senior)
   {
      if(senior)
      {
         this.senior = senior;
         return true;
      }
      else { return false; }
   }
   
   //---Special Purpose Method---
   
   //This method will get the number of employees to keep track 
   public static int getNumEmp() { return numEmp; }
   
   //This method will get the total of amount for all employees
   public static double getTotalAmount() { return totalAmount; }
   
   //This method is used to reduce redundant data
   public boolean isValid(double value, double min, double max) 
   {
      if(value > min && value < max) 
      {
         return true;
      }
      else { return false; }
   }
   
   //Calculations for payroll 
   public double payrollCalc()
   {
      double payroll = 0; 
      if(senior) 
      {
         payroll = payRate * hoursWorked + SENIOR_BONUS;
         totalAmount += payroll;
      }
      else
      {
         payroll = payRate * hoursWorked;
         totalAmount += payroll; 
      }
      return payroll;
   }
   
   //toString to output employee info that was prompted from the user
   public String toString() 
   {
      return "---Employee Report---\n\n" + 
             "Employee's Name: " + this.name + 
             "\nEmployee's ID# : " + this.numID + 
             "\nEmployee's Pay Rate: " + (String.format("$%.2f", this.payRate)) + 
             "\nEmployee's Hours: " + this.hoursWorked + 
             "\nCurrent Payroll: " + (String.format("$%.2f", this.payrollCalc())); 
   }
   
}  //End of DDC Class