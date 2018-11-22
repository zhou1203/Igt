package Card;

public class CardA extends Card {

	private String type;
	private int bouns, penalty;
	private boolean isWin;
	
	public CardA() {
		this.type = "A";
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
		this.isWin =  CardUtil.probability(5, this);
	}
	
	public void generatePenalty() {
		this.penalty = 35 + (int)(Math.random() * 115);
	}
	
	public void Desc() {
		CardUtil.Desc(this);
	}
	
}
