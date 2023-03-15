import java.util.Arrays;

public class findclosestsum {
    public static void main(String[] args) {
        final int target = 200;
        final int k = 6;
        
        //Create A Random List
        int[] list = new int[20];
        for(int i = 0; i < 20; i++)
            list[i] = (int)(Math.random() * 50);
        //Sort It
        Arrays.sort(list);
        //Print the List To Console
        for(int i = 0; i < 20; i++){
            System.out.print(list[i] + "\t");
            if (( i+ 1) % 5 == 0)
                System.out.println();
        }
        
        //Calculte The Closest Sum
        int[] xtemp = new int[k];
        int diff = findClosestSum(list,target, xtemp, k);
        //Printing Results
        printresult(list, xtemp);
        System.out.println();
        System.out.println("\n Total: " + (target - diff));
    }
    public static void printresult(int[] list, int[] indexs){
        System.out.println("--------------------");
        System.out.print("Index:\t");
        for (int i = 0,n = indexs.length; i < n; i++)
            System.out.print(indexs[i] + "\t");
        System.out.println();
        System.out.print("E:\t");
        for (int i = 0,n = indexs.length; i < n; i++)
            System.out.print(list[indexs[i]] + "\t");
    }

        /**
     * Returns the sum of the values in the given list that are closest to the target value.
     * The number of values to sum is determined by the k parameter.
     *
     * @param list   the list of integers to sum from
     * @param target the target value to get close to
     * @param index  an array to hold the indices of the values to sum
     * @param k      the number of values to sum
     * @return the sum of the values that are closest to the target value
     */
    public static int findClosestSum(int[] list, int target, int[] index, int k) {
        int diff = 0;
        // Find the First Pair
        if (k > 1) {
            diff = findFirstPair(list, target, index, k);
        }
        // For the Rest Of Pairs
        while (k > 2) {
            k--;
            diff = findRestPair(list, diff, index, k);
        }
        return diff;
    }

    /**
     * Finds the pair of values in the given list that are closest to the target value,
     * based on the k parameter and sets their indices in the index array.
     *
     * @param list   the list of integers to search in
     * @param target the target value to get close to
     * @param index  an array to hold the indices of the values to sum
     * @param k      the number of values to sum
     * @return the difference between the sum of the pair of values and the target value
     */
    private static int findFirstPair(int[] list, int target, int[] index, int k) {
        int len = list.length;
        int mindiff = Integer.MAX_VALUE;
        for (int i = k - 2; i < len - 1; i++) {
            for (int j = k - 1; j < len; j++) {
                if (i == j) continue;
                int diff = (target - list[i] - list[j]);
                if (Math.abs(mindiff) > Math.abs(diff)) {
                    mindiff = diff;
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return mindiff;
    }

    /**
     * Finds the kth value in the list that is closest to the target value,
     * based on the previously found pairs and sets its index in the index array.
     *
     * @param list   the list of integers to search in
     * @param target the target value to get close to
     * @param index  an array to hold the indices of the values to sum
     * @param k      the number of values to sum
     * @return the difference between the sum of the k values and the target value
     */
    private static int findRestPair(int[] list, int target, int[] index, int k) {
        int len = list.length;
        int mindiff = Integer.MAX_VALUE;
        for (int i = k - 2; i < len; i++) {
            int diff = (target - list[i]);
            if (Math.abs(mindiff) > Math.abs(diff)) {

                boolean is_index = false;
                for (int j = 0, n = index.length; j < n; j++) {
                    if (index[j] == i) {
                        is_index = true;
                        break;
                    }
                }
                if (is_index) continue;

                mindiff = diff;
                index[index.length - k + 1] = i;
            }
        }
        return mindiff;
    }

}
