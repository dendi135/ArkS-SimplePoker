import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gameplay {

	public Gameplay() {
	}

	public void gameRun() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Table t = new Table(5000);
		t.setRate(br);
	}

	public static void main(String[] args) {
		new Gameplay().gameRun();
	}

}
