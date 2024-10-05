package OsGrillTraining;

import java.io.Serializable;
import java.util.Scanner;

public class Members implements Serializable
{
    String name;
    int teamPassword;
    int testScore;


    public Members(String name, int teamPassword,int testScore)
    {
        this.name = name;
        this.teamPassword = teamPassword;
        this.testScore = testScore;
    }
    public String getName()
    {
        return name;
    }
    public int getTeamPassword()
    {
        return teamPassword;
    }
    public int getTestScore()
    {
        return testScore;
    }
    public static void CreateMember()
    {
                Scanner userLogin = new Scanner(System.in); // Read input from the keyboard
                String name = userLogin.nextLine(); // Read an integer
                int teamPassword = userLogin.nextInt();
                int testScore = userLogin.nextInt(); // Read a double
                
                Members Member1 = new Members (name, teamPassword, testScore);
                System.out.println("Name: " + Member1.name + ", Age: " + Member1.teamPassword);
        
                userLogin.close();
        }
}