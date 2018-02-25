package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Card.Suit;
import com.tpg.puzzles.cards.Hand;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public final class NCardsSameSuitRule implements HandRule {

    private final int numberOfCards;

    NCardsSameSuitRule(int numberOfCards) {

        this.numberOfCards = numberOfCards;
    }

    public boolean validate(Hand hand) {

        Map<Suit, List<Card>> result = hand.getCards().stream().collect(groupingBy(Card::getSuit));

        return result.values().stream().anyMatch(value -> value.size() == numberOfCards);
    }
}
