package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Hand;

public interface HandRule {

    boolean validate(Hand hand);
}
