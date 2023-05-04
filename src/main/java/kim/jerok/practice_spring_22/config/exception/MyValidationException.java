package kim.jerok.practice_spring_22.config.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class MyValidationException extends RuntimeException {

    private Map<String, String> errorMap;

    public MyValidationException(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

}
