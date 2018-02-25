package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

import java.util.HashSet;
import java.util.Set;

public final class FullHouseRule implements PokerHandRule, GroupByValue {

    private final AndRule theRule;

    public FullHouseRule() {
        NCardsSameValueRule rule1 = new NCardsSameValueRule(3);
        PairRule rule2 = new PairRule();

        Set<HandRule> rules = new HashSet<>();
        rules.add(rule1);
        rules.add(rule2);

        theRule = new AndRule(rules);
    }

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
