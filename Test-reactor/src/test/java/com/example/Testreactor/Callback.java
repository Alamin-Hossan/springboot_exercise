package com.example.Testreactor;

import reactor.core.publisher.Flux;

public class Callback {
    public static void main(String[] args) {
        Flux.just("a","b","c").doOnSubscribe(subscription -> System.out.println("Subscription: " +subscription))
                .doOnNext(val-> System.out.println("Values: "+ val)).subscribe();
    }
}
