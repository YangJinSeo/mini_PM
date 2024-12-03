package Mini_PM_System.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Alias("astartEndPage")
public class AStartEndPageDTO {
	int startRow;
	int endRow;
	String searchWord;
	String startDate;
	String endDate;
	
}

