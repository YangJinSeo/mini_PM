package Mini_PM_System.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.command.PaymentCommand;
import Mini_PM_System.domain.PaymentDTO;
import Mini_PM_System.mapper.PaymentMapper;

@Service
public class PaymentInsertService {
	@Autowired
	PaymentMapper paymentMapper;
	
	public void execute(PaymentCommand paymentCommand) {
		PaymentDTO dto = new PaymentDTO();
		dto.setBonus(paymentCommand.getBonus());
		dto.setEmpNum(paymentCommand.getEmpNum());
		dto.setEmpSalary(paymentCommand.getEmpSalary());
		dto.setPayDate(paymentCommand.getPayDate());
		paymentMapper.paymentInsert(dto);
	}

}
