package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.PokerHand;

public final class HighCardRule implements PokerHandRule {

    private final PairRule pairRule = new PairRule();
    private final TwoPairsRule twoPairsRule = new TwoPairsRule();
    private final ThreeOfAKindRule threeOfAKindRule = new ThreeOfAKindRule();
    private final StraightRule straightRule = new StraightRule();
    private final FlushRule flushRule = new FlushRule();
    private final FullHouseRule fullHouseRule = new FullHouseRule();
    private final FourOfAKindRule fourOfAKindRule = new FourOfAKindRule();
    private final StraightFlushRule straightFlushRule = new StraightFlushRule();

    @Override
    public boolean validate(PokerHand hand) {

        return !(pairRule.validate(hand) ||
                twoPairsRule.validate(hand) ||
                threeOfAKindRule.validate(hand) ||
                straightFlushRule.validate(hand) ||
                straightRule.validate(hand) ||
                flushRule.validate(hand) ||
                fullHouseRule.validate(hand) ||
                fourOfAKindRule.validate(hand));

    }
}
