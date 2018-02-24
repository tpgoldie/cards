package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import com.tpg.puzzles.cards.Value;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.Suit.DIAMONDS;
import static com.tpg.puzzles.cards.Card.Suit.HEARTS;
import static com.tpg.puzzles.cards.Card.Suit.SPADES;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.Value.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConsecutiveCardsRuleTest {

    private ConsecutiveCardsRule rule;

    @Before
    public void setUp() {
        rule = new ConsecutiveCardsRule();
    }

    @Test
    public void validate() {

        Set<Card> cards = new HashSet<>(asList(
            card(TWO, HEARTS),
            card(THREE, DIAMONDS),
            card(FOUR, SPADES)
        ));

        boolean actual = rule.validate(new Hand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidate() {

        Set<Card> cards = new HashSet<>(asList(
            card(FIVE, HEARTS),
            card(THREE, DIAMONDS),
            card(TWO, SPADES)
        ));

        boolean actual = rule.validate(new Hand(cards));

        assertFalse(actual);
    }

    @Test
    public void invalidateWithDuplicates() {

        Set<Card> cards = new HashSet<>(asList(
            card(THREE, HEARTS),
            card(TWO, DIAMONDS),
            card(THREE, DIAMONDS),
            card(FOUR, SPADES)
        ));

        boolean actual = rule.validate(new Hand(cards));

        assertFalse(actual);
    }
}
