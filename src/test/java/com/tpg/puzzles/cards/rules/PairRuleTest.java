package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
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

public class PairRuleTest {

    private PairRule rule;

    @Before
    public void setUp() {

        rule = new PairRule();
    }

    @Test
    public void validate() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(TWO, DIAMONDS),
                card(FOUR, SPADES),
                card(FIVE, SPADES),
                card(SIX, SPADES)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidate() {

        Set<Card> cards = new HashSet<>(asList(
                card(TWO, HEARTS),
                card(THREE, DIAMONDS),
                card(FOUR, SPADES),
                card(FIVE, SPADES),
                card(SIX, CLUBS)
        ));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }
}
