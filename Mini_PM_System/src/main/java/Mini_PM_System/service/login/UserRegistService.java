package Mini_PM_System.service.login;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.UserCommand;
import Mini_PM_System.domain.UserDTO;
import Mini_PM_System.mapper.LoginMapper;

@Service
public class UserRegistService {
	
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Integer execute(UserCommand userCommand) {
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(userCommand, dto);
		
		String encodePw = passwordEncoder.encode(userCommand.getUserPw());
		dto.setUserPw(encodePw);
		return loginMapper.userInsert(dto);
	}

}
