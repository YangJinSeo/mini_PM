package Mini_PM_System.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.PaymentDTO;
import Mini_PM_System.domain.StartEndPageDTO;
import Mini_PM_System.mapper.PaymentMapper;
import Mini_PM_System.service.StartEndPageService;

@Service
public class PaymentListService {
	@Autowired
	PaymentMapper paymentMapper;
	@Autowired
	StartEndPageService startEndPageService;
	
	public void execute(Integer page, String searchWord, Model model) {
		int limit = 3;
		
		StartEndPageDTO sepDTO = startEndPageService.execute(limit, page, searchWord);
		List<PaymentDTO> list = paymentMapper.paymentSelectList(sepDTO);
		
		Integer count = paymentMapper.paymentCount(searchWord);
		startEndPageService.execute(page, limit, count, searchWord, list, model);
	}
	
}
