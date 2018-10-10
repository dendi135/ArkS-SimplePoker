import java.util.Random;

public class Card {

	public Card(Cards card, Suit suit) {
	}

	public static Cards getCard() {
		Cards[] CARDS = Cards.values();
		int pick = new Random().nextInt(Cards.values().length);
		Cards haveCard = CARDS[pick];
		return haveCard;
	}

	public static Suit getSuit() {
		Suit[] SUIT = Suit.values();
		int pickS = new Random().nextInt(Suit.values().length);
		Suit haveSuit = SUIT[pickS];
		return haveSuit;
	}

	@Override
	public String toString() {
		return getCard().toString() + " of " + getSuit().toString();

	}

}
