package com.yong.iot;

import com.yong.iot.handler.MarkHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author yong.a.liang
 */
@SpringBootApplication
@EnableWebFlux
public class VueDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueDemoServerApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction(MarkHandler echoHandler) {
        return route(GET("/hello"), request -> ok().body(Mono.just("hello Web flux"), String.class))
            .andRoute(GET("/mark"), echoHandler::findAllMark)
            .andRoute(GET("/mark/count/{count}"), echoHandler::findMarkByCount)
            .andRoute(OPTIONS("/**"),echoHandler::optionsRequest)
            ;
    }
}

