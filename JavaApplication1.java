/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * 
 * @author 26919
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    //@SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("""
                           1) Selection Sort 
                           2) Bubble Sort 
                           3) Insettion Sort""");
        System.out.print("Choice: ");
        int choice = input.nextInt();
        //If Selection Or Bubble Sort Selected
        if (choice == 1 || choice == 2){
            // Defining Lenght and Delcreaing an array
            System.out.println("---------------------");
            System.out.print("How Many Numbers:");
            int n = input.nextInt();
            System.out.println("---------------------");
            int[] arr = new int[n];
            
            //Input an array
            System.out.println("Enter Number:");
            for (int i = 0; i < n; arr[i++] = input.nextInt());
            
            //Sorting
            if (choice == 1)
                selection_sort(arr);
            else 
                bubble_sort(arr);
            
            // Printing
            System.out.println("---------------");
            System.out.println("Sorted by " + ((choice == 1) ? "Selection Sort ->" : "Bubble Sort - >" ) );
            for(int i : arr)
                System.out.println(i);   
            System.out.println("---------------");
            
        }else if (choice == 3){ //insertion
            System.out.println("--------------------------");
            System.out.println("How many Lenght of Array #1");
            System.out.print(" - > ");
            int length_arr1 = input.nextInt();
            System.out.println("--------------------------");
            
            int[] arr1 = new int[length_arr1];
            //Input an array
            System.out.println("Enter Number:");
            for (int i = 0; i < length_arr1; arr1[i++] = input.nextInt());
            
            System.out.println("--------------------------");
            System.out.println("How many Lenght of Array #2");
            System.out.print(" - > ");
            int lenght_arr2 = input.nextInt();
            System.out.println("--------------------------");
            
            int[] arr2 = new int[lenght_arr2];
            //Input an array
            System.out.println("Enter Number:");
            for (int i = 0; i < lenght_arr2; arr2[i++] = input.nextInt());
            int[] arr3 = insertion_sort(arr1,arr2);
            System.out.println("---------------");
            System.out.println("Sorted: ");
            for(int i : arr3)
                System.out.println(i); 
            System.out.println("---------------");
            
        }

      
    }
    
    static void selection_sort(int[] arr){
        final int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]){
                    //Swapping
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            
            }
        }
    }
    
    static void bubble_sort(int[] arr){
        final int n = arr.length;
        boolean is_sorted = false;
        int x = 0;
        while(!is_sorted){
            is_sorted = true;
            for (int i = 0; i < n - x - 1; i++){
                if(arr[i] > arr[i + 1]){
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                    is_sorted = false;
                }
            }
            x++;
        }
    }
    
    static int[] insertion_sort(int[] arr1,int[] arr2){
        int[] arr3 = new int[arr1.length + arr2.length];
        int small_arr_length = Math.min(arr1.length, arr2.length);
       
        int i = 0; 
        int j = 0;
        int index = 0;
        // 1 3 5 6
        // 2 4
        while (true){
            if (index == arr1.length + arr2.length ) 
                break;
            if (i < arr1.length && j < arr2.length){
                if (arr1[i] >= arr2[j])
                    arr3[index] = arr2[j++];
                else if (arr1[i] < arr2[j])
                    arr3[index] = arr1[i++];
            }else{
                if (i < arr1.length )
                    arr3[index] = arr1[i++];
                else if (j < arr2.length)
                    arr3[index] = arr2[j++];
            }
            index++;
        }
        return arr3;
    }
}
