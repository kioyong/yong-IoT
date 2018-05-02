package com.yong.iot.handler;

import com.yong.iot.model.Mark;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @acthor yong.a.liang
 * @date 2018/04/27
 */
@Slf4j
@Component
@AllArgsConstructor
public class MarkHandler {

//    private final MarkRepository repository;

//    public Mono<ServerResponse> findAllMark(final ServerRequest request) {
//        return ok().body(repository.findAll(), Mark.class);
//    }

    /**
     * 校验count的有效性，0 < count <= 100
     * 查出数据库里面所有大于等于count的记录
     * 将items里面isactive=false的过滤掉
     **/
//    public Mono<ServerResponse> findMarkByCount(final ServerRequest request) {
//        int count = Integer.valueOf(request.pathVariable("count"));
//        checkArgument(count <= 100 && count > 0, "PatchVariable verification Exception, count not should be > 100 or < 0");
//        return ok().body(
//            repository.findByCountGreaterThanEqual(count)
//                .transform(this::filterInactiveItems),
//            Mark.class);
//    }

    Flux<Mark> filterInactiveItems(Flux<Mark> marks) {
        return marks.map(
            t -> {
                t.setItem(t.getItem().stream().filter(
                    i -> i.isActive() == true).collect(Collectors.toList()));
                return t;
            });
    }


    Mono<ServerResponse> serverResponse(Mono<Mark> markMono) {
        return ok().body(markMono, Mark.class);
    }

    Mono<ServerResponse> serverResponse(Flux<Mark> marks) {
        return (Mono<ServerResponse>)ok().body(marks, Mark.class);
    }

    public Mono<ServerResponse> optionsRequest(ServerRequest request) {
        return ok().build();
    }

}
