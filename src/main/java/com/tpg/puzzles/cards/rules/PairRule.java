package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import com.tpg.puzzles.cards.Value;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class PairRule implements PokerRule {

    @Override
    public boolean validate(Hand hand) {

        Map<Value, List<Card>> actual = hand.getCards().stream().collect(groupingBy(Card::getValue));
        return actual.values().stream().filter(this::isPair).findFirst().isPresent();
    }

    private boolean isPair(List<Card> cards) {
        return cards.size() == 2;
    }
}
