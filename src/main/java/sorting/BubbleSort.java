package sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers ={4,3,8,9,6};

        bubbleSortNumbers(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    private static void bubbleSortNumbers(int[] numbers) {

      boolean swapped = true;
      while (swapped) {
          swapped =false;
          for (int i =0; i < numbers.length -1 ; i++){
              if(numbers[i] > numbers [i+ 1]){
                  swapNumber(numbers,i, i+1);
                  swapped=true;
              }
          }
      }
    }

    public static void swapNumber(int[] numbers, int val1, int val2){
        int temp = numbers[val1];
        numbers[val1] = numbers[val2];
        numbers[val2] = temp;
    }
}
