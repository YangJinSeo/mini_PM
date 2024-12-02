package Mini_PM_System.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import Mini_PM_System.command.LoginCommand;
import Mini_PM_System.domain.AuthInfoDTO;
import Mini_PM_System.mapper.LoginMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class UserLoginService {
	
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(LoginCommand loginCommand
						, BindingResult result
						, HttpSession session) {
		
		String userId = loginCommand.getUserId();
		String userPw = loginCommand.getUserPw();
		
		// 회원 로그인 정보를 가져오기 위한 DTO 필요
		AuthInfoDTO auth = loginMapper.loginSelect(userId);
		if (userId != "" && userId != null) {
			if (auth != null) { // 회원 아이디가 있으면 auth가 null이 아니다.
				if (auth.getUserApproval() == null) {
					System.out.println("아이디는 있지만 부서장의 승인을 받기 전일때");
					result.rejectValue("userId", "loginCommand.getUserId()"
										,"부서장 승인이 나지 않았습니다." );
				
				} else { // 아이디가 존재하고 비밀번호 여부
					
					if (passwordEncoder.matches(userPw, auth.getUserPw())) {
						System.out.println("비밀번호가 일치");
						// 아이디와 비번이 일치하면 session으로 로그인 정보 저장
						session.setAttribute("auth", auth);
						
					}else {
						System.out.println("비밀번호가 불일치");
						
						result.rejectValue("userPw", "loginCommand.getUserPw()"
								,"비밀번호가 틀렸습니다." );
						
					}
				}
			}else {
				System.out.println("아이디가 존재하지 않을 때");
				result.rejectValue("userId", "loginCommand.getUserId()"
						,"아이디가 존재하지 않습니다." );
			}
			
		}
		
		
	}

}
