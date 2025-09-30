import java.util.*;
import java.util.stream.Collectors;

public class ChallengeTest {
    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(new Employee("Rana", 1L, 30, 15000,"IT","Male"),
                new Employee("Waqas", 2L, 29, 18000,"HR","Female"),
                new Employee("Bob", 2L, 29, 18000,"Finance","Male"),
                new Employee("Bob", 2L, 29, 22000,"Finance","Male"),
                new Employee("Alice", 2L, 29, 25000,"IT","Male"),
                new Employee("kamran", 3L, 31, 20000,"HealthCare","Female"));

        findLongestSubStringDistinctWithKSize();
        findLongestNonRepeatingSubstring();
        findMaxSubStringWithK();
        findFirstTwoSumTarget();
        findTwoSumByPointers();
        getNoOfGenderByDepartment(employeeList);
        findMaxSalaryByDept(employeeList);
        findMaxSubstringWithoutRepeating();
        findMinLengthSubArray(10);
        findMaxSubArrayMoreThanTargetTarget();
    }

    public static void findLongestSubStringDistinctWithKSize() {
        String givenString = "eceba";
        int left = 0;
        int k=2;
        int maxLength=0;
        HashMap<Character,Integer> map = new HashMap<>();

        for (int right = 0 ; right < givenString.length(); right++){

            char currentChar = givenString.charAt(right);
            map.put(currentChar,map.getOrDefault(currentChar,0) + 1);
            while (map.size() > k){
                char leftChar = givenString.charAt(left);
                map.put(leftChar,map.get(leftChar) -1 ); // decrease value of left
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength,right - left +1);
        }
        System.out.println("max length...+" +  maxLength);
    }


    public static void findLongestNonRepeatingSubstring() {
        String givenString = "abbbbbabc";
        int left = 0;
        int maxLength =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int right=0; right <  givenString.length(); right ++){

            char currentChar = givenString.charAt(right);
            while (map.containsKey(currentChar)){
                char leftChar = givenString.charAt(left);
                if(map.containsKey(leftChar)){
                    map.remove(leftChar);
                }
                left++;
            }
            map.put(currentChar,right);
           maxLength = Math.max(maxLength ,right -left  + 1);

        }

        System.out.println("findLongestNonRepeatingSubstring max length...+" +  maxLength);
    }

    public static void findMaxSubStringWithK(){
        /*arr = [2,1,5,1,3,2], K = 3
        Subarrays: [2,1,5] = 8, [1,5,1] = 7, [5,1,3] = 9, [1,3,2] = 6
        Answer → 9  (subarray [5,1,3])*/
     int[] numbers = {2,1,5,1,3,2};
     int left =0 ;
     int k = 3;
     int windowSum=0;
     int sum =0;

     for (int right= 0; right < k; right++){
         windowSum += numbers[right];
     }
     sum = windowSum;

     for (int right=k; right < numbers.length ; right ++){

         windowSum += numbers[right];
         windowSum -= numbers[left];
         left++;
         sum =  Math.max(windowSum,sum);

     }

        System.out.println("findMaxSubStringWithK...:" + sum );

    }


   public static void findFirstTwoSumTarget(){

        int[] numbers ={4,3,2,9,2,1};
        int target= 5;
        HashMap<Integer,Integer> modMap = new HashMap<>();
        for (int i =0; i < numbers.length; i++){
           int compensation = target - numbers[i];
           if(modMap.containsKey(compensation)){
               System.out.println("first pair    " + compensation + "  and   " +numbers[i]);
               break;
           }
           modMap.put(numbers[i], i);
        }

   }

   public static void findTwoSumByPointers(){
        int[] numbers ={2,4,8,1,6,9,0};
       Arrays.sort(numbers);
        int leftPointer = 0;
        int rightPointer = numbers.length - 1 ;
        int target= 10;

        while(leftPointer < rightPointer){
            int currentSum = numbers[leftPointer]  + numbers[rightPointer];
            if(currentSum ==  target){
                System.out.println("findTwoSumByPointers..+" + numbers[leftPointer]  +"right group"+ numbers[rightPointer]);
               // break;
                leftPointer++;
                rightPointer--;
            }
            if(currentSum < target){
                leftPointer ++;
            }
            if(currentSum > target){
                rightPointer --;
            }
        }
   }

    private static void getNoOfGenderByDepartment(List<Employee> employeeList) {

        Map<Integer, List<Employee>> getSalaryGroup =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary));

        Map<String, Map<String, Long>> genderByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender,Collectors.counting())));


        getSalaryGroup.forEach((salary,empl) -> System.out.println("salary..+" +salary + "list of emp..+" +  empl));

        for (Map.Entry<String, Map<String, Long>> mapEntry : genderByDepartment.entrySet()) {
            System.out.println("dept" +  mapEntry.getKey());
            for (Map.Entry<String,Long> genderCount : mapEntry.getValue().entrySet()){
                System.out.println("gender" +  genderCount.getKey() + "count" + genderCount.getValue());

            }
        }


    }

    private static void findMaxSalaryByDept(List<Employee> employeeList){
       String dept = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .map(Employee::getDepartment)
                        .toString();

        Map<String, Integer> deptSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));

        LinkedHashMap<String, Integer> deptSalarySorted = deptSalary.entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()
                        , (e1, e2) -> e1, LinkedHashMap::new));


        for (Map.Entry<String, Integer> salaryDept : deptSalarySorted.entrySet()) {

            System.out.println(" findMaxSalaryByDept dept"+ salaryDept.getKey() + "salary" + salaryDept.getValue());

        }


    }

    public static void findMaxSubstringWithoutRepeating(){
        String givenString = "abcdabcbb";
        int left =0;
        int maxLength=0;
        HashMap<Character,Integer> trackMap = new HashMap<>();
        for (int right= 0; right < givenString.length(); right++) {
            char currentChar = givenString.charAt(right);
        while(trackMap.containsKey(currentChar)){
            char leftChar =givenString.charAt(left);
            trackMap.remove(leftChar         );
            left++;
        }
        trackMap.put(currentChar,right);
         maxLength =Math.max(maxLength,right - left +1);
        }
        System.out.println("findMaxSubstringWithoutRepeating new...+" +  maxLength);
    }

    public static void findMinLengthSubArray(int target) {
        int[] numbers = {2, 5, 8, 9, 3, 5};
        int sum = 0;
        int left = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = -1, endIndex = -1;

        for (int right = 0; right < numbers.length; right++) {
            sum += numbers[right];

            while (sum >= target) {
                int windowLength = right - left + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    startIndex = left;
                    endIndex = right;
                }
                sum -= numbers[left];
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println("No subarray found with sum ≥ " + target);
        } else {
            System.out.println("Minimum length: " + minLength);
            System.out.print("Subarray: ");
            for (int i = startIndex; i <= endIndex; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
        }
    }

    private static void findMaxSubArrayMoreThanTargetTarget() {
        int[] numbers = {3,8,2,13,7,6,12} ;
        int maxSize=3;
        int target=20;
        int sum =0;
        int maxLength = 0;
        int maxSum=0;
        StringBuilder stringBuilder = new StringBuilder();
        //13,7,6

        int left =0;
        HashMap<String,String> map= new HashMap<>();
        for (int right =0; right < maxSize; right++){
            sum += numbers[right];
            stringBuilder.append(numbers[right]);
        }
        maxSum = sum;
        if(maxSum > target){
            map.put("1", stringBuilder.toString());
        }
        for (int right =maxSize; right < numbers.length; right++){

            StringBuilder sb = new StringBuilder();
            sum += numbers[right];
            sum -= numbers[left];
            left++;

            for (int j=left; j <= right; j++){
                sb.append(numbers[j]).append(",");
            }
            if (sum > maxSum){
                maxSum = sum;
            }
            if(maxSum > target){
                map.put(String.valueOf(left), sb.toString());
            }
        }

        System.out.println("findMaxSubArrayWithTarget.."+ maxSum + " max length.. + "+  maxLength);
        for (Map.Entry<String,String>  mp : map.entrySet()){
            System.out.println("map" +  mp.getValue());
        }

    }

}
