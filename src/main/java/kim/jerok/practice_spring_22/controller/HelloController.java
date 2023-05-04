package kim.jerok.practice_spring_22.controller;

import kim.jerok.practice_spring_22.config.annotation.Bye;
import kim.jerok.practice_spring_22.config.annotation.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Bye
    @GetMapping("/hello/v1")
    public String v1(String username) {
        System.out.println(username + "님 Bye");
        return "v1";
    }

    // http://localhost:8080/hello/v2?username=jerok
    @Hello
    @GetMapping("/hello/v2")
    public String v2(String username) {
        System.out.println("username : 값 변경? : " + username);
        return "v2";
    }

}
