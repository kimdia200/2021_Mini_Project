package vo;

import java.io.Serializable;
import java.util.Objects;

public class Eng implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String word;
	private String meaning;
	private String sentence;
	
	
	public Eng() {
		super();
	}

	public Eng(String word, String meaning, String sentence) {
		super();
		this.word = word;
		this.meaning = meaning;
		this.sentence = sentence;
	}
	
	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public String getMeaning() {
		return meaning;
	}


	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}


	public String getSentence() {
		return sentence;
	}


	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	@Override
	public String toString() {
		return "Eng [word=" + word + ", meaning=" + meaning + ", sentence=" + sentence + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Eng))
			return false;
		if(this.word.equals(((Eng)obj).getWord()))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
}