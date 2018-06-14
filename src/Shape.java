import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Shape extends MobileComponent{

	protected Expression shape;
	protected Expression bound;
	protected String shapeEquation;
	protected String boundEquation;
	protected double density;
	protected Expression centroidX;
	protected Expression centroidY;
	protected double a, b;
	protected int n;
	
	public Shape(String shape, String bound, double b, double a, int n, double density) {
		this.shapeEquation = shape;
		this.boundEquation = bound;
		this.b = b;
		this.a = a;
		this.n = n;
		this.density = density;
		centroidX = new ExpressionBuilder("x((" + shape + ")-(" + bound + "))")
				.variable(Utility.X)
				.build();
		centroidY = new ExpressionBuilder(".5((" + shape + ")^2-(" + bound + ")^2)")
				.variable(Utility.X)
				.build();

		this.shape = new ExpressionBuilder(shape)
			.variable(Utility.X)
			.build();
		if(bound != null && bound.length() > 0)
		{
			this.bound = new ExpressionBuilder(bound)
					.variable(Utility.X)
					.build();
		}
	}
	
	public double getArea() {
		return Math.abs(Utility.integral(shape, b, a, n) - (bound == null ? 0 : Utility.integral(bound, b, a, n)));
	}

	@Override
	public double getCentroidX() {
		return Math.abs((1 / getArea()) * Utility.integral(centroidX, b, a, n));
	}

	public double getCentroidY() {
		return Math.abs(1 / getArea() * Utility.integral(centroidY, b, a, n));
	}
	
	@Override
	public double getTotalMass() {
		return density * getArea();
	}
	
	public Moment createMoment(double x) {
		return new Moment(x, getTotalMass());
	}
	@Override
	public void debug() {
		System.out.println("Shape: " + shapeEquation + "  and  " + boundEquation);
		System.out.println("Area: " + getArea());
		System.out.println("Centroid X: " + getCentroidX());
		System.out.println("Centroid Y: " + getCentroidY());
		System.out.println("Total Mass: " + getTotalMass());
		System.out.println();
	}
}
