package kim.jerok.practice_spring_22.config.advice;

import kim.jerok.practice_spring_22.config.exception.MyValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MyValidationException.class)
    public ResponseEntity<?> error(MyValidationException e) {
        return new ResponseEntity<>(e.getErrorMap().toString(), HttpStatus.BAD_REQUEST);
    }

}
