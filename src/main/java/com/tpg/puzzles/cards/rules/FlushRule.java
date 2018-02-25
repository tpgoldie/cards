package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

public class FlushRule implements PokerHandRule {

    private final NCardsSameSuitRule theRule = new NCardsSameSuitRule(5);

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
