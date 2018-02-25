package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

public final class FlushRule implements PokerHandRule {

    private static final int NUMBER_OF_CARDS = 5;

    private final NCardsSameSuitRule theRule = new NCardsSameSuitRule(NUMBER_OF_CARDS);

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
