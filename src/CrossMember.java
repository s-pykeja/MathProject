
public class CrossMember extends MobileComponent{
	private Moment[] moments;
	private double weight;
	public CrossMember(double weight, Moment[] moments) {
		this.moments = moments;
		this.weight = weight;
	}
	@Override
	public double getCentroidX() {
		int mSum = 0;
		for(int i = 0; i < moments.length; i++) {
			mSum += moments[i].x * moments[i].m;
		}
		return mSum / (getTotalMass() - weight);
	}
	@Override
	public double getTotalMass() {
		int mass = 0;
		for(int i = 0; i < moments.length; i++) {
			mass += moments[i].m;
		}
		return mass + weight;
	}
	@Override
	public void debug() {
		System.out.println("Cross Member");
		System.out.println("Centroid X " + getCentroidX());
		System.out.println();
	}
	
	public Moment createMoment(double x) {
		return new Moment(x, getTotalMass());
	}
}
