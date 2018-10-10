import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Table {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Random rd = new Random();

	private Hand myHand = new Hand();
	private AIHand aiHand = new AIHand();
	int myCards = myHand.getCombination(myHand.getMyCards());
	int AICards = aiHand.getCombination(aiHand.getMyCards());

	private int money = 0;
	private long rate = 0;
	private int increaseCount = 0;
	private int numOfMoves = 0;

	public Table(int money) {
		this.money = money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void showMyMoney() {
		System.out.println("You have: " + money + "$");
	}

	public int getNumOfMoves() {
		return numOfMoves;
	}

	public void setRate(BufferedReader br) {
		int myRate = 0;
		System.out.println("Make your bet: ");
		try {
			myRate = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Bet must be a number!!!");
			setRate(br);
		} catch (IOException e) {
			System.out.println("Bet must be a number!!!");
			setRate(br);
		}
		if (myRate >= 200) {
			if (money > 0 && money >= myRate) {
				rate += myRate;
				money -= myRate;
				System.out.println("Your money: " + getMoney());
				System.out.println("Current bet: " + getRate());
				passOrCheck(br);
			} else {
				System.out.println("You don't have money!");
				setRate(br);
			}
		} else {
			System.out.println("You must put at least 200$");
			setRate(br);
		}
	}

	public long getRate() {
		return rate;
	}

	public void passOrCheck(BufferedReader br) {
		String pass = "";
		System.out.println("If you want to quit the game - send '/pass'");
		System.out.println("If you want to continue - send '/check'");
		System.out.println("If you want to increase your bet - send '/increase'");
		System.out.println("Or you can open the cards - send '/open'");
		try {
			pass = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (pass.equals("/open") && numOfMoves >= 0) {
			openCards();
			System.exit(1);
		} else if (pass.equals("/show")) {
			showMyMoney();
			passOrCheck(br);
		} else if (pass.equals("/pass")) {
			System.out.println("You lose!");
			System.out.println("You have a lot: " + money + "$");
		} else if (pass.equals("/check")) {
			increaseCount = 0;
			numOfMoves++;
			System.out.println("You checked...");
			actionAI();
		} else if (pass.equals("/increase")) {
			if (increaseCount != 0) {
				increaseCount = 0;
				System.out.println(
						"Please send '/increase' again to increase your bet if your opponent has not surrendered yet");
				actionAI();
			} else {
				increaseCount++;
				numOfMoves++;
				System.out.println("Your opponent make something");
				System.out.println("Please increase your bet!");
				setRate(br);
				System.out.println("Your money: " + getMoney());
				System.out.println("Current bet: " + getRate());
			}
		} else {
			System.out.println("You must do 4 moves at least!");
			System.out.println("Unknown command! Please choose one of the following:");
			passOrCheck(br);
		}
	}

	public void actionAI() {
		int action = rd.nextInt(3);
		int aiRate = rd.nextInt(1000);
		if (action == 0) {
			System.out.println("Your opponent checked");
			passOrCheck(br);
		} else if (action == 1) {
			System.out.println("Your opponent raises the bet on: " + aiRate);
			rate += aiRate;
			passOrCheck(br);
		} else if (action == 2) {
			System.out.println("Your opponent gives up!");
			money += rate + new Random().nextInt(500);
			System.out.println("Congratulations, you won!");
			System.out.println("You have: " + money + "$");
			System.exit(1);
		}

	}

	public void openCards() {
		if (myCards < AICards) {
			System.out.println("YOU WIN!");
			money += rate + new Random().nextInt(500);
			System.out.println("You have: " + money + "$");
		} else if(myHand.getHighCard() > aiHand.getHighCard()) {
			System.out.println("YOU WIN! (Highest card)");
			money += rate + new Random().nextInt(500);
			System.out.println("You have: " + money + "$");
		} else {
			System.out.println("YOU LOSE!");
			System.out.println("You have a lot: " + money + "$");
		}
	}

}
