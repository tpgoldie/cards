package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

import java.util.HashSet;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.SUITS;
import static java.util.stream.Collectors.toSet;

public class StraightFlushRule implements PokerHandRule {

    private final AndRule theRule;

    StraightFlushRule() {

        ConsecutiveCardsRule consecutiveCardsRule = new ConsecutiveCardsRule();

        HashSet<HandRule> children = new HashSet<>();

        children.add(new NCardsSameSuitRule(5));
        children.add(consecutiveCardsRule);


        theRule = new AndRule(children);
    }

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
