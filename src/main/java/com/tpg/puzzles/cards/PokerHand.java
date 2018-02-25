package com.tpg.puzzles.cards;

import lombok.ToString;

import java.util.Set;

@ToString
public class PokerHand extends Hand {

    private static final int HAND_SIZE = 5;

    public static PokerHand pokerHand(Set<Card> cards) {

        assert cards.size() == HAND_SIZE;

        return new PokerHand(cards);
    }

    private PokerHand(Set<Card> cards) {

        super(cards);
    }
}
