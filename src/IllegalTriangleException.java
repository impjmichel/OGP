
public class IllegalTriangleException extends Exception
{

	private double side1,side2,side3;
	
	public IllegalTriangleException(double side1, double side2, double side3)
	{
		super("Illegal Triangle constructed with: "+side1+", "+side2+", "+side3+".");
		this.setSide1(side1);
		this.setSide2(side2);
		this.setSide3(side3);
		
		if(side1+side2 < side3)
			message();
	}
	
	public void message()
	{
		System.out.print("illegal triangle!!\nThe given sides do not form a triangle");
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}
}
