package com.yong.iot.handler;

import com.yong.iot.model.Item;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
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
     * 主动抛出异常示例
     * **/
    public Mono<ServerResponse> findById(final ServerRequest request) {
        String id = request.pathVariable("id");

//        (1)
//        return ok().body(repository.findById(id).switchIfEmpty(Mono.error(new IllegalArgumentException("not found"))), Mark.class);
//        (2)
//        return repository.findById(id)
//            .flatMap(mark -> ok().body(fromObject(mark)))
//            .switchIfEmpty(
//                ok().body(
//                    fromObject(
//                        Mono.error(new IllegalArgumentException("not found")
//                        )
//                    )
//                )
//            );
//        (3)
//        return repository.findById(id).flatMap(mark -> ok().body(fromObject(mark))).switchIfEmpty(notFound().build());
        return repository.findById(id).flatMap(this::serverResponse).switchIfEmpty(notFound().build());

    }

    /**
     * 深层嵌套路径空指针处理示范
     * **/
    public Mono<ServerResponse> findMaxItemByMarkId(final ServerRequest request) {
        String id = request.pathVariable("id");
        return ok().body(
            repository.findById(id).map(Mark::getItem).map(Item::getValue)
                .defaultIfEmpty(0).onErrorReturn(0)
            ,Integer.class);
    }

    /**
     * 对比
     * **/
//    @GetMapping("/mark/item/value/{id}")
//    public Integer findMaxItemByMarkId(@PathVariable("id") String id) {
//        Mark mark = repository.findById(id)；
//        if (mark ==null || mark.getItem() ==null || mark.getItem().getValue() == null){
//            return 0;
//        }else{
//            return mark.getItem().getValue();
//        }
//    }


    /**
     * 数据处理示例
     *
     * 校验参数的有效性，0 < count <= 100
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

    /**
     * 多线程处理示例 async
     * **/
    //TODO pending tuning
    public Mono<ServerResponse> findMarkByLimit(final ServerRequest request) {
        Optional<String> maxOptional = request.queryParam("max");
        Optional<String> minOptional = request.queryParam("min");
        int max = Integer.valueOf(maxOptional.get());
        int min = Integer.valueOf(minOptional.get());
        CompletableFuture<Flux<Mark>> cf1 = markService.findByCountGreaterThanEqualFutureAsync(max);
        CompletableFuture<Flux<Mark>> cf2 = markService.findByCountLessThanFutureAsync(min);
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
//    }

    Flux<Mark> filterInactiveItems(Flux<Mark> marks) {
        return marks.map(
            t -> {
                t.setItems(t.getItems().stream().filter(
                    i -> i.isActive() == true).collect(Collectors.toList()));
                return t;
            });
    }

    public Mono<ServerResponse> test1(final ServerRequest request) {
        return ok().body(
            Flux.just("a", "b").map(t -> t.concat("test"))
            , String.class);
    }

    Mono<ServerResponse> serverResponse(Object object) {
        return ok().body(fromObject(object));
    }

    Mono<ServerResponse> serverResponse(Mono<Mark> mono) {
        return ok().body(mono, Mark.class);
    }


    public Mono<ServerResponse> optionsRequest(ServerRequest request) {
        return ok().build();
    }

}
