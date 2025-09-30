package sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] numbers ={2,3,8,9,6};

         selectionSortNumbers(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    private static void selectionSortNumbers(int[] inputArray) {

        for(int i =0; i < inputArray.length -1 ; i++ ){
           int minIndex= i;

           for( int j = i+1; j < inputArray.length; j++){
               if(inputArray[j] < minIndex){
                   minIndex = j;
               }
           }
           swapNumber(inputArray,i,minIndex);
        }
    }

    private static void swapNumber(int[] inputArray, int i, int minIndex) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[minIndex];
        inputArray[minIndex ] = temp;
    }
}
