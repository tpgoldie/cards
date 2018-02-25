package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Value;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.Suit.CLUBS;
import static com.tpg.puzzles.cards.Card.Suit.DIAMONDS;
import static com.tpg.puzzles.cards.Card.Suit.HEARTS;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.PokerHand.pokerHand;
import static com.tpg.puzzles.cards.Value.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StraightTest {

    private StraightRule rule;

    @Before
    public void setUp() {
        rule = new StraightRule();
    }

    @Test
    public void validateOnAllWithSameSuit() {

        List<Value> values = asList(THREE, FOUR, FIVE, SIX, SEVEN);

        Set<Card> cards = values.stream().map(value -> card(value, DIAMONDS)).collect(toSet());

        boolean actual = rule.validate(pokerHand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidateOnNoConsecutiveOfSameSuit() {

        List<Value> values = asList(TWO, THREE, FOUR, FIVE, EIGHT);

        Set<Card> cards = values.stream().map(value -> card(value, DIAMONDS)).collect(toSet());

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }

    @Test
    public void validateOnConsecutiveOfDifferentSuits() {

        List<Value> values = asList(TWO, THREE, FOUR);

        Set<Card> cards1 = values.stream().map(value -> card(value, DIAMONDS)).collect(toSet());

        values = asList(FIVE, SIX);

        Set<Card> cards2 = values.stream().map(value -> card(value, CLUBS)).collect(toSet());

        Set<Card> cards = new HashSet<>();

        cards.addAll(cards1);
        cards.addAll(cards2);

        boolean actual = rule.validate(pokerHand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidateOnNonConsecutiveOfDifferentSuits() {

        List<Value> values = asList(TWO, THREE, FOUR);

        Set<Card> cards1 = values.stream().map(value -> card(value, DIAMONDS)).collect(toSet());

        values = asList(FIVE, SEVEN);

        Set<Card> cards2 = values.stream().map(value -> card(value, CLUBS)).collect(toSet());

        Set<Card> cards = new HashSet<>();

        cards.addAll(cards1);
        cards.addAll(cards2);

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }
}
