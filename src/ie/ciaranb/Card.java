package ie.ciaranb;

/**
 * Creating card types.
 * @author Ciaran Brennan
 *
 */
public class Card {
	
	 
	private Suit mySuit;  //One of the four suits for this card 
	private int myNumber; // the value of each card
	
	public Card(Suit aSuit, int aNumber) {  // asuit = the suit of the card, anumber = number of card
		
		this.mySuit = aSuit;
		
		if(aNumber >= 1 && aNumber <= 13) {
			this.myNumber = aNumber;
		}else {
			System.err.println(aNumber + " is not a valid card no.");
			System.exit(1);
		}
		this.myNumber = aNumber;
	}
	
	public int getNumber() {
		return myNumber;
	}
	
	public String toString(){
		String numStr = "Error"; //outputs error if it takes in an invalid input.
		
		switch(this.myNumber){
		
		case 2:
			numStr = "Two";
			break;
			
		case 3:
			numStr = "Three";
			break;
			
		case 4:
			numStr = "Four";
			break;
			
		case 5:
			numStr = "Five";
			break;
			
		case 6:
			numStr = "Six";
			break;
			
		case 7:
			numStr = "Seven";
			break;
			
		case 8:
			numStr = "Eight";
			break;
			
		case 9:
			numStr = "Nine";
			break;
			
		case 10:
			numStr = "Ten";
			
		case 11:
			numStr = "Jack";
			break;
			
		case 12:
			numStr = "Queen";
			break;
			
		case 13:
			numStr = "King";
			break;
			
		case 1:
			numStr = "Ace";
			break;
			
		}
		return numStr + " of " + mySuit.toString();
	}
	
}
