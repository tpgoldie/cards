package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.PokerHand;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

import static com.tpg.puzzles.cards.Card.Suit.*;
import static com.tpg.puzzles.cards.Card.card;
import static com.tpg.puzzles.cards.PokerHand.pokerHand;
import static com.tpg.puzzles.cards.Value.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class PokerHandTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void invalidConstructionOnEmptySetOfCards() {

        expectedException.expect(AssertionError.class);

        pokerHand(new HashSet<>());
    }

    @Test
    public void invalidConstructionOnNumberOfCardsLessThanFive() {

        expectedException.expect(AssertionError.class);

        Set<Card> cards = new HashSet<>(asList(
                card(THREE, HEARTS),
                card(FOUR, HEARTS),
                card(THREE, CLUBS),
                card(TWO, HEARTS)
        ));

        pokerHand(new HashSet<>(cards));
    }

    @Test
    public void invalidConstructionOnNumberOfCardsGreaterThanFive() {

        expectedException.expect(AssertionError.class);

        Set<Card> cards = new HashSet<>(asList(
                card(THREE, HEARTS),
                card(THREE, DIAMONDS),
                card(FOUR, HEARTS),
                card(THREE, CLUBS),
                card(SIX, CLUBS),
                card(TWO, HEARTS)
        ));

        pokerHand(new HashSet<>(cards));
    }

    @Test
    public void validConstructionOnNumberOfCardsEqualsFive() {

        Set<Card> cards = new HashSet<>(asList(
                card(THREE, HEARTS),
                card(THREE, DIAMONDS),
                card(FOUR, HEARTS),
                card(THREE, CLUBS),
                card(TWO, HEARTS)
        ));

        PokerHand actual = pokerHand(new HashSet<>(cards));

        assertEquals(cards, actual.getCards());
    }
}
