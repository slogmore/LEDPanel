package LEDPanel;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PGraphics;

public class LEDSurface {
	private ArrayList<LEDAnimation> ledAnimations; 
	private Vector location;
	private Bulb [][] bulbs;
	private Dimensions bulbDim;
	private Dimensions bulbGridDim;
	private Dimensions pixelGridDim;
	private PApplet parent; 
	private PGraphics bulbSurface;
	
	public LEDSurface(PApplet parent, Bulb bulb, Vector location, int width, int height) { 
		this.parent = parent;
		this.location = location;
		ledAnimations = new ArrayList<LEDAnimation>();
		
		initializeDim(bulb, width, height); 
		buildBulbArray(bulb);
		buildBulbBackgroundImage();
	}
	
	private void initializeDim(Bulb bulb, int width, int height) {
		bulbDim = new Dimensions(bulb.width, bulb.height);
		pixelGridDim = new Dimensions(width * bulb.width, height * bulb.height);
		bulbGridDim = new Dimensions(width, height);
	}
	
	private void buildBulbArray(Bulb bulb)	{
		int xLoc, yLoc; 
		bulbs = new Bulb[bulbGridDim.width][bulbGridDim.height];
		for(int row = 0; row < bulbGridDim.height; row++)
			for(int col = 0; col < bulbGridDim.width; col++)
				bulbs[col][row] = new Bulb(bulb, col * bulb.width, row * bulb.height);
	}
	
	private void buildBulbBackgroundImage() {
		bulbSurface = parent.createGraphics(pixelGridDim.width, pixelGridDim.height, parent.JAVA2D);
		bulbSurface.beginDraw();
		for(int row = 0; row < bulbGridDim.height; row++)
			for(int col = 0; col < bulbGridDim.width; col++)
				bulbSurface.image(bulbs[col][row].bulbOff, bulbs[col][row].x, bulbs[col][row].y);
		bulbSurface.endDraw();
	}
	
	void drawSurface() {
		drawBackground(); 
		drawAnimations();
	}
	
	private void drawBackground() {
		parent.image(bulbSurface, location.x, location.y);
	}
	
	private void drawAnimations() {
		for(LEDAnimation animation : ledAnimations) {
			animation.update();
			for(Vector ledVector : animation.ledObject.onOffArray) {
				int x = (int)ledVector.x;
				int y = (int)ledVector.y;
				if(onSurface(x, y)) {
					int bulbOnX = (int)(bulbs[x][y].x + location.x);
					int bulbOnY = (int)(bulbs[x][y].y + location.y);
					parent.image(bulbs[x][y].bulbOn, bulbOnX, bulbOnY);
				}
			}
		}
	}
	
	private boolean onSurface(int x, int y) {
		if(x >= 0 && x < bulbGridDim.width)
			if(y >= 0 && y < bulbGridDim.height)
				return true;
		return false;
	}
	
	
	void addAnimation(LEDAnimation animation) {
		ledAnimations.add(animation);
	}

}
