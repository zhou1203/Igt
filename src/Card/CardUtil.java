package Card;

public class CardUtil {
	
	public static void  Desc(Card card) {
		System.out.println("你抽到的是牌" + card.getType() + "\n");
	}
	
	public static boolean probability(int p, Card card) {
		int count = 10 / p;
		int a[] = new int[count];
		for (int i=0; i<count; i++) {
			a[i] = i + 1;
		}
		
		int x = a[(int)(Math.random() * count)];
		if (x == a[0]) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void cardFactory(Card card) {
		card.generatePenalty();
		card.lotterySystem();
	}
}


