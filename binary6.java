//find position of a target element in infinite sorted array

public class binary6 {
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,10,90,100,130,140,160,170};
        int target=10;
        System.out.println(findingRange(arr, target));
        
    }

    static int findingRange(int[] arr, int target){
        //first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;

        //comdition for target to lie in range
        while(target>arr[end]){
            int temp = end + 1; //this is a new start
            //double the box value
            //end = previous end + sizeofbox*2
            end = end + (end - start +1)*2;
            start = temp;

        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){
          /**
             * find the middle element
             * int mid = (start+end)/2;
             * might be possible that (s+e)/2 exeeds the range of integer in java
             */
            int mid = start + (end-start)/2;

            if(target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
