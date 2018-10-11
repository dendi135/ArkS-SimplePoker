import java.util.ArrayList;
import java.util.List;

public class Hand extends Combinations implements Hands{

	private static int highCard = 0;

	public Hand() {

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
		System.out.println("Your have this cards: " + firstCard + ", " + secondCard + ", " + thirdCard + ", "
				+ fourthCard + ", " + fifthCard);
		// --------------------------------------------------------------------------------------------------
		Combinations c = new Combinations();
		int high = c.highCard(combination);
		highCard = high;
		// --------------------------------------------------------------------------------------------------
			return myCombination(combination);
	}
	
	@Override
	protected int myCombination(List<String> combination) {
		if (royalFlush(combination) == 1) {
			System.out.println("Your combination is: 'Rolyal Flush'");
			return 1;
		} else if (straightFlush(combination) == 2) {
			System.out.println("Your combination is: 'Straight Flush'");
			return 2;
		} else if (fourOfAKind(combination) == 3) {
			System.out.println("Your combination is: 'Four of a Kind'");
			return 3;
		} else if (fullHouse(combination) == 4) {
			System.out.println("Your combination is: 'Full House'");
			return 4;
		} else if (flush(combination) == 5) {
			System.out.println("Your combination is: 'Flush'");
			return 5;
		} else if (straight(combination) == 6) {
			System.out.println("Your combination is: 'Straight'");
			return 6;
		} else if (threeOfAKind(combination) == 7) {
			System.out.println("Your combination is: 'Three of a Kind'");
			return 7;
		} else if (twoPair(combination) == 8) {
			// System.out.println("Your combination is: 'Two Pair'");
			return 8;
		} else if (pair(combination) == 9) {
			System.out.println("Your combination is: 'Pair'");
			return 9;
		} else
			return 0;
	}

}
