import java.util.*;
class BubbleSort{
  public static void main(String[] args){
    int[] arr={3,3,4,5,6};
    boolean isSorted=sort(arr);
    if(isSorted){
      System.out.println("Array is already sorted ");
    }
    else{
      System.out.println("Sorted Array:- "+Arrays.toString(arr));
    }
  }
  public static boolean sort(int[] arr){
    boolean isSwap;
    boolean alreadySorted=true;
    int n=arr.length;
    for(int i=0;i<n-1;i++){
      isSwap=false;
      for(int j=0;j<arr.length-i-1;j++){
        if(arr[j]>arr[j+1]){
          int t=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=t;
          isSwap=true;
        }
      }
      if(isSwap){
        alreadySorted= false;
      }
      else break;
    }
    return alreadySorted;
  }
}