package Deck;

import java.util.ArrayList;

import Card.*;

public class Deck {
	private ArrayList<Card> deck;
	private Card card;
	
	public Deck() {
		deck = new ArrayList<>();
		deck.add(new CardA());
		deck.add(new CardB());
		deck.add(new CardC());
		deck.add(new CardD());
	}
	
	public Card getCard(int index) {
		card = deck.get(index);
		CardUtil.cardFactory(card);
		return card;
	}
	
	
	

}	

