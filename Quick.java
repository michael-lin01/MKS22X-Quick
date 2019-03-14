import java.util.*;


public class Quick{

  private static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  private static int[] partitionDutch(int[] data, int start, int end){
    //start = starting index in group of pivot values
    //current = index of value you are currently looking at and comparing to pivot
    //end = last index not checked yet
    int middle = (start+end)/2;
    int pivot = Math.max(Math.min(data[start],data[middle]) , Math.min(Math.max(data[start],data[middle]), data[end])); //max of the 2 smallest

    int current = start;

    while(current<=end){
      if(data[current]<pivot){ //if less than pivot
        swap(data,current++,start++); //swap to front of group of pivots and increment the start
      }
      else{
        if(data[current]>pivot){ //if value is greater than pivot
          swap(data,current,end--); //swap to end and decrease end
        }
        else current++;
      }
    }

    return new int[] {start,end};
  }

  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length-1;

    while(true){
      int[] pivot = partitionDutch(data,start,end);
      if(k>=pivot[0]&&k<=pivot[1]) return data[k];
      if(k<pivot[0]) end = pivot[0]-1;
      else start = pivot[1]+1;
    }
  }

  public static void quicksort(int[] data){
    quicksort(data,0,data.length-1);
  }

  private static void quicksort(int[] data, int start, int end){
    if(start<end){
      int[] pivot = partitionDutch(data,start,end);
      quicksort(data,start,pivot[0]-1);
      quicksort(data,pivot[1]+1,end);
    }
  }

  public static void main(String args[]){
    Random r = new Random();
    int[] ary = new int[100];
    int[] ary2 = new int[100];
    for(int i = 0; i < ary.length;i++){
      int a = r.nextInt(1000);
      ary[i]=ary2[i]=a;
    }

    //System.out.println(Arrays.toString(ary));
    int q = quickselect(ary,10);
    //System.out.println(q);
    //quicksort(ary);
    Arrays.sort(ary2);
    //System.out.println(Arrays.toString(ary));
    //System.out.println(Arrays.toString(ary2));
    System.out.println(q==ary2[10]);

  }
}
