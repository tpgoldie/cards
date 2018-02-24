package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import com.tpg.puzzles.cards.Value;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class NCardsSameValueRule implements PokerRule {

    private final int numberOfCards;
    private final Value value;

    public NCardsSameValueRule(int numberOfCards, Value value) {

        this.numberOfCards = numberOfCards;
        this.value = value;
    }

    @Override
    public boolean validate(Hand hand) {

        return equalNumberOfCards(hand) && hasSameValue(hand);
    }

    private boolean hasSameValue(Hand hand) {
        return hand.getCards().stream().collect(groupingBy(Card::getValue)).size() == 1;
    }

    private boolean equalNumberOfCards(Hand hand) {
        return hand.getCards().size() == numberOfCards;
    }
}
