package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import com.tpg.puzzles.cards.Value;

import java.util.List;
import java.util.Map;

public final class NCardsSameValueRule implements HandRule, GroupByValue {

    private final int numberOfCards;

    NCardsSameValueRule(int numberOfCards) {

        this.numberOfCards = numberOfCards;
    }

    @Override
    public boolean validate(Hand hand) {

        Map<Value, List<Card>> result = groupByValue(hand);

        return result.values().stream().anyMatch(value -> value.size() == numberOfCards);
    }
}
