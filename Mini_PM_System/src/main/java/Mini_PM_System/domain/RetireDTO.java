package Mini_PM_System.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("retireDTO")
@Data
public class RetireDTO {
	String retireNum;
	String retireEmpNum;
	String retireName;
	String retirePhone;
	Date hireDate;
	Date retireDate;
	String finalPosition;
	String finalDpId;
	
}
