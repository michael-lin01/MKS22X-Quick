import java.util.Random;

public class Quick{
  public static int partition(int[] data, int start, int end){
    Random r = new Random();
    int pivot = start+Math.abs(r.nextInt())%(end-start);
    //System.out.println(data[pivot]);
    int temp = data[start];
    data[start]=data[pivot];
    data[pivot]=temp;
    pivot=start;
    start++;
    while(start!=end){
      if(data[start]>data[pivot]){ //if value is greater than pivot
        int t = data[start];
        data[start]=data[end];
        data[end]=t;
        end--;
      }
      else{
        start++;
      }
    }
    if(data[end]>data[pivot]){
      int t = data[end-1];
      data[end-1]=data[pivot];
      data[pivot]=t;
      pivot=end-1;
    }
    else{
      int t = data[end];
      data[end]=data[pivot];
      data[pivot]=t;
      pivot=end;
    }
    return pivot;
  }

  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length-1;
    
    while(true){
      int pivot = partition(data,start,end);
      if(k==pivot) return data[pivot];
      if(k<pivot) end = pivot-1;
      else start = pivot+1;
    }
  }
}
