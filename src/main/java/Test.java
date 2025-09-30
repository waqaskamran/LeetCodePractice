import java.util.*;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        findMaximumSubstringWithTarget();
        findLongestSubstring();
        findSubstringPalinDrom();
        findLongestSubstringWithKDistinctChar();
        findMinimumWindowsSubstring();
        findMinimumWindowsSubstringWithSlidingWindow();
        findMinSumLengthWithTargetBrutForce();
        findAllAnagrams();
        findLongestSubstringWithKDistinctCharTest();
        //findMinimumWindowsSubstringTest();
        findLongestNonRepeatingSubstringTest();
        sortListUsingStream();
        findLongestWithKAtMost();
        System.out.println("balanceBracketProblem..result " + balanceBracketProblem());
        mergeTwoSortedList();
        findMissingNumberInArray();
        findMaxSubArrayWithWindow();


    }

    private static void findMissingNumberInArray() {
        int[] numbers = {2,4,1,5};

        int numbersLength = numbers.length;
        int expectedSum = (numbersLength+1) * (numbersLength +2) /2;
        int actualSum = 0;
        for(int number : numbers){
            actualSum += number;
        }
       int missingNumber = expectedSum - actualSum;
        System.out.println("findMissingNumberInArray..+" +  missingNumber);
    }

    private static void mergeTwoSortedList() {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(8);
        ListNode mergedList = mergeTwoSortedList(l1, l2);
        while (mergedList != null){
            System.out.println("mergeTwoSortedList..sorted" +  mergedList.value);
            mergedList =mergedList.next;
        }
    }

    private static ListNode mergeTwoSortedList(ListNode l1,ListNode l2) {
        if(l1 == null) return l2;
        if (l2 == null) return l1;
        if(l1.value < l2.value){
            l1.next = mergeTwoSortedList(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoSortedList(l1,l2.next);
            return l2;
        }
    }

    private static boolean balanceBracketProblem() {
        String givenStr ="()[]{}";
        HashMap<Character, Character> trackMap = new HashMap();
        trackMap.put('(',')');
        trackMap.put('[',']');
        trackMap.put('{','}');
        Stack<Character> stack = new Stack<>();

        for (char c : givenStr.toCharArray()) {
            if(trackMap.containsKey(c)){
               stack.push(c);
            } else  {
                Character pop = stack.pop();
                if(trackMap.get(pop) != c){
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }

    private static void findLongestWithKAtMost() {
        String givenStr = "eceba";
        int k = 2;
        int left =0;
        int maxLength =0;
        HashMap<Character,Integer> trackMap = new HashMap<>();

        for (int i =0; i < givenStr.length(); i ++){
            char currentChar = givenStr.charAt(i);
            trackMap.put(currentChar,trackMap.getOrDefault(currentChar,0)+1);
            while (trackMap.size() > k){
                char leftChar= givenStr.charAt(left);
                trackMap.put(leftChar, trackMap.get(leftChar)-1);
                if(trackMap.get(leftChar) == 0){
                    trackMap.remove(leftChar);
                }
                left++;
            }
            maxLength= Math.max(maxLength, i - left +1);
        }
        System.out.println("findLongestWithKAtMost .."+ maxLength);
    }

    private static void sortListUsingStream() {

        //int[] number = {4,3,2,1};

       // int[] number2 = {7,5,5};

       List<Integer> numbers = Arrays.asList(4,3,2,1);
       List<Integer> numbers2 = Arrays.asList(6,5,5);

       List<Integer> finalList = numbers.stream()
               .sorted()
               .toList();


        finalList.forEach(x->System.out.println("sortListUsingStream" + x));

    }

    private static void findLongestNonRepeatingSubstringTest() {
      //  "abcabcbb" → output 3 ("abc").
                String givenStr ="abcabcbb";
                HashMap<Character,Integer> trackMap = new HashMap<>();
                int maxLength=0;
                int left =0;
                int start =0;
                int end =0;
                for (int i=0; i < givenStr.length(); i++){
                    char currentChar = givenStr.charAt(i);
                    trackMap.put(givenStr.charAt(i),trackMap.getOrDefault(givenStr.charAt(i),0)+1);
                    while (trackMap.containsKey(givenStr.charAt(i)) && trackMap.get(givenStr.charAt(i)) > 1){

                        trackMap.put(givenStr.charAt(left), trackMap.get(givenStr.charAt(left)) -1);
                        if(trackMap.get(givenStr.charAt(left)) ==0 ){
                            trackMap.remove(givenStr.charAt(left));
                        }
                        left++;

                    }
                  //  maxLength = Math.max(maxLength,i -left +1);
                    if(maxLength < i - left +1 ){
                            maxLength = i - left +1 ;
                            start = left;
                            end = i;
                        }


                }
                System.out.println("findLongestNonRepeatingSubstringTest..." +  maxLength + "start +"
                        + givenStr.substring(start ,start + maxLength));

    }

    private static void findMinimumWindowsSubstringTest() {
        //Input: s = "ADOBECODEBANC", t = "ABC"
        //Output: "BANC"

        String givenStr= "ADOBECODEBANC";
        String pattern = "ABC";
        int minLength=100;
        int left =0;
        String finalShortSubString="";
        List<String> trackList = new ArrayList<>();

        int textSize = givenStr.length();
        int patterLength= pattern.length();

        for (int right =0; right < textSize; right ++){

            String window= givenStr.substring(left, right + 1);
            while (containsAll(window,pattern)){
                if(minLength > window.length()){
                    minLength = window.length();
                    finalShortSubString = window;
                }
                left++;

            }
        }
        System.out.println("findMinimumWindowsSubstringTest.." + finalShortSubString);
    }

    private static void findLongestSubstringWithKDistinctCharTest() {
        String givenStr =  "eceba";
        int k = 2;
        int left =0;
        int maxLength = 0;
        int start=0;
        int end =0;
        HashMap<Character,Integer> trackMap = new HashMap<>();

        for(int right =0; right < givenStr.length(); right++){
            char currentChar = givenStr.charAt(right);
            trackMap.put(currentChar,trackMap.getOrDefault(currentChar,0)+1);
            while(trackMap.size() > k) {
                char leftChar = givenStr.charAt(left);
                trackMap.put(leftChar, trackMap.get(leftChar) - 1);
                if (trackMap.get(leftChar) == 0) {
                    trackMap.remove(leftChar);
                }
                left++;
            }
               // maxLength = Math.max(maxLength,right -left +1);
                if(maxLength < right - left +1){
                    maxLength = right - left +1;
                    start = left;
                    end = right;
                }

        }
        System.out.println("findLongestSubstringWithKDistinctCharTest max length" +maxLength + "first pair" +  start + "seconf pair" +  end);
    }
//classic O(n)2
    private static void findMinimumWindowsSubstring() {
        String givenStr = "ABOBECODEBANC";
        String pattern = "ABC";
        int minLength=100;
        String finalShortString ="";

        for(int i =0; i < givenStr.length(); i++){

            for(int j=i; j < givenStr.length(); j++){
                String sub = givenStr.substring(i, j+1);
                if(containsAll(sub,pattern)){
                    if(minLength >  sub.length()) {
                        minLength = sub.length();
                        finalShortString = sub;
                    }
                }
            }

        }
        System.out.println("findMinimumWindowsSubstring...:+" + finalShortString);



    }

    private static boolean containsAll(String sub, String pattern) {
        HashSet<Character> set = new HashSet<>();
        for (char c  : sub.toCharArray()){
            set.add(c);
        }
        for (char c  : pattern.toCharArray()){
           if(!set.contains(c)){
               return false;
           }
        }
        return true;
    }

private static void findMinimumWindowsSubstringWithSlidingWindow() {
        String givenStr = "ABOBECODEBANC";
        String pattern = "ABC";
        int minLength=100;
        String finalShortString ="";
        int left =0;
        for(int right =0; right < givenStr.length(); right++){
          String window= givenStr.substring(left, right +1);
          while (containsAll(window,pattern)){
              if(minLength > window.length()){
                  minLength = window.length();
                  finalShortString = window;
              }
              left++;
              window = givenStr.substring(left,right +1);
          }
        }
    System.out.println("findMinimumWindowsSubstringWithSlidingWindow sliding" +
            "...:+" + finalShortString);


}

    private static void findLongestSubstringWithKDistinctChar() {
       String givenStr =  "eceba";
       int k = 2;
       int left =0;
       int maxLength=0;
       int startIndex =0;
       HashMap<Character,Integer> freqMap = new HashMap<>();
       for (int right = 0; right < givenStr.length(); right++){
           freqMap.put(givenStr.charAt(right), freqMap.getOrDefault(givenStr.charAt(right),0) +  1);

           while (freqMap.size() > k){
               char leftChar = givenStr.charAt(left);
               if(freqMap.containsKey(leftChar)){
                   freqMap.put(leftChar, freqMap.get(leftChar) -1);
                   if(freqMap.get(leftChar) == 0){
                       freqMap.remove(leftChar);
                   }
               }
               left++;

           }
           if(maxLength < right - left + 1){
               maxLength = right - left +1;
               startIndex = left;
           }

       }
        String actualString =  givenStr.substring(startIndex,startIndex + maxLength);
        System.out.println("actual sub string .. + " +  actualString);
    }

    private static void findSubstringPalinDrom() {
        String giveStr= "babad"; // bab or aba
        String longestSubstring ="";
        for(int i =0; i < giveStr.length(); i++){
            System.out.println("findSubstringPalinDrom I" +  giveStr.charAt(i));

            for (int j =i; j < giveStr.length() -1; j ++){
                System.out.println("findSubstringPalinDrom J" +  giveStr.charAt(i) + giveStr.charAt(j));

                String sub = giveStr.substring(i , j+1);
                System.out.println("substring" +  sub);
                if (isPalinDrome(sub) && sub.length() > longestSubstring.length()){
                    longestSubstring = sub;
                }

            }
        }
        System.out.println("findSubstringPalinDrom..final    " +  longestSubstring);

    }

    public static void findMinSumLengthWithTargetBrutForce(){
        int[] givenArray = {2,3,4,3,3,6,1};
        int target = 9;
        int minLength = 100;
        int sum =0;
        int left =0;
        int start=0;
        int end=0;

        for(int right = 0; right < givenArray.length; right ++){
            sum += givenArray[right] ;

            while (sum >= target){
                sum -= givenArray[left];
               // minLength =  Math.min(minLength, right -left +1);
                if(minLength > right -left +1){
                    minLength = right - left +1;
                    start = left;
                    end = left + minLength -1;
                }
                left++;
            }
        }
        System.out.println("findMinSumLengthWithTargetBrutForce..:" + minLength +"start " +  givenArray[start] + "next :" +  givenArray[end]);

    }

    private static boolean isPalinDrome(String testPalindromStr) {
        int right = testPalindromStr.length() -1;
        int left =0;
        while(left < right){
            left++;
            right--;
            if(testPalindromStr.charAt(left) !=  testPalindromStr.charAt(right)){
                return false;
            }

        }
        return true;
    }

    private static void findLongestSubstring() {
        String givenStr ="abcdaacbb";
        HashMap<Character,Integer> trackMap = new HashMap<>();
        int left =0;
        int maxLength =0;

        for(int right=0; right < givenStr.length(); right ++){
            char currentChar = givenStr.charAt(right);
            while (trackMap.containsKey(currentChar)){
                char leftChar = givenStr.charAt(left);
                trackMap.remove(leftChar);
                left++;
                printWindowLongest(givenStr,left,right);
            }
            trackMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left +1);
        }
        System.out.println("findLongestSubstring.." + maxLength);
        trackMap.forEach((x,y)-> System.out.println(x) );

    }

    private static void printWindowLongest(String givenStr,int left, int right){

        System.out.print("    windows [");
        for (int i= left; i <= right; i++){
            System.out.print(givenStr.charAt(i));
        }
        System.out.println("]");
    }

    private static void findMaximumSubstringWithTarget() {
        int[] numbers ={2, 1, 5, 1, 3, 2};
        int k = 3 ;
        int target=9;
        int left=0;
        int sum=0;
        int windowSum=0;

        for(int i=0; i < k; i++){

            windowSum += numbers[i];
        }
        sum=windowSum;
        for(int right =k; right < numbers.length; right++){
            windowSum += numbers[right];
            windowSum -= numbers[left];
            left++;
            printWindowSlide(numbers,left,right,windowSum);
          sum =  Math.max(sum,windowSum);
        }
        System.out.println("   final sum,...+"+  sum);
    }

    private static void printWindowSlide(int[] numbers,int left, int right,int sum){

        System.out.print("    windows [");
        for (int i= left; i <= right; i++){
            System.out.print(numbers[i] +",");
        }
        System.out.print("] =   " + sum);
    }

    public static void findAllAnagrams(){
        String givenStr = "cbaebabacd";
        String pattern = "abc";
        Integer index =1;
        HashMap<Integer,String> trackMap = new HashMap<>();

        int textSize = givenStr.length();
        int patternSize = pattern.length();

        for (int right=0; right <= textSize - patternSize; right ++){

            String sub = givenStr.substring(right , right + patternSize );
            if(isAnagram(sub,pattern)){
                trackMap.put(index,sub);
                index++;
            }
        }
        System.out.println("findAllAnagrams..+" + trackMap.size() );
        trackMap.forEach((x,y) -> System.out.println("actual value..+" +  y));
    }

    private static boolean isAnagram(String sub, String pattern) {
        char[] windowArray =sub.toCharArray();
        char[] patternArray = pattern.toCharArray();
        Arrays.sort(windowArray);
        Arrays.sort(patternArray);
        return Arrays.equals(windowArray,patternArray);
    }

    public static void findMaxSubArrayWithWindow(){
        int[] numbers = {3,8,2,5,7,6,12} ;
        int windowSize =4;
        int windowSum=0;
        int finalSum=Integer.MAX_VALUE;
        int left =0;
        for (int i=0; i < windowSize; i++){
            windowSum += numbers[i];
        }
        finalSum = windowSum;
        for (int right =windowSize ; right < numbers.length; right++){
            windowSum += numbers[right];
            windowSum -= numbers[left];
            left++;
        }
        finalSum = Math.max(finalSum,windowSum);
        System.out.println("findMaxSubArrayWithWindow..:" + finalSum);

    }

}

