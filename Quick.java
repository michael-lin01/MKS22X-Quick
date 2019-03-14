import java.util.*;


public class Quick{

  private static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  public static int partition(int[] data, int start, int end){
    if(start==end) return start;
    Random r = new Random();
    int pivot = start+Math.abs(r.nextInt())%(end-start);
    //System.out.println(data[pivot]);
    swap(data,start,pivot);
    pivot=start;
    start++;
    while(start!=end){
      if(data[start]>data[pivot]){ //if value is greater than pivot
        swap(data,start,end);
        end--;
      }
      else{
        start++;
      }
    }
    if(data[end]>data[pivot]) end--;
    swap(data,pivot,end);

    return end;
  }


  public static int partitionImp(int[] data, int start, int end){
    //if(start==end) return start;
    int middle = (start+end)/2;
    int med = Math.max(Math.min(data[start],data[middle]) , Math.min(Math.max(data[start],data[middle]), data[end])); //max of the 2 smallest
    int pivot = med == data[end] ? end : med == data[middle] ? middle : start;

    //System.out.println(data[pivot]);
    swap(data,start,pivot);
    pivot=start;
    start++;
    while(start!=end){
      if(data[start]==data[pivot]){
        if(Math.random()<0.5) {
          swap(data, start,end);
          end--;
        }
        else start++;
      }
      else {
        if(data[start]>data[pivot]){ //if value is greater than pivot
          swap(data,start,end);
          end--;
        }
        else start++;
      }
    }

    if(data[end]>data[pivot]) end--;
    swap(data,pivot,end);

    return end;
  }


  private int[] partitionDutch(int[] data, int start, int end){
    int middle = (start+end)/2;
    int pivot = start;
    int med = Math.max(Math.min(data[start],data[middle]) , Math.min(Math.max(data[start],data[middle]), data[end])); //max of the 2 smallest
    if(med == data[end]) pivot = end;
    else pivot = middle;


    return new int[] {1,2};
  }

  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length-1;

    while(true){
      int pivot = partitionImp(data,start,end);
      if(k==pivot) return data[pivot];
      if(k<pivot) end = pivot-1;
      else start = pivot+1;
    }
  }

  public static void quicksort(int[] data){
    quicksort(data,0,data.length-1);
  }

  private static void quicksort(int[] data, int start, int end){
    if(start<end){
      int pivot = partitionImp(data,start,end);
      quicksort(data,0,pivot-1);
      quicksort(data,pivot+1,end);
    }
  }

  public static void main(String args[]){
    Random r = new Random();
    int[] ary = new int[100];
    for(int i = 0; i < ary.length;i++){
      ary[i]=r.nextInt(10);
    }

    System.out.println(Arrays.toString(ary));
    //System.out.println(quickselect(ary,3));
    quicksort(ary);
    //Arrays.sort(ary);
    System.out.println(Arrays.toString(ary));

  }
}
