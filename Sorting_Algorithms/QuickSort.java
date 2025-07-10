import java.util.*;
public class QuickSort{
  public static void main(String[] args){
    int[] arr1={3,2,4,1,5,0};
    int[] arr2={3,2,4,1,5,0};
    sort1(arr1,0,arr1.length-1);
    sort2(arr2,0,arr2.length-1);
    System.out.print("Sorted Array:- "+Arrays.toString(arr1));
    System.out.print("Sorted Array:- "+Arrays.toString(arr2));
  }
  public static void sort1(int[] arr,int l,int r){
    if(l<r){
      int pivot=partition1(arr,l,r);
      sort1(arr,l,pivot-1);
      sort1(arr,pivot+1,r);
    }
  }
  public static void sort2(int[] arr,int l,int r){
    if(l<r){
      int pivot=partition2(arr,l,r);
      sort2(arr,l,pivot);
      sort2(arr,pivot+1,r);
    }
  }
  public static int partition1(int[] arr,int l,int r){
    int pivot=arr[r];
    int i=l-1;
    for(int j=l;j<r;j++){
      if(arr[j]<pivot){
        i++;
        swap(arr,i,j);
      }
    }
    swap(arr, i + 1, r);  
    return i + 1;
  }
  public static int partition2(int[] arr,int l,int r){
    int pivot=arr[l+(r-l)/2];
    int i=l,j=r;
    while(true){
      while(arr[i]<pivot) i++;
      while(arr[j]>pivot) j--;
      if(i>=j) break;
      swap(arr,i,j);
      i++;
      j--;
    }
    return j;
  }
  public static void swap(int[] arr,int i,int j){
    int t=arr[i];
    arr[i]=arr[j];
    arr[j]=t;
  }
}