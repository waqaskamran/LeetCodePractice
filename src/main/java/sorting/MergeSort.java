package sorting;

public class MergeSort {

    public static void main(String[] main){
        int[] inputArray ={2,6,8,9,3,1,};
        mergeSort(inputArray);
    }

    private static void mergeSort(int[] inputArray) {

        int arraySize = inputArray.length;

        if(arraySize <  2){
            return;
        }

        int mid = inputArray.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arraySize - mid];

        for (int i= 0; i < mid; i++){
            leftArray[i] = inputArray[i];
        }

        for (int right= mid; right < inputArray.length; right++){
            rightArray[right - mid] = inputArray[right];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        int[] finalSortedArray = merge(inputArray, leftArray, rightArray);

        System.out.println("final array");
        for (int i = 0; i < finalSortedArray.length; i++) {
            System.out.println(finalSortedArray[i]);
        }
    }

    private static int[] merge(int[] inputArray, int[] leftArray, int[] rightArray) {

        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i =0,j=0,k=0;

        while (i < leftSize && j < rightSize){
            if(leftArray[i] <= rightArray[j]){
                inputArray[k] = leftArray[i];
                i++;
                k++;
            }
            else {inputArray[k]= rightArray[j];
                k++;
                j++;
            }
        }

        while (i < leftSize){
            inputArray[k] =  leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize){
            inputArray[k] =  rightArray[j];
            j++;
            k++;
        }
       return inputArray;
    }
}
