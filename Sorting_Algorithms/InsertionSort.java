import java.util.*;
class InsertionSort{
  public static void main(String[] args){
    int[] arr={3,4,5,6};
    boolean isSorted=sort(arr);
    if(isSorted) System.out.print("Array  is already sorted");
    else System.out.print("Sorted Array:- "+Arrays.toString(arr));
  }
  public static boolean sort(int[] arr){
    int n=arr.length;
    boolean alreadySorted=true;
    for(int i=1;i<n;i++){
      int key=arr[i];
      int j=i-1;
      if(arr[j]>key) alreadySorted=false;
      while(j>=0 && arr[j]>key){
        arr[j+1]=arr[j];
        j--;
      }
      arr[j+1]=key;
    }
    return alreadySorted;
  }
}