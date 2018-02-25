package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import com.tpg.puzzles.cards.Value;

import java.util.List;
import java.util.Map;

public class NCardsSameValueRule extends PokerRule {

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

        Map<Value, List<Card>> result = groupByValue(hand);

        return result.size() == 1 && result.containsKey(value);
    }

    private boolean equalNumberOfCards(Hand hand) {
        return hand.getCards().size() == numberOfCards;
    }
}
