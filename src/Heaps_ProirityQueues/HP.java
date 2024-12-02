package Heaps_ProirityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HP {
	
		// leetcode 1405
		public String longestDiverseString(int a, int b, int c){
			PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x,y) -> y[0] - x[0]);
		    if (a > 0)	priorityQueue.offer(new int[]{a,'a'});
			if (b > 0)  priorityQueue.offer(new int[]{b,'b'});
			if (c > 0)	priorityQueue.offer(new int[]{c,'c'});
			
			StringBuilder answer = new StringBuilder();
			while (!priorityQueue.isEmpty()){
				int[] first = priorityQueue.poll();
				if (answer.length() >= 2 && answer.charAt(answer.length()-1) == first[1] && answer.charAt(answer.length()-2) == first[1])
				{
		            if (priorityQueue.isEmpty()) break;
					
					int [] second = priorityQueue.poll();
					answer.append ( (char) second[1]);
					second[0]--;
					
					if (second[0] > 0) priorityQueue.offer(second);
					priorityQueue.offer(first);
				}else {
					answer.append ( (char) first[1]);
					first[0]--;
				 
					if (first[0] > 0) priorityQueue.offer(first);
				}
			}
			return answer.toString();
		}
}
