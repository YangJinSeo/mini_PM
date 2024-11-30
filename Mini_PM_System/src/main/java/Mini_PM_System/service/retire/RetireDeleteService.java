package Mini_PM_System.service.retire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.mapper.RetireMapper;

@Service
public class RetireDeleteService {
	
	@Autowired
	RetireMapper retireMapper;
	public void execute(String num) {
		retireMapper.delete(num);
		
	}

}
