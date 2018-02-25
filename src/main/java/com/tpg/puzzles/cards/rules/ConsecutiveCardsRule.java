package com.tpg.puzzles.cards.rules;

import com.tpg.puzzles.cards.Hand;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ConsecutiveCardsRule implements HandRule {

    public boolean validate(Hand hand) {

        List<Integer> values = hand.getCards().stream().map(card -> card.getValue().getValue()).collect(toList());

        return validate(values);
    }

    private boolean validate(List<Integer> values) {

        Optional<Integer> min = values.stream().min(Integer::compareTo);

        List<Integer> sorted = values.stream().sorted(Integer::compareTo).collect(toList());

        return min.map(m -> validate(m, sorted)).get();
    }

    private boolean validate(Integer min, List<Integer> actual) {

        int index = actual.size() - 1;

        Integer max = actual.get(index);

        return validate(min, max, actual);
    }

    private boolean validate(Integer min, Integer max, List<Integer> actual) {

        List<Integer> expected = IntStream.range(min, max+1).boxed().collect(toList());

        return actual.equals(expected);
    }
}
