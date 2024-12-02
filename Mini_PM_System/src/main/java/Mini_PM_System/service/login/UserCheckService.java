package Mini_PM_System.service.login;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.LoginCommand;
import Mini_PM_System.domain.LoginDTO;
import Mini_PM_System.mapper.LoginMapper;

@Service
public class UserCheckService {
	
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(LoginCommand loginCommand) {
		LoginDTO dto = new LoginDTO();
		BeanUtils.copyProperties(loginCommand, dto);
		return loginMapper.userInsert(dto);
	}

}
