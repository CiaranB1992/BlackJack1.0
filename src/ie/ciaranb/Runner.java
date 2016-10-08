package ie.ciaranb;

import java.util.Scanner;
public class Runner {
	
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck(1, true);
		
		//init the player objects
		Player me = new Player("Ciarans");
		Player dealer = new Player("Dealer");
		
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		//print the initial hands
		System.out.println("Cards are dealt\n");
		System.out.println("\n");
		me.printHand(true);
		System.out.println("\n");
		dealer.printHand(false);
		System.out.println("\n");
		
		// flags when each player finishes hitting
		boolean meDone = false;
		boolean dealerDone = false;
		String ans;
		
		while(!meDone || !dealerDone){
		
			//player's turn
			if(!meDone){
				System.out.print("\nHit or Stay? (Enter H or S): ");
				ans = sc.next();
				System.out.println();
				
				//if the player hits
				if(ans.compareToIgnoreCase("H") == 0){
					
					//add next card in deck and store if busted
					System.out.println();
					meDone = !me.addCard(theDeck.dealNextCard()); 
					me.printHand(true);
							
				}else {
					meDone = true;
				}
				//dealers turn
				if(!dealerDone){
					if (dealer.getHandSum() < 17){
						System.out.println();
						System.out.println("\nThe dealer Hits\n");
						dealerDone = !dealer.addCard(theDeck.dealNextCard());
						dealer.printHand(false);
					}else {
						System.out.println();
						System.out.println("\nThe dealer stays\n");
						dealerDone = true;
					}
				}
				System.out.println();
			}
			
			//close scanner
			sc.close();
			
			//print final hands
			System.out.println("\n");
			me.printHand(true);
			System.out.println("\n");
			dealer.printHand(true);
			
			int mySum = me.getHandSum();
			int dealerSum = dealer.getHandSum();
			
			if (mySum > dealerSum && mySum <= 21 || dealerSum > 21){
				System.out.println("\nYou win!");
			} else { 
			System.out.println("\nDealer wins!");
			}
		}
	
	}

}
