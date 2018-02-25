package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import com.tpg.puzzles.cards.Value;

import java.util.List;
import java.util.Map;

public final class NDifferentPairsRule implements HandRule, GroupByValue {

    private static final int MINIMUM_NUMBER = 1;

    private final int numberOfDifferentPairs;

    NDifferentPairsRule(int numberOfDifferentPairs) {

        assert numberOfDifferentPairs >= MINIMUM_NUMBER;

        this.numberOfDifferentPairs = numberOfDifferentPairs;
    }

    @Override
    public boolean validate(Hand hand) {

        Map<Value, List<Card>> actual = groupByValue(hand);

        long result = actual.values().stream().filter(value -> value.size() == 2).count();

        return result == numberOfDifferentPairs;
    }
}
