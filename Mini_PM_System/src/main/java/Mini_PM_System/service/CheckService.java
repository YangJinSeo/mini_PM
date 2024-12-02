package Mini_PM_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.mapper.LoginMapper;

@Service
public class CheckService {
	
	@Autowired
	LoginMapper loginMapper;
	public Integer email(String empEmail) {
		
		return loginMapper.empEmailCheck(empEmail);
	}

	public Integer IdCheck(String userId) {
		return loginMapper.idCheck(userId);
	}
	
	public Integer empNumCheck(String empNum) {
		
		return loginMapper.empNumCheck(empNum);
	}

}
