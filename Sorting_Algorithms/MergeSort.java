import java.util.*;
class MergeSort{
  public static void main(String[] args){
    int[] arr={3,4,5,7,6};
    boolean isSorted=checkSorted(arr);
    if(isSorted) System.out.print("Array is already sorted");
    else{
      sort(arr,0,arr.length-1);
      System.out.print("Sorted array:- "+Arrays.toString(arr));
    }
  }
  public static boolean checkSorted(int[] arr){
    for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
    }
    return true;
  }
  public static void sort(int[] arr,int l,int r){
    if(l<r){
      int partition=l+(r-l)/2;
      sort(arr,l,partition);
      sort(arr,partition+1,r);
      merge(arr,l,partition,r);
    }
  }
  public static void merge(int[] arr,int l,int m,int r){
    int n1=m-l+1;
    int n2=r-m;
    int[] left=new int[n1];
    int[] right=new int[n2];
    for(int i=0;i<n1;i++) left[i]=arr[l+i];
    for(int i=0;i<n2;i++) right[i]=arr[m+i+1];
    int i=0,j=0,k=l;
    while(i<n1 && j<n2){
      if(left[i]<right[j]) arr[k++]=left[i++];
      else arr[k++]=right[j++];
    }
    while(i<n1){
      arr[k++]=left[i++];
    }
    while(j<n2){
      arr[k++]=right[j++];
    }
  }
}