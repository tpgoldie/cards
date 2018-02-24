package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Hand;

public interface PokerRule {

    boolean validate(Hand hand);
}
