package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import com.tpg.puzzles.cards.Value;

import java.util.List;
import java.util.Map;

public class PairRule extends PokerRule {

    @Override
    public boolean validate(Hand hand) {

        Map<Value, List<Card>> actual = groupByValue(hand);

        return actual.values().stream().anyMatch(this::isPair);
    }

    private boolean isPair(List<Card> cards) {
        return cards.size() == 2;
    }
}
