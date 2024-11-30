package Mini_PM_System.mapper;

import org.apache.ibatis.annotations.Mapper;

import Mini_PM_System.domain.EmployeeDTO;

@Mapper
public interface RetireMapper {

	public EmployeeDTO selectEmpOne(String num);

	public int empChangeRetire(EmployeeDTO dto);

	public void empDelete(String num);

}
