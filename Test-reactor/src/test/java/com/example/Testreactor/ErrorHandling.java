package com.example.Testreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorHandling {
    public static void main(String[] args) {
        Flux.just(2,7,10)
                .concatWith(Flux.error(new RuntimeException("Exception occurred")))
                .concatWith(Mono.just(5));
//                .onErrorReturn(72)
                /*.onErrorResume(err->{
                    System.out.println("Error occurs");
                    return Mono.just(72);
                })*/
                /*.map(element ->{
                    if(element == 7){
                        throw new RuntimeException("Exception Occure");
                    }
                    return element;
                }).onErrorContinue((ex.el)->{
                    System.out.println("occurred: "+ex);
                })
                        .log()
                        .subscribe();*/
         Flux.just();
    }
}
