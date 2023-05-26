package com.example.Testreactor.problem;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
//Problem 2

public class RotateElements {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d"};

        Flux<String> flux = Flux.fromArray(array)
                                 .concatWith(Mono.fromCallable(() -> array[0]))
                                 .skip(1); // Skip the first element

        flux.subscribe(System.out::println);
    }
}
