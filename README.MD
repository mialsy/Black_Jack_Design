## Black Jack Automator Implementation ##

<p>This implementation provided a simplified version of the Black Jack Game. </p>

<p>This implementation includes the following classes:  </p>
<li>Card - stimulate the poke card without 4 suits and 13 face values for each suit
    <p> has fields:
    <li> FaceValue
    <li> Suit
    </li></p>
<li>Enum FaceValue - stimulate the face value of the card
    <p> Range: ACE，C2，C3，C4，C5， C6， C7，C8，C9，C10，JACK，QUEEN，KING 
    </p> 
<li>Enum Suit - stimulate the suit on the card
    <p> Range: CLUB, DIAMOND, SPADE, HEART
    </p> 
<li>BlackJackGameAutomator - stimulate the black jack game
    <p> has fields:
    <li> Deck </li>
    <li> List of BlackJackHands</li>
    </p> 
    <p> has methods:
    <li>initDeck
    <li>initDeal
    <li>getBlackJacks
    <li>playHand
    <li>playAllHands
    <li>getWinners
    <li>display
    <li>startGame
    </p> 
<li>BlackJackHand - stimulate the black jack hand
    <p> has methods: 
    <li>score
    <li>possibleScores
    <li>updareScores
    <li>getScores
    <li>busted
    <li>isBlackJack
    <li>isFaceCard</li>
    </p>
<li>Hand - the abstract hand class
    <p> has fields:
    <li> List of Cards</li>
    </p>
    <p> has methods:  
    <li>score
    <li>addCards
    <li>size 
    <li>print
    </p>
<li> Deck - stimulate the deck
    <p> has fields:
    <li> List of Cards
    <li> dealtIndex - indicate the card that has been dealt </li>
    </p>
    <p> has methods:
    <li>Deck
    <li>shuffle
    <li>remainCards
    <li>dealHand
    <li>dealCard
    <li>reset
    <li>toString
    </p>

<p> The tests are designed for FaceValue, Card, Deck, and BlackJackAutomator:
<li> Test for FaceValue is checking whether the possible values are all included 
in the enum.
<li>Test for Card checked the constructor and the toString method in the card
<li> Test for Deck 
</li> 
</p>