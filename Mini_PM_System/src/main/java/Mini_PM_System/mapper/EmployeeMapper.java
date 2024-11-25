package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Mini_PM_System.domain.EmployeeDTO;

@Mapper
public interface EmployeeMapper {

	public void empInsert(EmployeeDTO dto);

	public List<EmployeeDTO> selectList();
	
	
}
