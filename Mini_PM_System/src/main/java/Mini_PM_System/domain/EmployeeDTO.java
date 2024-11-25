package Mini_PM_System.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("empDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
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
	Date empHireDate;
	String urgentPhone;
	
}
