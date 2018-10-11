

interface Hands {
	public int getHighCard();
	public int getCombination(Card[] myCards);
	
	public default Card[] getMyCards() {
		Card[] myCards = new Card[5];
		int i = 0;
		while (i < 5) {
			myCards[i] = new Card(Card.getCard(), Card.getSuit());
			i++;
		}
		return myCards;
	}
}
