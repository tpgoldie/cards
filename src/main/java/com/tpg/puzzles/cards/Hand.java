package com.tpg.puzzles.cards;

import lombok.Getter;

import java.util.Optional;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

@Getter
public class Hand {

    private final Set<Card> cards;

    public Hand(Set<Card> cards) {

        this.cards = unmodifiableSet(cards);
    }

    public Optional<Card> rank() {

        return cards.stream().max(Card::compareTo);
    }
}
