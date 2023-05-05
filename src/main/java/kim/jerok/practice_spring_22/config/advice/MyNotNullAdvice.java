package kim.jerok.practice_spring_22.config.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component  // IoC 등록 new를 해야됨
public class MyNotNullAdvice {

    // 깃발에 별칭주기
    @Pointcut("@annotation(kim.jerok.practice_spring_22.config.annotation.MyNotNull)")
    public void myNotNull() {
    }

    // 매개변수에 접근해서 값을 찾는 것을 가능 - 값을 주입하려면 @Around 사용해야함
    @Before("myNotNull()")
    public void notNullAdvice(JoinPoint jp) throws Throwable {
        
        Object[] args = jp.getArgs();

        for (Object arg : args) {
            if (arg instanceof String) {
                String username = (String) arg;
                System.out.println(username + "님 안녕");
            }
        }
    }

}
