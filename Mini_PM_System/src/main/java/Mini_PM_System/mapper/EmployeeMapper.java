package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Mini_PM_System.command.EmpCommand;
import Mini_PM_System.domain.EmpDetailDTO;
import Mini_PM_System.domain.EmployeeDTO;
import Mini_PM_System.domain.StartEndPageDTO;

@Mapper
public interface EmployeeMapper {

	public void empInsert(EmployeeDTO dto);

	public List<EmployeeDTO> selectList(StartEndPageDTO sepDTO);

	public EmpDetailDTO selectOne(String empNum);

	public void empUpdate(EmployeeDTO dto);

	public Integer empCount(String searchWord);
	
	
}
