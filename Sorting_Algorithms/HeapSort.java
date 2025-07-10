import java.util.*;
class HeapSort{
  public static void main(String[] args){
    int[] arr={3,2,4,1,5,0};
    heapSort(arr);
    System.out.print(Arrays.toString(arr));
  }
  public static void heapSort(int[] arr){
    int n=arr.length;
    for(int i=n/2-1;i>=0;i--){
      heapify(arr,n,i);
    }
    for(int i=n-1;i>=0;i--){
      int t=arr[0];
      arr[0]=arr[i];
      arr[i]=t;
      heapify(arr,i,0);
    }
  }
  public static void heapify(int[] arr,int n,int i){
    int largest=i;
    int l=2*i+1;
    int r=2*i+2;
    if(l<n && arr[l]>arr[largest]) largest=l;
    if(r<n && arr[r]>arr[largest]) largest=r;
    if(largest!=i){
      int t=arr[i];
      arr[i]=arr[largest];
      arr[largest]=t;
      heapify(arr,n,largest);
    }
  }
}