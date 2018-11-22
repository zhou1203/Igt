package Card;

public abstract class Card {
	
	public String type;
	public int bouns, penalty;
	public boolean isWin;

	public Card() {}
	
	public String getType() {
		return type;
	}
	
	public int getBouns() {
		return bouns;
	}

	public int getPenalty() {
		return penalty;
	}
	
	public boolean isWin() {
		return isWin;
	}

	public abstract void lotterySystem();
	
	public abstract void generatePenalty();;
	
	public abstract void Desc();
}
