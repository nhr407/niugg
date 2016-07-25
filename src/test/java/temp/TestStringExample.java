package temp;

public class TestStringExample {

	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		System.out.println("a==b: "+(a==b));
		String c = new String("abc");
		String d = new String("abc");
		System.out.println("c==d: " + (c==d));
		System.out.println("c.intern()==d.intern(): " + (c.intern()==d.intern()));
		System.out.println("c.intern()==a: "+(c.intern()==a));
		
		Integer a1= 3;
		Integer a2 = 3;
		System.out.println("a1==a2:" + (a1==a2));
		
	}

}
