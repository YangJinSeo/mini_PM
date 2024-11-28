package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Mini_PM_System.domain.PersonnelDTO;
import Mini_PM_System.domain.StartEndPageDTO;

@Mapper
public interface PersonnelMapper {
	public Integer personnelInsert(PersonnelDTO dto);
	public List<PersonnelDTO> empSelectList(
			@Param(value="startRow") int startRow
			,@Param(value="endRow")  int endRow
			,@Param(value="searchWord") String searchWord);
	public int empSelectListCount(String searchWord);
	public List<PersonnelDTO> dpSelectList(
			@Param(value="startRow") int startRow
			,@Param(value="endRow")  int endRow
			,@Param(value="searchWord") String searchWord);
	public int dpSelectListCount(String searchWord);
	public List<PersonnelDTO> personnelSelectList(StartEndPageDTO sepDTO);
	public int personnelCount(String searchWord);
}
