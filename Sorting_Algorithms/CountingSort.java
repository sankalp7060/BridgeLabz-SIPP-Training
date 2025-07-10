import java.util.*;
class CountingSort{
  public static void main(String[] args){
    int[] arr={2,5,3,0,2,3,0,3};
    int max=Integer.MIN_VALUE;
    for(int i:arr) max=Math.max(i,max);
    int[] count=new int[max+1];
    for(int i=0;i<arr.length;i++) count[arr[i]]++;
    for(int i=1;i<=max;i++){
      count[i]+=count[i-1];
    }
    int[] ans=new int[arr.length];
    for(int i=arr.length-1;i>=0;i--){
      ans[count[arr[i]]-1]=arr[i];
      count[arr[i]]--;
    }
    System.out.print(Arrays.toString(ans));
  }
}