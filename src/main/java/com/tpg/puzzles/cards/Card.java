package com.tpg.puzzles.cards;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class Card {

    public static Card card(Value value, Suit suit) {

        return new Card(value, suit);
    }

    public enum Suit {
        HEARTS, CLUBS, DIAMONDS, SPADES
    }

    private final Suit suit;
    private final Value value;

    private Card(Value value, Suit suit) {

        this.suit = suit;
        this.value = value;
    }
}
