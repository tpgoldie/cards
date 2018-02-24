package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.Suit.DIAMONDS;
import static com.tpg.puzzles.cards.Card.Suit.HEARTS;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.Value.THREE;
import static com.tpg.puzzles.cards.Value.TWO;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NCardsSameSuitRuleTest {

    private NCardsSameSuitRule rule;

    @Before
    public void setUp() {

        rule = new NCardsSameSuitRule(2, HEARTS);
    }

    @Test
    public void validate() {
        Set<Card> cards = new HashSet<>(asList(
            card(THREE, HEARTS),
            card(TWO, HEARTS)
        ));

        boolean actual = rule.validate(new Hand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidate() {
        Set<Card> cards = new HashSet<>(asList(
            card(THREE, HEARTS),
            card(TWO, DIAMONDS)
        ));

        boolean actual = rule.validate(new Hand(cards));

        assertFalse(actual);
    }
}
