package ie.ciaranb;

/**
 * Blackjack player class
 * @author Ciaran
 *
 */
public class Player {
	
	private String name;
	private int maxNumCards = 10;
	/**
	 *  The cards in the player's current hand.
	 */
	private Card[] hand = new Card[10];		
	/**
	 * Number of cards in players hand.
	 */
	
	private int numCards;
	/**
	 * Player Constructor
	 * 
	 * @param aName name of player
	 */
	public Player(String aName){
		
		this.name = aName;
				
		//set a player's hand to empty
		this.emptyHand();
		}
		
		/**
		 * Reset the player's hand to have no cards
		 */
		 public void emptyHand() {
			 for(int c = 0; c < 10; c++){
				 this.hand[c] = null;
			 }
			 this.numCards = 0;
		 }

		 /**
		  * add card to hand
		  * @param aCard = card to add
		  * @return if sum of new hand <= 21
		  */
		 public boolean addCard(Card aCard){
			 //print error if we already have max cards
			 if(this.numCards == maxNumCards){
				 System.err.printf("%s's hand already has " + maxNumCards + " cards: " + "cannot add another", this.name);
				 System.exit(1);
			 }
			 
			 //add new card in next slot and increment number of cards counter
			 this.hand[this.numCards] = aCard;
			 this.numCards++;
			 
			 return(this.getHandSum() <= 21);
		 }
		 
		 /**
		  * Get sum of cards in hnd
		  * @return total
		  */
		 public int getHandSum(){
			 int handSum = 0;
			 int cardNum;
			 int numAces = 0;
			 
			 //calculate each card's value to hand sum
			 for (int c = 0; c < this.numCards; c++){
				 
				 //get num for current card
				 cardNum = this.hand[c].getNumber();
				 
				 if (cardNum == 1){
					 numAces++;
					 handSum += 11;
				 } else if (cardNum > 10){
					 handSum += 10;
				 } else {
					 handSum += cardNum;
				 }
			 }
			 
			 // if we have an ace and our sum is > 21, set some/all aces to 1
			 
			 while (handSum > 21 && numAces > 0){
				 handSum -= 10;
				 numAces--;
			 }
			 
			 return handSum;
		 }
		 
		 /**
		  * Print the cards in the player's hand.
		  * 
		  * @param showFirstCard whether the first card is hidden or not.
		  */
		 public void printHand(boolean showFirstCard){
			 
			 System.out.printf("%s's cards:\n", this.name);
			 for(int c = 0; c < this.numCards; c++){
				 if (c == 0 && !showFirstCard){
					 System.out.println("   [hidden]");
				 } else {
					 System.out.printf("   %s", this.hand[c].toString());
				 }
			 }
			 
		 }
}

