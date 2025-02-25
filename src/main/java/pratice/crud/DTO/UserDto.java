package pratice.crud.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

// DTO 는 클라이언트와 데이터를 주고받을 때 사용하는 객체.
// 엔티티와 직접 주고받으면 보안 문제나 유지보수 문제가 발생할 수 있음.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    private String name;

    @Email(message = "유효한 이메일을 입력하세요.")
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    private String email;
}
