import java.util.Random;
import java.util.Scanner;


public class NumberGuessingGame2{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);
        Random robj = new Random();

        boolean playAgain = true;

        System.out.println("welcome to Ultimate Number Guessing Game! ");

        while(playAgain){
            System.out.println("\n Choose Difficulty Level :");
            System.out.println("1. Easy(1 - 50)");
            System.out.println("2. Medium(1 - 100)");
            System.out.println("3. Hard(1 - 200)");
            System.out.println("Enter 1/2/3 :");

            int level = sobj.nextInt();
            int maxRange = 100;

            switch(level){
                case 1: maxRange = 50; break;
                case 2: maxRange = 100; break;
                case 3: maxRange = 200; break;
                default: System.out.println("Invalid choice , defaulting to Medium"); maxRange = 100;
            }

            int randomNumber = robj.nextInt(maxRange)+ 1;
            int guess = 0;
            int attempts = 0;

            System.out.println("\nGuess a number between 1 to "+ maxRange);

            while(guess != randomNumber)
            {
                System.out.print("Enter your guess :");
                guess = sobj.nextInt();
                attempts++;

                int diff = Math.abs(guess - randomNumber);

                if(guess == randomNumber){
                    System.out.println("Correct! You Won in " + attempts + " attempts");
                }
                else if(diff <= 5){
                    System.out.println("Almost there! Super Close");
                }
                else if(diff <= 10)
                {
                    System.out.println("Very close! Try again");
                }
                else if(diff <= 20)
                {
                    System.out.println("Close, but not very close");
                }
                else if(diff <= 50)
                {
                   System.out.println("Far, keep trying"); 
                }
                else
                {
                     System.out.println(" Very far");
                }
            }

            System.out.println("\nDO you want to play again?(yes/no):");
            String response = sobj.next();
            if(!response.equalsIgnoreCase("yes")){
                playAgain = false;
                System.out.println("\nThanks for playing..See you soon");
            }
        }

        sobj.close();
    }
}
