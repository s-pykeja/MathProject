import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MathProject {

	public static void main(String[] args) {
		Shape s = new Shape("-x^2+5", "0",2.236, 0.0, 10000, 10);
		s.debug();
		
		Shape s2 = new Shape("-x^2+5", "x^3",1.433, 0.0, 10000, 10);
		s2.debug();
		
		CrossMember member = new CrossMember(.5, new Moment[] {s.createMoment(-1), s2.createMoment(1)});
		member.debug();
		
		CrossMember base = new CrossMember(.5, new Moment[] { member.createMoment(.25) } );
		base.debug();
	}
}
