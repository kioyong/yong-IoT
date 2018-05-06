package com.yong.iot;

import com.yong.iot.handler.MarkHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.OPTIONS;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author yong.a.liang
 */
@EnableAsync
@EnableWebFlux
@SpringBootApplication
public class IotApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction(MarkHandler echoHandler) {
        return route(GET("/hello"), request -> ok().body(Mono.just("hello Web flux"), String.class))
            .andRoute(GET("/mark"), echoHandler::findAllMark)
            .andRoute(GET("/mark/{id}"), echoHandler::findById)
            .andRoute(GET("/mark/item/value/{id}"), echoHandler::findMaxItemByMarkId)
            .andRoute(GET("/mark/count/{count}"), echoHandler::findMarkByCount)
            .andRoute(GET("/mark/limit"), echoHandler::findMarkByLimit)
            .andRoute(GET("/test1"), echoHandler::test1)
            .andRoute(OPTIONS("/**"),echoHandler::optionsRequest)
            ;
    }
}

