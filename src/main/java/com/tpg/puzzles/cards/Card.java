package com.tpg.puzzles.cards;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.EnumSet;

@Getter
@EqualsAndHashCode
public final class Card implements Comparable<Card> {

    public static Card card(Value value, Suit suit) {

        return new Card(value, suit);
    }

    @Override
    public int compareTo(Card that) {

        return this.getValue().compareTo(that.getValue());
    }

    public enum Suit {
        HEARTS, CLUBS, DIAMONDS, SPADES
    }

    public static final EnumSet<Suit> SUITS = EnumSet.allOf(Suit.class);

    private final Suit suit;
    private final Value value;

    private Card(Value value, Suit suit) {

        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%d of %s", value.getValue(), suit.name());
    }
}
