import java.util.PriorityQueue;

public class ListQuestions {

    public static void main(String[] args) {
        findThirdLargestNumberInArray();
        findThirdLargestNumberInPriorityQueue();
        findPrimeNumberFromStartToEnd(50);
    }

    private static void findPrimeNumberFromStartToEnd(int numbers) {

        for (int i = 0; i < numbers; i++){
            if(checkIfNumberIsPrime(i)){
                System.out.println("findPrimeNumberFromStartToEnd..."+ i);
            }

        }
    }

    private static boolean checkIfNumberIsPrime(int n) {
        if( n <= 1) return false;
        if( n == 2) return true;
        if(n % 2 ==0) return false;

        for(int i=2; i < Math.sqrt(n); i ++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    private static void findThirdLargestNumberInPriorityQueue() {

        int[] numbers =  {4,6,8,8,9,6,10,10,10,10};

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int number : numbers) {
            if(!priorityQueue.contains(number)){
                priorityQueue.offer(number);
            }
            System.out.println("third largest.." + priorityQueue);
            if(priorityQueue.size() > 3){
                System.out.println("removing last element");
                priorityQueue.poll();
            }
        }
        System.out.println("findThirdLargestNumberInPriorityQueue "+ priorityQueue.peek());

    }

    private static void findThirdLargestNumberInArray() {
        int[] numbers =  {4,6,8,8,9,10,10};

        Integer first =null;
        Integer second =null;
        Integer third = null;

        for (int number : numbers) {

            if(first != null && first == number  || second != null && second ==number  || third != null && number == third){
                continue;

            }

            if( first ==null ||  number >  first){
                third =second;
                second = first;
                first = number;
            }else if( second == null || number > second){
                third = second;
                second =number;
            }
            else if( third == null || number > third){
                third = number;
            }

        }
        System.out.println("findThirdLargestNumberInArray..." + third);
    }
}
