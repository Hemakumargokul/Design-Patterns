

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;





public class Monkey {

	private int x=0;
	private int y=0;
	
	MonkeyState monkeyState;

	
	public Monkey() {
		monkeyState = new IdleState();
		
	}

	public void setMonkeyState(MonkeyState newMonkeyState) {
		monkeyState = newMonkeyState;
	}

	

	public MonkeyState moveUp(Monkey monkey) {
		return monkeyState.moveUp(this);
	}

	public MonkeyState moveDown(Monkey monkey) {
		return monkeyState.moveDown(this);
	}

	public MonkeyState moveLeft(Monkey monkey) {
		return monkeyState.moveLeft(this);
	}

	public MonkeyState moveRight(Monkey monkey) {
		return monkeyState.moveRight(this);
	}

	public MonkeyState moveReleased(Monkey monkey) {
		return monkeyState.moveReleased(this);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
