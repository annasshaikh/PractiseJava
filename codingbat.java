//CodingBat Array 3
public boolean canBalance(int[] nums) {
  for (int i = 0, n = nums.length; i < n; i++){
    int sum2 = 0,sum1 = 0;
    for (int j = 0; j <=i; sum1 += nums[j++]);
    for (int j = i + 1; j < n; sum2 += nums[j++]);
    if (sum1==sum2) return true;
  }
  return false;
}

public int[] squareUp(int n) {
  int[] arr = new int[n*n];
  for(int i = 0; i < n*n; arr[i] = ((n - (i/n + 1) ) <= i % n) ? n - (i++ % n ) : ++i-i);
  return arr;
}

public int[] squareUp(int n) {
  int[] arr = new int[n*n];
  for(int i = 0; i < n*n; i++)
    if ((n - (i/n + 1) ) <= i % n)
      arr[i] = n - (i % n );
  return arr;
}

public int[] seriesUp(int n) {
  final int x = n*(n+1)/2;
  int[] arr = new int[x];
  int e = 1 , z =1;
  for(int i = 0; i < x; i++){
    if(z % e == 0){
      e++;
      z = 1;
    }
    arr[i] = z++;
  }
  return arr;
}

public int maxMirror(int[] nums) {
        
        final int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++){
            for (int k = n - 1; k >= i; k-- ){
                int count = 0;
                int t_i = i, t_k = k;
                while(nums[t_i] == nums[t_k]){
                    count++;
                    if (t_i == n - 1)  break; else t_i++;
                    if (t_k == 0) break; else t_k--; 
                }
                max = (max < count) ? count : max;
            }
        }
        return max;
        
}
public int countClumps(int[] nums) {
  int count = 0;
  int last_element = -1;
  for (int i = 0; i < nums.length - 1; i++){
    if (nums[i] == nums[i + 1]){
      if(last_element != nums[i])
        count++;
      i++;
    }
    last_element = nums[i];
  }
  return count;
}
