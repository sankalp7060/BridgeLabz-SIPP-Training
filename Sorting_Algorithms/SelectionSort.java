import java.util.*;
class SelectionSort{
  public static void main(String[] args){
    int[] arr={3,4,5};
    boolean isSorted=alreadySorted(arr);
    if(isSorted) System.out.print("Array is already sorted");
    else {
      sort(arr);
      System.out.print("Sorted Array:- "+Arrays.toString(arr));
    }
  }
  public static boolean alreadySorted(int[] arr){
    for(int i=1;i<arr.length;i++){
      if(arr[i-1]>arr[i]) return false;
    }
    return true;
  }
  public static void sort(int[] arr){
    for(int i=0;i<arr.length-1;i++){
      int min=i;
      for(int j=i+1;j<arr.length;j++){
        if(arr[j]<arr[min]){
          min=j;
        }
      }
      int t=arr[i];
      arr[i]=arr[min];
      arr[min]=t;
    }
  }
}