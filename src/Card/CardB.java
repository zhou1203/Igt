package Card;

public class CardB extends Card {
	private String type;
	private int bouns, penalty;
	private boolean isWin;
	
	public CardB() {
		this.type = "B";
		this.bouns = 100;
	}
		
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

	public void lotterySystem() {	
		 isWin = CardUtil.probability(1, this);
	}

	
	public void generatePenalty() {
		this.penalty = 1250;	
	}
	
	public void Desc() {
		CardUtil.Desc(this);
	}

}
