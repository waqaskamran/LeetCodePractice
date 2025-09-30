import java.util.HashMap;
import java.util.Map;

public class SameCharPattern {
    public static boolean haveSamePattern(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return getFrequencyPattern(s1).equals(getFrequencyPattern(s2));
    }

    private static String getFrequencyPattern(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder pattern = new StringBuilder();
        int code = 0;
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, code++);
            }
            pattern.append(map.get(c)).append("-");
        }
        return pattern.toString();
    }
    public static void main(String[] args) {
        System.out.println(haveSamePattern("xxy", "aba")); // false
        System.out.println(haveSamePattern("abc", "xyz")); // true
        System.out.println(compareCodePattern("fooa","barq")); // false
        System.out.println(comparePatternInString("foo", "bar")); // false
        System.out.println(comparePatternInString("aab", "xyz")); // false
        System.out.println(comparePatternInString("rna", "opq")); // true
        System.out.println(compareCodePattern("rna", "opq")); // true
    }

    public static boolean comparePatternInString(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
       for (int i =0; i < s1.length(); i++){
           if(s1.indexOf(s1.charAt(i)) !=  s2.indexOf(s2.charAt(i))
           || s1.lastIndexOf(s1.charAt(i)) != s2.lastIndexOf(s2.charAt(i))){
               return false;
           }
       }
       return true;
    }

    public static boolean compareCodePattern(String s1, String s2){
        return getPatternCode(s1).equals(getPatternCode(s2));
    }


    public static String getPatternCode(String s){

        HashMap map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        int code =1;
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, code++);
            stringBuilder.append(map.get(c));
        }
        return stringBuilder.toString() ;
    }

}