package com.example.Testreactor.problem;

import reactor.core.publisher.Flux;
import java.util.Map;

//Problem 4


public class FrequencyOfCharacters {
    public static void main(String[] args) {
        String input = "I am new learner of Reactive programming";
        Flux.fromArray(input.split(""))
                .filter(str -> !str.equals(" "))
                .groupBy(key -> key)
                .flatMap(groupedFlux -> groupedFlux.count()
                        .map(count -> Map.entry(groupedFlux.key(), count)))
                .collectMap(Map.Entry::getKey, Map.Entry::getValue)
                .subscribe(FrequencyOfCharacters::printCharacterFrequencies);
    }

    private static void printCharacterFrequencies(Map<String, Long> characterFrequencies) {
        characterFrequencies.forEach((character, frequency) ->
                System.out.println("Character: " + character + ", Frequency: " + frequency));

    }
}
