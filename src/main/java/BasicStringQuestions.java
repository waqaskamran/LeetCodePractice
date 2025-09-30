import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class BasicStringQuestions {
    private static HashMap<Integer ,Long> memoryMap =  new HashMap<>();

    public static void main(String[] args) {

       System.out.println( "isPalindrome ..." + isPalindrome("abba"));
       System.out.println( "first non repeated char ..." + firsNonRepeatedCharacter("swiss"));
       System.out.println( "fibonacciNumber..." + fibonacciNumber(3));
       System.out.println( "removeWhiteSpace..." + "J a v a is F u n");
       System.out.println( "are arrays equal..{}"+ compareTwoArraysEqual());
    }



    public static boolean  isPalindrome(String testStr){
        if(testStr == null){return false;}
        int lengthOfString  = testStr.length();

        for (int i = 0; i < lengthOfString/2; i++) {
            System.out.println("isPalindrome::value iterating.."+ i);
            if(testStr.charAt(i) != testStr.charAt(lengthOfString -i -1)){
                return false;
            }
        }
        return true;
    }

    public static Character firsNonRepeatedCharacter(String testStr){
        HashMap<Character,Integer> countMap = new LinkedHashMap<>();
        if(Objects.nonNull(testStr)){
            for (char ch : testStr.toCharArray()) {
                countMap.put(ch,countMap.getOrDefault(ch,0)+1);

            }
            for (Map.Entry<Character, Integer> characterIntegerEntry : countMap.entrySet()) {
                if(characterIntegerEntry.getValue() ==1){
                    return characterIntegerEntry.getKey();
                }
            }
        }
        return null;
    }


    public static Character findDuplicateCharacter(String testStr){
        HashMap<Character,Integer> countMap = new LinkedHashMap<>();
        if(Objects.nonNull(testStr)){
            for (char ch : testStr.toCharArray()) {
                countMap.put(ch,countMap.getOrDefault(ch,0)+1);

            }
            for (Map.Entry<Character, Integer> characterIntegerEntry : countMap.entrySet()) {
                if(characterIntegerEntry.getValue() > 1){
                    return characterIntegerEntry.getKey();
                }
            }
        }
        return null;
    }

    public static boolean compareTwoArraysEqual(){
        int[] array1 =  {1,1,2,4,4};
        int[] array2 =  {1,1,2,4,4};
        boolean isEqual = false;
        if(array1.equals(array2)){
            isEqual = true;
            for (int i = 0; i < array1.length; i++) {
                if(array1[i] != array2[i]){
                 isEqual = false;
                 break;
                }
            }
        }
        return isEqual;
    }
    public static String removeWhiteSpace(String whiteSpaceStr){
        if(Objects.nonNull(whiteSpaceStr)){
            return whiteSpaceStr.replaceAll("\\s+", "");
        }
        return null;
    }

    public static long  fibonacciNumber (int number) {

        System.out.println("fibonacciNumber..number"+ number);
        if(number <=1){
            System.out.println("less than "+ number);
            return number;
        }
        if(memoryMap.containsKey(number)){
            System.out.println("found in memory..number"+ number);
            return memoryMap.get(number);
        }

        System.out.println("fibonacciNumber..calling recurrsion for "+ number);
        long result = fibonacciNumber(number - 1) + fibonacciNumber(number - 2);
        System.out.println("result count "+ number);
        memoryMap.put(number,result);
        System.out.println("final return result..."+ result);
        return result;
    }
}