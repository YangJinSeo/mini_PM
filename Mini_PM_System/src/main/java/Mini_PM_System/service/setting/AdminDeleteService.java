package Mini_PM_System.service.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.mapper.FindMapper;

@Service
public class AdminDeleteService {
	
	@Autowired
	FindMapper findMapper;
	public void execute(String id) {
		
		findMapper.adminDelete(id);
	}

}
