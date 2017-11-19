import java.text.DecimalFormat;

/**
 * Created by Ranjani on 7/17/2016.
 * The purpose of this class is to represent a complex number and define operations such as
 * Addition, Subtraction, Multiplication and division, Magnitude, Conjugate for the complex number
 */
public class KesavanRanjaniComplex
{
    private double realNumber; //Real portion of the complex number
    private double imaginaryNumber; //Complex portion of the complex number

    //The two result variables will store the sum, difference, product or division depending on what operation is requested
    private static double resultRealNumber;
    private static double resultImaginaryNumber;

    private static DecimalFormat df = new DecimalFormat("#.##"); //2 Decimal points

    //Default constructor that assigns a value of (2, 2) to real and imaginary parts
    public KesavanRanjaniComplex()
    {
        realNumber = 2;
        imaginaryNumber = 2;
    }
    //Full constructor is used when user passes values of real and imaginary parts.
    public KesavanRanjaniComplex(double realPortion, double imaginaryPortion)

    {
        this.realNumber = realPortion;
        this.imaginaryNumber = imaginaryPortion;
    }

    //Set the real component of the Complex number
    public KesavanRanjaniComplex setRealNumber(double realPart)
    {
        this.realNumber = realPart;
        return this;
    }

    //Set the imaginary component of the Complex number
    public KesavanRanjaniComplex setImaginaryNumber(double imaginaryPart)
    {
        this.imaginaryNumber = imaginaryPart;
        return this;
    }

    //Get the real component of the Complex number
    public double getRealNumber()
    {
        return this.realNumber;

    }

    //Get the Imaginary component of the Complex number
    public double getImaginaryNumber()
    {
        return this.imaginaryNumber;
    }

    //Print the complex number
    public void printComplexNumber()
    {
        System.out.println("The complex number is : " + "(" + this.realNumber + ")" + "+ i" + "(" + this.imaginaryNumber + ")" );
    }

    /*printResult  method will print the result in "Complex number format" that is (x)+i(y)
      It will be called by other methods that perform operations - Addition, subtraction, multiplication, division*/

    public static void  printResult(String operation)
    {
        //Display the complex number after rounding real and imaginary parts to 2 decimal places
        System.out.println(operation + " of the 2 complex numbers is : " + "(" + Double.valueOf(df.format(resultRealNumber)) + ")" + "+ i" + "(" + Double.valueOf(df.format(resultImaginaryNumber)) + ")" );
        resultRealNumber = 0.0; //After printing, reset the result attributes to 0 for next operation
        resultImaginaryNumber = 0.0;
    }

    public void equals(KesavanRanjaniComplex p)
    {
        if((this.realNumber == p.realNumber) && (this.imaginaryNumber == p.imaginaryNumber)) // Check if the respective real and imaginary components of the 2 numbers are same
            System.out.println("Equals : true");
        else
            System.out.println("Equals : false");
    }
    public void isReal()
    {
        if((this.imaginaryNumber == 0.0) && (this.realNumber != 0.0)) //if complex number does not have an non-zero imaginary component
            System.out.println("Is the complex number Real : true");
        else //non zero imaginary component present
            System.out.println("Is the complex number Real : false");
    }
    public void isImag()
    {
        if((this.realNumber == 0.0) && (this.imaginaryNumber !=0.0)) //Check if complex number does not have a real component, but has non zero imaginary component
            System.out.println("Is the complex number Imaginary : true");
        else
            System.out.println("Is the complex number Imaginary : false");
    }
    public void magnitude()
    {
        //Implement the formula : magnitude(x+yi) = Math.sqrt(x^2 + y^2)
        Double magnitude = Double.valueOf(df.format(Math.sqrt((Math.pow(this.realNumber,2)) + (Math.pow(this.imaginaryNumber,2)))));
        System.out.println("Magnitude of the complex number : "+magnitude);
    }
    public void conjugate()
    {
        Double conjugateImagNumber;
        if(this.imaginaryNumber == 0.0)
            conjugateImagNumber = 0.0; //There is no conjugate property for a Purely Real complex number
        else
        {
            conjugateImagNumber = -this.imaginaryNumber; //Change the sign of the imaginary component of the complex number
        }
        System.out.println("Conjugate of the complex number : " + "(" + this.realNumber + ")" + "+ i" + "(" + conjugateImagNumber + ")" );
    }
    public void addComplex(KesavanRanjaniComplex x)
    {
        resultRealNumber = this.realNumber + x.realNumber;
        resultImaginaryNumber = this.imaginaryNumber + x.imaginaryNumber;
        KesavanRanjaniComplex.printResult("Sum");
    }

    public void subComplex(KesavanRanjaniComplex x)
    {
        resultRealNumber = this.realNumber - x.realNumber;
        resultImaginaryNumber = this.imaginaryNumber - x.imaginaryNumber;
        KesavanRanjaniComplex.printResult("Subtraction");
    }

    public void mulComplex(KesavanRanjaniComplex x)
    {
        //Implement the formula: (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
        resultRealNumber = (this.realNumber * x.realNumber) - (this.imaginaryNumber * x.imaginaryNumber);
        resultImaginaryNumber = (this.realNumber * x.imaginaryNumber) + (this.imaginaryNumber * x.realNumber);
        KesavanRanjaniComplex.printResult("Multiplication");
    }

    public void divComplex(KesavanRanjaniComplex x)
    {
        try
        {
            //Implement the formula: (a + bi) / (c + di) = [(a + bi) * (c – di)] / (c^2 + d^2)
            Double denominator = Math.pow(x.realNumber,2) + Math.pow(x.imaginaryNumber,2);
            //Implement the formula: (a + bi) * (c + di) = (ac - bd) + (ad + bc)i and then divide by the denominator
            resultRealNumber = ((this.realNumber * x.realNumber) - (this.imaginaryNumber * (-x.imaginaryNumber)))/denominator;
            resultImaginaryNumber = ((this.realNumber * (-x.imaginaryNumber)) + (this.imaginaryNumber * x.realNumber))/denominator;
            KesavanRanjaniComplex.printResult("Division");
        }
        catch (Exception ae) //Mainly to capture divide by 0 exception
        {
            System.out.println("Cannot divide a number by 0. Hence ignoring the division operation");
        }
    }

}
