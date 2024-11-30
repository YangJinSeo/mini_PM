package Mini_PM_System.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("review")
public class ReviewDTO {
	String empNum;
	String empComment;
	Integer score;
}
