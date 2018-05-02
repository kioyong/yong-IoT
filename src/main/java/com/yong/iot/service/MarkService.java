package com.yong.iot.service;

import com.yong.iot.model.Mark;
import reactor.core.publisher.Flux;

import java.util.concurrent.CompletableFuture;

public interface MarkService {

    CompletableFuture<Flux<Mark>> findByCountGreaterThanEqualFuture(int count);

    CompletableFuture<Flux<Mark>> findByCountLessThanFuture(int count);

}
