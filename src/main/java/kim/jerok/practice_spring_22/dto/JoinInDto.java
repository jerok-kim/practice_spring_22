package kim.jerok.practice_spring_22.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class JoinInDto {
    @NotNull
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Size(min = 4, max = 10)
    private String email;
}
