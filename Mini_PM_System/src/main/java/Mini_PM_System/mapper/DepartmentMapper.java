package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Mini_PM_System.domain.DepartmentDTO;
import Mini_PM_System.domain.StartEndPageDTO;

@Mapper
public interface DepartmentMapper {
	public Integer dpInsert(DepartmentDTO dto);
	public List<DepartmentDTO> dpSelectList(StartEndPageDTO sepDTO);
	public Integer dpCount(String searchWord);
	public DepartmentDTO dpSelectOne(String departmentId);
	public Integer dpUpdate(DepartmentDTO dto);
	public void dpDelete(String departmentId);
}
