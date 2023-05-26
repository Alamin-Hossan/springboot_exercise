package com.example.Testreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Concat {
    public static void main(String[] args) {
//       Flux<String> str1 = Flux.just("A","l","a","m","i","n");
//        Flux<String> str2 = Flux.just("H","o","s","s","a","i","n");
//
//        Flux<String> concat =  Flux.concat(str1,str2);
//        concat.subscribe(System.out::println);
//
//        Mono<String> eMono= Mono.just("e");
//
//
//        Flux.zip(str1,str2,(s1,s2)->s1+s2).subscribe(System.out::println);

        StepVerifier.create(returnedMerge())
                .expectNext("A")
                .expectNext("H")
                .expectNext("l")
                .expectNext("o")
                .expectNext("a")
                .expectNext("s")
                .expectNext("m")
                .expectNext("s")
                .expectNext("i")
                .expectNext("a")
                .expectNext("n")
                .expectNext("i")

        ;

    }
    private static Flux<String> returnedMerge(){
        Flux<String> str1 = Flux.fromArray(new String[]{"A", "l", "a", "m", "i", "n"}).delayElements(Duration.ofMillis(100));
        Flux<String> str2 = Flux.fromArray(new String[]{"H", "o", "s", "s", "a", "i"}).delayElements(Duration.ofMillis(100));

        return Flux.merge(str1,str2);
    };
}



