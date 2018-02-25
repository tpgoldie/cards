package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Value;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.SUITS;
import static com.tpg.puzzles.cards.Card.Suit.DIAMONDS;
import static com.tpg.puzzles.cards.Card.Suit.HEARTS;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.PokerHand.pokerHand;
import static com.tpg.puzzles.cards.Value.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlushTest {

    private FlushRule rule;

    @Before
    public void setUp() {
        rule = new FlushRule();
    }

    @Test
    public void validate() {
        List<Value> values = asList(TWO, THREE, FIVE, SEVEN, EIGHT);

        Set<Card> cards = values.stream().map(value -> card(value, DIAMONDS)).collect(toSet());

        boolean actual = rule.validate(pokerHand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidateOnDifferentNumberOfCardsOfSameSuit() {

        List<Value> values = asList(TWO, THREE, SEVEN, EIGHT);

        Set<Card> cards = values.stream().map(value -> card(value, DIAMONDS)).collect(toSet());

        cards.add(card(THREE, HEARTS));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }
}
