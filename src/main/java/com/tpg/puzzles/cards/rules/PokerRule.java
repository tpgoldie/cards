package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import com.tpg.puzzles.cards.Value;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public abstract class PokerRule implements HandRule {

    protected Map<Value, List<Card>> groupByValue(Hand hand) {

        return hand.getCards().stream().collect(groupingBy(Card::getValue));
    }
}
