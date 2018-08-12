public class Main {

    public static void main(String[] args) {
	// write your code here
        Array<Integer> array = new Array(20);
        for (int i = 0; i < 20; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());

        array.add(1,100);
        System.out.println(array.toString());

        System.out.println("get:"+array.get(1));
        array.set(2,200);
        System.out.println(array.toString());
        System.out.println("indexOf:"+array.indexOf(2));
        array.remove(1);
        System.out.println(array.toString());
        array.removeFirst();
        System.out.println(array.toString());
        array.removeLast();
        System.out.println(array.toString());
        array.removeElement(8);
        System.out.println(array.toString());


    }
}
