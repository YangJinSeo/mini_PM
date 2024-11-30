package Mini_PM_System.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RetireCommand {
	String retireNum;
	
	@NotEmpty(message = "직원번호를 입력하십시오.")
	String retireEmpNum;
	@NotEmpty(message = "이름을 입력하십시오.")
	String retireName;
	@NotEmpty(message = "연락처를 입력하십시오.")
	String retirePhone;
	
	@NotNull(message = "입사일을 선택하십시오.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date hireDate;
	
	@NotNull(message = "퇴사일을 선택하십시오.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date retireDate;
	
	@NotEmpty(message = "최종 직급을 입력하십시오.")
	String finalPosition;
	@NotEmpty(message = "최종 부서를 입력하십시오.")
	String finalDpId;
}
