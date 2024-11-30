package Mini_PM_System.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("salary")
public class SalaryDTO {
	String empNum;
	String empSalary;
	String account;
}
