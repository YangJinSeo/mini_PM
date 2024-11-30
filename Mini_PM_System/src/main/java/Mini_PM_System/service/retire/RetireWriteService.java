package Mini_PM_System.service.retire;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.RetireCommand;
import Mini_PM_System.domain.RetireDTO;
import Mini_PM_System.mapper.RetireMapper;

@Service
public class RetireWriteService {
	
	@Autowired
	RetireMapper retireMapper;
	
	public void execute(RetireCommand retireCommand) {
		RetireDTO dto = new RetireDTO();
		BeanUtils.copyProperties(retireCommand, dto);
		
		retireMapper.write(dto);
	}

}
