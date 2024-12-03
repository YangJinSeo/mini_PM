package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Mini_PM_System.domain.AStartEndPageDTO;
import Mini_PM_System.domain.AttendanceDTO;

@Mapper
public interface AttendanceMapper {
	public List<AttendanceDTO> attSelectList(AStartEndPageDTO sepDTO);
	public int attCount(String searchWord);
	public int attCount1(String searchWord);
	public int attCount2(String searchWord);
	public int attCount3(String searchWord);
}
