package com.example.Testreactor.problem;

import reactor.core.publisher.Flux;
//Problem 3

public class Palindrome {
    public static void main(String[] args) {
        String[] array = {"madam", "racecar", "civicr"};

        Flux<String> flux = Flux.fromArray(array)
                .filter(s -> new StringBuilder(s).reverse().toString().equals(s));

        flux.subscribe(System.out::println);
    }
}
