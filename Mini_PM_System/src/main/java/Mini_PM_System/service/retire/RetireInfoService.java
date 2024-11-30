package Mini_PM_System.service.retire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.RetireDTO;
import Mini_PM_System.mapper.RetireMapper;

@Service
public class RetireInfoService {

	@Autowired
	RetireMapper retireMapper;
	public void execute(String num, Model model) {
		RetireDTO dto = retireMapper.selectOne(num);
		model.addAttribute("retireCommand", dto);
	}
	
}
