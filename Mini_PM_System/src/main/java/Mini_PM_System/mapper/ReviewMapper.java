package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Mini_PM_System.domain.ReviewDTO;
import Mini_PM_System.domain.StartEndPageDTO;

@Mapper
public interface ReviewMapper {
	public int reviewInsert(ReviewDTO dto);
	public List<ReviewDTO> reviewSelectList(StartEndPageDTO sepDTO);
	public int reviewCount(String searchWord);
	public ReviewDTO reviewSelectOne(String empNum);
	public int reviewUpdate(ReviewDTO dto);
}
