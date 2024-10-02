package com.example.ikor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class FirstReactController {

  @GetMapping("mono")
  public Mono<String> firstReact() {
    return getMonoWithDelay();
  }

  @GetMapping("ostap")
  public Flux<String> firstFlux() {
    return getFluxWithDelay();
  }

  @GetMapping("david")
  public Flux<String> firstDavid() {
    return getFluxWithDelayDavid();
  }

  public Flux<String> getFluxWithDelay() {
    return Flux.just("Остап", " не вміє ", " грати", " у BRAWL STARS").delayElements(Duration.ofSeconds(5));
  }

  public Flux<String> getFluxWithDelayDavid() {
    return Flux.just("Давиду", " завтра", " 13", " років. ", "ВІТАЄМО !!!!").delayElements(Duration.ofSeconds(5));
  }


  public Mono<String> getMonoWithDelay() {
    return Mono.just("Hello World!").delayElement(Duration.ofSeconds(5));
  }
}
