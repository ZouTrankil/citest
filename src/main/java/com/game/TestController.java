package com.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: Mr.Zou
 * @email: 515600147@qq.com
 * @date: 2021/4/27 20:58
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping(value = "/{input}", method = RequestMethod.GET)
    public Mono<String> printEcho(@PathVariable String input) {
        log.info("收到了信息:" + input);
        return Mono.just("return your " + input);
    }

}
