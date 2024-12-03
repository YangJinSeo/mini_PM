package Mini_PM_System.service.setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.AuthInfoDTO;
import Mini_PM_System.mapper.FindMapper;

@Service
public class AdminListService {

	@Autowired
	FindMapper findMapper;
	public void execute(Model model) {
		List<AuthInfoDTO> list = findMapper.adminList();
		List<AuthInfoDTO> unauth = findMapper.unauthList();
		
		model.addAttribute("list", list);
		model.addAttribute("unauth", unauth);
	}

}
