package Mini_PM_System.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpCommand {
	String departmentId;
	String jobId;
	String empForm;
	String position;
	String empNum;
	String empName;
	String empId;
	String empPw;
	String empAddr;
	String empAddrDetail;
	String empPost;
	String empPhone;
	String empJumin;
	String empEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date empHireDate;
	String urgentPhone;
}
