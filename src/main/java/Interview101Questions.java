import java.util.*;
import java.util.stream.Collectors;

public class Interview101Questions {

    public static void main(String[] args) {
        System.out.println("Reverse String Solution...."+ reverseString("hello"));
        pyramidPrint(9);
        findSumOfTargetInArray();
        findFirstTwoSum();
        findThirdLargest();
        findThirdLargestUsingSwapStrategy();
        System.out.println("compare two arrays equal..." + compareIfTwoArraysAreEqual());
        removeAllWhiteSpaces();
        printDuplicateCharsInArray();
        sumOfAllDigits();
        reverseEachWordWithInString();
        sortMapByValue();

    }

    private static boolean compareIfTwoArraysAreEqual() {
        int[] array1= {2,4,6,8,9};
        int[] array2= {2,4,6,8,8};
        if(array1.length != array2.length){
            return false;
        }
        for (int i=0; i < array1.length ; i++){
            boolean b = array1[i] == array2[i];
            if(!b){
                return false;
            }
        }
        return true;
    }

    public static void removeAllWhiteSpaces() {
        StringBuilder stringBuilder = new StringBuilder();
        String text = "asdf sadfasdf asdfs   sdfsdfasdfa   ";
        for (char c : text.toCharArray()) {
            if(!Character.isWhitespace(c)){
                stringBuilder.append(c);
            }
        }
     System.out.println("removeAllWhiteSpaces..."+  stringBuilder);
    }

    private static void pyramidPrint(int rows) {

        for (int i = 0; i < rows ; i++) {
            for(int space = 0;  space < rows - i; space ++){
                System.out.print(" ");
            }
            for (int star = 0; star < 2*i  - 1 ; star ++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private  static void printDuplicateCharsInArray(){
        String duplicateChars= "test";
        HashMap<Character,Integer> frequencyMap = new HashMap<>();
        for (char c : duplicateChars.toCharArray()) {
            if(frequencyMap.containsKey(c)){
                frequencyMap.put(c, frequencyMap.get(c)+1);
            }
            else {frequencyMap.put(c,1);}
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : frequencyMap.entrySet()) {
            if(characterIntegerEntry.getValue() > 1){
             System.out.println("repeated key.." +  characterIntegerEntry.getKey() + "...times..." + characterIntegerEntry.getValue() );
            }
        }

    }

    private static void sumOfAllDigits(){
        String num= "7896T";
        int totalResult= 0;
        int totalValue = num.chars()
                .filter(Character::isDigit)
                .map(x -> x - '0')
                .sum();
        System.out.println("sumOfAllDigits.."+ totalValue);


        //another way
        for (char c : num.toCharArray()) {
            if(Character.isDigit(c)){
               totalResult += Character.getNumericValue(c);
            }
        }
        System.out.println("Sum of all digit in classic way.."+  totalResult);
    }

    private static void reverseEachWordWithInString(){
        String givenString =  "Hello world from java";
        String[] splitArray = givenString.split(" ");
        StringBuilder finalResult = new StringBuilder();

        for (String word : splitArray) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(word).reverse();
            finalResult.append(stringBuilder).append(" ");

        }


        System.out.println("reverseEachWordWithInString... result...." +  finalResult.toString().trim());
    }

    private static String reverseString(String reverse) {
         StringBuilder result = new StringBuilder();
         for (int i= reverse.length()-1 ; i >= 0 ; i--){
              result.append(reverse.charAt(i));
         }
         return result.toString();
    }

    private  static void findSumOfTargetInArray(){
        int[] nums = {1, 2, 4, 5, 6, 8, 4,8};
        int target = 11;

        int left = 0;                 // start pointer
        int right = nums.length - 1;  // end pointer

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                System.out.println(nums[left] + " + " + nums[right] + " = " + target);
                break;
            } else if (sum < target) {
                System.out.println("left"+ left +"....actual value"+  nums[left]);
                left++;  // move left pointer right
            } else {
                System.out.println("right"+ right +"....actual value"+  nums[right]);

                right--; // move right pointer left
            }
        }
    }

    public static void findFirstTwoSum(){
            int[] nums = {4, 7, 1, 3, 2, 8};
            int target = 5;

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                System.out.println("iterating numbers...");
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    System.out.println("First pair: " + complement + ", " + nums[i]);
                    return;
                }
                map.put(nums[i], i);
            }
        }

        public static void findThirdLargest(){
            int[] nums = {4, 7, 1, 3, 2, 8,4,8};

            PriorityQueue<Integer> heapQueue =  new PriorityQueue<>();
            for (int num : nums) {
                if(!heapQueue.contains(num)){
                    heapQueue.offer(num);
                }
                if(heapQueue.size() > 3){
                    heapQueue.poll();
                }

            }
            System.out.println("founded number..."+ heapQueue.peek());

        }

    public static void findThirdLargestUsingSwapStrategy(){
        int[] nums = {4, 7, 1, 3, 2, 8,8};
        int firstNumber  = Integer.MIN_VALUE;
        int secondNumber  = Integer.MIN_VALUE;
        int thirdNumber  = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == firstNumber || num == secondNumber || num == thirdNumber ){
                continue;

            }
            if(num > firstNumber ){
                thirdNumber= secondNumber;
                secondNumber = firstNumber;
                firstNumber = num;

            }else if(num > secondNumber && secondNumber < firstNumber){
                thirdNumber = secondNumber;
                secondNumber = num;
            }else if(num > thirdNumber  && thirdNumber < secondNumber) {
                thirdNumber  = num;
            }

        }

    System.out.println("findThirdLargestUsingSwapStrategy.." +  thirdNumber);
    }

    private static void sortMapByValue(){
        HashMap<String,Integer> employee  = new HashMap<>();
        employee.put("Rana",23);
        employee.put("Waqas",50);
        employee.put("Kamran",22);

      LinkedHashMap<String,Integer> sortedHashmap= employee.entrySet().stream()
                       .sorted(Map.Entry.comparingByValue())
                               .collect(Collectors.toMap(
                                       e -> e.getKey(),
                                       e->e.getValue(),
                                       (e1,e2)->e1,
                                       LinkedHashMap::new));


        Map<String, Integer> collect = employee.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2) -> e1,LinkedHashMap::new));


        System.out.println("Sorted Map:...:"+ sortedHashmap);
    }

}
