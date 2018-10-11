import java.util.ArrayList;
import java.util.List;

public class AIHand implements Hands{

	private static int highCard = 0;

	public AIHand() {

	}
	
	@Override
	public int getHighCard() {
		return highCard;
	}

	@Override
	public Card[] getMyCards() {
		return Hands.super.getMyCards();
	}

	@Override
	public int getCombination(Card[] myCards) {
		String firstCard = myCards[0].toString().toLowerCase();
		String secondCard = myCards[1].toString().toLowerCase();
		String thirdCard = myCards[2].toString().toLowerCase();
		String fourthCard = myCards[3].toString().toLowerCase();
		String fifthCard = myCards[4].toString().toLowerCase();
		String[] fcValue = firstCard.split(" ");
		String[] scValue = secondCard.split(" ");
		String[] tcValue = thirdCard.split(" ");
		String[] focValue = fourthCard.split(" ");
		String[] fifcValue = fifthCard.split(" ");
		List<String> combination = new ArrayList<String>();
		combination.add(fcValue[0]);
		combination.add(scValue[0]);
		combination.add(tcValue[0]);
		combination.add(focValue[0]);
		combination.add(fifcValue[0]);
		// --------------------------------------------------------------------------------------------------
		// System.out.println("Your have this cards: " + firstCard + ", " + secondCard +
		// ", " + thirdCard + ", " + fourthCard + ", " + fifthCard);
		// --------------------------------------------------------------------------------------------------
		Combinations c = new Combinations();
		int high = c.highCard(combination);
		highCard = high;
		// --------------------------------------------------------------------------------------------------
			return c.myCombination(combination);
	}

}
