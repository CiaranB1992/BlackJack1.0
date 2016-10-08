package ie.ciaranb;


import java.util.Random;
/**
 * Creating the deck of cards.
 * @author Ciaran
 *
 */
public class Deck {
	private Card[] myCards; // array of cards in dek, top card = first index.
	private int numCards; // num of cards left in deck
	
	//no arguments constructor
	public Deck(){
		//call the other constructor, define deck without shuffle
		this(1, false);
	}
	
	public Deck(int numDecks, boolean shuffle){ //constructor defines the number of decks used in this blackjack
		this.numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		//init index for card counter.
		int c = 0;
		
		//for each deck
		for(int d = 0; d < numDecks; d++) {
			//for each suit
			for(int s = 0; s < 4; s++) {
				//for each number
				for (int n = 1; n <= 13; n++) {
					
					//adding new cards to deck
					this.myCards[c] = new Card(Suit.values()[s], n);
					c++;
				}
			}
		}
		
		if(shuffle){//shuffle if true
			this.shuffle();
		}
	}
	public void shuffle(){

		
		//Shuffle deck by randomly swapping pairs of cards in array
		//init rng
		Random rng = new Random();
		
		//temp card
		Card temp;
		
		int j;
		for(int i = 0; i < this.numCards; i++){
			//get a random card j to swap i's value with
			j = rng.nextInt(this.numCards);
			
			//swap function
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
			//storing value of i in temp before swapping with j
			
		}
			
	}
	/**
	 * Deal the next card from the top of the deck.
	 * @return the dealt card
	 */
	public Card dealNextCard(){
		//get top card
		Card top =  this.myCards[0];
		
		//shift all the subsequent cards to the left by one index
		for(int c = 1; c < this.numCards; c++){
			this.myCards[c-1] = this.myCards[c];
		}
		this.myCards[this.numCards-1] = null;
		
		//decrement number of cards in our deck when cards are drawn
		this.numCards--;
		
		return top;
		
	}
	/**
	 * print the top cards
	 * 
	 * @param numToPrint the number of cards from the top of the deck to print
	 * 
	 */
	public void printDeck(int numToPrint){
		
		for(int c = 0; c < numToPrint; c++){
				
			System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());
			
		}
		System.out.println();
		System.out.printf("\t[%d others]\n", this.numCards-numToPrint);
	}
}
