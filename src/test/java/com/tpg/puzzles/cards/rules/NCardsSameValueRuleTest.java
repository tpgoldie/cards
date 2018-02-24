package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Card.Suit;
import com.tpg.puzzles.cards.Hand;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.Suit.*;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.Value.FIVE;
import static com.tpg.puzzles.cards.Value.TWO;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NCardsSameValueRuleTest {

    private NCardsSameValueRule rule;

    @Before
    public void setUp() {

        rule = new NCardsSameValueRule(3, FIVE);
    }

    @Test
    public void validate() {

        List<Suit> suits = asList(DIAMONDS, HEARTS, CLUBS);

        Set<Card> cards  = suits.stream().map(suit -> card(FIVE, suit)).collect(toSet());

        boolean actual = rule.validate(new Hand(cards));

        assertTrue(actual);
    }

    @Test
    public void invalidateOnDifferentNumberOfCards() {

        List<Suit> suits = asList(DIAMONDS, CLUBS);

        List<Card> cards  = suits.stream().map(suit -> card(FIVE, suit)).collect(toList());

        boolean actual = rule.validate(new Hand(new HashSet<>(cards)));

        assertFalse(actual);
    }

    @Test
    public void invalidateOnDifferentValues() {

        List<Card> cards  = asList(card(TWO, HEARTS), card(FIVE, DIAMONDS), card(FIVE, CLUBS));

        boolean actual = rule.validate(new Hand(new HashSet<>(cards)));

        assertFalse(actual);
    }
}
