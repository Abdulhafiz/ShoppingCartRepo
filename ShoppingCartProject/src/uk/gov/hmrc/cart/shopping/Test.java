package uk.gov.hmrc.cart.shopping;


public class Test {

	public static void main(String[] args) {

		Balloon red = new Balloon("Red"); //memory reference 50
		Balloon blue = new Balloon("Blue"); //memory reference 100
		
		swap(red, blue);
		System.out.println("red color="+red.getColor());
		System.out.println("blue color="+blue.getColor());
		
		foo(blue);
		System.out.println("blue color="+blue.getColor());
		
	}

	private static void foo(Balloon balloon) { //baloon=100
		balloon.setColor("Red"); //baloon=100
		balloon = new Balloon("Green"); //baloon=200
		//balloon.setColor("Blue"); //baloon = 200
		
		System.out.println("foo color="+balloon.getColor());
	}

	//Generic swap method
	public static void swap(Object o1, Object o2){
		Object temp = o1;
		o1=o2;
		o2=temp;
		
		System.out.println("o1Red bue color="+((Balloon) o1).getColor());
		System.out.println("o2Blue red color="+((Balloon) o2).getColor());
		
	}
}
