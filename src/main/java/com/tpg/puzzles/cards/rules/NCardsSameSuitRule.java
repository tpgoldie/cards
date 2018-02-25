package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Card.Suit;
import com.tpg.puzzles.cards.Hand;

import static java.util.stream.Collectors.groupingBy;

public class NCardsSameSuitRule implements HandRule {

    private final int numberOfCards;
    private final Suit suit;

    NCardsSameSuitRule(int numberOfCards, Suit suit) {

        this.numberOfCards = numberOfCards;
        this.suit = suit;
    }

    public boolean validate(Hand hand) {

        return equalNumberOfCards(hand) && sameSuit(hand);
    }

    private boolean equalNumberOfCards(Hand hand) {
        return hand.getCards().size() == numberOfCards;
    }

    private boolean sameSuit(Hand hand) {
        return hand.getCards().stream().collect(groupingBy(Card::getSuit)).size() == 1;
    }
}
