package kim.jerok.practice_spring_22.controller;

import kim.jerok.practice_spring_22.config.annotation.LoginUserAop;
import kim.jerok.practice_spring_22.config.annotation.LoginUserResolver;
import kim.jerok.practice_spring_22.dto.JoinInDto;
import kim.jerok.practice_spring_22.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final HttpSession session;

    @GetMapping("/login")
    public String login() {
        User user = new User(1, "jerok", "1234", "0102222");
        session.setAttribute("loginUser", user);
        return "login ok";
    }

    @GetMapping("/user")  // 인증 필요 없음
    public String userInfoNoAuth() {
        return "user ok";
    }

    // username 출력 안됨
    @GetMapping("/auth/v1")  // 인증 필요함
    public String userInfo(User user) {  // 값 할당 안됨
        return "v1 username : " + user.getUsername();
    }

    @GetMapping("/auth/v2")
    public String authInfoAop(@LoginUserAop User user) {  // 인증 필요함
        return "v2 username : " + user.getUsername();
    }

    @GetMapping("/auth/v3")
    public String authInfoResolver(@LoginUserResolver User user) {  // 인증 필요함
        System.out.println(user.getUsername());
        return "v3 username : " + user.getUsername();
    }

    // Valid AOP 발동
    @PostMapping("/valid")
    public String join(@Valid JoinInDto joinInDto, BindingResult bindingResult) {
        return "ok";
    }

}
