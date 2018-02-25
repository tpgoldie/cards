package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Hand;

import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public class OrRule implements HandRule {

    private final Set<HandRule> rules;

    public OrRule(Set<HandRule> rules) {

        this.rules = unmodifiableSet(rules);
    }

    @Override
    public boolean validate(Hand hand) {

        return rules.stream().anyMatch(rule -> rule.validate(hand));
    }
}
