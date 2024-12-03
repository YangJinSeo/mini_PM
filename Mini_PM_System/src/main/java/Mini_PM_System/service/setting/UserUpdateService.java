package Mini_PM_System.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.domain.AuthInfoDTO;
import Mini_PM_System.mapper.FindMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class UserUpdateService {

	@Autowired
	FindMapper findMapper;
	public void execute(String userName, String empNum) {
		findMapper.userUpdate(userName, empNum);
	}

}
