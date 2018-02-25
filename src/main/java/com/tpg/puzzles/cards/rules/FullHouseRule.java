package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

import java.util.HashSet;
import java.util.Set;

public final class FullHouseRule implements PokerHandRule, GroupByValue {

    private static final int NUMBER_OF_CARDS = 3;

    private final AndRule theRule;

    public FullHouseRule() {

        Set<HandRule> rules = new HashSet<>();

        rules.add(new NCardsSameValueRule(NUMBER_OF_CARDS));
        rules.add(new PairRule());

        theRule = new AndRule(rules);
    }

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
