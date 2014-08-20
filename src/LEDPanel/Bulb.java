package LEDPanel;
import processing.core.*;


public class Bulb {
	float x, y;
	int colorOn = 0;
	int colorOff = 255;
	PImage bulbOn;
	PImage bulbOff;
	int fadeOutTime; 
	int height, width;
	
	Bulb(PApplet parent, PImage bulbOn, PImage bulbOff)	{
		this.bulbOn = bulbOn;
		this.bulbOff = bulbOff;
		width = bulbOn.width;
		height = bulbOn.height;
	}

	Bulb(Bulb bulb)	{
		bulbOn = bulb.bulbOn;
		bulbOff = bulb.bulbOff;
	}

	void setLocation(float x, float y)	{
		this.x = x;
		this.y = y;
	}
	

}



 
