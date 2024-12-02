package Mini_PM_System.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.mapper.LoginMapper;

@Service
public class IdCheckService {
	
	@Autowired
	LoginMapper loginMapper;
	public Integer execute(String userId) {
		
		return loginMapper.idCheck(userId);
	}

}
