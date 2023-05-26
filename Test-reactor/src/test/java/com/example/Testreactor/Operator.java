package com.example.Testreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Operator {
    public static void main(String[] args) {
        Flux.fromArray(new String[]{"Alamin","Hossain"})
                .filter(name -> name.contains("n"))
                .map(String::toUpperCase).subscribe(System.out::println);


        Flux.fromArray(new String[]{"Alamin", "Hossain"}).flatMap(Operator::stringMono).subscribe(System.out::println);


    }

    private static Mono<String> stringMono(String value){
        return Mono.just(value.concat(" : updated"));
    }
}
