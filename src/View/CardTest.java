package View;

import Card.*;
import Deck.Deck;

public class CardTest {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Card c;
		boolean n;
		System.out.println(deck);
		
		for (int i = 0; i < 4; i ++ ) {
			c = deck.getCard(i);
			System.out.println("==============");
			c.Desc();
			n = c.isWin();
			
			if (n) {
				System.out.println("\n���н��ˣ�\n����" + c.getBouns());
			} else {
				System.out.println("\n�㱻�����ˣ�\n����" + c.getPenalty());
			}
		}

	}

}
