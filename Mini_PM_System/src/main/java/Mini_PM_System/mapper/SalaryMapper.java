package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Mini_PM_System.domain.SalaryDTO;
import Mini_PM_System.domain.StartEndPageDTO;

@Mapper
public interface SalaryMapper {
	public int salaryMerge(SalaryDTO dto);
	public List<SalaryDTO> salarySelectList(StartEndPageDTO dto);
	public int salaryCount(String searchWord);
}
