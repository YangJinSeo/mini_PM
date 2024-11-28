package Mini_PM_System.command;

import java.sql.Date;

import lombok.Data;

@Data
public class PaymentCommand {
	 int empSalary;
	 int bonus; 
	 Date payDate;
	 String empNum;
}
