//last in first out
public class stack {
    public static void main(String[] args) {
        String command = "1 2 3 + * 15 33 / - 5 +";
        String[] arr_command = command.split(" ");
        int[] arr = {};
        for (int i = 0, n = arr_command.length; i < n; i++){
            if (arr_command[i].equals("+")){
                int x = arr[arr.length - 1];
                arr = pop(arr);
                int y = arr[arr.length - 1];
                arr = pop(arr);
                arr = push(arr, x + y);
            }else if(arr_command[i].equals("-")){ 
                int x = arr[arr.length - 1];
                arr = pop(arr);
                int y = arr[arr.length - 1];
                arr = pop(arr);
                arr = push(arr, x - y);
            }else if(arr_command[i].equals("*")){
                int x = arr[arr.length - 1];
                arr = pop(arr);
                int y = arr[arr.length - 1];
                arr = pop(arr);
                arr = push(arr, x * y);
            }else if(arr_command[i].equals("/")){ 
                int x = arr[arr.length - 1];
                arr = pop(arr);
                int y = arr[arr.length - 1];
                arr = pop(arr);
                arr = push(arr, x / y);
            }else{
                arr = push(arr, Integer.parseInt(arr_command[i]));
            }
        }
        System.out.println(arr[0]);
    }

    static int[] pop(int[] arr){
        int n = arr.length;
        int[] newarr = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            newarr[i] = arr[i];
        return newarr;
    }

    static int[] push(int[] arr, int element){
        int n = arr.length;
        int[] newarr = new int[n + 1];
        for (int i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = element;
        return newarr;
    }
}
