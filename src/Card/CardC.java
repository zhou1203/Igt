package Card;

public class CardC extends Card {

	private String type;
	private int bouns, penalty;
	private boolean isWin;
	
	public CardC() {
		this.type = "C";
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
		isWin = CardUtil.probability(5, this);
	}

	@Override
	public void generatePenalty() {
		this.penalty = 25 + (int)(Math.random() * 50);
	}
	
	public void Desc() {
		CardUtil.Desc(this);
	}

}
