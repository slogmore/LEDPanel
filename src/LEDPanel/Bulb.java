package LEDPanel;
import processing.core.*;


public class Bulb {
	float x, y;
	PImage bulbOn;
	PImage bulbOff;
	int width, height;
	
	Bulb(PApplet parent, PImage bulbOn, PImage bulbOff)	{
		this.bulbOn = bulbOn;
		this.bulbOff = bulbOff;
		width = bulbOn.width;
		height = bulbOn.height;
	}

	Bulb(Bulb bulb, int x, int y) {
		this.bulbOn = bulb.bulbOn;
		this.bulbOff = bulb.bulbOff;
		this.x = x;
		this.y = y;
	}
}



 
