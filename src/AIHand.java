import java.util.ArrayList;
import java.util.List;

public class AIHand {

	private static int highCard = 0;

	public AIHand() {

	}

	public int getHighCard() {
		return highCard;
	}

	public Card[] getMyCards() {
		Card[] myCards = new Card[5];
		int i = 0;
		while (i < 5) {
			myCards[i] = new Card(Card.getCard(), Card.getSuit());
			i++;
		}
		return myCards;
	}

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
		int high = highCard(combination);
		highCard = high;
		// --------------------------------------------------------------------------------------------------
		if (royalFlush(combination) == 1) {
			return 1;
		} else if (straightFlush(combination) == 2) {
			;
			return 2;
		} else if (fourOfAKind(combination) == 3) {
			return 3;
		} else if (fullHouse(combination) == 4) {
			return 4;
		} else if (flush(combination) == 5) {
			return 5;
		} else if (straight(combination) == 6) {
			return 6;
		} else if (threeOfAKind(combination) == 7) {
			return 7;
		} else if (twoPair(combination) == 8) {
			return 8;
		} else if (pair(combination) == 9) {
			return 9;
		} else
			return 0;
	}

	private int royalFlush(List<String> combination) {
		if (combination.contains("ace") && combination.contains("king") && combination.contains("quin")
				&& combination.contains("jack") && combination.contains("ten")) {
			// System.out.println("Your combination is: 'Rolyal Flush'");
			return 1;
		} else
			return 0;
	}

	private int straightFlush(List<String> combination) {
		if (combination.contains("ten") && combination.contains("nine") && combination.contains("eight")
				&& combination.contains("seven") && combination.contains("six")) {
			// System.out.println("Your combination is: 'Straight Flush'");
			return 2;
		} else
			return 0;
	}

	private int fourOfAKind(List<String> combination) { // Доробити вдома!!!
		int currentElementCount = 0;
		for (int i = 0; i < combination.size() - 1; i++) {
			for (int j = i + 1; j < combination.size(); j++) {
				if (combination.get(i) == combination.get(j)) {
					continue;
				} else {
					currentElementCount++;
				}
			}
		}
		if (currentElementCount == 4) {
			// System.out.println("Your combination is: 'Four of a Kind'");
			return 3;
		} else
			return 0;
	}

	private int fullHouse(List<String> combination) {
		if (combination.contains("ace") && combination.contains("ace") && combination.contains("ace")
				&& combination.contains("king") && combination.contains("king")) {
			// System.out.println("Your combination is: 'Full House'");
			return 4;
		} else
			return 0;
	}

	private int flush(List<String> combination) {
		if (combination.contains("king") && combination.contains("ten") && combination.contains("eight")
				&& combination.contains("seven") && combination.contains("five")) {
			// System.out.println("Your combination is: 'Flush'");
			return 5;
		} else
			return 0;
	}

	private int straight(List<String> combination) {
		if (combination.contains("ten") && combination.contains("nine") && combination.contains("eight")
				&& combination.contains("seven") && combination.contains("six")) {
			// System.out.println("Your combination is: 'Straight'");
			return 6;
		} else
			return 0;
	}

	private int threeOfAKind(List<String> combination) {
		int currentElementCount = 0;
		for (int i = 0; i < combination.size() - 1; i++) {
			for (int j = i + 1; j < combination.size(); j++) {
				if (combination.get(i) == combination.get(j)) {
					currentElementCount++;
				}
			}
		}
		if (currentElementCount == 3) {
			// System.out.println("Your combination is: 'Three of a Kind'");
			return 7;
		} else
			return 0;
	}

	private int twoPair(List<String> combination) {
		// System.out.println("Your combination is: 'Two Pair'");
		return 0;
	}

	private int pair(List<String> combination) { // Не реалізовано!
		int currentElementCount = 0;
		for (int i = 0; i < combination.size() - 1; i++) {
			for (int j = i + 1; j < combination.size(); j++) {
				if (combination.get(i) == combination.get(j)) {
					currentElementCount++;
				}
			}
		}
		if (currentElementCount == 2) {
			System.out.println("Your combination is: 'Pair'");
			return 9;
		} else
			return 0;
	}

	private int highCard(List<String> combination) {
		if (combination.contains("ace")) {
			return 13;
		} else if (combination.contains("king")) {
			return 12;
		} else if (combination.contains("quin")) {
			return 11;
		} else if (combination.contains("jack")) {
			return 10;
		} else if (combination.contains("ten")) {
			return 9;
		} else if (combination.contains("nine")) {
			return 8;
		} else if (combination.contains("eight")) {
			return 7;
		} else if (combination.contains("seven")) {
			return 6;
		} else if (combination.contains("six")) {
			return 5;
		} else if (combination.contains("five")) {
			return 4;
		} else if (combination.contains("four")) {
			return 3;
		} else if (combination.contains("three")) {
			return 2;
		} else if (combination.contains("two")) {
			return 1;
		} else {
			return 0;
		}
	}

}
