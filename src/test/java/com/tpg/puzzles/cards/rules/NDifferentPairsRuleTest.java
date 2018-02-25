package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.Suit.*;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.Value.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NDifferentPairsRuleTest {

    private NDifferentPairsRule rule;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {

        rule = new NDifferentPairsRule(2);
    }

    @Test
    public void invalidConstructionWhenPositiveNLessThanMinimumValue() {

        expectedException.expect(AssertionError.class);

        new NDifferentPairsRule(1);
    }

    @Test
    public void invalidConstructionWhenNEqualsZero() {

        expectedException.expect(AssertionError.class);

        new NDifferentPairsRule(0);
    }

    @Test
    public void invalidConstructionForNegativeN() {

        expectedException.expect(AssertionError.class);

        new NDifferentPairsRule(-1);
    }

    @Test
    public void validateOnContainingNDifferentPairs() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(TWO, DIAMONDS),
                card(FOUR, SPADES),
                card(FOUR, CLUBS),
                card(FIVE, CLUBS)
        ));

        boolean actual = rule.validate(new Hand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidateOnContainingLessThanNDifferentPairs() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(THREE, DIAMONDS),
                card(TWO, DIAMONDS),
                card(FOUR, SPADES)
        ));

        boolean actual = rule.validate(new Hand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnContainingGreaterThanNDifferentPairs() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(THREE, DIAMONDS),
                card(THREE, HEARTS),
                card(TWO, DIAMONDS),
                card(FOUR, SPADES),
                card(FOUR, DIAMONDS)
        ));

        boolean actual = rule.validate(new Hand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnContainingNoPairs() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(THREE, DIAMONDS),
                card(TWO, DIAMONDS),
                card(FOUR, SPADES)
        ));

        boolean actual = rule.validate(new Hand(cards));

        assertFalse(actual);
    }
}
