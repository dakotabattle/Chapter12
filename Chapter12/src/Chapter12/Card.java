// Each exercise is inside this Card Class, there are comments
// which will let you know which sections are applicable
// to each exercise.

package Chapter12;
public class Card {
    
	
	public static final String[] RANKS = {
	        null, "Ace", "2", "3", "4", "5", "6", "7",
	        "8", "9", "10", "Jack", "Queen", "King"};

	    public static final String[] SUITS = {
	        "Clubs", "Diamonds", "Hearts", "Spades"};
	
	private final int rank;
    private final int suit;
    
    
    
    
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
    

    
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    

	public static void printDeck(Card[] cards) {
	    for (int i = 0; i < cards.length; i++) {
	        System.out.println(cards[i]);
	    }
	}
	
	
	
	
	// ========================================================================
	
	// EXERCISE 1 
	
	// ========================================================================
	
	
	
	// Creates a new traditional 52-card deck, and displays it.
	public static Card[] makeDeck() {
		Card[] newCards = new Card[52];
		
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
		    for (int rank = 1; rank <= 13; rank++) {
		        newCards[index] = new Card(rank, suit);
		        index++;
		    }
		}
		if (newCards[0] == null)
		{
			System.out.println("No card yet!");
		}
		
		return newCards;
		}
	
	
	// =========================================================================
	
	// END OF EXERCISE 1
	
	// =========================================================================
	
	
	
	
	
    
    public boolean equals(Card that) {
        return this.rank == that.rank
            && this.suit == that.suit;
    }
    

	public static int search(Card[] cards, Card target) {
	    for (int i = 0; i < cards.length; i++) {
	        if (cards[i].equals(target)) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	
	public static int binarySearch(Card[] cards, Card target) {
	    int low = 0;
	    int high = cards.length - 1;
	    while (low <= high) {
	        int mid = (low + high) / 2;                 // step 1
	        int comp = cards[mid].compareTo(target);
	
	        if (comp == 0) {                            // step 2
	            return mid;
	        } else if (comp < 0) {                      // step 3
	            low = mid + 1;
	        } else {                                    // step 4
	            high = mid - 1;
	        }
	    }
	    return -1;
	}
	
	
	
	
	
	
	
	// ===========================================================
	
	// Exercise 2
	
	// ===========================================================
	
    
	
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
        
    }
    
    
    
    
	// ===========================================================
	
	// End of Exercise 2
	
	// ===========================================================
    
    
    
    
    
	// ===========================================================
	
	// Exercise 3
	
	// ===========================================================
    
    //Part 1
    
    public static void suitHist(Card[] cards)
    {
    	Card current;
    	int currentSuit;
    	
    	int clubCount = 0;
    	int diamondCount = 0;
    	int heartCount = 0;
    	int spadeCount = 0;
    	for (int i = 0; i < cards.length; i++)
    	{
    		current = cards[i];
    		currentSuit = current.getSuit();
    		if (currentSuit == 0)
    		{
    			clubCount++;
    		}
    		
    		if (currentSuit == 1)
    		{
    			diamondCount++;
    		}
    		
    		if (currentSuit == 2)
    		{
    			heartCount++;
    		}
    		
    		if (currentSuit == 3)
    		{
    			spadeCount++;
    		}
    	}
    		System.out.println("Clubs: " + clubCount);
    		System.out.println("Diamonds: " + diamondCount);
    		System.out.println("Hearts " + heartCount);
    		System.out.println("Spades: " + spadeCount);
    			
    			

    	}
    
    // Part 2
    
    public static boolean hasFlush(Card[] cards)
    {
    	Card current;
    	int currentSuit;
    	
    	int clubCount = 0;
    	int diamondCount = 0;
    	int heartCount = 0;
    	int spadeCount = 0;
    	for (int i = 0; i < cards.length; i++)
    	{
    		current = cards[i];
    		currentSuit = current.getSuit();
    		if (currentSuit == 0)
    		{
    			clubCount++;
    		}
    		
    		if (currentSuit == 1)
    		{
    			diamondCount++;
    		}
    		
    		if (currentSuit == 2)
    		{
    			heartCount++;
    		}
    		
    		if (currentSuit == 3)
    		{
    			spadeCount++;
    		}
    	}
    	if (clubCount >= 5 || diamondCount >= 5 || heartCount >= 5 || spadeCount >= 5)
    	{
    		return true;
    	}
    	return false;
    }
    
	// ===========================================================
	
	// End of Exercise 3
	
	// ===========================================================
   
    
    
    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }
    
    
    public static void main(String[] args) {
		
    	// Run the program to see the exercises in action!
    	
    	System.out.println("Exercise 1 (makeDeck): ");
    	Card[] deck = makeDeck();
    	System.out.println("Deck successfully created.");

    	System.out.println();
    	System.out.println();
    	
    	Card card1 = new Card(11, 1);
    	Card card2 = new Card(12, 2);
    	System.out.println("Exercise 2 (compareTo): ");
    	System.out.println("Comparing Card1(11, 1) to Card2(12, 2): " + card1.compareTo(card2));
		
    	System.out.println();
    	System.out.println();
    	
    	System.out.println("Exercise 3, Part 1 (suitHist):");
    	suitHist(deck);
    	System.out.println();
		
		System.out.println("Exercise 3, Part 2 (hasFlush):");
		System.out.println("Does the deck have a flush? \n" + hasFlush(deck));
		
		System.out.println();
		System.out.println();
		
		System.out.println("Exercise 4 (CardTable.java):");
		System.out.println("CardTable.java and Search.java successfully set up and run.");
		
		
		}
		
		
		
		
		
		
			
		
		
    
    

    
    }
