package com.example.Testreactor;

import ch.qos.logback.core.net.SyslogOutputStream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class practice {
    public static void main(String[] args) {
       /* Mono<String> monoString = Mono.just("data");
        monoString.subscribe(System.out::println, System.out::println, ()-> System.out.println("Completed"));*/

        /*Mono<Object> monoException=Mono.fromSupplier(()-> {
            throw new RuntimeException("Exception");
        });
        monoException.subscribe(System.out::println, System.out::println, ()-> System.out.println("Completed"));*/

      /*  Flux<String> fluxData = Flux.just("data","Testing", "Example");
        fluxData.subscribe(System.out::println, System.out::println, ()-> System.out.println("Completed"));

        List<String> listString = new ArrayList<>();
        listString.add("This");
        listString.add("is a test string list");

        Flux<String> stringFlux = Flux.fromIterable(listString);
        stringFlux.subscribe(System.out::println, System.out::println, ()-> System.out.println("Completed"));

        Flux.range(1,5).subscribe(System.out::println);
        */

    }
}
