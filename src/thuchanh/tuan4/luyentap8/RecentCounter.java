package thuchanh.tuan4.luyentap8;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.offer(t);

        // Remove requests that are outside the time frame [t-3000, t]
        while (requests.peek() < t - 3000) {
            requests.poll();
        }

        // Return the number of requests within the time frame
        return requests.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1)); // Output: 1
        System.out.println(recentCounter.ping(100)); // Output: 2
        System.out.println(recentCounter.ping(3001)); // Output: 3
        System.out.println(recentCounter.ping(3002)); // Output: 3
    }
}