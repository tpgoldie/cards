package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.Suit.*;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.PokerHand.pokerHand;
import static com.tpg.puzzles.cards.Value.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HighCardRuleTest {

    private HighCardRule rule;

    @Before
    public void setUp() {

        rule = new HighCardRule();
    }

    @Test
    public void validate() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(SEVEN, DIAMONDS),
                card(FOUR, SPADES),
                card(FIVE, CLUBS),
                card(SIX, SPADES)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidateOnSinglePair() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(TWO, DIAMONDS),
                card(FOUR, SPADES),
                card(FIVE, SPADES),
                card(SIX, CLUBS)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnTwoPairs() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(TWO, DIAMONDS),
                card(FOUR, SPADES),
                card(FIVE, SPADES),
                card(FIVE, CLUBS)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnThreeOfAKind() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(TWO, DIAMONDS),
                card(TWO, SPADES),
                card(FOUR, SPADES),
                card(FIVE, CLUBS)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnStraight() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(THREE, DIAMONDS),
                card(FOUR, SPADES),
                card(FIVE, CLUBS),
                card(SIX, SPADES)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnFlush() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(THREE, HEARTS),
                card(FOUR, HEARTS),
                card(FIVE, HEARTS),
                card(SEVEN, HEARTS)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnFullHouse() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(TWO, DIAMONDS),
                card(TWO, CLUBS),
                card(FIVE, HEARTS),
                card(FIVE, DIAMONDS)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnFourOfAKind() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(TWO, DIAMONDS),
                card(TWO, CLUBS),
                card(TWO, SPADES),
                card(FIVE, DIAMONDS)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnStraightFlush() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, DIAMONDS),
                card(THREE, DIAMONDS),
                card(FOUR, DIAMONDS),
                card(SIX, DIAMONDS),
                card(FIVE, DIAMONDS)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }
}
