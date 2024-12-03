package Mini_PM_System.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.mapper.FindMapper;

@Service
public class AdminOkService {
	
	@Autowired
	FindMapper findMapper;
	public Integer changeY(String userId) {
		
		return findMapper.changeY(userId);
	}

	public Integer changeH(String userId) {
		
		return findMapper.changeH(userId);
	}

}
