package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static com.tpg.puzzles.cards.Card.SUITS;
import static com.tpg.puzzles.cards.Card.Suit.DIAMONDS;
import static com.tpg.puzzles.cards.Card.Suit.HEARTS;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.PokerHand.pokerHand;
import static com.tpg.puzzles.cards.Value.*;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreeOfAKindRuleTest {

    private ThreeOfAKindRule rule;

    @Before
    public void setUp() {

        rule = new ThreeOfAKindRule();
    }

    @Test
    public void validate() {

        Set<Card> cards = SUITS.stream().map(suit -> card(TWO, suit)).collect(toSet());

        cards.remove(card(TWO, HEARTS));

        cards.add(card(THREE, HEARTS));
        cards.add(card(FOUR, HEARTS));

        boolean actual = rule.validate(pokerHand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidate() {

        Set<Card> cards = SUITS.stream().map(suit -> card(TWO, suit)).collect(toSet());

        cards.add(card(FOUR, DIAMONDS));

        boolean actual = rule.validate(pokerHand(cards));

        assertFalse(actual);
    }
}
