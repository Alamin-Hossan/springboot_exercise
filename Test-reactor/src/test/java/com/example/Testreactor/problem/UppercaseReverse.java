package com.example.Testreactor.problem;

import reactor.core.publisher.Flux;

//Problem 5

public class UppercaseReverse {
    public static void main(String[] args) {
        String[] array = {"hello", "world"};

        Flux<String> flux = Flux.fromArray(array)
                .map(String::toUpperCase)
                .map(str -> new StringBuilder(str).reverse().toString());

        flux.subscribe(System.out::println);
    }
}
