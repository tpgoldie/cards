package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Card.Suit;
import com.tpg.puzzles.cards.Hand;
import com.tpg.puzzles.cards.Value;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.tpg.puzzles.cards.Card.Suit.DIAMONDS;
import static com.tpg.puzzles.cards.Card.Suit.HEARTS;
import static com.tpg.puzzles.cards.Card.Suit.SPADES;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.Value.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StraightFlushRuleTest {

    private StraightFlushRule rule;

    @Before
    public void setUp() {

        rule = new StraightFlushRule();
    }

    @Test
    public void validate() {

        List<Value> values = asList(TWO, THREE, FOUR, FIVE, SIX);

        Set<Card> cards = values.stream().map(value -> card(value, HEARTS)).collect(toSet());

        boolean actual = rule.validate(new Hand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidateNotFiveCards() {

        List<Value> values = asList(TWO, THREE, FOUR, FIVE);

        Set<Card> cards = values.stream().map(value -> card(value, HEARTS)).collect(toSet());

        boolean actual = rule.validate(new Hand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateNonConsecutiveNumbers() {

        List<Value> values = asList(TWO, THREE, FIVE, SIX, SEVEN);

        Set<Card> cards = values.stream().map(value -> card(value, HEARTS)).collect(toSet());

        boolean actual = rule.validate(new Hand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateDifferentSuits() {

        List<Value> values = asList(TWO, THREE, FOUR, FIVE);

        Set<Card> cards = values.stream().map(value -> card(value, HEARTS)).collect(toSet());
        cards.add(card(SIX, DIAMONDS));

        boolean actual = rule.validate(new Hand(cards));

        assertFalse(actual);
    }
}
