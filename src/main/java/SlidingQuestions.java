import java.util.*;

public class SlidingQuestions {


    public static void main(String[] args) {
        findMaxSubArray();
        findMaxSubArrayWithWindow();
        findAllAnagramInString();
        findMinLenOfSubArray(7);
        findMaximumLengthOfSubstrings();

    }

    private static void findMaxSubArray() {
        int [] numbers= {2,4,5,1,9,6,5,4,2,3,4} ;
        int max = Integer.MIN_VALUE;
        int subArraySize = 4;
        for (int i =0 ; i < numbers.length -subArraySize ; i++){
            int current = 0;

            for (int j = i ; j < i + subArraySize -1 ; j++){
                current = current + numbers[j];
            }
           if(current > max){
               max = current;
           }
        }
        System.out.println("findMaxSubArray ...: " + max);
    }

    private static void findMaxSubArrayWithWindow() {
        int[] numbers = {3,8,2,5,7,6,12} ;
        int max = Integer.MIN_VALUE;
        int subArraySize = 4;
        int current = 0;
        for (int i = 0;  i < subArraySize ;  i++){
            current += numbers[i] ;
            System.out.println("findMaxSubArrayWithWindow first window..:" +  max);
        }
        for (int i = 1; i <= numbers.length - subArraySize  ; i++){
            current += numbers[i + subArraySize -1];
            current -= numbers[i-1];
            if(current > max){
                System.out.println("findMaxSubArrayWithWindow ...max value:   " + max );
                max =current;
            }
        }
        System.out.println("findMaxSubArrayWithWindow..: final ..:    " +  max);
    }

    public static void findAllAnagramInString(){
        String text =  "bacadbcadbca";
        String pattern = "abc";
        int windowSize = 3;
        List<Integer> indexOfAngramList = new ArrayList<>();

        HashMap<Character,Integer> patternMap = new HashMap<>();
        HashMap<Character,Integer> windowMap = new HashMap<>();


        for (int i=0; i< pattern.length(); i++){
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i),0)+1);
        }
        for (int i=0; i< windowSize; i++){
            windowMap.put(text.charAt(i), windowMap.getOrDefault(text.charAt(i),0)+1);
        }
        if(windowMap.equals(patternMap)){
            indexOfAngramList.add(0);
        }
        //Sliding window

        for (int i= windowSize; i < text.length();  i++){
            char nextChar = text.charAt(i);
            windowMap.put(nextChar, windowMap.getOrDefault(nextChar,0)+1);
            //remove previous

            char oldChar = text.charAt(i - windowSize);
            windowMap.put(oldChar,windowMap.get(oldChar) -1);
            if(windowMap.get(oldChar) == 0){
                windowMap.remove(oldChar);
            }
            if(windowMap.equals(patternMap)){
                indexOfAngramList.add(i -windowSize +1);
            }
        }

        System.out.println("findAllAnagramInString...:   " );
        indexOfAngramList.forEach(System.out::println);

    }
    public  static void findMinLenOfSubArray(int target){
       int[] array = {2, 3, 1, 2, 4, 3};
        int minLength=Integer.MAX_VALUE;
        int left  = 0;
        int sum = 0;
        for(int i =0; i < array.length; i ++){
            sum += array[i];

            while(sum >= target){
                if(i+1 - left < minLength ){
                    minLength = i+1 - left;
                }
                sum -= array[left];
                left++;

            }
        }
        System.out.println("findMinLenOfSubArray...:" + minLength);
    }

    public static void findMaximumLengthOfSubstrings() {
        String givenString = "abba";
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < givenString.length(); right++) {
            char currentChar = givenString.charAt(right);

            // If duplicate found, shift `left` to the next position after last occurrence
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update the index of currentChar
            map.put(currentChar, right);

            // Calculate length
            int currentLength = right - left + 1;
            maxLength = Math.max(maxLength, currentLength);
        }

        System.out.println("findMaximumLengthOfSubstrings..: " + maxLength);
    }


}
