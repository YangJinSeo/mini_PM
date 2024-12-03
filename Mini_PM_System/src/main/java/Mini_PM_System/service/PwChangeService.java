package Mini_PM_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Mini_PM_System.mapper.FindMapper;

@Service
public class PwChangeService {
	
	@Autowired
	FindMapper findMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public Integer execute(String newPw, String userId) {
		
		String encodeNewPw = passwordEncoder.encode(newPw);
		return findMapper.chagePw(encodeNewPw, userId);
	}

}
