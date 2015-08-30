public class DeckOfCards {

  public static final int numOfCards = 52;

  private Card[] deckOfCards;            //contains all 52 cards
  private int currentCard;               //deal this card in deck

  public DeckOfCards() {
    deckOfCards = new Card[numOfCards];
    int i = 0;
    for (int suit = Card.SPADE; suit <= Card.CLUB; suit++) {
      for (int rank = 1; rank <= 13; rank++) {
        deckOfCards[i++] = new Card(suit, rank);
      }
    }
    currentCard = 0;
  }

  //shuffle(n): shuffle the deck
  public void shuffle(int n) {
    int i, j, k;
    for (k = 0; k < n; k++) {
      i = (int)(numOfCards * Math.random());    //pick 2 random cards in the deck
      j = (int)(numOfCards * Math.random());  

      /* swap these randomly picked cards */
      Card tmp = deckOfCards[i];
      deckOfCards[i] = deckOfCards[j];
      deckOfCards[j] = tmp;
    }
    currentCard = 0;     //reset current card to deal
  }
  
  public Card deal() {
    if (currentCard < numOfCards) {
      return deckOfCards[currentCard++];
    }else {
      System.out.println("out of cards error");
      return null;
    }
  }
  
  public String toString() {
    String s = "";
    int k = 0;
    for (int i =0 ; i< 4; i++) {
      for (int j = 1; j <=13; j++) {
        s += deckOfCards[k++] + " ";
      }
      s += "\n";
    }
    return s;
  }
}//end class DeckofCards




class Card {
  public final static int SPADE   = 0;     //codes for the 4 suits, plus joker.
  public final static int HEART   = 1;
  public final static int DIAMOND = 2;
  public final static int CLUB    = 3;
  public final static int JOKER   = 4;

  public final static int ACE   = 1;
  public final static int JACK  = 11;
  public final static int QUEEN = 12;
  public final static int KING  = 13;

  //then we define this card's suit
  private final int suit;
  //then we define this card's value
  private final int value;

  //a constructor to create a Joker, with 1 as its value.
  public Card() {
    suit = JOKER;
    value = 1;
  }

  //a constructor to create a card with a specified suit and value.
  public Card(int suit, int value) {
    if (suit != Card.SPADE && suit != Card.HEART && suit != Card.DIAMOND && suit != Card.CLUB && suit != Card.JOKER)
      throw new IllegalArgumentException("Illegal playing card suit");
    if (suit != JOKER && (value < 1 || value > 13))
      throw new IllegalArgumentException("Illegal playing card value.");
    this.suit = suit;
    this.value = value;
  }

  /*
   * returns the suit of this card.
   * returns the suit, which is one of the constans Card.SPADE, Card.HEART, Card.DIAMOND, Card.JOKER
   */
  public int getSuit() {
    return this.suit;
  }

  /*
   * returns the value of this card.
   */
  public int getValue() {
    return this.value;
  }


  /*
   * returns a string representation of the card's suit.
   */
 
  public String getSuitAsString() {
    switch(suit) {
      case Card.SPADE:  return "Spades";
      case Card.HEART:  return "Hearts";
      case Card.DIAMOND:  return "Diamonds";
      case Card.CLUB:     return "Clubs";
      default:            return "JOKER";
    }
  }

  /*
   * returns a string representation of the card's value 
   * return for a regular card, one of the strings "Ace", "2", ...."Jack", "Queen", or "king".
   */

  public String getValueAsString() {
    if (suit == JOKER)
        return ""+value;
    else {
      switch(value) {
        case 1:  return "Ace";
        case 2:  return "2";
        case 3:  return "3";
        case 4:  return "4";
        case 5:  return "5";
        case 6:  return "6";
        case 7:  return "7";
        case 8:  return "8";
        case 9:  return "9";
        case 10: return "10";
        case 11: return "Jack";
        case 12: return "Queen";
        default: return "King";
      }
    }
  }

  /*
   * returns a string representation of this card, including both its suit and its value (except that for a joker with value 1,
   * and returns value is just "joker". sample return valus are: "Queen of Hearts", "10 of Diamonds", "Ace of Spades", "Joker", "Joker #2"
   */
  public String toString() {
    if (suit == JOKER) {
      if (value == 1) {
        return "joker";
      }else {
        return "joker #" + value;
      }
    }else {
      return getValueAsString() + " of " + getSuitAsString();
    }
  }

}//end class Card
