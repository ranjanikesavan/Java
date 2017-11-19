/**
 * Created by Ranjani on 6/27/2016.
 */
/*
 The purpose of this Java class is to print numbers from 1 till a user defined number.
 It prints Fizz if the number is a multiple of 5,
 prints Buzz if the number is a multiple of 7,
 prints FizzBuzz if the number is a multiple of both 5 and 7
 */
import java.io.*;
public class kesavanRanjaniHW1
{
    public static void main(String arg[]) throws IOException
    {
        boolean isError= true; //Default isError to true to allow execution of the do while loop
        int userInput= 0; //This variable is used to capture the user input. Initialize it to 0
        do
        {
            try
            {
                System.out.println("Please enter a positive integer till which you want the program to print the output: ");
                BufferedReader bufferRdr = new BufferedReader(new InputStreamReader(System.in)); //Capture the user input
                userInput = Integer.parseInt(bufferRdr.readLine()); //Capture the integer value returned
                if(userInput <= 0) //User enters a negative integer or 0
                {
                    System.out.println("Error! Only Positive integers are permitted");
                    isError = true;
                    continue; // This will execute the loop again
                }
                System.out.println("The number you have entered is " + userInput);
                System.out.println("Printing the output of the program for 1 to "+userInput);
                isError = false;  //User entered a positive integer, hence no error captured
            }
            catch (Exception e)
            {
                // This block catches exceptions when user enters an input which is not an integer in which case isError boolean will be true
                System.out.println("Error! Only Positive integers are permitted");
            }
        }while (isError);//Execute the do while block if there is a user input error to allow the user to input again

        for (int i=1; i<=userInput; i++) //Repeat till the number entered by the user
        {
            if ((i%5 == 0) && (i%7 == 0)) //Check if the number is a multiple of both 5 and 7
                System.out.print("FizzBuzz" + " ");
            else if(i%5 == 0)             //Check if the number is a multiple of only 5(but not 7)
                System.out.print("Fizz" + " ");
            else if(i%7 == 0)            //Check if the number is a multiple of only 7(but not 5)
                System.out.print("Buzz" + " ");
            else
                System.out.print(i + " "); //Print the actual number if it is neither a multiple of 5 nor 7
        }
    }
}

