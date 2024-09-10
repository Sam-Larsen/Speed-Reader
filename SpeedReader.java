import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
/**
 * @author SamLarsen
 * Assignment 5 Speed Reader
 * 11/14/2022
 * Written/online sources used: none
 * Help obtained: none
 * I confirm that the above list of sources is complete AND that I have not talked to anyone else (e.g., CSC 207 students) about the solution to this problem.
 */
public class SpeedReader {
		
	public static void main(String[] args) throws InterruptedException {
		int width = 400;
		int height = 400;
		int fontSize = 20;
		int wpm = 250;
		WordGenerator text;
		if(args.length != 5) {
			System.err.println("Please Pass 5 arguments of the form:\n <filename> <width> <height> <font size> <wpm>");
			return;
		}
		try {
			text = new WordGenerator(args[0]);
		} catch(FileNotFoundException e) {
			System.err.println("Error: File cannot be found.");
			return;
		}
		try {
			width = Integer.parseInt(args[1]);
			height = Integer.parseInt(args[2]);
			fontSize = Integer.parseInt(args[3]);
			wpm = Integer.parseInt(args[4]);
		} catch(NumberFormatException e) {
			System.err.println("Please enter integer values for width, height, font size and words per minute.");
			return;
		}
		
		DrawingPanel dp = new DrawingPanel(width, height);
		Graphics g = dp.getGraphics();
		Font f = new Font("Courier", Font.BOLD, fontSize);
		g.setFont(f);
		while(text.hasNext()) {
			g.drawString(text.next(), fontSize+10, fontSize+10);
			Thread.sleep(60000/wpm);
			g.setColor(Color.WHITE);
			g.fillRect(0,0, width, height);
			g.setColor(Color.BLACK);
		}
		f = new Font("Courier", Font.BOLD, (int)(fontSize*.6));
		g.setFont(f);
		g.drawString("Word count: "+text.getWordCount(), fontSize+10, fontSize+10);
		g.drawString("Sentence count: "+text.getSentenceCount(), fontSize+10, fontSize+40);
	}
}
