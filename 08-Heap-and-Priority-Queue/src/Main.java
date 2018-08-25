import java.util.Random;

/**
 * @author ronglexie
 * @version 2018/8/25
 */
public class Main {

	public static void main(String[] args) {
		int n = 1000000;

		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		}

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] =maxHeap.extractMax();
		}

		for (int i = 1; i < n; i++) {
			if(arr[i-1] < arr[i]){
				throw new IllegalArgumentException("Error");
			}
		}

		MinHeap<Integer> minHeap = new MinHeap<>();
		random = new Random();
		for (int i = 0; i < n; i++) {
			minHeap.add(random.nextInt(Integer.MAX_VALUE));
		}

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] =minHeap.extractMin();
		}

		for (int i = 1; i < n; i++) {
			if(arr[i-1] > arr[i]){
				throw new IllegalArgumentException("Error");
			}
		}
	}

}
