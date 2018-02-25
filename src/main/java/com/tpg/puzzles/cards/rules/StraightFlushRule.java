package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Card.Suit;
import com.tpg.puzzles.cards.Hand;
import lombok.val;

import java.util.HashSet;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.SUITS;
import static com.tpg.puzzles.cards.Card.Suit.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;

public class StraightFlushRule implements PokerRule {

    private final AndRule theRule;

    StraightFlushRule() {

        ConsecutiveCardsRule consecutiveCardsRule = new ConsecutiveCardsRule();

        Set<PokerRule> suitRules = SUITS.stream().map(suit -> new NCardsSameSuitRule(5, suit))
                .collect(toSet());

        OrRule orRule = new OrRule(suitRules);

        HashSet<PokerRule> children = new HashSet<>();

        children.add(orRule);
        children.add(consecutiveCardsRule);


        theRule = new AndRule(children);
    }

    @Override
    public boolean validate(Hand hand) {

        return theRule.validate(hand);
    }
}
