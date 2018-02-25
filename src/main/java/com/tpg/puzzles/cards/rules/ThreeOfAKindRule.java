package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

public final class ThreeOfAKindRule implements PokerHandRule {

    private static final int NUMBER_OF_CARDS = 3;

    private NCardsSameValueRule theRule = new NCardsSameValueRule(NUMBER_OF_CARDS);

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
