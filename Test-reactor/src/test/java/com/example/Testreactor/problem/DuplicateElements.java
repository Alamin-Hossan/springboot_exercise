package com.example.Testreactor.problem;

import reactor.core.publisher.Flux;

import java.util.Arrays;

//Problem 1

public class DuplicateElements {
    public static void main(String[] args) {
        String[] array = {"a", "b", "a", "c", "b","b"};

        Flux<String> flux = Flux.fromArray(array)
                .distinct()
                .filter(str -> Arrays.stream(array).filter(test -> test.equals(str)).count() > 1);

        flux.subscribe(System.out::println);
    }
}
