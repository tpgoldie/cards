package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

public class PairRule implements PokerHandRule {

    private static final int NUMBER_OF_PAIRS = 1;

    private final NDifferentPairsRule theRule = new NDifferentPairsRule(NUMBER_OF_PAIRS);

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
