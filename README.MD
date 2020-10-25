## Black Jack Game Automator Implementation ##

<p>This implementation provided a simplified version of the Black Jack Game. </p>
<p>The BlackJackGameAutomator can generate a game stimulation with the user input player numbers.</p>
<p>The automator stimulates the most simple situation that all player plays 
following the rule that they keep asking for card until win or busted no matter what 
they hand cards are. And each of the player only have one hand in the game so 
they are simplified to a BlackJackHand class. </p>


<p>This implementation includes the following classes:  
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
    </li></p>
    
<p> The tests are designed for FaceValue, Card, BlackJackHand, Deck, and BlackJackAutomator:
<li> Test for FaceValue is checking whether the possible values are all included 
in the enum.
<li> Test for Card checked the constructor and the toString method in the card.
<li> Test for BlackJackHand checked the addCards, size, print, score, busted
 and isBlackJack methods, with the input one hand with cards A and Q, 
 and another hand with cards K, Q, and 2. The first one will be backjack with score 21.
 The second one will be busted with score 22.
<li> Test for Deck tested the shuffle, dealHand, dealCard and reset sequentially . 
</li> Test for BlackJackAutomator generate black jack game with random input gamer count
and need to check the result manually.