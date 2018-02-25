package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Hand;

import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public class AndRule implements PokerRule {

    private final Set<PokerRule> rules;

    public AndRule(Set<PokerRule> rules) {

        this.rules = unmodifiableSet(rules);
    }

    @Override
    public boolean validate(Hand hand) {

        return rules.stream().allMatch(rule -> rule.validate(hand));
    }
}
