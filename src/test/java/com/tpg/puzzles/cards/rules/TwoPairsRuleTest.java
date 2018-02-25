package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.Suit.CLUBS;
import static com.tpg.puzzles.cards.Card.Suit.HEARTS;
import static com.tpg.puzzles.cards.Card.Suit.SPADES;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.PokerHand.pokerHand;
import static com.tpg.puzzles.cards.Value.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TwoPairsRuleTest {

    private Set<Card> cards;

    private TwoPairsRule rule;

    @Before
    public void setUp() {
        cards = new HashSet<>();

        rule = new TwoPairsRule();
    }

    @Test
    public void validate() {

        cards.add(card(THREE, HEARTS));
        cards.add(card(THREE, CLUBS));
        cards.add(card(FOUR, HEARTS));
        cards.add(card(FOUR, SPADES));
        cards.add(card(FIVE, SPADES));

        boolean actual = rule.validate(pokerHand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidate() {

        cards.add(card(THREE, HEARTS));
        cards.add(card(SEVEN, CLUBS));
        cards.add(card(FOUR, HEARTS));
        cards.add(card(FOUR, SPADES));
        cards.add(card(FIVE, SPADES));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }
}
