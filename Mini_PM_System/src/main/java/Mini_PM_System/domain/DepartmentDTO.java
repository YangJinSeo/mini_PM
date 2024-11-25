package Mini_PM_System.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("department")
public class DepartmentDTO {
	 String departmentId;
	 String departmentName;
	 String officeLoc;
	 String managerId;
	 String duty;
}
