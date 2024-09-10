import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordGenerator {
	
	private Scanner sc;
	private int wordCount;
	private int sentenceCount;
	
	/**
	 * One argument constructor
	 * @param fileName name of file to read words from
	 */
	public WordGenerator(String fileName) throws FileNotFoundException {
		try {
			sc = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e){
			throw new FileNotFoundException();
		}
		wordCount = 0;
		sentenceCount = 0;
	}
	
	/**
	 * hasNext
	 * @return true if sc has more data to read
	 */
	public boolean hasNext() {
		return sc.hasNext();
	}
	
	/**
	 * next
	 * @return returns the next String
	 */
	public String next() {
		wordCount++;
		String ret = sc.next();
		if(ret.endsWith(".") || ret.endsWith("?") || ret.endsWith("!") ) {
			sentenceCount++;
		}
		return ret;
	}
	
	/**
	 * getWordCount
	 * @return wordCount
	 */
	public int getWordCount() {
		return wordCount;
	}
	
	/**
	 * getSentenceCount
	 * @return sentenceCount
	 */
	public int getSentenceCount() {
		return sentenceCount;
	}
	
}
