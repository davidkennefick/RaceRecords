/*	Arthur: David Kennefick
	Race Records
*/

import java.util.*;

public class RaceRecords
{
	private String race_number;
    private String runner_name;//runner name
    private int time_ran;

    public RaceRecords(String number, String name, int time)
    {
        race_number = number;
        runner_name = name;
		time_ran = time;
    }
	
    public String getNumber()
    {
        return race_number;
    }
	
    public String getName()
    {
        return runner_name;
    }

    public int getTime()
    {
		return time_ran;
        
    }

    public String toString()
    {
		int minutes = 0;
		int seconds = 0;
		minutes = time_ran / 60;
		seconds = time_ran % 60;
        return "Race: " + race_number + ", Name: " + runner_name + 
               (", Time:"+ minutes + "Mins & "+ seconds + "Seconds");
    }

    public static void main(String[] args) 
    {
       ArrayList<RaceRecords> runners = new ArrayList<RaceRecords>();
       Scanner input = new Scanner(System.in);

       int menuChoice = 4;
       do {
           System.out.println("\t\t\tRace Records Record Menu");
           System.out.println("\t\t\n1. Add Race Record\t\n2. View Race Record\t\n3. Search Race Record\t\n4. Exit");
           try {
               System.out.println("Enter a choice: ");
               menuChoice = Integer.parseInt(input.nextLine());
           } catch (NumberFormatException e) {
               continue;
           }

           if (menuChoice==1)
           {
               System.out.println("RaceNumber:");
               String number = input.nextLine();
			   
			   System.out.println("Full name:");
               String name = input.nextLine();

               int time = -1;
               do {
                   try {
                       System.out.println("Time in seconds:");
                       time = Integer.parseInt(input.nextLine());
                   } catch (NumberFormatException e) {
                       System.out.println("Enter a number!");
                       continue;
                   }
               } while (time <= 0);

               RaceRecords runner = new RaceRecords(number, name, time);
               runners.add(runner);

            } else if (menuChoice==2) {
               System.out.println("Race Records:");
               for (RaceRecords runner : runners)//iterate through runners and print out each runner
               {
                   System.out.println(runner);
               }
			} else if (menuChoice==3) {
               System.out.println("Search Functionality Not implemented, Returning to Main Menu.");
		   }
		   
       } while (menuChoice<4);
    }
}