package sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoListAndSortUsingBubble {

    public static void main(String[] args) {
        mergeAndSortBothLists();
        testMergeTwoListsUsingJavaStream();
    }

    private static void testMergeTwoListsUsingJavaStream() {
        int[] arr1 = {5, 1, 9, 3};
        int[] arr2 = {8, 2, 3, 7};

      List<Integer> sortedList = Stream.concat(Arrays.stream(arr1).boxed(),Arrays.stream(arr2).boxed())
                .sorted()
              .collect(Collectors.toList());

        List<Integer> sortedList2 =    Stream.of(arr2,arr1)
              .flatMapToInt(Arrays::stream)
              .boxed()
              .sorted()
              .collect(Collectors.toList());

        sortedList.forEach(x->System.out.println(x));
        sortedList2.forEach(x->System.out.println(x));
    }

    private static void mergeAndSortBothLists() {
        int[] arr1 = {5, 1, 9, 3};
        int[] arr2 = {8, 2, 3, 7};

        int[] mergeSort = new int[arr1.length + arr2.length];

        int k =0;

        for( int arr :arr1){
            mergeSort[k++]= arr;
        }
        for( int arr :arr2){
            mergeSort[k++]= arr;
        }

        for(int i =0; i < mergeSort.length-1; i++){
            for(int j=0; j < mergeSort.length -i -1 ; j++){
                if(mergeSort[j] > mergeSort[j+1]){
                    int temp = mergeSort[j];
                    mergeSort[j] = mergeSort[j +1];
                    mergeSort[j +1] = temp;
                }
            }
        }

        for( int arr :mergeSort){
            System.out.println("merge .." +  arr);
        }
    }

}
