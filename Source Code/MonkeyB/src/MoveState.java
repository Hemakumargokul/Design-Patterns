public class MoveState extends MonkeyState {

	private int up,down,left,right;
	
	public MonkeyState moveLeft(Monkey monkey) {
		left=monkey.getX()- Utils.MONKEY_SIZE;
		monkey.setX(left);
		monkey.setMonkeyState(this);
		return this;
	}

	public MonkeyState moveRight(Monkey monkey) {
		right=monkey.getX()+ Utils.MONKEY_SIZE;
		monkey.setX(right);
		monkey.setMonkeyState(this);
		return this;
	}
	public MonkeyState moveUp(Monkey monkey) {
		up=monkey.getY()- Utils.MONKEY_SIZE;
		monkey.setY(up);
		monkey.setMonkeyState(this);
		return this;
	}

	public MonkeyState moveDown(Monkey monkey) {
		down=monkey.getY()+ Utils.MONKEY_SIZE;
		monkey.setY(down);
		monkey.setMonkeyState(this);
		return this;
	}
	public MonkeyState moveReleased(Monkey monkey) {
		monkey.setMonkeyState(new IdleState());
		return new IdleState();
	}
}
