package fmi.informatics.functional;

// Демонстриране чрез клас имплементиращ интерфейса IGravity
public class Rock implements IGravity {

	public void drop(double height) {
		double heightMeters = Math.abs(height);
		double timeToHitGround = Math.sqrt(2 * heightMeters / acceleration()); 
		System.out.format("It took %f seconds for the rock to hit the ground", timeToHitGround);
		System.out.format("\n The speed is %f ",speedAtImpact(heightMeters));
	}

	@Override
	public double height() {
		return 10;
	}
}
