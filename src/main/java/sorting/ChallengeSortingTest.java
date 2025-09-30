package sorting;


public class ChallengeSortingTest {

    public static void main(String[] args) {
        int[] inputArray ={2,6,8,9,3,1};
        sortByQuickSort(inputArray);
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println( inputArray[i]);
        }
    }

    private static void sortByQuickSort(int[] inputArray) {

        quickSort(inputArray,0,inputArray.length-1);

    }

   public static void quickSort(int[] inputArray, int lowIndex,int highIndex){
        if(lowIndex > highIndex) {
            return;
        }
        int pivot= inputArray[highIndex];
        int leftPointer =lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer){
            while (inputArray[leftPointer] <=  pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while (inputArray[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer --;
            }
            swapNumber(inputArray,leftPointer,rightPointer);
        }
        swapNumber(inputArray,leftPointer,highIndex);

        quickSort(inputArray,leftPointer,leftPointer -1);
        quickSort(inputArray,leftPointer + 1, highIndex);



   }
    public static void swapNumber(int[] inputArray,int number1,int number2){
        int temp= inputArray[number1];
        inputArray[number1] = inputArray[number2];
        inputArray[number2] = temp;
    }


}
