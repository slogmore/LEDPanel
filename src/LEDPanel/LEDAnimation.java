package LEDPanel;

public class LEDAnimation {
	Vector velocity; 
	LEDObject ledObject; 
	
	public LEDAnimation(LEDObject ledObject, Vector startLocation, Vector velocity) {
		this.velocity = velocity;
		this.ledObject = ledObject; 
		initialize(startLocation);
	}
	
	private void initialize(Vector startLocation) {
		for(Vector ledVector : ledObject.onOffArray)
			ledVector.add(startLocation);
	}
	
	public void update() {
		for(Vector ledVector : ledObject.onOffArray)
			ledVector.add(velocity);
	}
}
