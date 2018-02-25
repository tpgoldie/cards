package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

public class FourOfAKindRule implements PokerHandRule {

    private final HandRule theRule = new NCardsSameValueRule(4);

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
