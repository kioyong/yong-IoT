package com.yong.iot.service.impl;

import com.yong.iot.model.Mark;
import com.yong.iot.repository.MarkRepository;
import com.yong.iot.service.MarkService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class MarkServiceImpl implements MarkService {

    private final MarkRepository markRepository;

    @Async
    @Override
    public CompletableFuture<Flux<Mark>> findByCountGreaterThanEqualFutureAsync(int count) {
        return CompletableFuture.completedFuture(this.findByCountGreaterThanEqual(count));
    }

    @Async
    @Override
    public CompletableFuture<Flux<Mark>> findByCountLessThanFutureAsync(int count) {
        return CompletableFuture.completedFuture(this.findByCountLessThan(count));
    }


    public Flux<Mark> findByCountGreaterThanEqual(int count) {
        this.sleep();
        return markRepository.findByCountGreaterThanEqual(count);
    }

    public Flux<Mark> findByCountLessThan(int count) {
        this.sleep();
        return markRepository.findByCountLessThan(count);
    }

    public void sleep() {
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
