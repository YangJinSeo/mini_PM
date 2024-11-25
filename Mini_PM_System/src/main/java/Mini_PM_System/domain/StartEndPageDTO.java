package Mini_PM_System.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Alias("startEndPage")
public class StartEndPageDTO {
	int startRow;
	int endRow;
	String searchWord;
	
}

