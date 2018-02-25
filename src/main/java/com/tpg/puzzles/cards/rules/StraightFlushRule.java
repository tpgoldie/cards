package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

import java.util.HashSet;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.SUITS;
import static java.util.stream.Collectors.toSet;

public final class StraightFlushRule implements PokerHandRule {

    private static final int NUMBER_OF_CARDS = 5;

    private final AndRule theRule;

    StraightFlushRule() {

        HashSet<HandRule> children = new HashSet<>();

        children.add(new NCardsSameSuitRule(NUMBER_OF_CARDS));

        children.add(new ConsecutiveCardsRule());


        theRule = new AndRule(children);
    }

    @Override
    public boolean validate(PokerHand hand) {

        return theRule.validate(hand);
    }
}
