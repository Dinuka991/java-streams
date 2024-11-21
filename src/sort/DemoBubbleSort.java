package sort;

public class DemoBubbleSort {
    public static void main(String[] args) {

    }


    public static void demoBubble(int[] arr){

        int length = arr.length;

        for(int i=0; i< length -1; i++){
            for(int j=0; j < length - i -1 ; j++){
                  if ( arr[j] > arr [i]) {
                      int temp = arr[j];
                      arr[j] = arr [j +1];
                      arr[j + 1] = temp;

                  }
            }
        }

        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

