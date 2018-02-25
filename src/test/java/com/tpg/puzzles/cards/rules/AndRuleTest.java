package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Card;
import com.tpg.puzzles.cards.Hand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static com.tpg.puzzles.cards.Card.Suit.HEARTS;
import static com.tpg.puzzles.cards.Value.TWO;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AndRuleTest {

    private static final Hand HAND = new Hand(new HashSet<>(asList(Card.card(TWO, HEARTS))));

    @Mock
    private HandRule rule1;

    @Mock
    private HandRule rule2;

    private AndRule rule;

    @Before
    public void setUp() {

        rule = new AndRule(new HashSet<>(asList(rule1, rule2)));
    }

    @Test
    public void allValidate() {

        when(rule1.validate(HAND)).thenReturn(true);

        when(rule2.validate(HAND)).thenReturn(true);

        boolean actual = rule.validate(HAND);

        assertTrue(actual);
    }

    @Test
    public void validateAndInvalidate() {

        when(rule1.validate(HAND)).thenReturn(true);

        boolean actual = rule.validate(HAND);

        assertFalse(actual);
    }

    @Test
    public void allInvalidate() {

        boolean actual = rule.validate(HAND);

        assertFalse(actual);
    }
}
