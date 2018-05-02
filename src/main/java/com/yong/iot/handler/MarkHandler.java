package com.yong.iot.handler;

import com.yong.iot.model.Mark;
import com.yong.iot.repository.MarkRepository;
import com.yong.iot.service.MarkService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @acthor yong.a.liang
 * @date 2018/04/27
 */
@Slf4j
@Component
@AllArgsConstructor
public class MarkHandler {

    private final MarkRepository repository;

    private final MarkService markService;

    public Mono<ServerResponse> findAllMark(final ServerRequest request) {
        return ok().body(repository.findAll(), Mark.class);
    }

    /**
     * 校验count的有效性，0 < count <= 100
     * 查出数据库里面所有大于等于count的记录
     * 将items里面isactive=false的过滤掉
     **/
    public Mono<ServerResponse> findMarkByCount(final ServerRequest request) {
        int count = Integer.valueOf(request.pathVariable("count"));
        checkArgument(count <= 100 && count > 0, "PatchVariable verification Exception, count not should be > 100 or < 0");
        return ok().body(
            repository.findByCountGreaterThanEqual(count)
                .transform(this::filterInactiveItems),
            Mark.class);
    }

    public Mono<ServerResponse> findMarkByLimit(final ServerRequest request) {
        Optional<String> maxOptional = request.queryParam("max");
        Optional<String> minOptional = request.queryParam("min");
        int max = Integer.valueOf(maxOptional.get());
        int min = Integer.valueOf(minOptional.get());
        CompletableFuture<Flux<Mark>> cf1 = markService.findByCountGreaterThanEqualFuture(max);
        CompletableFuture<Flux<Mark>> cf2 = markService.findByCountLessThanFuture(min);
        try {
            return ok().body(
                cf1.thenCombineAsync(cf2, (c1, c2) -> c1.concatWith(c2)).get(),
                Mark.class
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


//    public Mono<ServerResponse> findMarkByLimit(final ServerRequest request){
//        Optional<String> maxOptional = request.queryParam("max");
//        Optional<String> minOptional = request.queryParam("min");
//        checkArgument(maxOptional.isPresent() == true, "Query Param 'max' is request");
//        checkArgument(minOptional.isPresent() == true, "Query Param 'min' is request");
//        int max = Integer.valueOf(maxOptional.get());
//        int min = Integer.valueOf(minOptional.get());
//        checkArgument(max <= 100 && max > 50, "PatchVariable verification Exception, max count should be <= 100 or > 50");
//        checkArgument(min <= 50 && min > 0, "PatchVariable verification Exception,min count should be <= 50 or > 0");
//        return ok().body(
//            repository.findByCountGreaterThanEqual(max).concatWith(repository.findByCountLessThan(min)),
//            Mark.class
//        );
//
//    }

    Flux<Mark> filterInactiveItems(Flux<Mark> marks) {
        return marks.map(
            t -> {
                t.setItem(t.getItem().stream().filter(
                    i -> i.isActive() == true).collect(Collectors.toList()));
                return t;
            });
    }

    public Mono<ServerResponse> test1(final ServerRequest request) {
        return ok().body(
            Flux.just("a", "b").map(t -> t.concat("test"))
            , String.class);
    }

    Mono<ServerResponse> serverResponse(Mono<Mark> markMono) {
        return ok().body(markMono, Mark.class);
    }

    Mono<ServerResponse> serverResponse(Flux<Mark> marks) {
        return (Mono<ServerResponse>) ok().body(marks, Mark.class);
    }

    public Mono<ServerResponse> optionsRequest(ServerRequest request) {
        return ok().build();
    }

}
