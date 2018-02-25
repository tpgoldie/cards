package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

public final class StraightRule implements PokerHandRule {

    private final ConsecutiveCardsRule theRule = new ConsecutiveCardsRule();

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
