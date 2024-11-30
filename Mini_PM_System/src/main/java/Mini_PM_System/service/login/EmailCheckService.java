package Mini_PM_System.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.mapper.LoginMapper;

@Service
public class EmailCheckService {
	
	@Autowired
	LoginMapper loginMapper;
	
	public Integer empCheck(String empEmail) {
		
		return loginMapper.empEmailCheck(empEmail);
	}

}
