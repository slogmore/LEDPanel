package LEDPanel;
import pixelated.*;
import processing.core.*;

public class Main extends PApplet
{
	Bulb bulb;
	LEDSurface ledSurface;
	LEDObject ledObject;
	LEDAnimation ledAnimation1, ledAnimation2;
	LEDObject ledTextObject;
	
	PImage busImage = loadImage("../images/bus.png");
	PImage on = loadImage("../images/on.png");
	PImage off = loadImage("../images/off.png");
	
	public void setup() {
	  size(600, 600);
      bulb = new Bulb(this, on, off);
      frameRate(24);
      ledSurface = new LEDSurface(this, bulb, new Vector(145, 45), 100, 15);
    
      PFont testFont = createFont("Times New Roman", 140);
      PixelatedText pixelatedText = new PixelatedText(this, testFont, color(200, 150, 0), "Valerie's Butt");				
      pixelatedText.setResolution(10);
      pixelatedText.setPixelationTolerance(0.5f);
	  ledTextObject = new LEDTextObject(this, pixelatedText);
	  ledAnimation1 = new LEDAnimation(ledTextObject, new Vector(100, 1), new Vector(-0.2, 0.0));
	  ledSurface.addAnimation(ledAnimation1);
	}

	public void draw() {
		background(255);
		ledSurface.drawSurface();
		image(busImage, 0, 0);
	}

	public static void main(String _args[])	{
		PApplet.main(new String[] { LEDPanel.Main.class.getName() });
	}
}











