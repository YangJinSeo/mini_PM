package Mini_PM_System.service.login;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.LoginCommand;
import Mini_PM_System.domain.LoginDTO;
import Mini_PM_System.mapper.LoginMapper;

@Service
public class UserCheckService {
	
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Integer execute(LoginCommand loginCommand) {
		LoginDTO dto = new LoginDTO();
		BeanUtils.copyProperties(loginCommand, dto);
		
		String encodePw = passwordEncoder.encode(loginCommand.getUserPw());
		dto.setUserPw(encodePw);
		return loginMapper.userInsert(dto);
	}

}
