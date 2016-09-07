import javax.swing.JOptionPane;

/*
   This application will test 2 parralel arrays to get the lowest score.
   @author: Samir Giad
   */
public class LowestScore 
{

   //main class that includes my methods. 
   public static void main (String [] args) 
   {
   
      JOptionPane.showMessageDialog(null, "Welcome to score analysist");
      String [] names = {"Joey", "Lisa", "Karen", "Mark", "Christopher"};
      double [] scores = {78.5, 97.0, 42.5, 86.5, 42.5};
      double lowestScore = getLowestScore(scores);
      int studentCounter = getStudentCounter(scores, lowestScore);
      String lowestStudentNames [] = getLowestStudentNames(names, scores, lowestScore, studentCounter);
      displayMessage(lowestScore, lowestStudentNames);
   }
   
   //this method will get the lowest score. 
   public static double getLowestScore (double [] scores) 
   {
      double lowest = 100.0;
      for (int i = 0; i < scores.length; i++) 
      {
         if (scores[i] < lowest)
         {
            lowest = scores[i];
         }
      }
      return lowest;
   }
   
   //this method will get the count of students with low score. 
   public static int getStudentCounter (double [] scores, double lowestScore)
   {
      int counter = 0;
      for (int i = 0; i < scores.length; i++) 
      {
         if (scores[i] == lowestScore) 
         {
            counter++;
         }
      }
      return counter;
   }
   
   //this method will assign lowest scores to names.
   public static String [] getLowestStudentNames(String [] names, double [] scores, double lowestScore, int studentCounter) 
   {
      int counter = 0; 
      String [] lowStuScore = new String [studentCounter]; 
      for (int i = 0; i < scores.length; i++) 
      {
         if (scores[i] == lowestScore) 
         {
            lowStuScore[counter] = names[i]; 
            counter++;
         }
      }
      return lowStuScore;
   }
   
   //this method will display the final report.
   public static void displayMessage(double lowestScore, String [] lowestStudentNames)
   {
      String report = "---Final Report---\n\n";
      report += "The lowest score of this course is: " + lowestScore;
      report += "\n\nStudents with lowest scores:\n";
      for (int i = 0; i < lowestStudentNames.length; i++)
      {
         report += "- " + lowestStudentNames[i] + "\n";
      }
      report += "\n\nThe student(s) may benefit from extra help.";
      JOptionPane.showMessageDialog(null, report);
   }
   
}