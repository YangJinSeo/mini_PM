package Mini_PM_System.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("empDtailDTO")
public class EmpDetailDTO {
	String departmentName;
	String jobName;
	EmployeeDTO employeeDTO;
	
}
