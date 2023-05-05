package kim.jerok.practice_spring_22.config.advice;

import kim.jerok.practice_spring_22.config.exception.MyValidationException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionAdvice {

    @Getter
    @Setter
    public static class ErrorDto {
        private String key;
        private String value;
    }

    @ExceptionHandler(MyValidationException.class)
    public ResponseEntity<?> error(MyValidationException e) {

        List<ErrorDto> list = new ArrayList<>();
        Map<String, String> map = e.getErrorMap();
        map.forEach((k, v) -> {
            ErrorDto dto = new ErrorDto();
            dto.setKey(k);
            dto.setValue(v);
            list.add(dto);
        });

        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }

}
