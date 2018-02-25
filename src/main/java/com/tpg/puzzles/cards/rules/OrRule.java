package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Hand;

import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public class OrRule implements PokerRule {

    private final Set<PokerRule> rules;

    public OrRule(Set<PokerRule> rules) {

        this.rules = unmodifiableSet(rules);
    }

    @Override
    public boolean validate(Hand hand) {

        return rules.stream().anyMatch(rule -> rule.validate(hand));
    }
}
