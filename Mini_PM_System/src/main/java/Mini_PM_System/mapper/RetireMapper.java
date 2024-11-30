package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Mini_PM_System.domain.EmployeeDTO;
import Mini_PM_System.domain.RetireDTO;
import Mini_PM_System.domain.StartEndPageDTO;

@Mapper
public interface RetireMapper {

	public EmployeeDTO selectEmpOne(String num);

	public int empChangeRetire(EmployeeDTO dto);

	public void empDelete(String num);

	public List<RetireDTO> selectList(StartEndPageDTO sepDTO);

	public void write(RetireDTO dto);

	public RetireDTO selectOne(String num);

	public void update(RetireDTO dto);

	public void delete(String num);

	public Integer count(String searchWord);

}
