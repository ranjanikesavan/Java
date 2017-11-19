/**
 * Created by Ranjani on 7/1/2016.
 */
/*
    This Java class performs the functions of a calculator:
    Addition, Subtraction, Multiplication, Division, Modulo and Factorial
*/
import java.io.*;
import java.util.Random;
import java.text.DecimalFormat;
public class kesavanRanjaniAssignment2
{
    static Random randomNum = new Random(); //Random object instantiation
    static double firstNumberDouble; //This variable captures the 1st random number generated
    static double secondNumberDouble; //This variable captures the 2nd random number generated
    static DecimalFormat df = new DecimalFormat("#.####"); //Format upto 4 decimal points

    /*The method generateRandomDoubleNumbers() is used for generating, assigning and printing 2 random numbers of data type double.
      This will be called only when the user chooses one of the operations - Addition, Subtraction, Multiplication.
     */
    static void generateRandomDoubleNumbers()
    {
        firstNumberDouble = Double.valueOf(df.format((randomNum.nextDouble()) * 1000)); //Random number in the range 0.0 to 1.0 is multiplied by 1000, Format to 4 decimal places
        secondNumberDouble = Double.valueOf(df.format((randomNum.nextDouble()) * 1000));
        System.out.println("\n2 random numbers generated are: ");
        System.out.println("\nFirst Number: "+firstNumberDouble);
        System.out.println("\nSecond Number: "+secondNumberDouble);
    }
    public static void main(String arg[]) throws IOException
    {
        int userSelectedAction; //This variable is used to capture operation selected by user
        Double resultDouble;    //Result for addition,subtraction,multiplication,division

        int firstNumberInt;     //To store 1st random number generated for modulo
        int secondNumberInt;    //To store 2nd random number generated for modulo
        int resultInt;          //result for modulo

        short numberShort;      //To capture the random short number generated for factorial operation
        long resultLong;        //To capture the result of factorial

        boolean isError= true;  //Default isError to true to allow execution of the do while loop
        boolean repeatMenu = true;
        boolean repeatQuestion = true;

        do
        {
                System.out.println("\nMENU\n\nChoose an action to perform: \n\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Modulo\n6. Factorial");
                System.out.print("\nYour choice: ");
                BufferedReader bufferRdr = new BufferedReader(new InputStreamReader(System.in)); //Capture the user input
                try
                {
                    userSelectedAction = Integer.parseInt(bufferRdr.readLine()); //Capture the integer value of user's selection
                }
                catch(NumberFormatException numFormatExeption)
                {
                     System.out.println("Error!Invalid selection!Please try again"); //User did not enter an integer to select the desired operation
                     repeatMenu = true; //this variable is later used to decide if the menu should be displayed again
                     continue; // This will execute the loop again
                }
                resultDouble = 0.0; //Initialize the result
                resultInt = 0;
                //Perform the requested calculation
                switch (userSelectedAction)
                {
                    case 1: //Addition
                        generateRandomDoubleNumbers(); //calls method to generate random numbers
                        resultDouble = Double.valueOf(df.format(firstNumberDouble + secondNumberDouble)); //Add the numbers, result is upto 4 decimal points
                        System.out.println("\nResult: " + firstNumberDouble + "+" + secondNumberDouble + " = " + resultDouble);
                        break;
                    case 2: //Subtraction
                        generateRandomDoubleNumbers(); //calls method to generate random numbers
                        resultDouble = Double.valueOf(df.format(firstNumberDouble - secondNumberDouble));
                        System.out.println("\nResult: " + firstNumberDouble + "-" + secondNumberDouble + " = " + resultDouble);
                        break;
                    case 3: //Multiplication
                        generateRandomDoubleNumbers(); //calls method to generate random numbers
                        resultDouble = Double.valueOf(df.format(firstNumberDouble * secondNumberDouble));
                        System.out.println("\nResult: " + firstNumberDouble + "*" + secondNumberDouble + " = " + resultDouble);
                        break;
                    case 4: //Division
                        isError = true; //Default isError to true to allow execution of the do while loop
                        //generateRandomDoubleNumbers method not used since division requires additional exception handling for divide by zero
                        do
                        {
                            firstNumberDouble = Double.valueOf(df.format((randomNum.nextDouble()) * 1000));//generate a random number between 0 and 1 and multiply by 1000
                            secondNumberDouble = Double.valueOf(df.format((randomNum.nextDouble()) * 1000));
                            try
                            {
                                resultDouble = Double.valueOf(df.format(firstNumberDouble / secondNumberDouble));
                            }
                            catch (ArithmeticException ae) //Mainly to capture divide by 0 exception
                            {
                                isError = true; //to repeat the do while loop again
                                continue; //This will execute the do while again to generate a new set of random numbers
                            }
                            isError = false; //the division was successful
                            System.out.println("\n2 random numbers generated are: ");
                            System.out.println("\nFirst Number: "+firstNumberDouble);
                            System.out.println("\nSecond Number: "+secondNumberDouble);
                        }while (isError); //repeat if there is an error
                        System.out.println("\nResult: " + firstNumberDouble + "/" + secondNumberDouble + " = " + resultDouble);
                        break;
                    case 5: //Modulo
                    {
                        isError = true;
                        do {
                            firstNumberInt = randomNum.nextInt(10000); //Random number between 0 and 9999 is generated
                            secondNumberInt = randomNum.nextInt(100); //Random number between 0 and 99 is generated
                            try
                            {
                                resultInt = firstNumberInt % secondNumberInt;
                            }
                            catch (ArithmeticException ae) //Mainly to capture divide by 0 exception
                            {
                                isError = true;
                                continue;
                            }
                            isError = false; //modulo executed without exception
                        } while (isError); //repeat if there is an error
                        System.out.println("\n2 random numbers generated are: ");
                        System.out.println("\nFirst Number: "+firstNumberInt);
                        System.out.println("\nSecond Number: "+secondNumberInt);
                        System.out.println("\nResult: " + firstNumberInt + "%" + secondNumberInt + " = " + resultInt);
                        break;
                    }
                    case 6: //Factorial
                    {   resultLong = 1; //Initialize it to 1 to display the factorial as 1 if the random selected number is 1 or 0
                        numberShort = (short) randomNum.nextInt(15); // A random integer between 0 and 14 is chosen
                        System.out.println("\nRandom number generated is : "+numberShort);
                        for (short i = numberShort; i > 1; i--) //loop executed only for numbers greater than 1
                        {
                            resultLong = resultLong * i;
                        }
                        System.out.println("\nResult: " + numberShort + "!" + " = " + resultLong);
                        break;
                    }
                    default: //User entered an option that is not between 1 and 6
                    {
                        System.out.println("Error!Invalid selection! Please try again");
                        repeatMenu = true; //To display the menu again to user
                        continue;
                    }
                }

                do
                {
                    System.out.print("\nWould you like to do another operation? (Y/N) ");
                    String anotherOperation = bufferRdr.readLine();
                    if(anotherOperation.equalsIgnoreCase("Y"))
                    {
                        repeatMenu = true;  //To display the menu again to user
                        repeatQuestion = false;
                        break;
                    }
                    else if(anotherOperation.equalsIgnoreCase("N"))
                    {
                        repeatMenu = false; //User decided to exit the calculator
                        repeatQuestion = false;
                        System.out.println("Thank you for using the calculator. Bye!");
                        break;
                    }
                    else  //User entered an input that is not Y or N
                    {
                        repeatQuestion = true; //Ask the same question again
                        repeatMenu = false;
                        System.out.println("Error! Invalid response");
                    }
                }while(repeatQuestion);

        }while (repeatMenu);//Display the menu only if user entered an incorrect selection or user requested for another operation

    }
}