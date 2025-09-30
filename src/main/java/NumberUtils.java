import java.util.PriorityQueue;

public class NumberUtils {

    public static int findThirdLargestNumber(int[] numbers) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int number : numbers) {
            if (!priorityQueue.contains(number)) {
                priorityQueue.offer(number);
            }
            if (priorityQueue.size() > 3) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }
}
