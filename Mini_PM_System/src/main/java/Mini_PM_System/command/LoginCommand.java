package Mini_PM_System.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginCommand {
	@NotBlank(message = "아이디를 입력하세요.")
	@Size(min = 4, max = 12)
	String userId;
	@NotBlank(message = "비밀번호를 입력하세요.")
	@Size(min = 4, max = 16)
	String userPw;
	
	Boolean autoLogin;
	Boolean idStore;
}
