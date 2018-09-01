import java.util.Random;

/**
 * @author ronglexie
 * @version 2018/9/1
 */
public class Main {

	public static void main(String[] args) {
		int n = 1000000;
		int size = 1000000;

		UnionFind1 unionFind1 = new UnionFind1(size);
		double testUnionFind1Time = testUnionFind(unionFind1, n);
		System.out.println("UnionFind1： "+testUnionFind1Time+" s");

		UnionFind2 unionFind2 = new UnionFind2(size);
		double testUnionFind2Time = testUnionFind(unionFind2, n);
		System.out.println("UnionFind2： "+testUnionFind2Time+" s");

		UnionFind3 unionFind3 = new UnionFind3(size);
		double testUnionFind3Time = testUnionFind(unionFind3, n);
		System.out.println("UnionFind3： "+testUnionFind3Time+" s");

		UnionFind4 unionFind4 = new UnionFind4(size);
		double testUnionFind4Time = testUnionFind(unionFind4, n);
		System.out.println("UnionFind4： "+testUnionFind4Time+" s");

		UnionFind5 unionFind5 = new UnionFind5(size);
		double testUnionFind5Time = testUnionFind(unionFind5, n);
		System.out.println("UnionFind5： "+testUnionFind5Time+" s");

		UnionFind6 unionFind6 = new UnionFind6(size);
		double testUnionFind6Time = testUnionFind(unionFind6, n);
		System.out.println("UnionFind6： "+testUnionFind6Time+" s");
	}

	/**
	 * 测试并查集性能
	 *
	 * @param unionFind
	 * @param n
	 * @return double
	 * @author ronglexie
	 * @version 2018/9/1
	 */
	public static double testUnionFind(UnionFind unionFind, int n){
		int size = unionFind.getSize();
		Random random = new Random();

		long startTime = System.nanoTime();

		for (int i = 0; i < n; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			unionFind.unionElements(a,b);
		}

		for (int i = 0; i < n; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			unionFind.isConnected(a,b);
		}

		long endTime = System.nanoTime();
		return (endTime - startTime) / 1e9;
	}
}
