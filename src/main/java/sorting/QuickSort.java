package sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] inputArray ={2,6,8,9,3,1};
        quickSort(inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            System.out.println("after sorting .."+  inputArray[i]);
        }

    }

    private static void quickSort(int[] inputArray) {

        quickSort(inputArray,0,inputArray.length-1);
    }


    private static void quickSort(int[] inputArray,int lowIndex,int highIndex) {

        if(lowIndex >  highIndex){
            return;
        }
        int pivot = inputArray[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer){

            while (inputArray[leftPointer] <=  pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while (inputArray[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(inputArray,leftPointer,rightPointer);
        }
        swap(inputArray,leftPointer,highIndex);

        quickSort(inputArray,lowIndex,leftPointer-1);
        quickSort(inputArray,leftPointer + 1,highIndex);

    }

    public static void swap( int[] inputArray,int index1,int index2){
        int temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;

    }

}
