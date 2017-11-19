/**
 * Created by Ranjani on 7/9/2016.
 */
// This Java class decodes a message to discover the answer to the ultimate question of life
public class kesavanRanjaniAssignment3
{
    public static void main(String arg[])
    {
        String message = "$epqux.sxn";
        char[] messageCharArray = message.toCharArray(); //Convert the string to a Character Array
        System.out.println("The answer to the ultimate question of life is:");
        for(int i=0; i<messageCharArray.length; i++) //Loop through every character in the character array
            //If the index i is divisible by 2, then 2*(i%2)-1 will be -1, that is Subtract 1 from the Ascii value of the character at index i,print the new character
            //If the index i is not divisible by 2, then 2*(i%2)-1 will be 1, that is Add 1 to the Ascii value of the character at index i,print the new character
            System.out.print((char)(messageCharArray[i] + 2*(i%2)-1));
    }
}
