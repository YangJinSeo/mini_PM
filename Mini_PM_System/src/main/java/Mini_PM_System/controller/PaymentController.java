package Mini_PM_System.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Mini_PM_System.command.PaymentCommand;
import Mini_PM_System.service.payment.PaymentInsertService;
import Mini_PM_System.service.payment.PaymentListService;
import Mini_PM_System.service.payment.SalarysService;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	PaymentInsertService paymentInsertService; 
	@Autowired
	SalarysService salarysService;
	@Autowired
	PaymentListService paymentListService;
	
	@GetMapping("paymentList") 
	public String paymentList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page
			, @RequestParam(value = "searchWord", required = false) String searchWord
			,Model model) {
		paymentListService.execute(page, searchWord, model);
		return "thymeleaf/payment/paymentList";
	}
	
	@GetMapping("paymentWrite")
	public String paymentWrite() {
		
		return "thymeleaf/payment/paymentForm";
	}
	@PostMapping("paymentInsert")
	public String paymentInsert(PaymentCommand paymentCommand) {
		paymentInsertService.execute(paymentCommand);
		return "redirect:paymentList";
	}
	@GetMapping("salarys")
	public String salarys() {
		
		return "thymeleaf/payment/salarys";
	}
	@PostMapping("salarysList")
	public @ResponseBody Map<String, Object> salarysList(
			@RequestParam(value = "page" , required = false , defaultValue = "1") int page
			,@RequestParam(value = "searchWord", required = false) String searchWord) {
		Map<String, Object> map = salarysService.execute(page, searchWord);
		return map;
	}
}
