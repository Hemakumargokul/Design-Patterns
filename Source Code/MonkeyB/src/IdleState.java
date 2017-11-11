
	



 
public class IdleState extends MonkeyState {

	public MonkeyState moveUp(Monkey monkey) {
		monkey.setY(monkey.getY() );
		monkey.setMonkeyState(new MoveState());
		return new MoveState();
	}

	public MonkeyState moveRight(Monkey monkey) {
		monkey.setX(monkey.getX() );
		monkey.setMonkeyState(new MoveState());
		return new MoveState();
	}

	public MonkeyState moveDown(Monkey monkey) {
		monkey.setY(monkey.getY() );
		monkey.setMonkeyState(new MoveState());
		return new MoveState();
	}

	public MonkeyState moveLeft(Monkey monkey) {
		monkey.setX(monkey.getX());
		monkey.setMonkeyState(new MoveState());
		return new MoveState();
	}
	
	public MonkeyState moveReleased(Monkey monkey) {
		
		return this;
	}

}
