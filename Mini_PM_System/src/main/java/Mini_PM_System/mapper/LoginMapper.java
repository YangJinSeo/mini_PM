package Mini_PM_System.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

	public Integer empEmailCheck(@Param("empEmail") String empEmail);


}
