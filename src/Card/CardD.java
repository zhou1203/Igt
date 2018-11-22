package Card;

public class CardD extends Card {

	private String type;
	private int bouns, penalty;
	private boolean isWin;
	
	public CardD() {
		this.type = "D";
		this.bouns = 50;
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

	@Override
	public void lotterySystem() {
		isWin = CardUtil.probability(1, this);
	}

	@Override
	public void generatePenalty() {
		this.penalty = 250;	
	}
	
	public void Desc() {
		CardUtil.Desc(this);
	}

}
