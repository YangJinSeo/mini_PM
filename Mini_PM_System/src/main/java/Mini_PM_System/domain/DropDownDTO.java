package Mini_PM_System.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("dropDTO")
public class DropDownDTO {
	
	String tableName;
	String colName1;
	String colName2;
}
