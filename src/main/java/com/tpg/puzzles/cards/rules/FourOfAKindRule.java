package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

public final class FourOfAKindRule implements PokerHandRule {

    private static final int NUMBER_OF_CARDS = 4;

    private final HandRule theRule = new NCardsSameValueRule(NUMBER_OF_CARDS);

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
