
/*
 * 28/09/2022
 *  `1) How to find the maximum occurring character in a given String? (solution)
    Write an efficient Java/C/Python program to return the maximum occurring character in the input string, e.g., if the input string is "Java" then the function should return 'a'.
    Read more: https://www.java67.com/2018/04/21-string-programming-and-coding-interview-questions-answers.html#ixzz7gCvIZBR7
 * 
 */
import java.util.Scanner;

public class occuring_string{
    public static void main(String[] args) {
        // input the word
        Scanner input = new Scanner(System.in);
        String text = new String(input.next());

        char char_array[] = {}; // Store the unique Characters
        int num[] = {};         // Store the number of times a Characters Occur
        int heightest = 0;

        for (int i = 0, n = text.length(); i < n; i++){ 
            boolean is_in = false;

            //Checks whether the current character is already in char_array (repeated in string)
            for (int j = 0, m = char_array.length; j < m; j++){ 
                if (text.charAt(i) == char_array[j]){
                    is_in = true;
                    break;
                }
            }

            if (is_in){ // If the current character is already in the char_array so

                int index = find_index(char_array, text.charAt(i)); // Find the index of that char in char_array
                num[index] ++;                                      // Increase the number of occurance by 1

                if (heightest < num[index])                        // Checks that that if its the most occuraning char
                    heightest = num[index];
                

            }else{  // New character is found, add it in array and add a new element in num array of 1
                char_array = add_char_array(char_array, text.charAt(i));
                num = add_int_array(num, 1);
            }
            
        }

        //Print the Highest Occring Char
        System.out.printf("The Heighest Occuring Character is/are (%d times): | " , heightest);
        for(int i = 0, n = num.length; i < n; i++){
            if (heightest == num[i])
                System.out.print(char_array[i] + " | ");
        }
        
                
    }

    // find the index for char x in char_array and return its index
    public static int find_index(char char_array[], char x){
        for (int i = 0, n = char_array.length; i < n; i++)
            if (x == char_array[i])
                return i;
        return -1;
    }
    // add the integer x to end of the array and return new array
    public static int[] add_int_array(int int_array[], int x){
        int n = int_array.length;
        int new_int_array[] = new int[n + 1];
        for (int i = 0; i < n; i++ )
            new_int_array[i] = int_array[i];
        new_int_array[n] = x;
        return new_int_array;
    }
    // add the char x to end of the array and return new array
    public static char[] add_char_array(char char_array[], char x){
        int n = char_array.length;
        char new_char_array[] = new char[n + 1];
        for (int i = 0; i < n; i++ )
            new_char_array[i] = char_array[i];
        new_char_array[n] = x;
        return new_char_array;
    }
}
