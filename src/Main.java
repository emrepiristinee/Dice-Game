import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		SLL player1SLL = new SLL();
		SLL player2SLL = new SLL();
		int rndPlayer1, rndPlayer2, score1 = 0, score2 = 0;
		Random rnd = new Random();

		for (int i = 0; i < 10; i++) {
			score1 += player1SLL.check(); // checks the score
			score2 += player2SLL.check(); // checks the score

			for (int j = 0; j < 3; j++) { // rolling the dice
				rndPlayer1 = rnd.nextInt(6) + 1;
				player1SLL.add(rndPlayer1);
				rndPlayer2 = rnd.nextInt(6) + 1;
				player2SLL.add(rndPlayer2);
			}

			System.out.print("Score: " + score1 + "\tPlayer1: ");
			player1SLL.print(); // print the numbers

			System.out.print("\nScore: " + score2 + "\tPlayer2: ");
			player2SLL.print(); // print the numbers
			System.out.println("\n");

		}

		SLL ScoreTable = new SLL();

		if (score1 >= score2) {
			ScoreTable.Sortadd(score1, "score1");
		} else {
			ScoreTable.Sortadd(score2, "score2");
		}

		System.out.println();

		// Read file operations
		String NameAndScore = "", tempName = "";
		File HighScoreTableFile = new File("HighScoreTable.txt");
		Scanner HighScoreTableScanner = new Scanner(HighScoreTableFile);
		int i = 0;
		while (HighScoreTableScanner.hasNextLine()) {
			NameAndScore = HighScoreTableScanner.nextLine();
			if (i % 2 == 0) {
				tempName = NameAndScore;
			} else {
				int tempScore = Integer.parseInt((String) NameAndScore);
				ScoreTable.Sortadd(tempScore, tempName); // sort the score
				tempName = "";
			}
			i++;
		}
		HighScoreTableScanner.close();

		ScoreTable.printNameandScore(); // print High Score Table to screen
		ScoreTable.WriteFile(); // writes new High Score Table in .txt

	}
}
