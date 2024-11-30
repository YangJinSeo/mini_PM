package Mini_PM_System.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmpCommand {
	@NotEmpty(message = "부서를 선택하십시오.")
	String departmentId;
	@NotEmpty(message = "직무를 선택하십시오.")
	String jobId;
	
	@NotEmpty(message = "고용형태를 선택하십시오.")
	String empForm;
	@NotEmpty(message = "직책을 선택하십시오.")
	String position;
	
	String empNum;
	
	@NotEmpty(message = "이름을 입력하십시오.")
	String empName;
	
	String empId;
	String empPw;
	
	@NotEmpty(message = "주소를 입력하십시오.")
	String empAddr;
	String empAddrDetail;
	String empPost;
	
	@NotEmpty(message = "연락처를 입력하십시오.")
	@Size(min = 11, max = 23)
	String empPhone;
	
	@NotEmpty(message = "주민번호를 입력하십시오.")
	String empJumin;
	
	@NotBlank(message = "이메일을 입력하십시오.")
	String empEmail;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date empHireDate;
	
	@NotEmpty(message = "긴급 연락처를 하십시오.")
	@Size(min = 11, max = 23)
	String urgentPhone;
}
