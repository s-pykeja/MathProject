import net.objecthunter.exp4j.Expression;

public class Utility {
	public static final String X = "x";
	public static double integral(Expression e, double b, double a, int n) {
		double fa = 0, fb = 0, sum = 0;
		e.setVariable(X,a);
		fa = e.evaluate();
		e.setVariable(X, b);
		fb = e.evaluate();
		for(int k = 1; k <= n - 1; k++) {
			e.setVariable(X, a + k*(b-a)/n);
			sum += e.evaluate();
		}
		return (b - a) / n * (fa / 2 + sum + fb / 2);
	}
}
