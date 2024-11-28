package Mini_PM_System.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("payment")
public class PaymentDTO {
	 int empSalary;
	 int bonus; 
	 Date payDate;
	 String empNum;
}
